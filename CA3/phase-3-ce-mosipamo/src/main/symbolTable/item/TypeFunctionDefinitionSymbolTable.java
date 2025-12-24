package main.symbolTable.item;

import main.ast.nodes.declaration.FunctionDefinition;
import main.ast.nodes.declaration.ParameterList;

import java.util.ArrayList;

public class TypeFunctionDefinitionSymbolTable extends SymbolTableItem {
    public static final String START_KEY = "Function_";
    public TypeFunctionDefinitionSymbolTable(FunctionDefinition funcDec, String returnType, ArrayList<String> mamad) {
        this.funcDec = funcDec;
        this.returnType = returnType;
        this.argsType = mamad;
    }

    private FunctionDefinition funcDec;
    public FunctionDefinition getFunctionDefinition() {
        return this.funcDec;
    }
    public void setFuncDec(FunctionDefinition funcDec) {
        this.funcDec = funcDec;
    }

    private ArrayList<String> argsType;
    public ArrayList<String> getArgsType() {
        return argsType;
    }
    public void setArgsType(ArrayList<String> argsType) {
        this.argsType = argsType;
    }
    private void addArgsType(String ar) {
        this.argsType.add(ar);
    }

    private String returnType;
    public String getReturnType() {
        return returnType;
    }
    public void setReturnType(String returnType) {
        this.returnType = returnType;
    }

    @Override
    public String getKey() {
        ParameterList paramList = funcDec.getDeclarator()
                .getDirectDeclarator()
                .getParameterList();
        int paramCount = 0;
        if (paramList != null && paramList.getParameterDeclarationArrayList() != null) {
            paramCount = paramList.getParameterDeclarationArrayList().size();
        }
        String res = "";
        res += START_KEY + this.funcDec.getDeclarator().getDirectDeclarator().getDirectDeclarator().getIdentifier() + "#" + paramCount;
//        res += "#" + this.returnType + "#" + this.argsType;
        return res;
    }
}
