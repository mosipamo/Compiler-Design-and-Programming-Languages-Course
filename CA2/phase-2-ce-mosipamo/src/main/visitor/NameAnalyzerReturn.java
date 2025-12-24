package main.visitor;

import main.ast.nodes.*;
import main.ast.nodes.declaration.*;
import main.ast.nodes.expression.*;
import main.ast.nodes.statement.*;
import main.symbolTable.SymbolTable;
import main.symbolTable.exceptions.ItemAlreadyExistsException;
import main.symbolTable.exceptions.ItemNotFoundException;
import main.symbolTable.item.VariableSymbolTableItem;
import main.symbolTable.item.FunctionDefinitionSymbolTable;
import java.util.List;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.Set;
import java.util.Vector;

public class NameAnalyzerReturn extends Visitor<Void> {
    private static final String EXPRSTRING = ": Expr ";
    private static final String LINESTRING = "Line ";
    private static final String EQUALSTRING = " = ";
    private static final String EXPRESSIONQUAL = "Expr ";
    private static final Set<String> builtIns = Set.of("printf", "scanf");
    private static final Vector<String> optizes = new Vector<>();

    private int countNumOfStatements(Statement stmt) {
        int cnt = 0;

        if (stmt instanceof CompoundStatement b) {
            for (BlockItem item : b.getBlockItemArrayList()) {
                if (item.getStatement() != null || item.getDeclaration() != null)
                    cnt++;
            }
        }
        else if (stmt != null)
            cnt = 1;

        return cnt;
    }

    private void helperPrint(Node node, String msg) {
        String COLONSTRING = ": ";
        System.out.println(LINESTRING + node.getLine() + COLONSTRING + msg);
    }

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
        Expression cond = initializer.getExpression();
        if (cond instanceof ConstantExpression) {
//            System.out.println(LINESTRING + cond.getLine() + EXPRSTRING + ((ConstantExpression) cond).getConstant());
        }
        if (!cond.getTemp_op().isEmpty()) {
            for (String s: cond.getTemp_op()) {
//                System.out.println(LINESTRING + cond.getLine() + EXPRSTRING + s);
            }
        }
        if (cond instanceof BinaryExpression)
//            System.out.println(LINESTRING + cond.getLine() + EXPRSTRING + ((BinaryExpression) cond).getOp());

            if (cond instanceof CommaExpression)
                for (String s :  ((CommaExpression) cond).getComma()) {

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
//                    System.out.println("fucj yo + " + name);
                    VariableSymbolTableItem varItem = new VariableSymbolTableItem(name);
                    try {
                        SymbolTable.top.put(varItem);
                    } catch (ItemAlreadyExistsException e) {
                        //                System.out.println("Line " + declarationSpecifier.getLine() +
                        //                        " -> Not Declared \"" + varName + "\"");
                    }
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

            if (varName.contains("int") || varName.contains("void") || varName.contains("char")  ||
                    varName.contains("short") || varName.contains("long") ||
                    varName.contains("double") || varName.contains("float") ||
                    varName.contains("signed") || varName.contains("unsigned") || varName.contains("bool")) {
                return null;
            }
            VariableSymbolTableItem varItem = new VariableSymbolTableItem(varName);
            try {
                SymbolTable.top.put(varItem);
            } catch (ItemAlreadyExistsException e) {
//                System.out.println("Line " + declarationSpecifier.getLine() +
//                        " -> Not Declared \"" + varName + "\"");
            }
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
        if (parameterDeclaration.getDeclarationSpecifiers() != null) {
            parameterDeclaration.getDeclarationSpecifiers().accept(this);
        }
        if (parameterDeclaration.getDeclarator() != null) {
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
//            System.out.println("Line:" + identifierExpression.getLine() + "-> " + name + " not declared");
//            anses.add("Line:" + identifierExpression.getLine() + "-> " + name + " not declared");
        }

        return null;
    }

//    @Override
//    public Void visit(ExpressionStatement expressionStatement) {
//        if (expressionStatement.getExpression() != null) {
//            expressionStatement.getExpression().accept(this);
//        }
//        return null;
//    }
    @Override
    public Void visit(ExpressionStatement expressionStatement) {
        if (expressionStatement.getExpression() != null) {
            if (expressionStatement.getExpression() instanceof AssignmentExpression) {
                expressionStatement.setExpression(expressionStatement.getExpression());
                expressionStatement.getExpression().accept(this);
            }
            else if (expressionStatement.getExpression() instanceof FunctionCallExpression) {
                expressionStatement.setExpression(expressionStatement.getExpression());
                expressionStatement.getExpression().accept(this);
            }
            else if (expressionStatement.getExpression().getTemp_op().size() != 0) {
                expressionStatement.setExpression(expressionStatement.getExpression());
                expressionStatement.getExpression().accept(this);
            }
            else {
                expressionStatement.setExpression(null);
            }
        }
        return null;
    }

    @Override
    public Void visit(JumpStatement jumpStatement) {
        if (jumpStatement.getExpression() != null) {
            jumpStatement.getExpression().accept(this);
        }
        Expression expr = jumpStatement.getExpression();
        if (expr instanceof ConstantExpression constExpr) {
//            helperPrint(constExpr, EXPRESSIONQUAL  + constExpr.getConstant());
        }
        return null;
    }

    @Override
    public Void visit(IterationStatement iterationStatement) {
        if (iterationStatement.getExpression() != null) {
            iterationStatement.getExpression().accept(this);
        }
        if (iterationStatement.getStatement() != null) {
            iterationStatement.getStatement().accept(this);
        }
        if (iterationStatement.getForCondition() != null) {
            iterationStatement.getForCondition().accept(this);
        }
        Expression cond = iterationStatement.getExpression();
        if (cond instanceof ConstantExpression constExpr) {
//            helperPrint(constExpr, EXPRESSIONQUAL + constExpr.getConstant());
        }

        if (iterationStatement.getStatement() != null) {
            int count = countNumOfStatements(iterationStatement.getStatement());
            String SHIT = "Stmt ";
//            helperPrint(iterationStatement, SHIT + iterationStatement.getLoopType() + EQUALSTRING +  count);
        }
        return null;
    }

    private boolean andHame;

    @Override
    public Void visit(SelectionStatement selectionStatement) {
        ArrayList<Boolean> mamad = new ArrayList<Boolean>();
        if (selectionStatement.getExpression() != null) {
            for (Statement s: selectionStatement.getStatementArrayList()) {
                boolean flag = false;
                if (s instanceof CompoundStatement) {
                    ArrayList<BlockItem> b = ((CompoundStatement) s).getBlockItemArrayList();
                    for (BlockItem bb: b) {
                        if (bb.getStatement() instanceof JumpStatement) {
                            mamad.add(true);
                            flag = true;
                            break;
                        }
                    }
                    if (flag == false) {
                        mamad.add(false);
                    }
                }
                if (s != null) {
                    s.accept(this);
                }
            }
        }

        boolean res = true;
        for (Boolean b: mamad) {
            res = res & b;
        }
        andHame = res;

        ArrayList<Expression> cond = selectionStatement.getExpression();
        for (Expression e : cond) {
            if (e instanceof ConstantExpression) {
//                helperPrint(e, EXPRESSIONQUAL + ((ConstantExpression) e).getConstant());
            }
        }
        return null;
    }


//    @Override
//    public Void visit(CompoundStatement compoundStmt) {
//        SymbolTable compound_table = new SymbolTable(SymbolTable.top);
//        compoundStmt.set_symbol_table(compound_table);
//        SymbolTable.push(compound_table);
//        ArrayList<BlockItem> new_blockItems = new ArrayList<>();
//        List<BlockItem> list = compoundStmt.getBlockItemArrayList();
//        list.sort(Comparator.comparingInt(BlockItem::getLine));
//
//        for (BlockItem item : list) {
//            if (item.getDeclaration() != null) {
//                new_blockItems.add(item);
//                item.getDeclaration().accept(this);
//            }
//            if (item.getStatement() != null) {
//                new_blockItems.add(item);
//                if (item.getStatement() instanceof JumpStatement) {
//                    item.getStatement().accept(this);
//                    break;
//                }
//            }
//        }
//        compoundStmt.setBlockItemArrayList(new_blockItems);
//
//
//        SymbolTable.pop();
//        return null;
//    }

    @Override
    public Void visit(CompoundStatement compoundStmt) {
        SymbolTable compound_table = new SymbolTable(SymbolTable.top);
        compoundStmt.set_symbol_table(compound_table);
        SymbolTable.push(compound_table);

        ArrayList<BlockItem> new_blockItems = new ArrayList<>();

        for (BlockItem item : compoundStmt.getBlockItemArrayList()) {
            new_blockItems.add(item);
//            if (terminated) break;
            if (item.getStatement() instanceof JumpStatement) {
                item.accept(this);
                break;
            }
            if (item.getStatement() instanceof SelectionStatement) {
                item.accept(this);
                if (andHame) {
                    break;
                }
            }

            item.accept(this);

//            if (item.getDeclaration() != null) {
//                item.getDeclaration().accept(this);
//            }
//
//            if (item.getStatement() != null) {
//                item.getStatement().accept(this);
////                if (doesAlwaysReturn(item.getStatement())) {
////                    terminated = true;
////                }
//            }
        }

        compoundStmt.setBlockItemArrayList(new_blockItems);
        SymbolTable.pop();
        return null;
    }


    private boolean doesAlwaysReturn(Statement stmt) {
        if (stmt instanceof JumpStatement) return true;

        if (stmt instanceof SelectionStatement sel) {
            List<Statement> branches = sel.getStatementArrayList();
            if (branches.size() == 2)
                return doesAlwaysReturn(branches.get(0)) && doesAlwaysReturn(branches.get(1));
        }

        if (stmt instanceof IterationStatement loop) {
            return doesAlwaysReturn(loop.getStatement());
        }

        if (stmt instanceof CompoundStatement comp) {
            for (BlockItem item : comp.getBlockItemArrayList()) {
                if (item.getStatement() != null && doesAlwaysReturn(item.getStatement()))
                    return true;
            }
        }

        return false;
    }



    @Override
    public Void visit(ForCondition forCondition) {
        if (forCondition.getExpression() != null) {
            forCondition.getExpression().accept(this);
        }
        if (forCondition.getForDeclaration() != null) {
            forCondition.getForDeclaration().accept(this);
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
//                    ArrayList<Expression> e = argumentExpressionList.getExpression();
//                    for (Expression s: e) {
//                        System.out.println("1"+ s.getTypeName());
//                    }
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

    @Override
    public Void visit(AssignmentExpression assignmentExpression) {
        String op = "";
        if (assignmentExpression.getLeft() != null) {
            assignmentExpression.getLeft().accept(this);
            op = assignmentExpression.getOperator().toString();
        }
        if (assignmentExpression.getRight() != null) {
            assignmentExpression.getRight().accept(this);
            op = assignmentExpression.getOperator().toString();
        }

        return null;
    }

    @Override
    public Void visit(Expression expr) {
        // If it's a function call, visit the argument list
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
        FunctionDefinitionSymbolTable func_dec_item = new FunctionDefinitionSymbolTable(functionDefinition);

        if (functionDefinition.getDeclarationSpecifiers() != null) {
            for (DeclarationSpecifiers d : functionDefinition.getDeclarationSpecifiers()) {
                if (d != null) {
                    d.accept(this);
                }
            }
        }
        if (functionDefinition.getDeclarator() != null) {
            String name = functionDefinition.getDeclarator().getDirectDeclarator().getDirectDeclarator().getIdentifier() + "#";
            int paramCount = 0;

            ParameterList paramList = functionDefinition.getDeclarator()
                    .getDirectDeclarator()
                    .getParameterList();
            if (paramList != null && paramList.getParameterDeclarationArrayList() != null)
                paramCount = paramList.getParameterDeclarationArrayList().size();

            name += String.valueOf(paramCount);

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

    @Override
    public Void visit(BinaryExpression binaryExpression) {
        if (binaryExpression.getLeft() != null) {
            binaryExpression.getLeft().accept(this);
        }
        if (binaryExpression.getRight() != null) {
            binaryExpression.getRight().accept(this);
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
//                System.out.print(iExp.getName() + " ");
                if (builtIns.contains(iExp.getName())) {
                    return null;
                }
                else {
                    if (functionCallExpression.getArgumentExpressionList() != null) {
                        ArgumentExpressionList argumentExpressionList = functionCallExpression.getArgumentExpressionList();
                        ArrayList<Expression> expressionList = argumentExpressionList.getExpression();

                        for (Expression expression: expressionList) {
//                            System.out.print(iExp.getName() + " ");
//                            System.out.println(expression.getExpressionArrayList().size());
                            name += "#" + expression.getExpressionArrayList().size();
//                            System.out.println("name "  + name);
                            try {
                                SymbolTable.top.getItem(name);
                            } catch (ItemNotFoundException e) {
//                                System.out.println("Line:" + exprName.getLine() + "-> " + ((IdentifierExpression) exprName).getName() + " not declared");
                            }
                        }
                    }
                    else {
                        name = "Function_" + ((IdentifierExpression) exprName).getName() + "#0";
//                        System.out.println("name1 "  + name);
                        try {
                            SymbolTable.top.getItem(name);
                        } catch (ItemNotFoundException e) {
//                            System.out.println("Line:" + exprName.getLine() + "-> " + ((IdentifierExpression) exprName).getName() + " not declared");
                        }
                    }
                }
            }

        }
        return null;
    }
}