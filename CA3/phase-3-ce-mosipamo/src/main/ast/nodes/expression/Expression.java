package main.ast.nodes.expression;

import main.ast.nodes.Node;
import main.ast.nodes.declaration.*;
import main.ast.nodes.expression.operator.*;
import main.visitor.IVisitor;

import java.lang.reflect.Array;
import java.util.ArrayList;

public abstract class Expression extends Node {
    public TypeName getTypeName() {
        return typeName;
    }

    public String to_string() {
        return this.getTypeName().toString();
    }

    public void setTypeName(TypeName typeName) {
        this.typeName = typeName;
    }

    private TypeName typeName;
    private ArgumentExpressionList argumentExpressionList;
    private InitializerList initializerList;
    private AssignmentOperator assignmentOperator;
    private UnaryOperator unaryOperator;

    public ArrayList<Expression> getExpressionArrayList() {
        return expressionArrayList;
    }

    public void setExpressionArrayList(ArrayList<Expression> expressionArrayList) {
        this.expressionArrayList = expressionArrayList;
    }

    private ArrayList<Expression> expressionArrayList = new ArrayList<>();

    public ArgumentExpressionList getArgumentExpressionList() {
        return argumentExpressionList;
    }

    public void setArgumentExpressionList(ArgumentExpressionList argumentExpressionList) {
        this.argumentExpressionList = argumentExpressionList;
    }


    public InitializerList getInitializerList() {
        return initializerList;
    }

    public void setInitializerList(InitializerList initializerList) {
        this.initializerList = initializerList;
    }


    public AssignmentOperator getAssignmentOperator() {
        return assignmentOperator;
    }

    public void setAssignmentOperator(AssignmentOperator assignmentOperator) {
        this.assignmentOperator = assignmentOperator;
    }


    public UnaryOperator getUnaryOperator() {
        return unaryOperator;
    }

    public void setUnaryOperator(UnaryOperator unaryOperator) {
        this.unaryOperator = unaryOperator;
    }

    public abstract <T> T accept(IVisitor<T> visitor);

    public void addExpression(Expression e) {
        this.expressionArrayList.add(e);
    }

    public ArrayList<String> getTemp_op() {
        return temp_op;
    }

    public void setTemp_op(String temp_op) {
        this.temp_op.add(temp_op);
    }

    public void addTemp_op(String s) {
        this.temp_op.add(s);
    }

    private ArrayList<String> temp_op = new ArrayList<>();

    public String getShit() {
        return shit;
    }

    public void setShit(String shit) {
        this.shit = shit;
    }

    private String shit;

    private boolean visited = false;
    public boolean getVisited() {
        return visited;
    }
    public void setVisited() {
        this.visited = true;
    }
}