package model.command.control;

import java.util.ArrayList;
import java.util.List;
import model.command.CommandLibrary;
import model.command.CommandNode;
import model.command.StringCommandNode;

/**
 * Command node representing the contents of a list as defined by brackets.
 * @author james
 *
 */
public class UserDefinedCommandNode extends CommandNode {

    private List<String> myParameterNames;
    private List<Integer> myParameterValues;
    private ListCommandNode myCommands;
    private String myName;
    
    public UserDefinedCommandNode() {
        super();
        myParameterNames = new ArrayList<String>();
        myParameterValues = new ArrayList<Integer>();
    }
    
    @Override
    public UserDefinedCommandNode getCopyOfInstance () {
        return new UserDefinedCommandNode();
    }

    @Override
    public int resolve () throws Exception {
        List<CommandNode> children = super.getChildren();
        
        // add values of parameter variables to myParameterValues
        myParameterValues.clear();
        for (CommandNode child : children) {
            addUserVariableValue(child.resolve());
        }
        
        // adds parameter library to user variable libraries in CommandLibrary
        CommandLibrary.createVariableLibrary(myName, myParameterNames, myParameterValues);
        
        // creates the children based on parameter names
        super.clearChildren();
        for (String param : myParameterNames) {
            StringCommandNode newNode = new StringCommandNode();
            newNode.setMyValue(param);
            addChild(newNode);
        }
        
        // switch variable libraries in CommandLibrary and execute the user defined command
        CommandLibrary.loadVariableLibrary(myName);
        int result = myCommands.resolve();
        
        // load original variable library
        CommandLibrary.loadVariableLibrary();
        
//        System.out.printf("User defined command %s executed, returning %d\n", myName, result);
        return result;
    }
    
    /**
     * Adds a user variable to the list for this user-defined command. Replaces the
     * existing value if it already exists.
     */
    public void addUserVariable(String name, int value) {
        if (myParameterNames.contains(name)) {
            int index = myParameterNames.indexOf(name);
            myParameterValues.remove(index);
            myParameterValues.add(index, value);
        } else {
            myParameterNames.add(name);
            myParameterValues.add(value);
        }
    }
    
    /**
     * Adds a parameter name.
     */
    public void addUserVariableName(String name) {
        myParameterNames.add(name);
    }
    
    /**
     * Adds a parameter value.
     */
    public void addUserVariableValue(int value) {
        myParameterValues.add(value);
    }
    
    /**
     * Sets the command name.
     */
    public void setMyName(String name) {
        myName = name;
    }
    
    /**
     * Sets the commands for this user defined command, as represented by a ListCommandNode.
     */
    public void addCommands(ListCommandNode commands) {
        myCommands = commands;
    }
    
    /**
     * Returns the parameter names of this command.
     */
    public List<String> getCopyOfParameterNames() {
        List<String> result = new ArrayList<String>(myParameterNames.size());
        for (String param : myParameterNames) {
            result.add(new String(param));
        }
        return result;
    }

}
