package main.visitor;

import main.ast.nodes.*;
import main.ast.nodes.declaration.*;
import main.ast.nodes.expression.*;
import main.ast.nodes.statement.ExpressionStatement;
import main.ast.nodes.statement.IterationStatement;
import main.ast.nodes.statement.JumpStatement;
import main.ast.nodes.statement.SelectionStatement;
import main.symbolTable.SymbolTable;
import java.util.ArrayList;

public class ASTCleanerVisitor extends Visitor<Void> {
    @Override
    public Void visit(Program program) {
        ArrayList<ExternalDeclaration> newList = new ArrayList<>();
        for (ExternalDeclaration ext : program.getTranslationUnit().getExternalDeclaration()) {
            if (ext.getFunctionDefinition() != null) {
                String key = "Function_" + ext.getFunctionDefinition()
                        .getDeclarator()
                        .getDirectDeclarator()
                        .getDirectDeclarator()
                        .getIdentifier()
                        + "#" +
                        ext.getFunctionDefinition()
                                .getDeclarator()
                                .getDirectDeclarator()
                                .getParameterList()
                                .getParameterDeclarationArrayList()
                                .size();
                if (SymbolTable.root.items.containsKey(key)) {
                    newList.add(ext);
                }
            } else {
                // Keep other external declarations (e.g., variable decls)
                newList.add(ext);
            }
        }
        program.getTranslationUnit().setExternalDeclaration(newList);
        return null;
    }

    @Override
    public Void visit(DeclarationSpecifier declarationSpecifier) {
        return null;
    }

    @Override
    public Void visit(InitDeclarator initDeclarator) {
        return null;
    }

    @Override
    public Void visit(InitDeclaratorList initDeclaratorList) {
        return null;
    }

    @Override
    public Void visit(Initializer initializer) {
        return null;
    }

    @Override
    public Void visit(TypeName typeName) {
        return null;
    }

    @Override
    public Void visit(ArgumentExpressionList argumentExpressionList) {
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
        return null;
    }

    @Override
    public Void visit(ParameterList parameterList) {
        return null;
    }

    @Override
    public Void visit(ParameterDeclaration parameterDeclaration) {
        return null;
    }

    @Override
    public Void visit(AbstractDeclarator abstractDeclaration) {
        return null;
    }

    @Override
    public Void visit(DirectAbstractDeclarator directAbstractDeclarator) {
        return null;
    }

    @Override
    public Void visit(InitializerList initializerList) {
        return null;
    }

    @Override
    public Void visit(Designation designation) {
        return null;
    }

    @Override
    public Void visit(Designator designator) {
        return null;
    }

    @Override
    public Void visit(BlockItem blockItem) {
        return null;
    }

    @Override
    public Void visit(ExpressionStatement expressionStatement) {
        return null;
    }

    @Override
    public Void visit(JumpStatement jumpStatement) {
        return null;
    }

    @Override
    public Void visit(IterationStatement iterationStatement) {
        return null;
    }

    @Override
    public Void visit(SelectionStatement selectionStatement) {
        return null;
    }

    @Override
    public Void visit(ForCondition forDeclaration) {
        return null;
    }

    @Override
    public Void visit(ForExpression forExpression) {
        return null;
    }

    @Override
    public Void visit(ForDeclaration forDeclaration) {
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
        return null;
    }

    @Override
    public Void visit(CommaExpression commaExpression) {
        return null;
    }

    @Override
    public Void visit(AssignmentExpression assignmentExpression) {
        return null;
    }

    @Override
    public Void visit(Expression expression) {
        return null;
    }

    @Override
    public Void visit(SpecifierQualifierList specifierQualifierList) {
        return null;
    }

    @Override
    public Void visit(IdentifierList identifierList) {
        return null;
    }

    @Override
    public Void visit(ThreeExpression threeExpression) {
        return null;
    }

    @Override
    public Void visit(BinaryExpression binaryExpression) {
        return null;
    }

    @Override
    public Void visit(FunctionCallExpression functionCallExpression) {
        return null;
    }

    // You can expand this to also clean compound statements or declarations if needed
}
