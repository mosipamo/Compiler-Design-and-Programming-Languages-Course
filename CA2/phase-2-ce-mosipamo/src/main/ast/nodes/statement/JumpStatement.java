package main.ast.nodes.statement;

import main.ast.nodes.Statement;
import main.ast.nodes.expression.Expression;
import main.visitor.IVisitor;

public class JumpStatement extends Statement {
    public Expression getExpression() {
        return expression;
    }

    public void setExpression(Expression expression) {
        this.expression = expression;
    }

    private Expression expression;

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public String getKeyword() {
        return jumpType;
    }

    public void setKeyword(String jumpType) {
        this.jumpType = jumpType;
    }

    private String jumpType; // e.g., "return", "break", "continue"

}
