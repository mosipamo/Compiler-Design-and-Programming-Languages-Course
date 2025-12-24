package main.visitor;

import main.ast.nodes.*;
import main.ast.nodes.declaration.*;
import main.ast.nodes.declaration.DirectDeclarator;
import main.ast.nodes.expression.*;
import main.ast.nodes.expression.StringLiteralExpression;
import main.ast.nodes.statement.*;

public interface IVisitor<T> {
    T visit(TypeSpecifier program);

    T visit(TranslationUnit translationUnit);

    T visit(ExternalDeclaration externalDeclaration);

    T visit(Declaration declaration);

    T visit(DeclarationList declarationList);

    T visit(FunctionDefinition functionDefinition);

    T visit(Declarator declarator);

    T visit(CompoundStatement compoundStatement);

    T visit(Program program);

    T visit(DeclarationSpecifier declarationSpecifier);

    T visit(DeclarationSpecifiers declarationSpecifiers);

    T visit(InitDeclarator initDeclarator);

    T visit(InitDeclaratorList initDeclaratorList);

    T visit(Initializer initializer);

    T visit(TypeName typeName);

    T visit(ArgumentExpressionList argumentExpressionList);

    T visit(StringLiteralExpression stringLiteralExpression);

    T visit(PointerType pointerType);

    T visit(IdentifierDeclarator identifierDeclarator);

    T visit(DirectDeclarator directDeclarator);

    T visit(ParameterList parameterList);

    T visit(ParameterDeclaration parameterDeclaration);

    T visit(AbstractDeclarator abstractDeclaration);

    T visit(DirectAbstractDeclarator directAbstractDeclarator);

    T visit(InitializerList initializerList);

    T visit(Designation designation);

    T visit(Designator designator);

    T visit(BlockItem blockItem);

    T visit(ExpressionStatement expressionStatement);

    T visit(JumpStatement jumpStatement);

    T visit(IterationStatement iterationStatement);

    T visit(SelectionStatement selectionStatement);

    T visit(ForCondition forDeclaration);

    T visit(ForExpression forExpression);

    T visit(ForDeclaration forDeclaration);

    T visit(IdentifierExpression identifierExpression);

    T visit(ConstantExpression constantExpression);

    T visit(CastExpression castExpression);

    T visit(CommaExpression commaExpression);

    T visit(AssignmentExpression assignmentExpression);

    T visit(Expression expression);

    T visit(SpecifierQualifierList specifierQualifierList);

    T visit(IdentifierList identifierList);

    T visit(ThreeExpression threeExpression);

    T visit(BinaryExpression binaryExpression);

    T visit(FunctionCallExpression functionCallExpression);
}