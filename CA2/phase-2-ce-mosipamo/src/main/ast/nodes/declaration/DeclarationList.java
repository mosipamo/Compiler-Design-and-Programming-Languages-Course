package main.ast.nodes.declaration;

import main.ast.nodes.Declaration;
import main.ast.nodes.Node;
import main.visitor.IVisitor;

import java.util.ArrayList;

public class DeclarationList extends Node {
    private ArrayList<Declaration> declarationArrayList = new ArrayList<>();
    public void addDeclaration(Declaration d) {
        declarationArrayList.add(d);
    }

    public ArrayList<Declaration> getDeclarations() {
        return declarationArrayList;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
