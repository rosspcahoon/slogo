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
    public int resolve () {
        List<CommandNode> children = super.getChildren();
        CommandNode name = children.get(0);
        CommandNode parameters = children.get(1);
        CommandNode commands = children.get(2);
        UserDefinedCommandNode result = new UserDefinedCommandNode();
        StringCommandNode nameNode = null;
        ListCommandNode commandList = null;
        
        // establish the command name
        if (name instanceof StringCommandNode) {
            nameNode = (StringCommandNode) name;
        } else {
            //TODO: throw error
        }
        String nameString = nameNode.getMyValue();
        
        // establish the command parameters
        for (CommandNode param : parameters.getChildren()) {
            StringCommandNode currentParam = null;
            if (param instanceof StringCommandNode) {
                currentParam = (StringCommandNode) param;
            }
            result.addUserVariableName(currentParam.getMyValue());
        }
        
        // establish commands to execute
        if (commands instanceof ListCommandNode) {
            commandList = (ListCommandNode) commands;
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
     */
    @Override
    public void setUp(Scanner s, Room r) throws NoSuchElementException {
        super.clearChildren();
        String commandName = s.next();
        commandName = commandName.toLowerCase();
        StringCommandNode nameNode = new StringCommandNode();
        nameNode.setMyValue(commandName);        
        addChild(nameNode);
        nameNode.setUp(s, r);
        setMyRoom(r);
        int expected = getMyExpectedArgs();
        for (int i=1; i<expected; i++) {
            String nextString = s.next();
            nextString = nextString.toLowerCase();
            CommandNode nextNode = CommandLibrary.getCommandNode(nextString);
            addChild(nextNode);
            nextNode.setUp(s, r);
        }
    }

}
