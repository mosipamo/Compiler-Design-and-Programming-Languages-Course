package main.ast.nodes.expression;

import main.ast.nodes.declaration.TypeName;
import main.visitor.IVisitor;

public class CastExpression extends Expression {
    private TypeName typeName;
    private CastExpression castExpression;
    private Expression expression;

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public TypeName getTypeName() {
        return typeName;
    }

    public void setTypeName(TypeName typeName) {
        this.typeName = typeName;
    }

    public Expression getExpression() {
        return expression;
    }

    public void setExpression(Expression expression) {
        this.expression = expression;
    }

    public CastExpression getCastExpression() {
        return castExpression;
    }

    public void setCastExpression(CastExpression castExpression) {
        this.castExpression = castExpression;
    }
}
