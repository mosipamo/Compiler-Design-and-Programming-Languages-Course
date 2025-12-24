package main.ast.nodes.declaration;

import main.ast.nodes.Node;
import main.visitor.IVisitor;

import java.util.ArrayList;

public class Designation extends Node {
    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public ArrayList<Designator> getDesignatorArrayList() {
        return designatorArrayList;
    }

    public void setDesignatorArrayList(ArrayList<Designator> designatorArrayList) {
        this.designatorArrayList = designatorArrayList;
    }

    public void addDesignator(Designator d) {
        this.designatorArrayList.add(d);
    }

    private ArrayList<Designator> designatorArrayList = new ArrayList<>();
}
