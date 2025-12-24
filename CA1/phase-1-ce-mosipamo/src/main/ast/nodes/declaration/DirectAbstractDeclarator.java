package main.ast.nodes.declaration;

import main.ast.nodes.Node;
import main.ast.nodes.expression.Expression;
import main.visitor.IVisitor;

public class DirectAbstractDeclarator extends Node {
    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

    private Expression expression;
    private AbstractDeclarator abstractDeclarator;
    private ParameterList parameterList;
    private DirectAbstractDeclarator directAbstractDeclarator;

    public void setDirectAbstractDeclarator(DirectAbstractDeclarator directAbstractDeclarator) {
        this.directAbstractDeclarator = directAbstractDeclarator;
    }

    public void setExpression(Expression expression) {
        this.expression = expression;
    }

    public void setAbstractDeclarator(AbstractDeclarator abstractDeclarator) {
        this.abstractDeclarator = abstractDeclarator;
    }

    public void setParameterList(ParameterList parameterList) {
        this.parameterList = parameterList;
    }

    public DirectAbstractDeclarator getDirectAbstractDeclarator() {
        return directAbstractDeclarator;
    }

    public Expression getExpression() {
        return expression;
    }

    public AbstractDeclarator getAbstractDeclarator() {
        return abstractDeclarator;
    }

    public ParameterList getParameterList() {
        return parameterList;
    }
}