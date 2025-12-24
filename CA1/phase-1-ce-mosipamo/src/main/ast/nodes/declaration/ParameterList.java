package main.ast.nodes.declaration;

import main.ast.nodes.Node;
import main.visitor.IVisitor;

import java.util.ArrayList;

public class ParameterList extends Node {
    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public ArrayList<ParameterDeclaration> getParameterDeclarationArrayList() {
        return parameterDeclarationArrayList;
    }

    public void setParameterDeclarationArrayList(ArrayList<ParameterDeclaration> parameterDeclarationArrayList) {
        this.parameterDeclarationArrayList = parameterDeclarationArrayList;
    }

    private ArrayList<ParameterDeclaration> parameterDeclarationArrayList = new ArrayList<>();

    public void addParameterDeclaration(ParameterDeclaration parameterLists) {
        this.parameterDeclarationArrayList.add(parameterLists);
    }
}
