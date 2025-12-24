package main.visitor;

import main.ast.nodes.*;
import main.ast.nodes.declaration.*;
import main.ast.nodes.expression.*;
import main.ast.nodes.statement.*;
import main.symbolTable.SymbolTable;
import main.symbolTable.exceptions.ItemAlreadyExistsException;
import main.symbolTable.exceptions.ItemNotFoundException;
import main.symbolTable.item.FunctionDefinitionSymbolTable;
import main.symbolTable.item.TypeFunctionDefinitionSymbolTable;
import main.symbolTable.item.TypeVariableSymbolTableItem;
import main.symbolTable.item.VariableSymbolTableItem;

import java.util.*;

public class NonSameOperandsVisitor extends Visitor<Void> {
    private static final Set<String> builtIns = Set.of("printf", "scanf", "malloc", "free", "realloc", "calloc");
    public static final Vector<String> anses = new Vector<>();

    @Override
    public Void visit(Program program) {
        SymbolTable.top = new SymbolTable();
        SymbolTable.root = SymbolTable.top;
        program.set_symbol_table(SymbolTable.top);

        if (program.getTranslationUnit() != null) {
            program.getTranslationUnit().accept(this);
        }
        return null;
    }

    @Override
    public Void visit(TranslationUnit translationUnit) {
        if (translationUnit.getExternalDeclaration() != null) {
            for (ExternalDeclaration e : translationUnit.getExternalDeclaration()) {
                if (e != null) {
                    e.accept(this);
                }
            }
        }
        return null;
    }

    @Override
    public Void visit(ExternalDeclaration externalDeclaration) {
        if (externalDeclaration.getFunctionDefinition() != null) {
            externalDeclaration.getFunctionDefinition().accept(this);
        }
        if (externalDeclaration.getDeclaration() != null) {
            externalDeclaration.getDeclaration().accept(this);
        }
        return null;
    }

    @Override
    public Void visit(InitDeclaratorList initDeclaratorList) {
        if (initDeclaratorList.getInitDeclarators() != null) {
            for (InitDeclarator initDeclarator : initDeclaratorList.getInitDeclarators()) {
                if (initDeclarator != null) {
                    initDeclarator.accept(this);
                }
            }
        }
        return null;
    }


    @Override
    public Void visit(Initializer initializer) {
        if (initializer.getInitializerList() != null) {
            initializer.getInitializerList().accept(this);
        }
        if (initializer.getExpression() != null) {
            initializer.getExpression().accept(this);
        }
        return null;
    }

    @Override
    public Void visit(TypeName typeName) {
        if (typeName.getAbstractDeclarator() != null) {
            typeName.getAbstractDeclarator().accept(this);
        }
        if (typeName.getSpecifierQualifierList() != null) {
            typeName.getSpecifierQualifierList().accept(this);
        }
        return null;
    }

    @Override
    public Void visit(StringLiteralExpression stringLiteralExpression) {
        return null;
    }

    @Override
    public Void visit(PointerType pointerType) {
        return null;
    }

    @Override
    public Void visit(IdentifierDeclarator identifierDeclarator) {
        return null;
    }

    @Override
    public Void visit(InitDeclarator initDeclarator) {
        if (initDeclarator.getDeclarator() != null) {
            Declarator declarator = initDeclarator.getDeclarator();
            if (declarator.getDirectDeclarator() != null) {
                DirectDeclarator directDeclarator = declarator.getDirectDeclarator();
                if (directDeclarator.getDirectDeclarator() != null) {
                    String name = directDeclarator.getDirectDeclarator().getIdentifier();
                    VariableSymbolTableItem varItem = new VariableSymbolTableItem(name);
                    varItem.setLine(directDeclarator.getDirectDeclarator().getLine());
//                    try {
//                        SymbolTable.top.put(varItem);
//                    } catch (ItemAlreadyExistsException e) {
//                    }
                }
                else {
                    String name = directDeclarator.getIdentifier();
                    VariableSymbolTableItem varItem = new VariableSymbolTableItem(name);
                    varItem.setLine(directDeclarator.getLine());
//                    try {
//                        SymbolTable.top.put(varItem);
//                    } catch (ItemAlreadyExistsException e) {
//                    }
                }
            }
            declarator.accept(this);
        }

        if (initDeclarator.getInitializer() != null) {
            initDeclarator.getInitializer().accept(this);
        }

        return null;
    }

    @Override
    public Void visit(DeclarationSpecifiers declarationSpecifiers) {
        if (declarationSpecifiers.getSpecifiers() != null) {
            for (DeclarationSpecifier d : declarationSpecifiers.getSpecifiers()) {
                if (d != null) {
                    d.accept(this);
                }
            }
        }
        return null;
    }

    @Override
    public Void visit(DeclarationSpecifier declarationSpecifier) {
        if (declarationSpecifier.getTypeSpecifier() != null) {
            String varName = declarationSpecifier.getTypeSpecifier().getTypeName();

//            if (varName.contains("int") || varName.contains("void") || varName.contains("char")  ||
//                    varName.contains("short") || varName.contains("long") ||
//                    varName.contains("double") || varName.contains("float") ||
//                    varName.contains("signed") || varName.contains("unsigned") || varName.contains("bool")) {
//                        return null;
//            }
//            VariableSymbolTableItem varItem = new VariableSymbolTableItem(varName);
//            varItem.setLine(declarationSpecifier.getTypeSpecifier().getLine());
//            try {
//                SymbolTable.top.put(varItem);
//            } catch (ItemAlreadyExistsException e) {
//
//            }
            declarationSpecifier.getTypeSpecifier().accept(this);
        }
        return null;
    }

    @Override
    public Void visit(DirectDeclarator directDeclarator) {
        if (directDeclarator.getDeclarator() != null) {
            directDeclarator.getDeclarator().accept(this);
        }
        if (directDeclarator.getDirectDeclarator() != null) {
//            String name = directDeclarator.getDirectDeclarator().getIdentifier();
//            if (directDeclarator.getExpression() != null) {
//                VariableSymbolTableItem varItem = new VariableSymbolTableItem(name);
//                varItem.setLine(directDeclarator.getLine());
//                try {
//                    SymbolTable.top.put(varItem);
//                } catch (ItemAlreadyExistsException e) {
////                    anses.add("Line:" + directDeclarator.getLine() + "-> " + name + " not declared");
//                }
//            }
            directDeclarator.getDirectDeclarator().accept(this);
        }
        if (directDeclarator.getExpression() != null) {
            directDeclarator.getExpression().accept(this);
        }
        if (directDeclarator.getIdentifierList() != null) {
            directDeclarator.getIdentifierList().accept(this);
        }
        if (directDeclarator.getParameterList() != null) {
            directDeclarator.getParameterList().accept(this);
        }
        return null;
    }

    @Override
    public Void visit(ParameterList parameterList) {
        if (parameterList.getParameterDeclarationArrayList() != null) {
            for (ParameterDeclaration p : parameterList.getParameterDeclarationArrayList()) {
                if (p != null) {
                    p.accept(this);
                }
            }
        }
        return null;
    }

    @Override
    public Void visit(ParameterDeclaration parameterDeclaration) {
        String type = "";
        if (parameterDeclaration.getDeclarationSpecifiers() != null) {
            DeclarationSpecifiers declarationSpecifiers = parameterDeclaration.getDeclarationSpecifiers();
            if (declarationSpecifiers.getSpecifiers() != null) {
                type = declarationSpecifiers.getSpecifiers().get(0).getTypeSpecifier().getTypeName();
            }
            parameterDeclaration.getDeclarationSpecifiers().accept(this);
        }
        if (parameterDeclaration.getDeclarator() != null) {
            Declarator d = parameterDeclaration.getDeclarator();
            if (d.getDirectDeclarator() != null) {
                DirectDeclarator dd = d.getDirectDeclarator();
                String pointerNameInParameter = dd.getIdentifier();
                TypeVariableSymbolTableItem varItem = new TypeVariableSymbolTableItem(pointerNameInParameter, type);
                varItem.setLine(dd.getLine());
                try {
                    SymbolTable.top.put(varItem);
                } catch (ItemAlreadyExistsException e) {
                }
            }
            parameterDeclaration.getDeclarator().accept(this);
        }
        if (parameterDeclaration.getAbstractDeclarator() != null) {
            parameterDeclaration.getAbstractDeclarator().accept(this);
        }
        return null;
    }

    @Override
    public Void visit(AbstractDeclarator abstractDeclaration) {
        if (abstractDeclaration.getPointerTypeArrayList() != null) {
            for (PointerType p : abstractDeclaration.getPointerTypeArrayList()) {
                if (p != null) {
                    p.accept(this);
                }
            }
        }
        if (abstractDeclaration.getDirectAbstractDeclarator() != null) {
            abstractDeclaration.getDirectAbstractDeclarator().accept(this);
        }
        return null;
    }

    @Override
    public Void visit(DirectAbstractDeclarator directAbstractDeclarator) {
        if (directAbstractDeclarator.getExpression() != null) {
            directAbstractDeclarator.getExpression().accept(this);
        }
        if (directAbstractDeclarator.getAbstractDeclarator() != null) {
            directAbstractDeclarator.getAbstractDeclarator().accept(this);
        }
        if (directAbstractDeclarator.getDirectAbstractDeclarator() != null) {
            directAbstractDeclarator.getDirectAbstractDeclarator().accept(this);
        }
        if (directAbstractDeclarator.getParameterList() != null) {
            directAbstractDeclarator.getParameterList().accept(this);
        }
        return null;
    }

    @Override
    public Void visit(InitializerList initializerList) {
        if (initializerList.getDesignationArrayList() != null) {
            for (Designation d : initializerList.getDesignationArrayList()) {
                if (d != null) {
                    d.accept(this);
                }
            }
        }
        if (initializerList.getInitializerArrayList() != null) {
            for (Initializer i : initializerList.getInitializerArrayList()) {
                if (i != null) {
                    i.accept(this);
                }
            }
        }
        return null;
    }

    @Override
    public Void visit(Designation designation) {
        if (designation.getDesignatorArrayList() != null) {
            for (Designator d : designation.getDesignatorArrayList()) {
                if (d != null) {
                    d.accept(this);
                }
            }
        }
        return null;
    }

    @Override
    public Void visit(Designator designator) {
        if (designator.getExpression() != null) {
            designator.getExpression().accept(this);
        }
        return null;
    }

    @Override
    public Void visit(BlockItem blockItem) {
        if (blockItem.getStatement() != null) {
            blockItem.getStatement().accept(this);
        }
        if (blockItem.getDeclaration() != null) {
            blockItem.getDeclaration().accept(this);
        }
        return null;
    }

    @Override
    public Void visit(IdentifierExpression identifierExpression) {
        String name = identifierExpression.getName();

        if (builtIns.contains(name)) {
            return null;
        }

        try {
            SymbolTable.top.getItem("Variable_" + name);
        } catch (ItemNotFoundException e) {
//            anses.add("Line:" + identifierExpression.getLine() + "-> " + name + " not declared");
        }

        return null;
    }

    @Override
    public Void visit(ExpressionStatement expressionStatement) {
        if (expressionStatement.getExpression() != null) {
            expressionStatement.getExpression().accept(this);
        }
        return null;
    }

    @Override
    public Void visit(JumpStatement jumpStatement) {
        if (jumpStatement.getExpression() != null) {
            jumpStatement.getExpression().accept(this);
        }
        return null;
    }

    @Override
    public Void visit(IterationStatement iterationStatement) {
        if (iterationStatement.getExpression() != null) {
            iterationStatement.getExpression().accept(this);
        }
        String type = "";
        String name = "";
        SymbolTable forDeclaration_table = new SymbolTable(SymbolTable.top);
        iterationStatement.set_symbol_table(forDeclaration_table);
        SymbolTable.push(forDeclaration_table);

        if (iterationStatement.getForCondition() != null) {
            if (iterationStatement.getForCondition().getForDeclaration() != null) {
                if (iterationStatement.getForCondition().getForDeclaration().getDeclarationSpecifiers() != null) {
                    if (iterationStatement.getForCondition().getForDeclaration().getDeclarationSpecifiers().getSpecifiers().get(0) != null)
                        if (iterationStatement.getForCondition().getForDeclaration().getDeclarationSpecifiers().getSpecifiers().get(0).getTypeSpecifier() != null)
                            type = iterationStatement.getForCondition().getForDeclaration().getDeclarationSpecifiers().getSpecifiers().get(0).getTypeSpecifier().getTypeName();
                }
                if (iterationStatement.getForCondition().getForDeclaration().getInitDeclaratorList() != null) {
                    List<InitDeclarator> initDeclaratorArrayList = iterationStatement.getForCondition().getForDeclaration().getInitDeclaratorList().getInitDeclarators();
                    for (InitDeclarator id: initDeclaratorArrayList) {
                        if (id.getDeclarator() != null) {
                            Declarator d = id.getDeclarator();
                            if (d != null) {
                                DirectDeclarator dd = d.getDirectDeclarator();
                                if (dd !=  null) {
                                    name = dd.getIdentifier();
                                    TypeVariableSymbolTableItem varItem = new TypeVariableSymbolTableItem(name, type);
                                    varItem.setLine(dd.getLine());
                                    try {
                                        SymbolTable.top.put(varItem);
//                                        System.out.println(varItem.getKey());
                                    } catch (ItemAlreadyExistsException e) {
//                                        anses.add("Line:" + iterationStatement.getLine() + "-> " + name + " not declared");
                                    }
                                }
                            }
                        }
                    }
                }
                iterationStatement.getForCondition().accept(this);
            }
        }
        if (iterationStatement.getStatement() != null) {
            iterationStatement.getStatement().accept(this);
        }
        SymbolTable.pop();
        return null;
    }

    @Override
    public Void visit(SelectionStatement selectionStatement) {
        ArrayList<Expression> conds = selectionStatement.getExpression();
        for (Expression expr : conds) {
            if (expr != null) {
                expr.accept(this);
            }
        }
        ArrayList<Statement> branches = selectionStatement.getStatementArrayList();
        for (Statement stmt : branches) {
            SymbolTable inner = new SymbolTable(SymbolTable.top);
            SymbolTable.push(inner);
            if (stmt != null) {
                stmt.accept(this);
            }
            SymbolTable.pop();
        }
        return null;
    }

    @Override
    public Void visit(CompoundStatement compoundStmt) {

        List<BlockItem> list = compoundStmt.getBlockItemArrayList();
        list.sort(Comparator.comparingInt(BlockItem::getLine));
        for (BlockItem item : list) {
            if (item.getDeclaration() != null) {
                item.getDeclaration().accept(this);
            }
            if (item.getStatement() != null) {
                item.getStatement().accept(this);
            }
        }
        return null;
    }


    @Override
    public Void visit(ForCondition forCondition) {
        if (forCondition.getForDeclaration() != null) {
            forCondition.getForDeclaration().accept(this);
        }
        if (forCondition.getExpression() != null) {
            forCondition.getExpression().accept(this);
        }
        if (forCondition.getForExpressionArrayList() != null) {
            for (ForExpression f : forCondition.getForExpressionArrayList()) {
                if (f != null) {
                    f.accept(this);
                }
            }
        }
        return null;
    }

    @Override
    public Void visit(ForExpression forExpression) {
        if (forExpression.getExpressionArrayList() != null) {
            for (Expression e : forExpression.getExpressionArrayList()) {
                if (e != null) {
                    e.accept(this);
                }
            }
        }
        return null;
    }

    @Override
    public Void visit(ForDeclaration forDeclaration) {
        if (forDeclaration.getDeclarationSpecifiers() != null) {
            forDeclaration.getDeclarationSpecifiers().accept(this);
        }
        if (forDeclaration.getInitDeclaratorList() != null) {
            forDeclaration.getInitDeclaratorList().accept(this);
        }
        return null;
    }

    @Override
    public Void visit(ArgumentExpressionList argumentExpressionList) {
        if (argumentExpressionList.getExpression() != null) {
            for (Expression expression : argumentExpressionList.getExpression()) {
                if (expression != null) {
                    expression.accept(this);
                }
            }
        }
        return null;
    }

    @Override
    public Void visit(ConstantExpression constantExpression) {
        return null;
    }

    @Override
    public Void visit(CastExpression castExpression) {
        if (castExpression.getTypeName() != null) {
            castExpression.getTypeName().accept(this);
        }
        if (castExpression.getExpression() != null) {
            castExpression.getExpression().accept(this);
        }
        if (castExpression.getCastExpression() != null) {
            castExpression.getCastExpression().accept(this);
        }
        return null;
    }

    @Override
    public Void visit(CommaExpression commaExpression) {
        if (commaExpression.getExpressionArrayList() != null) {
            for (Expression e : commaExpression.getExpressionArrayList()) {
                if (e != null) {
                    if (!(e instanceof AssignmentExpression)) {
                        e.accept(this);
                    }
                }
            }
        }
        return null;
    }
    private String inferExprType(Expression expr) {
        if (expr instanceof IdentifierExpression id) {
            try {
                TypeVariableSymbolTableItem item = (TypeVariableSymbolTableItem) SymbolTable.top.getItem("Variable_" + id.getName());
                return item.getReturnType();
            } catch (ItemNotFoundException e) {
                return null;
            }
        } else if (expr instanceof ConstantExpression c) {
            if (c.getConstant().matches("^-?\\d+$")) return "int";
            if (c.getConstant().matches("^-?\\d+\\.\\d*$")) return "float";
        } else if (expr instanceof StringLiteralExpression) {
            return "string";
        } else if (expr instanceof BinaryExpression b) {
            String left = inferExprType(b.getLeft());
            String right = inferExprType(b.getRight());
            return promoteTypes(left, right);
        }
        return null;
    }

//    private String inferExprType(Expression expr) {
//        if (expr instanceof ConstantExpression c) {
//            if (c.getConstant().matches("\\d+")) return "int";
//            if (c.getConstant().startsWith("\"")) return "string";
//        }
//        if (expr instanceof IdentifierExpression id) {
//            String name = "Variable_" + id.getName();
//            try {
//                TypeVariableSymbolTableItem var = (TypeVariableSymbolTableItem) SymbolTable.top.getItem(name);
//                return var.getReturnType();
//            } catch (ItemNotFoundException e) {
//                return "unknown";
//            }
//        }
//        if (expr instanceof StringLiteralExpression) {
//            return "string";
//        }
//        if (expr instanceof CastExpression cexpr) {
//            if (cexpr.getTypeName() != null) {
//                SpecifierQualifierList specList = cexpr.getTypeName().getSpecifierQualifierList();
//                if (specList != null && specList.getTypeSpecifier() != null) {
//                    String castedType = specList.getTypeSpecifier().getTypeName();
//                    AbstractDeclarator abs = cexpr.getTypeName().getAbstractDeclarator();
//                    if (abs != null && abs.getPointerTypeArrayList() != null && !abs.getPointerTypeArrayList().isEmpty()) {
//                        castedType += "*".repeat(abs.getPointerTypeArrayList().size());
//                    }
//                    return castedType;
//                }
//            }
//        }
//        return "unknown";
//    }

    private String promoteTypes(String t1, String t2) {
        List<String> order = List.of("char", "short", "int", "float", "double");
        int i1 = order.indexOf(t1);
        int i2 = order.indexOf(t2);
        if (i1 == -1 || i2 == -1) return null;
        return order.get(Math.max(i1, i2));
    }

    @Override
    public Void visit(AssignmentExpression assignmentExpression) {
        if (assignmentExpression.getLeft() != null) {
            assignmentExpression.getLeft().accept(this);
        }
        if (assignmentExpression.getRight() != null) {
            assignmentExpression.getRight().accept(this);
        }

        String leftType = inferExprType(assignmentExpression.getLeft());
        String rightType = inferExprType(assignmentExpression.getRight());
        if (leftType != null && rightType != null && !areTypesCompatibleForAssignment(leftType, rightType)) {
            int line = assignmentExpression.getLine();
            anses.add("Line:" + line + " -> type mismatch in assignment");
        }

        return null;
    }

    private boolean areTypesCompatibleForAssignment(String target, String source) {
        // Allow same type
        if (target.equals(source)) return true;

        // Implicit promotion allowed in some cases (int <- char/short, float <- int, etc.)
        List<String> typeOrder = List.of("char", "short", "int", "float", "double");
        int targetIdx = typeOrder.indexOf(target);
        int sourceIdx = typeOrder.indexOf(source);

        // Disallow unknown types
        if (targetIdx == -1 || sourceIdx == -1) return false;

        // Allow only if source fits into target
        return sourceIdx <= targetIdx;
    }

    @Override
    public Void visit(Expression expr) {
        if (expr.getArgumentExpressionList() != null) {
            ArgumentExpressionList argList = expr.getArgumentExpressionList();
            for (Expression e : argList.getExpression()) {
                if (e != null) {
                    e.accept(this);
                }
            }
        }

        if (expr.getExpressionArrayList() != null) {
            for (Expression e : expr.getExpressionArrayList()) {
                if (e != null) {
                    e.accept(this);
                }
            }
        }

        if (expr.getTypeName() != null)
            expr.getTypeName().accept(this);
        if (expr.getInitializerList() != null)
            expr.getInitializerList().accept(this);
        return null;
    }

    @Override
    public Void visit(SpecifierQualifierList specifierQualifierList) {
        if (specifierQualifierList.getTypeSpecifier() != null) {
            specifierQualifierList.getTypeSpecifier().accept(this);
        }
        if (specifierQualifierList.getSpecifierQualifierList() != null) {
            specifierQualifierList.getSpecifierQualifierList().accept(this);
        }
        return null;
    }

    @Override
    public Void visit(Declarator declarator) {
        if (declarator.getPointer() != null) {
            declarator.getPointer().accept(this);
        }
        if (declarator.getDirectDeclarator() != null) {
            declarator.getDirectDeclarator().accept(this);
        }
        return null;
    }

    @Override
    public Void visit(FunctionDefinition functionDefinition) {
        String return_type = "";
        ArrayList<String> args = new ArrayList<>();

        if (functionDefinition.getDeclarationSpecifiers() != null) {
            for (DeclarationSpecifiers d : functionDefinition.getDeclarationSpecifiers()) {
                if (d.getSpecifiers() != null) {
                    DeclarationSpecifier dd = d.getSpecifiers().get(0);
                    return_type = dd.getTypeSpecifier().getTypeName();
//                    System.out.println(return_type);
                }
                if (d != null) {
                    d.accept(this);
                }
            }
        }
        if (functionDefinition.getDeclarator() != null) {
            Declarator declarator = functionDefinition.getDeclarator();
            if (declarator.getPointer() != null) {
                return_type += "*";
            }
            String arg = "";
            if (declarator.getDirectDeclarator() != null) {
                DirectDeclarator directDeclarator = declarator.getDirectDeclarator();
                if (directDeclarator.getParameterList() != null) {
                    ParameterList parameterList = directDeclarator.getParameterList();
                    if (parameterList.getParameterDeclarationArrayList() != null) {
                        ArrayList<ParameterDeclaration> parameterDeclarationArrayList = parameterList.getParameterDeclarationArrayList();
                        for (ParameterDeclaration p: parameterDeclarationArrayList) {
                            if (p.getDeclarationSpecifiers() != null) {
                                DeclarationSpecifiers declarationSpecifiers = p.getDeclarationSpecifiers();
                                if (declarationSpecifiers.getSpecifiers() != null) {
                                    DeclarationSpecifier declarationSpecifierArrayList = declarationSpecifiers.getSpecifiers().get(0);
                                    if (declarationSpecifierArrayList.getTypeSpecifier().getTypeName().contains("int") || declarationSpecifierArrayList.getTypeSpecifier().getTypeName().contains("void") || declarationSpecifierArrayList.getTypeSpecifier().getTypeName().contains("char")  ||
                                            declarationSpecifierArrayList.getTypeSpecifier().getTypeName().contains("short") || declarationSpecifierArrayList.getTypeSpecifier().getTypeName().contains("long") ||
                                            declarationSpecifierArrayList.getTypeSpecifier().getTypeName().contains("double") || declarationSpecifierArrayList.getTypeSpecifier().getTypeName().contains("float") ||
                                            declarationSpecifierArrayList.getTypeSpecifier().getTypeName().contains("signed") || declarationSpecifierArrayList.getTypeSpecifier().getTypeName().contains("unsigned") || declarationSpecifierArrayList.getTypeSpecifier().getTypeName().contains("bool")
                                            || declarationSpecifierArrayList.getTypeSpecifier().getTypeName().contains("string"))
                                    {
                                        arg = declarationSpecifierArrayList.getTypeSpecifier().getTypeName();
                                    }
                                }
                            }
                            if (p.getAbstractDeclarator() != null) {
                                if (p.getAbstractDeclarator().getDirectAbstractDeclarator() != null) {
                                    arg += "[]";
                                }
                            }

                            if (p.getDeclarator() != null) {
                                if (p.getDeclarator().getDirectDeclarator() != null) {
                                    arg += "*";
                                }
                            }
                            args.add(arg);
                        }
                    }
                }
            }
            String funcName = "";
            if (declarator.getDirectDeclarator().getDirectDeclarator() != null) {
                declarator.getDirectDeclarator().getDirectDeclarator().getIdentifier();
            }
            TypeFunctionDefinitionSymbolTable func_dec_item = new TypeFunctionDefinitionSymbolTable(functionDefinition, return_type, args);
            try {
                SymbolTable.top.put(func_dec_item);
            } catch (ItemAlreadyExistsException e) {
                System.out.println("Redefinition of function \"" + functionDefinition.getDeclarator().getDirectDeclarator().getDirectDeclarator().getIdentifier() +"\" in line " + functionDefinition.getLine());
            }
            SymbolTable func_dec_symbol_table = new SymbolTable(SymbolTable.top);
            functionDefinition.set_symbol_table(func_dec_symbol_table);
            SymbolTable.push(func_dec_symbol_table);
            functionDefinition.getDeclarator().accept(this);
        }
        if (functionDefinition.getDeclarationList() != null) {
            for (DeclarationList d : functionDefinition.getDeclarationList()) {
                if (d != null) {
                    d.accept(this);
                }
            }
        }
        if (functionDefinition.getCompoundStatement() != null) {
            functionDefinition.getCompoundStatement().accept(this);
        }

        SymbolTable.pop();

        return null;
    }

    @Override
    public Void visit(TypeSpecifier typeSpecifier) {
        return null;
    }

    @Override
    public Void visit(Declaration declaration) {
        boolean flag = false;
        String type = "";
        String name = "";
        if (declaration.getDeclarationSpecifiers() != null) {
            type = declaration.getDeclarationSpecifiers().getSpecifiers().get(0).getTypeSpecifier().getTypeName();
            try {
                if (declaration.getDeclarationSpecifiers().getSpecifiers().get(1) != null) {
                    name = declaration.getDeclarationSpecifiers().getSpecifiers().get(1).getTypeSpecifier().getTypeName();
                }
            }
            catch (Exception e) {

            }
        }

        if (declaration.getInitDeclaratorList() != null) {
            InitDeclaratorList initDeclaratorList = declaration.getInitDeclaratorList();
            try {
                if (initDeclaratorList.getInitDeclarators().size() > 1) {
                    flag = true;
                    for (InitDeclarator initDeclarator: initDeclaratorList.getInitDeclarators()) {
                        name = initDeclarator.getDeclarator().getDirectDeclarator().getIdentifier();
                        TypeVariableSymbolTableItem typeVariableSymbolTableItem = new TypeVariableSymbolTableItem(name, type);
                        try {
                            SymbolTable.top.put(typeVariableSymbolTableItem);
//                            System.out.println(typeVariableSymbolTableItem.getKey());
                        } catch (ItemAlreadyExistsException e) {
                            System.out.println("Redefinition");

                        }
                    }
                }
                else {
                    if (initDeclaratorList.getInitDeclarators().get(0).getDeclarator().getPointer() != null) {
                        type += "*";
                        name = initDeclaratorList.getInitDeclarators().get(0).getDeclarator().getDirectDeclarator().getIdentifier();
                    }
                    else if (initDeclaratorList.getInitDeclarators().get(0).getDeclarator().getDirectDeclarator().getDirectDeclarator() != null) {
                        type += "[]";

                    }
                    if (initDeclaratorList.getInitDeclarators().get(0).getDeclarator().getDirectDeclarator().getDirectDeclarator() != null) {
                        name = initDeclaratorList.getInitDeclarators().get(0).getDeclarator().getDirectDeclarator().getDirectDeclarator().getIdentifier();
                    }
                    else if (initDeclaratorList.getInitDeclarators().get(0).getInitializer() != null) {
                        name = initDeclaratorList.getInitDeclarators().get(0).getDeclarator().getDirectDeclarator().getIdentifier();
                    }
                }
            } catch (Exception e) {
                System.out.println("Redefinition");
            }
        }
        if (!flag) {
            TypeVariableSymbolTableItem typeVariableSymbolTableItem = new TypeVariableSymbolTableItem(name, type);
            try {
                SymbolTable.top.put(typeVariableSymbolTableItem);
//                System.out.println(typeVariableSymbolTableItem.getKey());
            } catch (ItemAlreadyExistsException e) {}
        }
        System.out.print(name + " ");
        System.out.println(type);
        if (declaration.getDeclarationSpecifiers() != null) {
            declaration.getDeclarationSpecifiers().accept(this);
        }
        if (declaration.getInitDeclaratorList() != null) {
            declaration.getInitDeclaratorList().accept(this);
        }

        return null;
    }


    @Override
    public Void visit(DeclarationList declarationList) {
        if (declarationList.getDeclarations() != null) {
            for (Declaration d : declarationList.getDeclarations()) {
                if (d != null) {
                    d.accept(this);
                }
            }
        }
        return null;
    }

    @Override
    public Void visit(IdentifierList identifierList) {
        return null;
    }

    @Override
    public Void visit(ThreeExpression threeExpression) {
        if (threeExpression.getLeft() != null) {
            threeExpression.getLeft().accept(this);
        }
        if (threeExpression.getMid() != null) {
            threeExpression.getMid().accept(this);
        }
        if (threeExpression.getRight() != null) {
            threeExpression.getRight().accept(this);
        }
        return null;
    }

    private static final List<String> typeOrder = List.of("char", "short", "int", "float", "double", "string");

    private boolean areCompatibleTypes(String a, String b) {
        if (a.equals("unknown") || b.equals("unknown")) return true; // can't decide, so ignore
        if (a.equals(b)) return true;
        int ia = typeOrder.indexOf(a);
        int ib = typeOrder.indexOf(b);
//        System.out.println(ia);
//        System.out.println(ib);
        return (ia != -1 && ib != -1 && Math.abs(ia - ib) <= 1 && Math.max(ia, ib) <= typeOrder.indexOf("double"));
    }

    @Override
    public Void visit(BinaryExpression binaryExpression) {
        if (binaryExpression.getLeft() != null) {
            binaryExpression.getLeft().accept(this);
        }
        if (binaryExpression.getRight() != null) {
            binaryExpression.getRight().accept(this);
        }

        String leftType = inferExprType(binaryExpression.getLeft());
        String rightType = inferExprType(binaryExpression.getRight());

        if (!areCompatibleTypes(leftType, rightType)) {
            anses.add("Line:" + binaryExpression.getLine() + " -> type mismatch in expression");
        }
        return null;
    }

    @Override
    public Void visit(FunctionCallExpression functionCallExpression) {
        if (functionCallExpression.getArgumentExpressionList() != null) {
            functionCallExpression.getArgumentExpressionList().accept(this);
        }

        if (functionCallExpression.getExpression() != null) {
            Expression exprName = functionCallExpression.getExpression();
            String name = "Function_" + ((IdentifierExpression) exprName).getName();
            if (exprName instanceof IdentifierExpression) {
                IdentifierExpression iExp = ((IdentifierExpression) exprName);
                if (builtIns.contains(iExp.getName())) {
                    return null;
                }
                else {
                    if (functionCallExpression.getArgumentExpressionList() != null) {
                        ArgumentExpressionList argumentExpressionList = functionCallExpression.getArgumentExpressionList();
                        ArrayList<Expression> expressionList = argumentExpressionList.getExpression();
                        name += "#" + expressionList.size();
                        try {
                            SymbolTable.top.getItem(name);
                        } catch (ItemNotFoundException e) {
//                            anses.add("Line:" + exprName.getLine() + "-> " + ((IdentifierExpression) exprName).getName() + " not declared");
                        }
                    }
                    else {
                        name = "Function_" + ((IdentifierExpression) exprName).getName() + "#0";
                        try {
                            SymbolTable.top.getItem(name);
                        } catch (ItemNotFoundException e) {
//                            anses.add("Line:" + exprName.getLine() + "-> " + ((IdentifierExpression) exprName).getName() + " not declared");
                        }
                    }
                }
            }

        }
        return null;
    }

    public boolean chap() {
        if (this.anses.size() != 0) {
            for (String s: anses) {
                System.out.println(s);
            }
            return true;
        }
        else {
            return false;
        }
    }
}