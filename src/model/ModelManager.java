package model;

import java.util.List;
import command.Command;

public class ModelManager implements ISLogoModel {

    private Parser myParser;
    private List<Command> myCommands;
    private Room myRoom;
    
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
