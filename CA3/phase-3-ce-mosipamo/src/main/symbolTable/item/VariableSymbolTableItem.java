package main.symbolTable.item;

import main.ast.nodes.declaration.Declarator;

public class VariableSymbolTableItem extends SymbolTableItem {
    public static String STARTKEY = "Variable_";

    private Declarator declarator;

    public VariableSymbolTableItem(Declarator declarator) {
        this.declarator = declarator;
    }

    public Declarator getDeclarator() {
        return declarator;
    }

    private String name;
    public VariableSymbolTableItem(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    private int line;
    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line = line;
    }

    @Override
    public String getKey() {
        return STARTKEY + name;
    }

    private boolean visited;

    public boolean getVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }



    private boolean isInitialized = false;
    public boolean isInitialized() {
        return isInitialized;
    }

    public void setInitialized(boolean initialized) {
        this.isInitialized = initialized;
    }
}
