package main.ast.nodes.expression;

import main.ast.nodes.declaration.InitializerList;
import main.ast.nodes.declaration.TypeName;
import main.visitor.IVisitor;

public class PtrExpressionWithoutInitializerList extends Expression{

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return null;
    }

    @Override
    public TypeName getTypeName() {
        return typeName;
    }

    @Override
    public void setTypeName(TypeName typeName) {
        this.typeName = typeName;
    }

    private TypeName typeName;

}
