package main.ast.nodes.declaration;

import main.ast.nodes.Node;
import main.visitor.IVisitor;

import java.util.ArrayList;

public class DeclarationSpecifiers extends Node {
    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

    private ArrayList<DeclarationSpecifier> specifiers = new ArrayList<>();

    public void addSpecifier(DeclarationSpecifier specifier) {
        this.specifiers.add(specifier);
    }

    public ArrayList<DeclarationSpecifier> getSpecifiers() {
        return specifiers;
    }

    public void setSpecifiers(ArrayList<DeclarationSpecifier> specifiers) {
        this.specifiers = specifiers;
    }
}