package main.ast.nodes;

import main.visitor.IVisitor;

public abstract class Statement extends Node {
    public abstract <T> T accept(IVisitor<T> visitor);
}