package main.ast.nodes.declaration;

import main.ast.nodes.Node;
import main.ast.nodes.expression.PointerType;
import main.visitor.IVisitor;
import java.util.ArrayList;

public class AbstractDeclarator extends Node {
    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public ArrayList<PointerType> getPointerTypeArrayList() {
        return pointerTypeArrayList;
    }

    public void setPointerTypeArrayList(ArrayList<PointerType> pointerTypeArrayList) {
        this.pointerTypeArrayList = pointerTypeArrayList;
    }

    public void addPointerType(PointerType p) {
        this.pointerTypeArrayList.add(p);
    }

    private ArrayList<PointerType> pointerTypeArrayList;
    private DirectAbstractDeclarator directAbstractDeclarator;

    public DirectAbstractDeclarator getDirectAbstractDeclarator() {
        return directAbstractDeclarator;
    }

    public void setDirectAbstractDeclarator(DirectAbstractDeclarator directAbstractDeclarator) {
        this.directAbstractDeclarator = directAbstractDeclarator;
    }
}