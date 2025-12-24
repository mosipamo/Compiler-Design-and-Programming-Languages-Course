package main.visitor;

import main.ast.nodes.*;
import main.ast.nodes.declaration.*;
import main.ast.nodes.expression.*;
import main.ast.nodes.statement.*;
import main.symbolTable.SymbolTable;
import main.symbolTable.exceptions.ItemAlreadyExistsException;
import main.symbolTable.exceptions.ItemNotFoundException;
import main.symbolTable.item.FunctionDefinitionSymbolTable;
import main.symbolTable.item.SymbolTableItem;
import main.symbolTable.item.VariableSymbolTableItem;

import javax.swing.plaf.IconUIResource;
import java.util.*;

public class Opt1VisitorRemove extends Visitor<Void> {
    private static final Set<String> builtIns = Set.of("printf", "scanf");
    public Vector<SymbolTableItem> not_used = new Vector<>();
    public Vector<FunctionDefinitionSymbolTable> shit = new Vector<>();
    private boolean insideForCondition = false;

    public void set(Vector<SymbolTableItem> s) {
        this.not_used = s;
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
//                if (directDeclarator.getDirectDeclarator() != null) {
//                    String name = directDeclarator.getDirectDeclarator().getIdentifier();
////                    System.out.println("fucj yo + " + name);
//                    VariableSymbolTableItem varItem = new VariableSymbolTableItem(name);
//                    try {
//                        SymbolTable.top.put(varItem);
////                        not_used.add(varItem);
//                    } catch (ItemAlreadyExistsException e) {
//                        //                System.out.println("Line " + declarationSpecifier.getLine() +
//                        //                        " -> Not Declared \"" + varName + "\"");
//                    }
//                }
//                else {
//                    String name = directDeclarator.getIdentifier();
////                    System.out.println("here + " + name);
//                    VariableSymbolTableItem varItem = new VariableSymbolTableItem(name);
//                    varItem.setLine(directDeclarator.getLine());
//                    try {
//                        SymbolTable.top.put(varItem);
////                        not_used.add(varItem);
//                    } catch (ItemAlreadyExistsException e) {
//                        //                System.out.println("Line " + declarationSpecifier.getLine() +
//                        //                        " -> Not Declared \"" + varName + "\"");
//                    }
//                }
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
//            System.out.println("2: " + varName);
            VariableSymbolTableItem varItem = new VariableSymbolTableItem(varName);
            varItem.setVisited(false);
            varItem.setLine(declarationSpecifier.getTypeSpecifier().getLine());
            try {
                SymbolTable.top.put(varItem);
//                not_used.add(varItem);
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
            String name = directDeclarator.getDirectDeclarator().getIdentifier();
//            System.out.println("fuck + " + name);
            if (directDeclarator.getExpression() != null) {
                VariableSymbolTableItem varItem = new VariableSymbolTableItem(name);
                varItem.setVisited(false);
                varItem.setLine(directDeclarator.getDirectDeclarator().getLine());
                int line = directDeclarator.getLine();
                varItem.setLine(line);
//                System.out.println("3: " + name);       //get arr declaration
                try {
                    SymbolTable.top.put(varItem);
//                    not_used.add(varItem);
                } catch (ItemAlreadyExistsException e) {
//                    anses.add("Line:" + directDeclarator.getLine() + "-> " + name + " not declared");
                }
            }
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
            VariableSymbolTableItem item = (VariableSymbolTableItem) SymbolTable.top.getItem("Variable_" + name);
            item.setVisited(true);
        } catch (ItemNotFoundException e) {

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
        SymbolTable forDeclaration_table = new SymbolTable(SymbolTable.top);
        iterationStatement.set_symbol_table(forDeclaration_table);
        SymbolTable.push(forDeclaration_table);

        if (iterationStatement.getForCondition() != null) {
            if (iterationStatement.getForCondition().getForDeclaration() != null) {
                if (iterationStatement.getForCondition().getForDeclaration().getInitDeclaratorList() != null) {
                    List<InitDeclarator> initDeclaratorArrayList = iterationStatement.getForCondition().getForDeclaration().getInitDeclaratorList().getInitDeclarators();
                    for (InitDeclarator id: initDeclaratorArrayList) {
                        if (id.getDeclarator() != null) {
                            Declarator d = id.getDeclarator();
                            if (d != null) {
                                DirectDeclarator dd = d.getDirectDeclarator();
                                if (dd !=  null) {
                                    String name = dd.getIdentifier();
                                    VariableSymbolTableItem varItem = new VariableSymbolTableItem(name);
                                    varItem.setVisited(false);
                                    varItem.setLine(dd.getLine());
//                                    System.out.println("4: " + name);
                                    try {
                                        SymbolTable.top.put(varItem);
//                                        not_used.add(varItem);
                                    } catch (ItemAlreadyExistsException e) {
//                                        System.out.println("Line:" + iterationStatement.getLine() + "-> " + name + " not declared");
//                                        not_used.add()
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
        if (iterationStatement.getExpression() != null) {
            iterationStatement.getExpression().accept(this);
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
        ArrayList<BlockItem> new_blockItems = new ArrayList<>();
        for (BlockItem item : list) {
            if (item.getDeclaration() != null) {
                if (not_used.size() == 0) {
//                    System.out.println("!");
//                    new_blockItems.add(item);
                }
                Declaration d = item.getDeclaration();
                if (d.getInitDeclaratorList() != null) {
                    InitDeclaratorList i = d.getInitDeclaratorList();
                    if (i.getInitDeclarators() != null) {
                        List<InitDeclarator> id = i.getInitDeclarators();
                        for (InitDeclarator ii: id) {
                            if (ii.getDeclarator() != null) {
                                Declarator dd = ii.getDeclarator();
                                if (dd.getDirectDeclarator() != null) {
                                    DirectDeclarator dddd = dd.getDirectDeclarator();
                                    if (dddd.getDirectDeclarator() == null) {
//                                        System.out.println("an");
                                    }
                                    else {
//                                        System.out.println("dddd " + dddd.getLine());
//                                        System.out.println(dddd.getIdentifier());

                                        boolean found = false;
                                        for (SymbolTableItem s: not_used) {
                                            if (dddd.getIdentifier() == ((VariableSymbolTableItem) s).getName() && dddd.getLine() == ((VariableSymbolTableItem) s).getLine() ) {
    //                                            System.out.println(((VariableSymbolTableItem) s).getLine() + "** " + ((VariableSymbolTableItem) s).getName() + " !! " + s);
                                                found = true;
                                                not_used.remove(s);
                                                break;
                                            }
                                        }
                                        if (!found) {

                                            new_blockItems.add(item);
                                            item.getDeclaration().accept(this);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (item.getStatement() != null) {
                if (item.getStatement() instanceof ExpressionStatement) {
                    ExpressionStatement s = ((ExpressionStatement)item.getStatement());
                    if (s.getExpression() != null) {
                        Expression ex = s.getExpression();

                        if (ex.getArgumentExpressionList() != null) {
                            ArgumentExpressionList alx = ex.getArgumentExpressionList();
                            ArrayList<Expression> arrayList = alx.getExpression();
                            if (not_used.size() == 0) {
//                                System.out.print(item.getLine());
//                                System.out.println(arrayList.size());




                                if (ex instanceof FunctionCallExpression fCall) {
                                    Expression targetExpr = fCall.getExpression();
                                    if (targetExpr instanceof IdentifierExpression idExpr) {
                                        String funcName = idExpr.getName();

                                        ArrayList<Expression> args = fCall.getArgumentExpressionList().getExpression();
                                        ArrayList<Expression> newArgs = new ArrayList<>();

                                        // Get the function definition
                                        for (SymbolTableItem items : SymbolTable.root.items.values()) {
                                            if (items instanceof FunctionDefinitionSymbolTable fd) {
                                                FunctionDefinition def = fd.getFunctionDefinition();
                                                if (def.getDeclarator().getDirectDeclarator().getDirectDeclarator().getIdentifier().equals(funcName)) {
                                                    ParameterList paramList = def.getDeclarator().getDirectDeclarator().getParameterList();
                                                    if (paramList == null || paramList.getParameterDeclarationArrayList() == null)
                                                        break;

                                                    ArrayList<ParameterDeclaration> paramDecls = paramList.getParameterDeclarationArrayList();

                                                    for (int i = 0; i < Math.min(args.size(), paramDecls.size()); i++) {
                                                        ParameterDeclaration p = paramDecls.get(i);
                                                        boolean remove = false;

                                                        if (p.getDeclarator() != null && p.getDeclarator().getDirectDeclarator() != null) {
                                                            String paramName = p.getDeclarator().getDirectDeclarator().getIdentifier();
                                                            int line = p.getDeclarator().getDirectDeclarator().getLine();

                                                            for (SymbolTableItem ss : not_used) {
                                                                if (ss instanceof VariableSymbolTableItem v &&
                                                                        v.getName().equals(paramName) &&
                                                                        v.getLine() == line) {
                                                                    remove = true;
                                                                    break;
                                                                }
                                                            }
                                                        }

                                                        if (!remove) {
                                                            newArgs.add(args.get(i));
                                                        }
                                                    }

                                                    fCall.getArgumentExpressionList().setExpression(newArgs);
                                                    break;
                                                }
                                            }
                                        }
                                    }
                                }

                                // Here

                                new_blockItems.add(item);
                                item.getStatement().accept(this);
                                continue;
                            }
                            int cnt = 0;
                            for (Expression e: arrayList) {
                                if (e instanceof IdentifierExpression) {
                                    if (not_used.size() == 0) {
//                                        System.out.println("goh");
                                        new_blockItems.add(item);
                                        item.getStatement().accept(this);
                                    }
                                    else {
                                        boolean found = false;
                                        for (SymbolTableItem ss: not_used) {
//                                            System.out.println(((IdentifierExpression) e).getName() + " " + ((IdentifierExpression) e).getLine());
                                            if (((IdentifierExpression) e).getName() == ((VariableSymbolTableItem) ss).getName()) {
//                                        System.out.println(((VariableSymbolTableItem) ss).getLine() + "** " + ((VariableSymbolTableItem) ss).getName() + " !! " + s);
                                                found = true;
                                                not_used.remove(ss);
                                                break;
                                            }
                                        }
                                        if (!found) {
//                                            System.out.println(item.getLine());
                                            new_blockItems.add(item);
                                            item.getStatement().accept(this);
                                        }
                                    }
                                }
                                if (e instanceof StringLiteralExpression) {
                                    cnt += 1;
                                }
                            }
                            if (cnt == arrayList.size()) {
//                                System.out.println(item);
                                new_blockItems.add(item);
                                item.getStatement().accept(this);
                            }
                        }
                        else {
                            new_blockItems.add(item);
                            item.getStatement().accept(this);
                        }
//                        if (ex.getExpressionArrayList() != null) {
//                            ArrayList<Expression> expressions= ex.getExpressionArrayList();
//                            for (Expression eee: expressions) {
//                                System.out.println("eee + " + eee);
//                            }
//                        }
                    }
                }
                else {
                    new_blockItems.add(item);
                    item.getStatement().accept(this);
                }
            }
        }
//        System.out.println("size: " + new_blockItems);
        compoundStmt.setBlockItemArrayList(new_blockItems);
//        for (BlockItem c: compoundStmt.getBlockItemArrayList()) {
//            System.out.println("an agha " + c);
//        }
        return null;
    }


    @Override
    public Void visit(ForCondition forCondition) {
        boolean prev = insideForCondition;
        insideForCondition = true;
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
        insideForCondition = prev;
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
            Declarator d = functionDefinition.getDeclarator();
            ArrayList<ParameterDeclaration> parameterDeclarationArrayList = new ArrayList<>();

            if (d.getDirectDeclarator() != null) {
                DirectDeclarator dd = d.getDirectDeclarator();
                if (dd.getParameterList() != null) {
                    ParameterList p = dd.getParameterList();
                    if (p.getParameterDeclarationArrayList() != null) {
                        ArrayList<ParameterDeclaration> pp = p.getParameterDeclarationArrayList();
                        for (ParameterDeclaration item: pp) {
//                            parameterDeclarationArrayList.clear();


                            if (item.getDeclarationSpecifiers() != null) {
                                DeclarationSpecifiers df = item.getDeclarationSpecifiers();
                                if (df.getSpecifiers() != null) {
                                    ArrayList<DeclarationSpecifier> dfd = df.getSpecifiers();
                                    for (DeclarationSpecifier ds: dfd) {
                                        if (ds.getTypeSpecifier().getTypeName() != null) {
                                            boolean found = false;
//                                            System.out.println("fucking test: " + ds.getTypeSpecifier().getTypeName() + " " + ds.getTypeSpecifier().getLine());
                                            for (SymbolTableItem ss: not_used) {
//                                                System.out.println("unused: " + ((VariableSymbolTableItem) ss).getName());
                                                if (ds.getTypeSpecifier().getTypeName() == ((VariableSymbolTableItem) ss).getName() && ds.getTypeSpecifier().getLine() == ((VariableSymbolTableItem) ss).getLine()) {
//                                                    System.out.println("fucking test2: " + ((VariableSymbolTableItem) ss).getName() + " " + ((VariableSymbolTableItem) ss).getLine());
                                                    if (ds.getTypeSpecifier().getTypeName() == "int" || ds.getTypeSpecifier().getTypeName()== "void" || ds.getTypeSpecifier().getTypeName()== "char"  ||
                                                            ds.getTypeSpecifier().getTypeName()== "short" || ds.getTypeSpecifier().getTypeName()== "long" ||
                                                            ds.getTypeSpecifier().getTypeName()== "double" || ds.getTypeSpecifier().getTypeName()== "float" ||
                                                            ds.getTypeSpecifier().getTypeName()== "signed" || ds.getTypeSpecifier().getTypeName()== "unsigned" || ds.getTypeSpecifier().getTypeName().contains("bool"))
                                                    {
                                                        continue;
                                                    }
                                                    else {
//                                                        System.out.println(ds.getTypeSpecifier().getTypeName());
                                                        found = true;
                                                        not_used.remove(ss);
//                                                        System.out.println("Allo: " + SymbolTable.top.items);
//                                                        System.out.println("hazf");
                                                        ((VariableSymbolTableItem) ss).setVisited(true);
                                                        break;
                                                    }
                                                }
//                                                else {
//                                                    parameterDeclarationArrayList.add(item);
//                                                }
                                            }
                                            if (!found) {
                                                if (ds.getTypeSpecifier().getTypeName() == "int" || ds.getTypeSpecifier().getTypeName()== "void" || ds.getTypeSpecifier().getTypeName()== "char"  ||
                                                        ds.getTypeSpecifier().getTypeName()== "short" || ds.getTypeSpecifier().getTypeName()== "long" ||
                                                        ds.getTypeSpecifier().getTypeName()== "double" || ds.getTypeSpecifier().getTypeName()== "float" ||
                                                        ds.getTypeSpecifier().getTypeName()== "signed" || ds.getTypeSpecifier().getTypeName()== "unsigned" || ds.getTypeSpecifier().getTypeName().contains("bool"))
                                                {
//                                                    continue;
                                                }
                                                else {
//                                                    System.out.println("oomad");
//                                                    p.getParameterDeclarationArrayList().remove(item);
                                                    parameterDeclarationArrayList.add(item);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (functionDefinition.getDeclarator() != null) {
                if (functionDefinition.getDeclarator().getDirectDeclarator() != null) {
                    if (functionDefinition.getDeclarator().getDirectDeclarator().getParameterList() != null) {
                        functionDefinition.getDeclarator().getDirectDeclarator().getParameterList().setParameterDeclarationArrayList(parameterDeclarationArrayList);
                    }
                }
            }
//            System.out.println(func_dec_item.getKey());
            try {
                SymbolTable.top.put(func_dec_item);
                shit.add(func_dec_item);
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
//    @Override
//    public Void visit(FunctionDefinition functionDefinition) {
//        FunctionDefinitionSymbolTable func_dec_item = new FunctionDefinitionSymbolTable(functionDefinition);
//
//        if (functionDefinition.getDeclarationSpecifiers() != null) {
//            for (DeclarationSpecifiers d : functionDefinition.getDeclarationSpecifiers()) {
//                if (d != null) {
//                    d.accept(this);
//                }
//            }
//        }
//        if (functionDefinition.getDeclarator() != null) {
//            String name = functionDefinition.getDeclarator().getDirectDeclarator().getDirectDeclarator().getIdentifier() + "#";
//            int paramCount = 0;
//
//            ParameterList paramList = functionDefinition.getDeclarator()
//                    .getDirectDeclarator()
//                    .getParameterList();
//            if (paramList != null && paramList.getParameterDeclarationArrayList() != null)
//                paramCount = paramList.getParameterDeclarationArrayList().size();
//
//            name += String.valueOf(paramCount);
//
//            try {
//                SymbolTable.top.put(func_dec_item);
//            } catch (ItemAlreadyExistsException e) {
//                System.out.println("Redefinition of function \"" + functionDefinition.getDeclarator().getDirectDeclarator().getDirectDeclarator().getIdentifier() +"\" in line " + functionDefinition.getLine());
//            }
//            SymbolTable func_dec_symbol_table = new SymbolTable(SymbolTable.top);
//            functionDefinition.set_symbol_table(func_dec_symbol_table);
//            SymbolTable.push(func_dec_symbol_table);
//            functionDefinition.getDeclarator().accept(this);
//        }
//        if (functionDefinition.getDeclarationList() != null) {
//            for (DeclarationList d : functionDefinition.getDeclarationList()) {
//                if (d != null) {
//                    d.accept(this);
//                }
//            }
//        }
//        if (functionDefinition.getCompoundStatement() != null) {
//            functionDefinition.getCompoundStatement().accept(this);
//        }
//
//        SymbolTable.pop();
//
//        return null;
//    }


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
//            System.out.println("name: " + name);
            if (exprName instanceof IdentifierExpression) {
                IdentifierExpression iExp = ((IdentifierExpression) exprName);
                if (builtIns.contains(iExp.getName())) {
                    return null;
                }
                else {
                    if (functionCallExpression.getArgumentExpressionList() != null) {
                        ArgumentExpressionList argumentExpressionList = functionCallExpression.getArgumentExpressionList();
                        ArrayList<Expression> expressionList = argumentExpressionList.getExpression();

//                        for (Expression expression: expressionList) {
//                            System.out.println(name + " mamad: " + expressionList.size());
//                            System.out.print(iExp.getName() + " ");
//                            System.out.println(expression.getExpressionArrayList().size());
//                            if (expressionList.size() == 0) {
//                                name += "#0";
//                            }
//                            else {
//                        System.out.println(name);
                        String func_name = name;
//                        name += "#" + expressionList.size();
//                        System.out.println(name);
//                        System.out.println(SymbolTable.top.items);
//                        System.out.println(shit);
                        for (FunctionDefinitionSymbolTable f: shit) {
                            String signiture = f.getKey();
                            int ind = signiture.indexOf('#');
                            String nameee = "";
                            String param = "";

                            for (int i = 0; i < ind; i++) {
                                nameee += signiture.charAt(i);
                            }
                            for (int i = ind; i < signiture.length(); i++) {

                                param += signiture.charAt(i);
                            }
//                            System.out.println("test: " + name  + " " + nameee);
                            if (name.equals(nameee)) {
                                name = nameee  + param;
//                                System.out.println(name);
                                break;
                            }
//                            System.out.println(nameee + "" + param);
                        }
//                        System.out.println(name);
//                        try {
//                            SymbolTable.top.getItem(name);
//                        } catch (ItemNotFoundException e) {
////                            System.out.println("name: " + name);
////                            System.out.println("akasoadjbsff");
////                                System.out.println("Line:" + exprName.getLine() + "-> " + ((IdentifierExpression) exprName).getName() + " not declared");
////                            anses.add("Line:" + exprName.getLine() + "-> " + ((IdentifierExpression) exprName).getName() + " not declared");
//                        }
//                        }
                    }
                    else {
                        name = "Function_" + ((IdentifierExpression) exprName).getName() + "#0";
//                        System.out.println(SymbolTable.top.items);
//                        try {
//                            SymbolTable.top.getItem(name);
//                        } catch (ItemNotFoundException e) {
////                            System.out.println("Line:" + exprName.getLine() + "-> " + ((IdentifierExpression) exprName).getName() + " not declared");
////                            anses.add("Line:" + exprName.getLine() + "-> " + ((IdentifierExpression) exprName).getName() + " not declared");
//                        }
                    }
                }
            }

        }
        return null;
    }

    public void chap() {
        for (SymbolTableItem s: not_used) {
            if (s instanceof VariableSymbolTableItem) {
                if (((VariableSymbolTableItem) s).getVisited() == false) {
//                    System.out.println("Ridam");
                    System.out.println(((VariableSymbolTableItem) s) +"   " +  ((VariableSymbolTableItem) s).getName() + " " + ((VariableSymbolTableItem) s).getLine());
                }
            }
        }
    }
}