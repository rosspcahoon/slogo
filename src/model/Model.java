package model;

import java.util.List;
import java.util.Observable;
import command.Command;

public class Model extends Observable implements ISLogoModel {

    private Parser myParser;
    private List<Command> myCommands;
    private Room myRoom;
    
    @Override
    public boolean processCommand (Room r, String s) {
        // TODO Auto-generated method stub
        Object feedback = new Object();
        notifyObservers(feedback);
        return true;
    }


}
