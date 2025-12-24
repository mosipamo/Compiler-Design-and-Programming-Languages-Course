package main.visitor;

import main.ast.nodes.*;
import main.ast.nodes.declaration.*;
import main.ast.nodes.expression.*;
import main.ast.nodes.expression.operator.UnaryOperator;
import main.ast.nodes.statement.*;
import main.symbolTable.SymbolTable;
import main.symbolTable.exceptions.ItemAlreadyExistsException;
import main.symbolTable.exceptions.ItemNotFoundException;
import main.symbolTable.item.FunctionDefinitionSymbolTable;
import main.symbolTable.item.VariableSymbolTableItem;

import java.util.*;

public class UserControlledMalloc extends Visitor<Void> {
    private static final Set<String> builtIns = Set.of("printf", "scanf", "malloc", "free", "realloc", "calloc");
    private final ArrayList<String> anses = new ArrayList<>();

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
                    try {
                        SymbolTable.top.put(varItem);
                    } catch (ItemAlreadyExistsException e) {

                    }
                }
                else {
                    String name = directDeclarator.getIdentifier();
                    VariableSymbolTableItem varItem = new VariableSymbolTableItem(name);
                    try {
                        SymbolTable.top.put(varItem);
                    } catch (ItemAlreadyExistsException e) {

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
            if (directDeclarator.getExpression() != null) {
                VariableSymbolTableItem varItem = new VariableSymbolTableItem(name);
                varItem.setLine(directDeclarator.getLine());
                try {
                    SymbolTable.top.put(varItem);
                } catch (ItemAlreadyExistsException e) {
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
            Declarator d = parameterDeclaration.getDeclarator();
            if (d.getDirectDeclarator() != null) {
                DirectDeclarator dd = d.getDirectDeclarator();
                String pointerNameInParameter = dd.getIdentifier();
                VariableSymbolTableItem varItem = new VariableSymbolTableItem(pointerNameInParameter);
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
                                    varItem.setLine(dd.getLine());
                                    try {
                                        SymbolTable.top.put(varItem);
                                    } catch (ItemAlreadyExistsException e) {
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

    @Override
    public Void visit(AssignmentExpression assignmentExpression) {
        if (assignmentExpression.getLeft() != null) {
            assignmentExpression.getLeft().accept(this);
        }
        if (assignmentExpression.getRight() != null) {
            assignmentExpression.getRight().accept(this);
        }

        return null;
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
        FunctionDefinitionSymbolTable func_dec_item = new FunctionDefinitionSymbolTable(functionDefinition);

        if (functionDefinition.getDeclarationSpecifiers() != null) {
            for (DeclarationSpecifiers d : functionDefinition.getDeclarationSpecifiers()) {
                if (d != null) {
                    d.accept(this);
                }
            }
        }
        if (functionDefinition.getDeclarator() != null) {
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
        if (functionCallExpression.getExpression() != null) {
            String pointerName = "";
            String pointerKind = "";

            Expression exp = functionCallExpression.getExpression();
            if (exp instanceof IdentifierExpression) {
                pointerKind = ((IdentifierExpression) exp).getName();
                if (pointerKind.equals("free")) {
                    if (functionCallExpression.getArgumentExpressionList() != null) {
                        ArgumentExpressionList argumentExpressionList = functionCallExpression.getArgumentExpressionList();
                        if (argumentExpressionList.getExpression() != null) {
                            ArrayList<Expression> expr = argumentExpressionList.getExpression();
                            for (Expression ee: expr) {
                                if (ee instanceof IdentifierExpression) {
                                    pointerName = ((IdentifierExpression) ee).getName();
                                    try {
                                        String name = "Variable_" + pointerName;
                                        SymbolTable.top.getItem(name);
                                    } catch (ItemNotFoundException e) {
                                    }
                                }
                            }
                        }
                    }
                }

                if (pointerKind.equals("scanf")) {
                    ArgumentExpressionList argList = functionCallExpression.getArgumentExpressionList();
                    if (argList != null) {
                        for (Expression arg : argList.getExpression()) {
                            if (arg instanceof CastExpression unary && unary.getUnaryOperator() == UnaryOperator.AND) {
                                Expression inner = unary.getExpression();
                                if (inner instanceof IdentifierExpression idInner) {
                                    String varName = idInner.getName();
                                    String key = "Variable_" + varName;
                                    anses.add(varName);
                                    try {
                                        SymbolTable.top.getItem(key);
                                    } catch (ItemNotFoundException e) {
                                    }
                                }
                            }
                        }
                    }
                }
                if (pointerKind.equals("malloc") || pointerKind.equals("realloc") || pointerKind.equals("calloc")) {
                    ArgumentExpressionList argList = functionCallExpression.getArgumentExpressionList();
                    if (argList != null) {
                        for (Expression arg : argList.getExpression()) {
                            if (arg instanceof BinaryExpression) {
                                if (((BinaryExpression) arg).getLeft() instanceof IdentifierExpression) {
                                    String name = ((IdentifierExpression) ((BinaryExpression) arg).getLeft()).getName();
                                    if (anses.contains(name)) {
                                        System.out.println("Line:" + functionCallExpression.getLine() + " -> user-controlled value used in malloc");
                                    }
                                }
                                if (((BinaryExpression) arg).getRight() instanceof IdentifierExpression) {
                                    String name = ((IdentifierExpression) ((BinaryExpression) arg).getRight()).getName();
                                    if (anses.contains(name)) {
                                        System.out.println("Line:" + functionCallExpression.getLine() + " -> user-controlled value used in malloc");
                                    }
                                }
                            }

                            if (arg instanceof CastExpression unary && unary.getUnaryOperator() == UnaryOperator.AND) {
                                Expression inner = unary.getExpression();
                                if (inner instanceof IdentifierExpression idInner) {
                                    String varName = idInner.getName();
                                    String key = "Variable_" + varName;
                                    anses.add(varName);
                                    try {
                                        SymbolTable.top.getItem(key);
                                    } catch (ItemNotFoundException f) {
                                    }
                                }
                            }
                        }
                    }
                }
            }

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
                        }
                    }
                    else {
                        name = "Function_" + ((IdentifierExpression) exprName).getName() + "#0";
                        try {
                            SymbolTable.top.getItem(name);
                        } catch (ItemNotFoundException e) {
                        }
                    }
                }
            }
        }
        if (functionCallExpression.getArgumentExpressionList() != null) {
            functionCallExpression.getArgumentExpressionList().accept(this);
        }
        return null;
    }
}
