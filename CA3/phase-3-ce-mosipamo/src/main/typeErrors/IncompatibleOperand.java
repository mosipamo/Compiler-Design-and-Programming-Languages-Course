package main.typeErrors;

public class IncompatibleOperand extends TypeError {
    public IncompatibleOperand(int line){
        this.line = line;
    }
    public String getErrorMessage(){return "Line:" + this.line + "-> Incompatible operand(s)";}

}
