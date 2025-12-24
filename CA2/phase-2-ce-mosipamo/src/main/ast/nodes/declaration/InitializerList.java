package main.ast.nodes.declaration;

import main.ast.nodes.Node;
import main.visitor.IVisitor;

import java.util.ArrayList;

public class InitializerList extends Node {
    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public ArrayList<Designation> getDesignationArrayList() {
        return designationArrayList;
    }

    public void setDesignationArrayList(ArrayList<Designation> designationArrayList) {
        this.designationArrayList = designationArrayList;
    }

    public void addDesignation(Designation d) {
        this.designationArrayList.add(d);
    }

    private ArrayList<Designation> designationArrayList = new ArrayList<>();

    private ArrayList<Initializer> initializerArrayList = new ArrayList<>();

    public ArrayList<Initializer> getInitializerArrayList() {
        return initializerArrayList;
    }

    public void setInitializerArrayList(ArrayList<Initializer> initializerArrayList) {
        this.initializerArrayList = initializerArrayList;
    }

    public void addInitializer(Initializer i) {
        this.initializerArrayList.add(i);
    }
}
