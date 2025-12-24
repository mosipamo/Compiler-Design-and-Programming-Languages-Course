package main.ast.nodes.expression;

import main.visitor.IVisitor;

public class IdentifierExpression extends Expression {
    private String name;

    public IdentifierExpression(String name) {
        this.name = name;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public String getName() {
        return name;
    }
}
