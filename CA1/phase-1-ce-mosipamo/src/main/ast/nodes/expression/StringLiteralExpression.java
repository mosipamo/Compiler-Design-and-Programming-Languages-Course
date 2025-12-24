package main.ast.nodes.expression;

import main.visitor.IVisitor;

import java.util.ArrayList;

public class StringLiteralExpression extends Expression {
    private ArrayList<String> strings = new ArrayList<>();

    public void addStringLiteralExpression(String s) {
        this.strings.add(s);
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
