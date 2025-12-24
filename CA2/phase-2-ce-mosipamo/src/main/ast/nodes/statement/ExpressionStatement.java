package main.ast.nodes.statement;

import main.ast.nodes.Statement;
import main.visitor.IVisitor;
import main.ast.nodes.expression.Expression;

public class ExpressionStatement extends Statement {
    private Expression expression;

    public Expression getExpression() {
        return expression;
    }

    public void setExpression(Expression expression) {
        this.expression = expression;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
