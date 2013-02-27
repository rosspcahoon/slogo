package command;

import java.util.HashMap;
import model.Room;

/**
 * Abstract class representing a command that can be executed in the room.
 * @author james
 *
 */
public abstract class Command {
    
    private HashMap<String,Double> myProperties;
    private int myExpectedArgs;
    
    /**
     * Constructor for the Command class. Instantiates the properties map.
     */
    public Command(int expectedArgs) {
        myProperties = new HashMap<String,Double>();
        myExpectedArgs = expectedArgs;
    }
    
    /**
     * Gets the value of a property from the properties map.
     */
    public Double getProperty(String name) {
        if (!myProperties.containsKey(name)) {
            return null;
        }
        return myProperties.get(name);
    }
    
    /**
     * Adds a property to the properties map, or updates its value if it exists.
     */
    public void addProperty(String name, Double value) {
        myProperties.put(name, value);
    }
    
    /**
     * Checks if the correct number of args were passed to the command. 
     */
    public boolean checkArgsLength(String[] args) {
        return myExpectedArgs == args.length;
    }
    
    /**
     * Adds the args to the command's properties. Overwritten by subclasses.
     * @param args
     */
    public abstract void addProperties(String[] args);

    /**
     * Executes the command in the given room.
     */
    public abstract void execute(Room r);
    
}
