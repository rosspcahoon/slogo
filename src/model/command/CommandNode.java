package model.command;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import model.Room;

/**
 * Abstract class representing a node in the command tree.
 * @author james
 *
 */
public abstract class CommandNode {

    private List<CommandNode> myChildren;
    private int myExpectedArgs;
    private Room myRoom;
    
    protected CommandNode() {
        myChildren = new ArrayList<CommandNode>();
    }    
    
    /**
     * Resolves this node--called by parent in it's own resolve method.
     * @throws Exception 
     */
    public abstract int resolve() throws Exception;
    
    /**
     * Performs basic setup of a node after it is created--involves establishing
     * its children nodes with the appropriate arguments. The passed scanner holds
     * the means to continue reading the input string.
     * @throws Exception 
     */
    public void setUp(Scanner s, Room r) throws Exception {
//        clearChildren();
        setMyRoom(r);
        int expected = getMyExpectedArgs();
        for (int i=0; i<expected; i++) {
            String nextString = s.next();
            nextString = nextString.toLowerCase();
            CommandNode nextNode = CommandLibrary.getCommandNode(nextString);
            addChild(nextNode);            
            nextNode.setUp(s, r);
        }
    }
    
    /**
     * Sets the number of expected args for this node.
     */
    public void setMyExpectedArgs(int args) {
        myExpectedArgs = args;
    }
    
    /**
     * Gets the number of expected args for this node.
     */
    public int getMyExpectedArgs() {
        return myExpectedArgs;
    }
    
    /**
     * Sets the current room.
     */
    public void setMyRoom(Room r) {
        myRoom = r;
    }
    
    /**
     * Gets the current room.
     */
    public Room getMyRoom() {
        return myRoom;
    }
    
    /**
     * Returns a copy of the command node as a new instance.
     */
    public abstract CommandNode getCopyOfInstance();
    
    /**
     * Prints out the CommandNode class type, value (if applicable), and children.
     */
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(this.getClass());
        builder.append("\nChildren:\n");
        for (CommandNode child : getChildren()) {
            builder.append(child.getClass());
            builder.append("\n");
        }
        return builder.toString();
    }
    
    /**
     * Adds a child to this node's list.
     */
    public void addChild(CommandNode child) {
        myChildren.add(child);
    }
    
    /**
     * Reads the children of the node.
     */
    public List<CommandNode> getChildren() {
        return myChildren;
    }
    
    /**
     * Removes all children from the node.
     */
    public void clearChildren() {
        myChildren.clear();
    }
    
    
}
