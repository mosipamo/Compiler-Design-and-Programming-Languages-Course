package main.ast.nodes;

import main.ast.nodes.declaration.FunctionDefinition;
import main.ast.nodes.expression.*;
import main.ast.nodes.statement.*;
import main.symbolTable.SymbolTable;
import main.symbolTable.item.FunctionDefinitionSymbolTable;
import main.symbolTable.item.SymbolTableItem;
import main.ast.nodes.declaration.*;

import java.util.*;

public class ReachabilityAnalyzer {

    private static Set<String> reachableFunctions = new HashSet<>();
    private static Map<String, FunctionDefinition> functionMap = new HashMap<>();

    public static void analyze() {
        String foundMain = "";

        for (SymbolTableItem item : SymbolTable.root.items.values()) {
            if (item instanceof FunctionDefinitionSymbolTable fdItem) {
                FunctionDefinition def = fdItem.getFunctionDefinition();
                String name = getFunctionKey(def);
                functionMap.put(name, def);
                if (name.startsWith("Function_main")) {
                    foundMain = name;
                }
            }
        }
        dfs(foundMain);

        SymbolTable.root.items.entrySet().removeIf(entry ->
                entry.getKey().startsWith("Function_") && !reachableFunctions.contains(entry.getKey()));
    }

    private static void dfs(String key) {
        if (reachableFunctions.contains(key) || !functionMap.containsKey(key))
            return;

        reachableFunctions.add(key);
        FunctionDefinition def = functionMap.get(key);

        if (def.getCompoundStatement() == null)
            return;

        for (BlockItem item : def.getCompoundStatement().getBlockItemArrayList()) {
            if (item.getStatement() != null) {
                extractCallsFromStatement(item.getStatement());
            }
        }
    }

    private static void extractCallsFromStatement(Statement stmt) {
        if (stmt instanceof ExpressionStatement exprStmt) {
            extractCallsFromExpression(exprStmt.getExpression());
        } else if (stmt instanceof JumpStatement jumpStmt) {
            extractCallsFromExpression(jumpStmt.getExpression());
        } else if (stmt instanceof SelectionStatement selStmt) {
            if (selStmt.getExpression() != null) {
                for (Expression e : selStmt.getExpression()) {
                    extractCallsFromExpression(e);
                }
            }
//            extractCallsFromExpression(selStmt.getExpression());
            if (selStmt.getStatementArrayList() != null) {
                for (Statement s : selStmt.getStatementArrayList()) {
                    extractCallsFromStatement(s);
                }
            }
        } else if (stmt instanceof IterationStatement iterStmt) {
            extractCallsFromExpression(iterStmt.getExpression());
            if (iterStmt.getForCondition() != null) {
                extractCallsFromExpression(iterStmt.getForCondition().getExpression());
                if (iterStmt.getForCondition().getForExpressionArrayList() != null) {
                    for (ForExpression f : iterStmt.getForCondition().getForExpressionArrayList()) {
                        for (Expression e : f.getExpressionArrayList()) {
                            extractCallsFromExpression(e);
                        }
                    }
                }
            }
            extractCallsFromStatement(iterStmt.getStatement());
        } else if (stmt instanceof CompoundStatement compoundStmt) {
            for (BlockItem b : compoundStmt.getBlockItemArrayList()) {
                if (b.getStatement() != null)
                    extractCallsFromStatement(b.getStatement());
            }
        }
    }

    private static void extractCallsFromExpression(Expression expr) {
        if (expr == null) return;

        // Direct function call
        if (expr instanceof FunctionCallExpression fce) {
            String funcName = extractFunctionName(fce.getExpression());
            if (funcName != null) {
                int argCount = fce.getArgumentExpressionList() == null ? 0 :
                        fce.getArgumentExpressionList().getExpression().size();
                String calledKey = "Function_" + funcName + "#" + argCount;
                dfs(calledKey);
            }

            // Traverse into inner expression
            extractCallsFromExpression(fce.getExpression());

            if (fce.getArgumentExpressionList() != null) {
                for (Expression arg : fce.getArgumentExpressionList().getExpression()) {
                    extractCallsFromExpression(arg);
                }
            }
        }

        // Binary expressions
        else if (expr instanceof BinaryExpression be) {
            extractCallsFromExpression(be.getLeft());
            extractCallsFromExpression(be.getRight());
        }

        // Cast expressions
        else if (expr instanceof CastExpression ce) {
            extractCallsFromExpression(ce.getExpression());
        }

        // Comma expressions
        else if (expr instanceof CommaExpression ce) {
            if (ce.getExpressionArrayList() != null) {
                for (Expression e : ce.getExpressionArrayList()) {
                    extractCallsFromExpression(e);
                }
            }
        }

        // Assignment expressions
        else if (expr instanceof AssignmentExpression ae) {
            extractCallsFromExpression(ae.getLeft());
            extractCallsFromExpression(ae.getRight());
        }

        // Three-way (ternary) expressions
        else if (expr instanceof ThreeExpression te) {
            extractCallsFromExpression(te.getLeft());
            extractCallsFromExpression(te.getMid());
            extractCallsFromExpression(te.getRight());
        }

        // Nested expressions (e.g., Expression wrapping other Expressions)
        else if (expr.getExpressionArrayList() != null) {
            for (Expression e : expr.getExpressionArrayList()) {
                extractCallsFromExpression(e);
            }
        }
    }


    private static String extractFunctionName(Expression expr) {
        if (expr instanceof IdentifierExpression id)
            return id.getName();
        return null;
    }

    private static String getFunctionKey(FunctionDefinition def) {
        String name = def.getDeclarator().getDirectDeclarator().getDirectDeclarator().getIdentifier();
        int paramCount = 0;
        if (def.getDeclarator().getDirectDeclarator().getParameterList() != null &&
                def.getDeclarator().getDirectDeclarator().getParameterList().getParameterDeclarationArrayList() != null) {
            paramCount = def.getDeclarator().getDirectDeclarator().getParameterList().getParameterDeclarationArrayList().size();
        }
        return "Function_" + name + "#" + paramCount;
    }

    public static void cleanAST(Program program) {
        ArrayList<ExternalDeclaration> cleaned = new ArrayList<>();

        for (ExternalDeclaration extDecl : program.getTranslationUnit().getExternalDeclaration()) {
            if (extDecl.getFunctionDefinition() != null) {
                FunctionDefinition def = extDecl.getFunctionDefinition();
                String key = getFunctionKey(def);
                if (reachableFunctions.contains(key)) {
                    cleaned.add(extDecl);
                }
            } else {
                cleaned.add(extDecl);
            }
        }

        program.getTranslationUnit().setExternalDeclaration(cleaned);
    }
}
