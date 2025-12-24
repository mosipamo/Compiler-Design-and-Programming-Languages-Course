package main.ast.nodes.declaration;

import main.ast.nodes.Node;
import main.ast.nodes.expression.Expression;
import main.visitor.IVisitor;
import java.util.ArrayList;

public class ForExpression extends Node {
    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public ArrayList<Expression> getExpressionArrayList() {
        return expressionArrayList;
    }

    public void setExpressionArrayList(ArrayList<Expression> expressionArrayList) {
        this.expressionArrayList = expressionArrayList;
    }

    public void addExpression(Expression e) {
        this.expressionArrayList.add(e);
    }

    private ArrayList<Expression> expressionArrayList = new ArrayList<>();
}
