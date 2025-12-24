package main.ast.nodes.statement;

import main.ast.nodes.Statement;
import main.visitor.IVisitor;
import main.ast.nodes.expression.Expression;
import java.util.ArrayList;

public class SelectionStatement extends Statement {
    public ArrayList<Expression> getExpression() {
        return expressionArrayList;
    }

    public void setExpression(ArrayList<Expression> expression) {
        this.expressionArrayList = expression;
    }


    public ArrayList<Statement> getStatementArrayList() {
        return statementArrayList;
    }

    public void addExpression(Expression e) {
        this.expressionArrayList.add(e);
    }

    public void setStatementArrayList(ArrayList<Statement> statementArrayList) {
        this.statementArrayList = statementArrayList;
    }

    private ArrayList<Expression> expressionArrayList = new ArrayList<>();
    private ArrayList<Statement> statementArrayList = new ArrayList<>();

    public void addStatement(Statement s) {
        this.statementArrayList.add(s);
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
