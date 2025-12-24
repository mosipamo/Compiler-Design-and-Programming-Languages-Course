package main.ast.nodes.declaration;

import main.ast.nodes.Node;
import main.visitor.IVisitor;

public class TypeName extends Node {
    private SpecifierQualifierList specifierQualifierList;
    private AbstractDeclarator abstractDeclarator;

    public SpecifierQualifierList getSpecifierQualifierList() {
        return this.specifierQualifierList;
    }
    public void setSpecifierQualifierList(SpecifierQualifierList specifier) {
        this.specifierQualifierList = specifier;
    }

    public AbstractDeclarator getAbstractDeclarator() {
        return abstractDeclarator;
    }
    public void setAbstractDeclarator(AbstractDeclarator abstractDeclarator) {
        this.abstractDeclarator = abstractDeclarator;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
