package main.visitor;

import main.ast.nodes.*;
import main.ast.nodes.expression.*;
import main.ast.nodes.statement.*;
import main.ast.nodes.declaration.*;
import java.util.ArrayList;

public class TestVisitor extends Visitor<Void> {
    private static final String EXPRSTRING = ": Expr ";
    private static final String LINESTRING = "Line ";
    private static final String EQUALSTRING = " = ";
    private static final String EXPRESSIONQUAL = "Expr ";

    private int countNumOfStatements(Statement stmt) {
        int cnt = 0;

        if (stmt instanceof CompoundStatement b) {
//            System.out.println("Allo + " + b.getBlockItemArrayList().size());
            cnt += b.getBlockItemArrayList().size();
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
        if (program.getTranslationUnit() != null) {
            program.getTranslationUnit().accept(this);
        }
        return null;
    }

    @Override
    public Void visit(DeclarationSpecifier declarationSpecifier) {
        if (declarationSpecifier.getTypeSpecifier() != null) {
            declarationSpecifier.getTypeSpecifier().accept(this);
        }
        return null;
    }

    @Override
    public Void visit(InitDeclarator initDeclarator) {
        if (initDeclarator.getDeclarator() != null) {
            initDeclarator.getDeclarator().accept(this);
        }
        if (initDeclarator.getInitializer() != null) {
            initDeclarator.getInitializer().accept(this);
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

        if (cond instanceof CommaExpression) {
            for (String s :  ((CommaExpression) cond).getComma()) {

            }
//          System.out.println(LINESTRING + cond.getLine() + EXPRSTRING + s);

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
    public Void visit(ArgumentExpressionList argumentExpressionList) {
        System.out.println("mamad");
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
            helperPrint(iterationStatement, SHIT + iterationStatement.getLoopType() + EQUALSTRING +  count);
        }
        return null;
    }

    @Override
    public Void visit(SelectionStatement selectionStatement) {
        if (selectionStatement.getExpression() != null) {
            for (Statement s: selectionStatement.getStatementArrayList()) {
                if (s != null) {
                    s.accept(this);
                }
            }
        }
        ArrayList<Expression> cond = selectionStatement.getExpression();
        for (Expression e : cond) {
            if (e instanceof ConstantExpression) {
//                helperPrint(e, EXPRESSIONQUAL + ((ConstantExpression) e).getConstant());
            }
        }

        if (selectionStatement.getStatementArrayList() != null) {
            for (Statement s : selectionStatement.getStatementArrayList()) {
                if (s != null) {
                    s.accept(this);
                    int count = countNumOfStatements(s);
                    String ANS = "Stmt selection = ";
                    helperPrint(s, ANS + count);
                }
            }
        }
        return null;
    }

    @Override
    public Void visit(CompoundStatement compoundStatement) {
//        if (compoundStatement.getStatements() != null) {
//            for (Statement s : compoundStatement.getStatements()) {
//                if (s != null) {
//                    s.accept(this);
//                }
//            }
//        }
        if (compoundStatement.getBlockItemArrayList() != null) {
            for (BlockItem b : compoundStatement.getBlockItemArrayList()) {
                if (b != null) {
                    b.accept(this);
                }
            }
        }
        return null;
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
    public Void visit(IdentifierExpression identifierExpression) {
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

//        System.out.println(LINESTRING + assignmentExpression.getLine() + EXPRSTRING + op);
        return null;
    }

    @Override
    public Void visit(Expression expression) {
        if (expression.getTypeName() != null) {
            expression.getTypeName().accept(this);
        }
        if (expression.getArgumentExpressionList() != null) {
            expression.getArgumentExpressionList().accept(this);
        }
        if (expression.getInitializerList() != null) {
            expression.getInitializerList().accept(this);
        }
        if (expression.getExpressionArrayList() != null) {
            for (Expression e : expression.getExpressionArrayList()) {
                if (e != null) {
                    e.accept(this);
                }
            }
        }
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
        if (functionDefinition.getDeclarationSpecifiers() != null) {
            for (DeclarationSpecifiers d : functionDefinition.getDeclarationSpecifiers()) {
                if (d != null) {
                    d.accept(this);
                }
            }
        }
        int parameters = 0;
        if (functionDefinition.getDeclarator() != null) {
            Declarator d = functionDefinition.getDeclarator();
            if (d != null) {
                DirectDeclarator dd = d.getDirectDeclarator();
                if (dd != null) {
                    if (dd.getParameterList() != null) {
                        if (dd.getParameterList().getParameterDeclarationArrayList() != null) {
                            parameters = dd.getParameterList().getParameterDeclarationArrayList().size();
                        }
                    }
                }

            }

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


        String STATEMENTSTRING = "Stmt function ";
        helperPrint(functionDefinition.getCompoundStatement(), STATEMENTSTRING +
                functionDefinition.getDeclarator().getDirectDeclarator().getDirectDeclarator().getIdentifier() + EQUALSTRING +
                countNumOfStatements(functionDefinition.getCompoundStatement()) + " " +  parameters);

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
//        System.out.println(binaryExpression.getLeft().getTypeName());
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
        return null;
    }
}