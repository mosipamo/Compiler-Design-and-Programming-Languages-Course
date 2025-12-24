package main.ast.nodes.declaration;

import main.ast.nodes.Declaration;
import main.ast.nodes.Node;
import main.ast.nodes.Statement;
import main.visitor.IVisitor;

public class BlockItem extends Node {
    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public Declaration getDeclaration() {
        return declaration;
    }

    public void setDeclaration(Declaration declaration) {
        this.declaration = declaration;
    }

    public Statement getStatement() {
        return statement;
    }

    public void setStatement(Statement statement) {
        this.statement = statement;
    }
    private Statement statement;
    private Declaration declaration;
}
