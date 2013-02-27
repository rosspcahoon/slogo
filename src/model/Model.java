package model;

import java.util.List;
import java.util.Observable;
import command.Command;

public class Model implements ISLogoModel {

    private Command myCommand;
    
    public Model(){
        myCommand = new Command();
    }
    
    @Override
    public boolean processCommand (Room r, String s) {
        
        Object feedback = new Object();
        s.trim();
        String[] output = s.split(" ");
        myCommand.processCommand(r, output);
        return true;
    }


}
