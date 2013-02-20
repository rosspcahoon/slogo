package command;

public abstract class Command {

    String myLiteral;
    
    public void setLiteral(String s) {
        myLiteral=s;
    }
    
    public String getLiteral() {
        return myLiteral;
    }
}
