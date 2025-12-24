package main.ast.nodes.expression;

import main.visitor.IVisitor;

import java.util.ArrayList;

public class ArgumentExpressionList extends Expression {
    private ArrayList<Expression> expressionArrayList = new ArrayList<>();
    public void addExpression(Expression expr) {
        expressionArrayList.add(expr);
    }

    public ArrayList<Expression> getExpression() {
        return expressionArrayList;
    }
    public void setExpression(ArrayList<Expression> expressions) { this.expressionArrayList=expressions;}
    public void setArgumentExpressionList(ArrayList<Expression> arguments) {
        this.expressionArrayList = arguments;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
