package main.ast.nodes.declaration;

import main.visitor.IVisitor;

public class IdentifierDeclarator extends DirectDeclarator {
    private String identifier;

    public IdentifierDeclarator(String identifier) {
        this.identifier = identifier;
    }

    public String getIdentifier() {
        return identifier;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
