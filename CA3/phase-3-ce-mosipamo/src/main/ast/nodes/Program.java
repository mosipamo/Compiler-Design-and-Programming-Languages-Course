package main.ast.nodes;

import main.symbolTable.SymbolTable;
import main.visitor.IVisitor;

public class Program extends Node{

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

    private TranslationUnit translationUnit;
    public void setTranslationUnit(TranslationUnit translationUnit) {
        this.translationUnit = translationUnit;
    }
    public TranslationUnit getTranslationUnit() {
        return translationUnit;
    }


    private SymbolTable symbol_table;

    public void set_symbol_table(SymbolTable symbol_table) {
        this.symbol_table = this.symbol_table;
    }
}