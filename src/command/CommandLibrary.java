package command;

import java.util.HashMap;
import model.Room;

/**
 * Class holding mappings for command keywords to command objects.
 * @author james
 *
 */
public class CommandLibrary {

    /**
     * HashMap holding mappings between command names and command objects.
     * Command names defined according to the CommandKeywords class.
     */
    private HashMap<String,Command> myCommands;
    
    /**
     * Constructor for the CommandLibrary class--instantiates the HashMap.
     */
    public CommandLibrary() {
        myCommands = new HashMap<String,Command>();
    }
    
    /**
     * Called by the Model class to acquire the appropriate command object
     * and execute the command within the room.
     * @param r is the room to execute the command in.
     * @param args are the parsed input arguments.
     */
    public void processCommand(Room r, String[] args) {
        String s = args[0];
        s = s.toLowerCase();
        Command c = getCommand(s);
        c.addProperties(args);
        c.execute(r);
    }
    
    /**
     * Gets the appropriate command object from the library, or gives an
     * error if none exists.
     */
    private Command getCommand(String name) {
        if (!myCommands.containsKey(name)) {
            // TODO: add code for setting error status in room
            return null;
        }
        return myCommands.get(name);
    }
    
}
