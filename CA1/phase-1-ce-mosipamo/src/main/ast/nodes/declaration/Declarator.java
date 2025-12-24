package main.ast.nodes.declaration;

import main.ast.nodes.Node;
import main.ast.nodes.expression.PointerType;
import main.visitor.IVisitor;

public class Declarator extends Node {

    public Declarator(String identifier) {
        this.identifier = identifier;
    }

    public Declarator() {}

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

    private PointerType pointer;
    private String identifier;
    private DirectDeclarator directDeclarator;

    public void setPointer(PointerType pointer) {
        this.pointer = pointer;
    }
    public void setDirectDeclarator(DirectDeclarator directDeclarator) {
        this.directDeclarator = directDeclarator;
    }

    public PointerType getPointer() {
        return pointer;
    }
    public DirectDeclarator getDirectDeclarator() {
        return directDeclarator;
    }
}
