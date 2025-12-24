package main.ast.nodes.declaration;

import main.ast.nodes.Node;
import main.symbolTable.SymbolTable;
import main.visitor.IVisitor;

public class ForDeclaration extends Node {
    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public DeclarationSpecifiers getDeclarationSpecifiers() {
        return declarationSpecifiers;
    }

    public void setDeclarationSpecifiers(DeclarationSpecifiers declarationSpecifiers) {
        this.declarationSpecifiers = declarationSpecifiers;
    }

    private DeclarationSpecifiers declarationSpecifiers;
    private InitDeclaratorList initDeclaratorList;

    public InitDeclaratorList getInitDeclaratorList() {
        return initDeclaratorList;
    }

    public void setInitDeclaratorList(InitDeclaratorList initDeclaratorList) {
        this.initDeclaratorList = initDeclaratorList;
    }


    private SymbolTable symbolTable;
    public void set_symbol_table(SymbolTable forDeclarationTable) {
        this.symbolTable = forDeclarationTable;
    }
}
