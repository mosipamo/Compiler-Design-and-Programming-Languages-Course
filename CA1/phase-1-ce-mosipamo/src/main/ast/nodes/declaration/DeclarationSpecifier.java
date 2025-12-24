package main.ast.nodes.declaration;

import main.ast.nodes.Node;
import main.visitor.IVisitor;

public class DeclarationSpecifier extends Node {
    private String keyword;
    private TypeSpecifier typeSpecifier;

    public DeclarationSpecifier(String keyword) {
        this.keyword = keyword;
    }

    public DeclarationSpecifier(TypeSpecifier typeSpecifier) {
        this.typeSpecifier = typeSpecifier;
    }

    public String getKeyword() {
        return keyword;
    }

    public TypeSpecifier getTypeSpecifier() {
        return typeSpecifier;
    }

    public void setTypeSpecifier(TypeSpecifier t) {
        this.typeSpecifier = t;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }
}