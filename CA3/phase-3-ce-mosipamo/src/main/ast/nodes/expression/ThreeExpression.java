package main.ast.nodes.expression;

import main.visitor.IVisitor;

public class ThreeExpression extends Expression {
    private Expression midExpr;
    private Expression leftExpr;
    private Expression rightExpr;

    private String leftOp;
    private String rightOp;

    public Expression getLeft() {
        return this.leftExpr;
    }
    public Expression getMid() {
        return this.midExpr;
    }
    public Expression getRight() {
        return this.rightExpr;
    }

    public void setLeft(Expression left) {
        this.leftExpr = left;
    }

    public void setRight(Expression right) {
        this.rightExpr = right;
    }

    public void setMid(Expression midExpr) {
        this.midExpr = midExpr;
    }

    public void setLeftOp(String op) {
        this.leftOp = op; }

    public void setRightOp(String op) {
        this.rightOp = op;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }
}