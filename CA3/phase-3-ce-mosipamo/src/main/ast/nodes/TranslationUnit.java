package main.ast.nodes;

import main.visitor.IVisitor;
import java.util.ArrayList;

public class TranslationUnit extends Node{
    private ArrayList<ExternalDeclaration> externalDeclarations = new ArrayList<>();

    public void addExternalDeclaration(ExternalDeclaration edc) {
            externalDeclarations.add(edc);
    }

    public ArrayList<ExternalDeclaration> getExternalDeclaration() {
        return externalDeclarations;
    }

    public void setExternalDeclaration(ArrayList<ExternalDeclaration> extDec) {
        this.externalDeclarations = extDec;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
