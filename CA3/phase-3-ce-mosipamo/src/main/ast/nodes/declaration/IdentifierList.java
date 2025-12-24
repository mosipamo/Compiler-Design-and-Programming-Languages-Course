package main.ast.nodes.declaration;

import main.ast.nodes.Node;
import main.visitor.IVisitor;

import java.util.ArrayList;
import java.util.List;

public class IdentifierList extends Node {
    private List<String> identifiers;

    public IdentifierList() {
        this.identifiers = new ArrayList<>();
    }

    public void addIdentifier(String identifier) {
        this.identifiers.add(identifier);
    }

    public List<String> getIdentifiers() {
        return identifiers;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }
}