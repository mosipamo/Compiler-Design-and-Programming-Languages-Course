package main.ast.nodes.statement;

import main.ast.nodes.Statement;
import main.ast.nodes.declaration.ForCondition;
import main.visitor.IVisitor;
import main.ast.nodes.expression.Expression;

public class IterationStatement extends Statement {
    public Expression getExpression() {
        return expression;
    }

    public void setExpression(Expression expression) {
        this.expression = expression;
    }


    public Statement getStatement() {
        return statement;
    }

    public void setStatement(Statement statement) {
        this.statement = statement;
    }

    private Expression expression;
    private Statement statement;
    private ForCondition forCondition;

    public ForCondition getForCondition() {
        return forCondition;
    }

    public void setForCondition(ForCondition forCondition) {
        this.forCondition = forCondition;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public String getLoopType() {
        return loopType;
    }

    public void setLoopType(String loopType) {
        this.loopType = loopType;
    }

    private String loopType;
}
