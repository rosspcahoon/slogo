package model;

import java.util.List;

import java.util.Observable;
import model.command.CommandManager;

/**
 * Controls the interaction of model side classes.
 * @author mp
 *
 */
public class Model implements ISLogoModel {

    private CommandManager myCommandManager;
    
    public Model(){
        myCommandManager = new CommandManager();
    }
    
    /**
     * splits input command string into an array of words, and passes to the 
     * CommandLibrary to process the commands.
     * @param r Room to process commands on
     * @param s command string
     */
    @Override
    public int processCommand (Room r, String s) {
        return myCommandManager.process(r, s);
    }


}
