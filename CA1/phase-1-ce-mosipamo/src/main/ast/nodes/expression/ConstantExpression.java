package main.ast.nodes.expression;

import main.visitor.IVisitor;

public class ConstantExpression extends Expression {
    private String constant;

    public ConstantExpression(String constant) {
        this.constant = constant;
    }

    public String getConstant() {
        return constant;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
