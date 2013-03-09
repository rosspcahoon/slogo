package command.backup;

import java.util.HashMap;
import model.Room;
import model.BasicRoomObject;

/**
 * Class holding mappings for command keywords to command objects.
 * @author james
 *
 */
@Deprecated
public class CommandLibrary {

    /**
     * HashMap holding mappings between command names and command objects.
     * Command names defined according to the CommandKeywords class.
     */
    private HashMap<String,Command> myCommands;
    
    /**
     * HashMap matching command names to their aliases.
     */
    private HashMap<String,String> myAliases;
    
    /**
     * Constructor for the CommandLibrary class--instantiates the HashMap.
     */
    public CommandLibrary() {
        myCommands = new HashMap<String,Command>();
        myAliases = new HashMap<String,String>();
        buildLibrary();
    }
    
    /**
     * Called by the Model class to acquire the appropriate command object
     * and execute the command within the room.
     * @param r is the room to execute the command in.
     * @param args are the parsed input arguments.
     */
    public void processCommand(Room r, BasicRoomObject o, String[] args) {
        args[0] = getAlias(args[0].toLowerCase());
        String s = args[0];
        Command c = getCommand(s);
        c.addProperties(args);
        c.execute(r, o);
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
    
    /**
     * Replaces the command alias with its original name, if it is an alias
     * For instance, replaces fd 50 with forward 50.
     */
    private String getAlias(String name) {
        if (!myAliases.containsKey(name)) {
            return name;
        }
        return myAliases.get(name);
    }
    
    /**
     * Builds the command library and the alias map.
     */
    private void buildLibrary() {
        myAliases.put(CommandConstants.COMMAND_NAME_FD, CommandConstants.COMMAND_NAME_FORWARD);
        myAliases.put(CommandConstants.COMMAND_NAME_BK, CommandConstants.COMMAND_NAME_BACK);
        myAliases.put(CommandConstants.COMMAND_NAME_LT, CommandConstants.COMMAND_NAME_LEFT);
        myAliases.put(CommandConstants.COMMAND_NAME_RT, CommandConstants.COMMAND_NAME_RIGHT);
        myCommands.put(CommandConstants.COMMAND_NAME_FORWARD, new MoveCommand());
        myCommands.put(CommandConstants.COMMAND_NAME_BACK, new MoveCommand());
        myCommands.put(CommandConstants.COMMAND_NAME_LEFT, new MoveCommand());
        myCommands.put(CommandConstants.COMMAND_NAME_RIGHT, new MoveCommand());
    }
    
}
