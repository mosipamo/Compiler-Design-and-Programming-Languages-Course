package main.typeErrors;

public class WrongCondition extends TypeError {
    public WrongCondition(int line){
        this.line = line;
    }
    public String getErrorMessage(){return "Line:" + this.line + "-> if statement's condition should be of boolean type";}

}
