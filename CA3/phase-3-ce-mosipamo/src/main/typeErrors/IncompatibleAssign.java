package main.typeErrors;


public class IncompatibleAssign extends TypeError {
    public IncompatibleAssign(int line){
        this.line = line;
    }
    public String getErrorMessage(){ return "Line:" + this.line + "-> Incompatible types on the two sides of the assign statment."; }

}
