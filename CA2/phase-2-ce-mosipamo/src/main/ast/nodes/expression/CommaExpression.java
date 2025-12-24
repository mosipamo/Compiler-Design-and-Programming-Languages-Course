package main.ast.nodes.expression;

import main.visitor.IVisitor;

import java.util.ArrayList;

public class CommaExpression extends Expression {
    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public ArrayList<Expression> getExpressionArrayList() {
        return expressionArrayList;
    }

    public void setExpressionArrayList(ArrayList<Expression> expression) {
        this.expressionArrayList = expression;
    }

    public void addExpression(Expression expression) {
        expressionArrayList.add(expression);
    }

    private ArrayList<Expression> expressionArrayList = new ArrayList<>();

    public ArrayList<String> getComma() {
        return comma;
    }

    public void setComma(ArrayList<String> comma) {
        this.comma = comma;
    }

    public void addComma(String c) {
        this.comma.add(c);
    }

    private ArrayList<String> comma = new ArrayList<>();
}
