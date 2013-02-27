package model;

import java.util.List;
import java.util.ArrayList;
import command.Command;

public class Model implements Observable {

    private Parser myParser;
    private List<Command> myCommands;
    private Room myRoom;
    
    public Model(){
        myParser = new Parser();
        myCommands = new ArrayList<Command>();
    }
    

    public boolean processCommand (Room r, String s) {
        ArrayList<String> parsedString = (ArrayList<String>)myParser.parseString(s);
        
        notifyObservers();

        return true;
    }
    
    
    @Override
    public boolean process (String s) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean display () {
        // TODO Auto-generated method stub
        return false;
    }

}
