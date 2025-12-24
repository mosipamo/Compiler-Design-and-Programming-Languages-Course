package main.ast.nodes.expression;

import main.ast.nodes.Node;
import main.visitor.IVisitor;

import java.util.List;

public class PointerType extends Node {
    private int pointerLevel;
    private boolean isConst;

    public PointerType(int pointerLevel, boolean isConst) {
        this.pointerLevel = pointerLevel;
        this.isConst = isConst;
    }

    public int getPointerLevel() {
        return pointerLevel;
    }

    public void setPointerLevel(int pointerLevel) {
        this.pointerLevel = pointerLevel;
    }

    public boolean isConst() {
        return isConst;
    }

    public void setConst(boolean aConst) {
        isConst = aConst;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return null;
    }
}
