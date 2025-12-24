package main.ast.nodes.declaration;

import main.ast.nodes.Node;
import main.visitor.IVisitor;
import java.util.ArrayList;
import java.util.List;

public class InitDeclaratorList extends Node {
    private List<InitDeclarator> initDeclarators = new ArrayList<>();

    public void addInitDeclarator(InitDeclarator decl) {
        initDeclarators.add(decl);
    }

    public List<InitDeclarator> getInitDeclarators() {
        return initDeclarators;
    }

    public void setInitDeclarators(List<InitDeclarator> initDeclarators) {
        this.initDeclarators = initDeclarators;
    }

    @Override
    public String toString() {
        return "InitDeclaratorList{" + initDeclarators + "}";
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
