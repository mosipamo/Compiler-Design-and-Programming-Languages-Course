package main.ast.nodes.expression;

import main.visitor.IVisitor;

public class FunctionCallExpression extends Expression{
    public Expression getExpression() {
        return expression;
    }

    public void setExpression(Expression expression) {
        this.expression = expression;
    }

    private Expression expression;

    public ArgumentExpressionList getArgumentExpressionList() {
        return argumentExpressionList;
    }

    public void setArgumentExpressionList(ArgumentExpressionList argumentExpressionList) {
        this.argumentExpressionList = argumentExpressionList;
    }

    private ArgumentExpressionList argumentExpressionList;

    public String getLeft_par() {
        return left_par;
    }

    public void setLeft_par(String left_par) {
        this.left_par = left_par;
    }

    private String left_par;

    public String getRight_par() {
        return right_par;
    }

    public void setRight_par(String right_par) {
        this.right_par = right_par;
    }

    private String right_par;

    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }


    private boolean visited;

    public boolean getVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }
}
