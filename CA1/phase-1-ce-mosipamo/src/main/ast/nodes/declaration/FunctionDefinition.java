package main.ast.nodes.declaration;

import main.ast.nodes.Node;
import main.ast.nodes.statement.CompoundStatement;
import main.visitor.IVisitor;
import java.util.ArrayList;

public class FunctionDefinition extends Node {
    ArrayList<DeclarationSpecifiers> declarationSpecifiersArrayList = new ArrayList<>();

    public void addDeclarationSpecifiers(DeclarationSpecifiers ds) {
        this.declarationSpecifiersArrayList.add(ds);
    }

    public ArrayList<DeclarationSpecifiers> getDeclarationSpecifiers() {
        return this.declarationSpecifiersArrayList;
    }

    private Declarator declarator;

    public void setDeclarator(Declarator d) {
        this.declarator = d;
    }
    public Declarator getDeclarator() {
        return this.declarator;
    }

    ArrayList<DeclarationList> declarationListArrayList = new ArrayList<>();

    public void addDeclarationList(DeclarationList dl) {
        this.declarationListArrayList.add(dl);
    }
    public ArrayList<DeclarationList> getDeclarationList() {
        return this.declarationListArrayList;
    }

    private CompoundStatement compoundStatement;
    public void setCompoundStatement(CompoundStatement cs) {
        this.compoundStatement = cs;
    }
    public CompoundStatement getCompoundStatement() {
        return this.compoundStatement;
    }

    public String getFunctionName() {
        if (declarator != null)
            return declarator.getIdentifier();
        return null;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }
}