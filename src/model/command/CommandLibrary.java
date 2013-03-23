package model.command;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.Room;
import model.Status;
import model.command.turtle.commands.*;
import model.command.turtle.queries.*;
import model.command.booleans.*;
import model.command.math.*;
import model.command.control.*;

/**
 * Class holding static mappings for command keywords to command objects.
 * @author james
 *
 */
public class CommandLibrary {

    /**
     * HashMap holding mappings between command names and command objects.
     * Command names defined according to the CommandKeywords class.
     */
    private static Map<String,CommandNode> myCommandNodes;
    
    /**
     * HashMap matching command names to their aliases.
     */
    private static Map<String,String> myCommandAliases;
    
    /**
     * HashMap for user-created variables. Changes based on the context in which
     * we are executing, i.e. if we are executing normal commands or user defined
     * commands which have their own custom set argument names
     */
    private static Map<String,Integer> myCurrentUserVariables;
    
    /**
     * HashMap for globally defined user variables.
     */
    private static Map<String,Integer> myDefaultUserVariables;
    
    /**
     * HashMap pointing to different user-defined variable sets.
     */
    private static Map<String,Map<String,Integer>> myUserVariableLibraries;
    
    /**
     * HashMap for user-defined commands.
     */
    private static Map<String,UserDefinedCommandNode> myUserCommands;
    
    /**
     * Static initialization block--calls the static buildLibrary() methods.
     */
    static {
        buildCommandLibrary();
        buildAliasLibrary();
        myDefaultUserVariables = new HashMap<String,Integer>();
        myUserVariableLibraries = new HashMap<String,Map<String,Integer>>();
        myUserCommands = new HashMap<String,UserDefinedCommandNode>();
        myCurrentUserVariables = new HashMap<String,Integer>();
        myCurrentUserVariables = myDefaultUserVariables;
    }
    
    /**
     * Gets the appropriate command object from the library, or gives an
     * error if none exists.
     */
    public static CommandNode getCommandNode(String name) throws Exception {        
        name = getAlias(name);
        
        // if the input is a user variable
        if (name.substring(0,1).equals(CommandConstants.COMMAND_NAME_VARIABLE_START)) {
            StringCommandNode result = new StringCommandNode();
            result.setMyValue(name);
            return result;
        }

        // if the input is a user defined command
        if (myUserCommands.containsKey(name)) {
            UserDefinedCommandNode result = myUserCommands.get(name);
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
            throw new Exception("User variable " + variableName + " not found");
        }
        return myCurrentUserVariables.get(variableName);
    }
    
    /**
     * Sets a certain user-defined variable library as the current. Libraries
     * are identified by the name of the user-defined command with which they
     * are associated.
     */
    public static void loadVariableLibrary(String commandName) {
        if (!myUserVariableLibraries.containsKey(commandName)) {
            Map<String,Integer> newLibrary = new HashMap<String,Integer>();
            myUserVariableLibraries.put(commandName, newLibrary);
        }
        myCurrentUserVariables = myUserVariableLibraries.get(commandName);
    }
    
    /**
     * If no command name is specified, load the default library.
     */
    public static void loadVariableLibrary() {
        myCurrentUserVariables = myDefaultUserVariables;
    }
    
    /**
     * Creates a new user variable library and adds it to the list.
     */
    public static void createVariableLibrary(String command, List<String> names, List<Integer> values) {
        Map<String,Integer> newLibrary = new HashMap<String,Integer>();
        if (names.size() != values.size()) {
            //TODO: throw error
        }
        for (int i=0; i<names.size(); i++) {
            newLibrary.put(names.get(i), values.get(i));
        }
        myUserVariableLibraries.put(command, newLibrary);
    }
    
    /**
     * Adds a user defined command to the library.
     */
    public static void addUserDefinedCommand(String name, UserDefinedCommandNode command) {
        myUserCommands.put(name, command);
    }
    
    /**
     * Adds contents of the default user variable library to status.
     */
    public static void addLibraryToRoomStatus(Room room) {
        Status status = room.getState();
        for (String key : myDefaultUserVariables.keySet()) {
            status.addVariable(key, myDefaultUserVariables.get(key));
        }                
    }
    
    /**
     * Replaces the command alias with its original name, if it is an alias
     * For instance, replaces fd 50 with forward 50.
     */
    private static String getAlias(String name) {
        if (!myCommandAliases.containsKey(name)) {
            return name;
        }
        return myCommandAliases.get(name);
    }
    
    /**
     * Builds the command library.
     */
    private static void buildCommandLibrary() {
        myCommandNodes = new HashMap<String,CommandNode>();
        myCommandNodes.put(CommandConstants.COMMAND_NAME_FORWARD, new ForwardCommandNode());
        myCommandNodes.put(CommandConstants.COMMAND_NAME_BACK, new BackCommandNode());
        myCommandNodes.put(CommandConstants.COMMAND_NAME_LEFT, new LeftCommandNode());
        myCommandNodes.put(CommandConstants.COMMAND_NAME_RIGHT, new RightCommandNode());
        myCommandNodes.put(CommandConstants.COMMAND_NAME_SET_HEADING, new SetHeadingCommandNode());
        myCommandNodes.put(CommandConstants.COMMAND_NAME_TOWARDS, new TowardsCommandNode());
        myCommandNodes.put(CommandConstants.COMMAND_NAME_SETXY, new SetXYCommandNode());
        myCommandNodes.put(CommandConstants.COMMAND_NAME_PENDOWN, new PenDownCommandNode());
        myCommandNodes.put(CommandConstants.COMMAND_NAME_PENUP, new PenUpCommandNode());
        myCommandNodes.put(CommandConstants.COMMAND_NAME_SHOW_TURTLE, new ShowTurtleCommandNode());
        myCommandNodes.put(CommandConstants.COMMAND_NAME_HIDE_TURTLE, new HideTurtleCommandNode());
        myCommandNodes.put(CommandConstants.COMMAND_NAME_HOME, new HomeCommandNode());
        myCommandNodes.put(CommandConstants.COMMAND_NAME_CLEAR_SCREEN, new ClearScreenCommandNode());
        myCommandNodes.put(CommandConstants.COMMAND_NAME_XCOR, new XCorCommandNode());
        myCommandNodes.put(CommandConstants.COMMAND_NAME_YCOR, new YCorCommandNode());
        myCommandNodes.put(CommandConstants.COMMAND_NAME_HEADING, new HeadingCommandNode());
        myCommandNodes.put(CommandConstants.COMMAND_NAME_IS_PENDOWN, new IsPenDownCommandNode());
        myCommandNodes.put(CommandConstants.COMMAND_NAME_IS_SHOWING, new IsShowingCommandNode());
        myCommandNodes.put(CommandConstants.COMMAND_NAME_SUM, new SumCommandNode());
        myCommandNodes.put(CommandConstants.COMMAND_NAME_DIFFERENCE, new DifferenceCommandNode());
        myCommandNodes.put(CommandConstants.COMMAND_NAME_PRODUCT, new ProductCommandNode());
        myCommandNodes.put(CommandConstants.COMMAND_NAME_QUOTIENT, new QuotientCommandNode());
        myCommandNodes.put(CommandConstants.COMMAND_NAME_REMAINDER, new RemainderCommandNode());
        myCommandNodes.put(CommandConstants.COMMAND_NAME_MINUS, new MinusCommandNode());
        myCommandNodes.put(CommandConstants.COMMAND_NAME_RANDOM, new RandomCommandNode());
        myCommandNodes.put(CommandConstants.COMMAND_NAME_IS_LESS, new IsLessCommandNode());
        myCommandNodes.put(CommandConstants.COMMAND_NAME_IS_GREATER, new IsGreaterCommandNode());
        myCommandNodes.put(CommandConstants.COMMAND_NAME_IS_EQUAL, new IsEqualCommandNode());
        myCommandNodes.put(CommandConstants.COMMAND_NAME_IS_NOT_EQUAL, new IsNotEqualCommandNode());
        myCommandNodes.put(CommandConstants.COMMAND_NAME_AND, new AndCommandNode());
        myCommandNodes.put(CommandConstants.COMMAND_NAME_OR, new OrCommandNode());
        myCommandNodes.put(CommandConstants.COMMAND_NAME_NOT, new NotCommandNode());
        myCommandNodes.put(CommandConstants.COMMAND_NAME_LIST_OPEN, new ListCommandNode());
        myCommandNodes.put(CommandConstants.COMMAND_NAME_MAKE, new MakeCommandNode());
        myCommandNodes.put(CommandConstants.COMMAND_NAME_REPEAT, new RepeatCommandNode());
        myCommandNodes.put(CommandConstants.COMMAND_NAME_IF, new IfCommandNode());
        myCommandNodes.put(CommandConstants.COMMAND_NAME_IFELSE, new IfElseCommandNode());
        myCommandNodes.put(CommandConstants.COMMAND_NAME_TO, new ToCommandNode());
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
}
