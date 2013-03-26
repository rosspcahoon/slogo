package model.command;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import model.Room;
import model.Status;
import model.command.turtle.*;
import model.command.booleans.*;
import model.command.math.*;
import model.command.control.*;
import model.command.extended.*;

/**
 * Class holding static mappings for command keywords to command objects.
 * @author james
 *
 */
public class CommandLibrary {

    /**
     * Map holding mappings between command names and command objects.
     * Command names defined according to the CommandKeywords class.
     */
    private static Map<String,CommandNode> myCommandNodes;
    
    /**
     * Map matching command names to their aliases.
     */
    private static Map<String,String> myCommandAliases;
    
    /**
     * Map for user-created variables. Changes based on the context in which
     * we are executing, i.e. if we are executing normal commands or user defined
     * commands which have their own custom set argument names
     */
    private static Map<String,Integer> myCurrentUserVariables;
    
    /**
     * Map pointing to different user-defined command parameter sets.
     */
    private static Map<String,Map<String,Integer>> myCommandParameterLibraries;
    
    /**
     * Map pointing to different user-defined variable sets.
     */
    private static Map<Integer,Map<String,Integer>> myRoomVariableLibraries;
    
    /**
     * Map pointing to different user-defined command libraries, organized by room.
     */
    private static Map<Integer,Map<String,UserDefinedCommandNode>> myRoomUserCommandLibraries;
    
    /**
     * Map for user-defined commands. Changes based on the room we are currently in.
     */
    private static Map<String,UserDefinedCommandNode> myCurrentUserCommands;

    private static ResourceBundle resources;
    
    /**
     * Static initialization block.
     */
    static {
        myCurrentUserVariables = new HashMap<String,Integer>();       
        myRoomVariableLibraries = new HashMap<Integer,Map<String,Integer>>();
        myRoomUserCommandLibraries = new HashMap<Integer,Map<String,UserDefinedCommandNode>>();
        myCommandParameterLibraries = new HashMap<String,Map<String,Integer>>();
        myCurrentUserCommands = new HashMap<String,UserDefinedCommandNode>();
    }
    
    /**
     * Gets the appropriate command object from the library, or gives an
     * error if none exists.
     */
    public static CommandNode getCommandNode(String name) throws Exception {        
        name = getAlias(name);
        
        // if the input is a user variable
        if (name.substring(0,1).equals(CommandConstants.COMMAND_NAME_VARIABLE_START)) {
            CommandNode result = new StringCommandNode();
            result.setMyString(name);
            return result;
        }

        // if the input is a user defined command
        if (myCurrentUserCommands.containsKey(name)) {
            UserDefinedCommandNode result = myCurrentUserCommands.get(name);
            return result;
        }
        
        // return the command node from the command library
        if (myCommandNodes.containsKey(name)) {
            CommandNode result = myCommandNodes.get(name).getCopyOfInstance();
            return result;
        }
        
        // if the input is an int                       
        try {
            int value = Integer.parseInt(name);
            NumberCommandNode result = new NumberCommandNode();
            result.setMyValue(value);
            return result;
        } catch (NumberFormatException e) {
            
        }
        
        // if the input is a double (cast to int)
        try {
            double value = Double.parseDouble(name);
            NumberCommandNode result = new NumberCommandNode();
            result.setMyValue((int) value);
            return result;
        } catch (NumberFormatException e) {

        }
        
        throw new Exception("Error parsing command -- could not interpret input: " + name);
        
    }
    
    /**
     * Adds the input user variable name and value into the hashmap
     */
    public static void addUserVariable(String variableName, int value) {
        myCurrentUserVariables.put(variableName,value);
    }
    
    /**
     * Returns the value associated with the input variableName
     * @throws Exception 
     */
    public static Integer getUserVariable(String variableName) throws Exception {
        if (!myCurrentUserVariables.containsKey(variableName)) {
            throw new Exception("Error retrieving user variable -- user variable " + variableName + " not found");
        }
        return myCurrentUserVariables.get(variableName);
    }
    
    /**
     * Sets a certain user-defined variable library as the current. Libraries
     * are identified by the name of the user-defined command with which they
     * are associated.
     */
    public static void loadParameterLibrary(String commandName) {
        if (!myCommandParameterLibraries.containsKey(commandName)) {            
            Map<String,Integer> newLibrary = new HashMap<String,Integer>();
            myCommandParameterLibraries.put(commandName, newLibrary);
        }
        myCurrentUserVariables = myCommandParameterLibraries.get(commandName);
    }
    
    /**
     * Sets a certain user-defined variable library as the current. Libraries
     * are identified by the id of the room with which they are associated.
     */
    public static void loadVariableLibrary(Room room) {
        int id = room.getID();
        if (!myRoomVariableLibraries.containsKey(id)) {            
            Map<String,Integer> newLibrary = new HashMap<String,Integer>();
            myRoomVariableLibraries.put(id, newLibrary);
        }
        myCurrentUserVariables = myRoomVariableLibraries.get(id);
    }    
    
    /**
     * Sets a certain user-defined variable library as the current. Libraries
     * are identified by the id of the room with which they are associated.
     */
    public static void loadCommandLibrary(Room room) {
        int id = room.getID();
        if (!myRoomUserCommandLibraries.containsKey(id)) {            
            Map<String,UserDefinedCommandNode> newLibrary = new HashMap<String,UserDefinedCommandNode>();
            myRoomUserCommandLibraries.put(id, newLibrary);
        }
        myCurrentUserCommands = myRoomUserCommandLibraries.get(id);
    }   
    
    /**
     * Creates a new user variable library and adds it to the list.
     * @throws Exception 
     */
    public static void createParameterLibrary(String name, List<String> names, List<Integer> values) throws Exception {
        Map<String,Integer> newLibrary = new HashMap<String,Integer>();
        if (names.size() != values.size()) {
            throw new Exception("Error creating variable library -- parameter and value list size mismatch");
        }
        for (int i=0; i<names.size(); i++) {
            newLibrary.put(names.get(i), values.get(i));
        }
        myCommandParameterLibraries.put(name, newLibrary);        
    }
    
    /**
     * Creates a new user variable library and adds it to the list.
     * @throws Exception 
     */
    public static void createRoomVariableLibrary(int id, List<String> names, List<Integer> values) throws Exception {
        Map<String,Integer> newLibrary = new HashMap<String,Integer>();
        if (names.size() != values.size()) {
            throw new Exception("Error creating variable library -- parameter and value list size mismatch");
        }
        for (int i=0; i<names.size(); i++) {
            newLibrary.put(names.get(i), values.get(i));
        }
        myRoomVariableLibraries.put(id, newLibrary);        
    }
    
    /**
     * Adds a user defined command to the library.
     */
    public static void addUserDefinedCommand(String name, UserDefinedCommandNode command) {
        myCurrentUserCommands.put(name, command);
    }
    
    /**
     * Adds contents of the user variable library for the given room to room status.
     */
    public static void addUserVariableLibraryToRoomStatus(Room room) {
        Status status = room.getState();
        Map<String,Integer> vars = myRoomVariableLibraries.get(room.getID());
        for (String key : vars.keySet()) {
            status.addVariable(key, vars.get(key));
        }                
    }
    
    /**
     * Adds contents of the user-defined command library to status.
     */
    public static void addCommandLibraryToRoomStatus(Room room) {
        Status status = room.getState();
        for (String key : myCurrentUserCommands.keySet()) {
            UserDefinedCommandNode ucdNode = myCurrentUserCommands.get(key);            
            status.addCommandName(key, ucdNode.getCopyOfParameterNames());
        }                
    }
    
    /**
     * Replaces the command alias with its original name, if it is an alias
     * For instance, replaces fd 50 with forward 50.
     */
    public static String getAlias(String name) {
        if (!myCommandAliases.containsKey(name)) {
            return name;
        }
        return myCommandAliases.get(name);
    }
    
    /**
     * Set the language resources for internationalization
     * @param ourResources
     */
    public static void loadResources (ResourceBundle ourResources) {
        resources = ourResources;
        buildCommandLibrary();
        buildAliasLibrary();
    }

    /**
     * Builds the command library.
     */
    private static void buildCommandLibrary() {
        myCommandNodes = new HashMap<String,CommandNode>();
        //if this was not static
        //myCommandNodes.put(resources.getString("COMMAND_NAME_FORWARD"), new ForwardCommandNode());
        //
        myCommandNodes.put(CommandConstants.COMMAND_NAME_FORWARD, new MoveCommandNode());
        myCommandNodes.put(CommandConstants.COMMAND_NAME_BACK, new MoveCommandNode());
        myCommandNodes.put(CommandConstants.COMMAND_NAME_LEFT, new RotateCommandNode());
        myCommandNodes.put(CommandConstants.COMMAND_NAME_RIGHT, new RotateCommandNode());
        myCommandNodes.put(CommandConstants.COMMAND_NAME_SET_HEADING, new SetHeadingCommandNode());
        myCommandNodes.put(CommandConstants.COMMAND_NAME_TOWARDS, new TowardsCommandNode());
        myCommandNodes.put(CommandConstants.COMMAND_NAME_SETXY, new SetXYCommandNode());
        myCommandNodes.put(CommandConstants.COMMAND_NAME_PENDOWN, new PenCommandNode());
        myCommandNodes.put(CommandConstants.COMMAND_NAME_PENUP, new PenCommandNode());
        myCommandNodes.put(CommandConstants.COMMAND_NAME_SHOW_TURTLE, new VisibleCommandNode());
        myCommandNodes.put(CommandConstants.COMMAND_NAME_HIDE_TURTLE, new VisibleCommandNode());
        myCommandNodes.put(CommandConstants.COMMAND_NAME_HOME, new ResetRoomCommandNode());
        myCommandNodes.put(CommandConstants.COMMAND_NAME_CLEAR_SCREEN, new ResetRoomCommandNode());
        myCommandNodes.put(CommandConstants.COMMAND_NAME_XCOR, new CorCommandNode());
        myCommandNodes.put(CommandConstants.COMMAND_NAME_YCOR, new CorCommandNode());
        myCommandNodes.put(CommandConstants.COMMAND_NAME_HEADING, new HeadingCommandNode());
        myCommandNodes.put(CommandConstants.COMMAND_NAME_IS_PENDOWN, new PenCommandNode());
        myCommandNodes.put(CommandConstants.COMMAND_NAME_IS_SHOWING, new VisibleCommandNode());
        myCommandNodes.put(CommandConstants.COMMAND_NAME_SUM, new TwoOperandMathCommandNode());
        myCommandNodes.put(CommandConstants.COMMAND_NAME_DIFFERENCE, new TwoOperandMathCommandNode());
        myCommandNodes.put(CommandConstants.COMMAND_NAME_PRODUCT, new TwoOperandMathCommandNode());
        myCommandNodes.put(CommandConstants.COMMAND_NAME_QUOTIENT, new TwoOperandMathCommandNode());
        myCommandNodes.put(CommandConstants.COMMAND_NAME_REMAINDER, new TwoOperandMathCommandNode());
        myCommandNodes.put(CommandConstants.COMMAND_NAME_MINUS, new OneOperandMathCommandNode());
        myCommandNodes.put(CommandConstants.COMMAND_NAME_RANDOM, new OneOperandMathCommandNode());
        myCommandNodes.put(CommandConstants.COMMAND_NAME_IS_LESS, new TwoOperandBooleanCommandNode());
        myCommandNodes.put(CommandConstants.COMMAND_NAME_IS_GREATER, new TwoOperandBooleanCommandNode());
        myCommandNodes.put(CommandConstants.COMMAND_NAME_IS_EQUAL, new TwoOperandBooleanCommandNode());
        myCommandNodes.put(CommandConstants.COMMAND_NAME_IS_NOT_EQUAL, new TwoOperandBooleanCommandNode());
        myCommandNodes.put(CommandConstants.COMMAND_NAME_AND, new TwoOperandBooleanCommandNode());
        myCommandNodes.put(CommandConstants.COMMAND_NAME_OR, new TwoOperandBooleanCommandNode());
        myCommandNodes.put(CommandConstants.COMMAND_NAME_NOT, new OneOperandBooleanCommandNode());
        myCommandNodes.put(CommandConstants.COMMAND_NAME_LIST_OPEN, new ListCommandNode());
        myCommandNodes.put(CommandConstants.COMMAND_NAME_MAKE, new MakeCommandNode());
        myCommandNodes.put(CommandConstants.COMMAND_NAME_REPEAT, new RepeatCommandNode());
        myCommandNodes.put(CommandConstants.COMMAND_NAME_IF, new IfCommandNode());
        myCommandNodes.put(CommandConstants.COMMAND_NAME_IFELSE, new IfElseCommandNode());
        myCommandNodes.put(CommandConstants.COMMAND_NAME_TO, new ToCommandNode());
        myCommandNodes.put(CommandConstants.COMMAND_NAME_SET_PEN_COLOR, new SetGraphicsCommandNode());
        myCommandNodes.put(CommandConstants.COMMAND_NAME_SET_PEN_SIZE, new SetGraphicsCommandNode());
        myCommandNodes.put(CommandConstants.COMMAND_NAME_SET_PEN_TYPE, new SetGraphicsCommandNode());
        myCommandNodes.put(CommandConstants.COMMAND_NAME_SET_SHAPE, new SetGraphicsCommandNode());
        myCommandNodes.put(CommandConstants.COMMAND_NAME_REGISTER_COLOR, new RegisterGraphicsCommandNode());
        myCommandNodes.put(CommandConstants.COMMAND_NAME_REGISTER_SHAPE, new RegisterGraphicsCommandNode());
        myCommandNodes.put(CommandConstants.COMMAND_NAME_DOTIMES, new DoTimesCommandNode());

    }

    /**
     * Builds the command alias map.
     */
    private static void buildAliasLibrary() {
        myCommandAliases = new HashMap<String,String>();
        myCommandAliases.put(CommandConstants.COMMAND_ALIAS_FD, CommandConstants.COMMAND_NAME_FORWARD);
        myCommandAliases.put(CommandConstants.COMMAND_ALIAS_BK, CommandConstants.COMMAND_NAME_BACK);
        myCommandAliases.put(CommandConstants.COMMAND_ALIAS_LT, CommandConstants.COMMAND_NAME_LEFT);
        myCommandAliases.put(CommandConstants.COMMAND_ALIAS_RT, CommandConstants.COMMAND_NAME_RIGHT);
        myCommandAliases.put(CommandConstants.COMMAND_ALIAS_SETH, CommandConstants.COMMAND_NAME_SET_HEADING);
        myCommandAliases.put(CommandConstants.COMMAND_ALIAS_GOTO, CommandConstants.COMMAND_NAME_SETXY);
        myCommandAliases.put(CommandConstants.COMMAND_ALIAS_PD, CommandConstants.COMMAND_NAME_PENDOWN);
        myCommandAliases.put(CommandConstants.COMMAND_ALIAS_PU, CommandConstants.COMMAND_NAME_PENUP);
        myCommandAliases.put(CommandConstants.COMMAND_ALIAS_ST, CommandConstants.COMMAND_NAME_SHOW_TURTLE);
        myCommandAliases.put(CommandConstants.COMMAND_ALIAS_HT, CommandConstants.COMMAND_NAME_HIDE_TURTLE);
        myCommandAliases.put(CommandConstants.COMMAND_ALIAS_CS, CommandConstants.COMMAND_NAME_CLEAR_SCREEN);
        myCommandAliases.put(CommandConstants.COMMAND_ALIAS_PENDOWN_P, CommandConstants.COMMAND_NAME_IS_PENDOWN);
        myCommandAliases.put(CommandConstants.COMMAND_ALIAS_SHOWING_P, CommandConstants.COMMAND_NAME_IS_SHOWING);
        myCommandAliases.put(CommandConstants.COMMAND_ALIAS_SUM, CommandConstants.COMMAND_NAME_SUM);
        myCommandAliases.put(CommandConstants.COMMAND_ALIAS_DIFFERENCE, CommandConstants.COMMAND_NAME_DIFFERENCE);
        myCommandAliases.put(CommandConstants.COMMAND_ALIAS_PRODUCT, CommandConstants.COMMAND_NAME_PRODUCT);
        myCommandAliases.put(CommandConstants.COMMAND_ALIAS_QUOTIENT, CommandConstants.COMMAND_NAME_QUOTIENT);
        myCommandAliases.put(CommandConstants.COMMAND_ALIAS_REMAINDER, CommandConstants.COMMAND_NAME_REMAINDER);
        myCommandAliases.put(CommandConstants.COMMAND_ALIAS_MINUS, CommandConstants.COMMAND_NAME_MINUS);
        myCommandAliases.put(CommandConstants.COMMAND_ALIAS_IS_LESS, CommandConstants.COMMAND_NAME_IS_LESS);
        myCommandAliases.put(CommandConstants.COMMAND_ALIAS_IS_GREATER, CommandConstants.COMMAND_NAME_IS_GREATER);
        myCommandAliases.put(CommandConstants.COMMAND_ALIAS_IS_EQUAL, CommandConstants.COMMAND_NAME_IS_EQUAL);
        myCommandAliases.put(CommandConstants.COMMAND_ALIAS_IS_NOT_EQUAL, CommandConstants.COMMAND_NAME_IS_NOT_EQUAL);
        myCommandAliases.put(CommandConstants.COMMAND_ALIAS_SET, CommandConstants.COMMAND_NAME_MAKE);
    }
    
    public static String getLiteral(String s) {
        return resources.getString(s);
    }


}
