package main.ast.nodes.declaration;

import main.ast.nodes.Node;
import main.ast.nodes.expression.Expression;
import main.visitor.IVisitor;

import java.util.ArrayList;

public class ForCondition extends Node {
    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public Expression getExpression() {
        return expression;
    }

    public void setExpression(Expression expression) {
        this.expression = expression;
    }

    public ForDeclaration getForDeclaration() {
        return forDeclaration;
    }

    public void setForDeclaration(ForDeclaration forDeclaration) {
        this.forDeclaration = forDeclaration;
    }

    private ForDeclaration forDeclaration;
    private Expression expression;
    private ArrayList<ForExpression> forExpressionArrayList = new ArrayList<>();

    public ArrayList<ForExpression> getForExpressionArrayList() {
        return forExpressionArrayList;
    }

    public void setForExpressionArrayList(ArrayList<ForExpression> forExpressionArrayList) {
        this.forExpressionArrayList = forExpressionArrayList;
    }

    public void addForExpression(ForExpression f) {
        this.forExpressionArrayList.add(f);
    }
}
