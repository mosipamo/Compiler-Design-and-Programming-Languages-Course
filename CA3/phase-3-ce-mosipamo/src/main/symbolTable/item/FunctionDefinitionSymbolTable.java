package main.symbolTable.item;
import main.ast.nodes.declaration.*;

public class FunctionDefinitionSymbolTable extends SymbolTableItem {
    public static final String START_KEY = "Function_";
    private FunctionDefinition funcDec;

    public FunctionDefinitionSymbolTable(FunctionDefinition funcDec) {
        this.funcDec = funcDec;
    }
    public FunctionDefinition getFunctionDefinition() {
        return this.funcDec;
    }

    // Constructor for built-in function stubs like printf
    public FunctionDefinitionSymbolTable(String name) {
        this.funcDec = new FunctionDefinition();

        DirectDeclarator direct = new DirectDeclarator();
        direct.setIdentifier(name);

        Declarator decl = new Declarator();
        decl.setDirectDeclarator(direct);

        this.funcDec.setDeclarator(decl);
    }

    public FunctionDefinition getFuncDec() {
        return funcDec;
    }

    public void setFuncDec(FunctionDefinition funcDec) {
        this.funcDec = funcDec;
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

        return res;
    }
}
