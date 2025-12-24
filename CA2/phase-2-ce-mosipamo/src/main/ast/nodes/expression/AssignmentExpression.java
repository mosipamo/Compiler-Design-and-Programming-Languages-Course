package main.ast.nodes.expression;

import main.visitor.IVisitor;
import main.ast.nodes.expression.operator.AssignmentOperator;

public class AssignmentExpression extends Expression {
    public AssignmentOperator getOperator() {
        return operator;
    }

    private Expression left;

    public Expression getRight() {
        return right;
    }

    private Expression right;
    private AssignmentOperator operator;

    public void setLeft(Expression left) {
        this.left = left;
    }

    public Expression getLeft() {
        return this.left;
    }

    public void setRight(Expression right) {
        this.right = right;
    }
    public void setOperator(AssignmentOperator operator) {
        this.operator = operator;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
