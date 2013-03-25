package model.command.control;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import model.Room;
import model.command.CommandConstants;
import model.command.CommandLibrary;
import model.command.CommandNode;
import model.command.StringCommandNode;

/**
 * Command node representing the contents of a list as defined by brackets.
 * @author james
 *
 */
public class ToCommandNode extends CommandNode {

    public ToCommandNode() {
        super();
        super.setMyExpectedArgs(CommandConstants.COMMAND_EXPECTED_ARGS_THREE);
    }
    
    @Override
    public CommandNode getCopyOfInstance () {
        return new ToCommandNode();
    }

    @Override
    public int resolve () throws Exception {
        List<CommandNode> children = super.getChildren();
        CommandNode name = children.get(0);
        CommandNode parameters = children.get(1);
        CommandNode commands = children.get(2);
        UserDefinedCommandNode result = new UserDefinedCommandNode();
        CommandNode nameNode = null;
        ListCommandNode paramList = null;
        ListCommandNode commandList = null;
        
        // establish the command name
        if (name instanceof StringCommandNode) {
            nameNode = (CommandNode) name;
        } else {
            throw new Exception("Error executing TO -- user-defined command name not a string");
        }
        String nameString = nameNode.getMyString();
        
        // establish the command parameters
        if (parameters instanceof ListCommandNode) {
            paramList = (ListCommandNode) parameters;
        } else {
            throw new Exception("Error executing TO -- command parameters must be entered as a list");
        }
        
        for (CommandNode param : paramList.getChildren()) {
            CommandNode currentParam = null;
            if (param instanceof StringCommandNode) {
                currentParam = (CommandNode) param;
            } else {
                throw new Exception("Error executing TO -- command parameter names badly formed");
            }
            result.addUserVariableName(currentParam.getMyString());
        }
        
        // establish commands to execute
        if (commands instanceof ListCommandNode) {
            commandList = (ListCommandNode) commands;
        } else {
            throw new Exception("Error executing TO -- command actions must be entered as a list");
        }
        
        // setup final UserDefinedCommandNode and add to CommandLibrary
        result.setMyName(nameString);
        result.addCommands(commandList);
        result.setMyExpectedArgs(parameters.getChildren().size());    
                
        CommandLibrary.addUserDefinedCommand(nameString, result);
//        System.out.printf("New command %s created, returning %d\n", nameString, CommandConstants.COMMAND_RETURN_TRUE);
        return CommandConstants.COMMAND_RETURN_TRUE;
    }
    
    /**
     * Overrides normal setup of a command node--establishes first child as command
     * name, which is represented by a StringCommandNode. Rest of the arguments are
     * set up as they are before.
     * @throws Exception 
     */
    @Override
    public void setUp(Scanner s, Room r, String v) throws Exception {
        super.clearChildren();
        super.setMyString(v);
        String commandName = s.next();
        commandName = commandName.toLowerCase();
        CommandNode nameNode = new StringCommandNode();
//        nameNode.setMyString(commandName);        
        addChild(nameNode);
        nameNode.setUp(s, r, commandName);
        setMyRoom(r);
        int expected = getMyExpectedArgs();
        for (int i=1; i<expected; i++) {
            String nextString;
            try {
                nextString = s.next();
            } catch (NoSuchElementException e) {
                throw new Exception("Error parsing command -- elements missing from input");
            }
            nextString = nextString.toLowerCase();
            CommandNode nextNode = CommandLibrary.getCommandNode(nextString);
            addChild(nextNode);
            nextNode.setUp(s, r, nextString);
        }
    }

}
