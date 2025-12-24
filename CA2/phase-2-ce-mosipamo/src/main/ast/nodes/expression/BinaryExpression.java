package main.ast.nodes.expression;

import main.visitor.IVisitor;

public class BinaryExpression extends Expression {
    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }
    private Expression right;
    private Expression left;
    private String op;

    public Expression getLeft() {
        return left;
    }

    public Expression getRight() {
        return right;
    }

    public String getOp() {
        return op;
    }

    public void setLeft(Expression left) {
        this.left = left;
    }
    public void setRight(Expression right) {
        this.right = right;
    }
    public void setOperator(String op) {
        this.op = op;
    }
}