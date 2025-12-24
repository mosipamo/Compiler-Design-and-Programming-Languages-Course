package main.ast.nodes.expression.operator;

import main.visitor.IVisitor;

public enum UnaryOperator {
    AND("&"),
    STAR("*"),
    PLUS("+"),
    MINUS("-"),
    TILDE("~"),
    NOT("!");

    private final String symbol;

    UnaryOperator(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
