package main.ast.nodes.statement;

import java.util.ArrayList;
import java.util.List;
import main.ast.nodes.*;
import main.ast.nodes.declaration.BlockItem;
import main.symbolTable.SymbolTable;
import main.visitor.IVisitor;

public class CompoundStatement extends Statement {
    private List<Statement> statements;
    private ArrayList<BlockItem> blockItemArrayList = new ArrayList<>();

    public CompoundStatement() {
        this.statements = new ArrayList<>();
    }

    public void addStatement(Statement statement) {
        this.statements.add(statement);
    }

    public List<Statement> getStatements() {
        return this.statements;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public ArrayList<BlockItem> getBlockItemArrayList() {
        return blockItemArrayList;
    }

    public void setBlockItemArrayList(ArrayList<BlockItem> blockItemArrayList) {
        this.blockItemArrayList = blockItemArrayList;
    }

    public void addBlockItem(BlockItem b) {
        this.blockItemArrayList.add(b);
    }

    private SymbolTable symbolTable;
    public void set_symbol_table(SymbolTable compound) {
        this.symbolTable = compound;
    }
}
