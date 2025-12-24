package main.ast.nodes.expression;
import main.ast.nodes.declaration.InitializerList;
import main.ast.nodes.declaration.TypeName;
import main.visitor.IVisitor;

public class PtrExpression extends Expression{

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return null;
    }

    @Override
    public InitializerList getInitializerList() {
        return initializerList;
    }

    @Override
    public void setInitializerList(InitializerList initializerList) {
        this.initializerList = initializerList;
    }

    private InitializerList initializerList;

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
