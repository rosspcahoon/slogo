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
public class MakeCommandNode extends CommandNode {

    public MakeCommandNode() {
        super();
        super.setMyExpectedArgs(CommandConstants.COMMAND_EXPECTED_ARGS_TWO);
    }
    
    @Override
    public CommandNode getCopyOfInstance () {
        return new MakeCommandNode();
    }
    
    @Override
    public int resolve () throws Exception {
        List<CommandNode> children = super.getChildren();
        CommandNode name = children.get(0);
        CommandNode value = children.get(1);
        CommandNode variable = null;
        if (name instanceof StringCommandNode) {
            variable = (CommandNode) name;
        } else {
            throw new Exception("Error executing MAKE -- variable name not a string");
        }
        String nameString = variable.getMyString();
        if (!nameString.substring(0, 1).equals(CommandConstants.COMMAND_NAME_VARIABLE_START)) {
            throw new Exception("Error executing MAKE -- variable name must begin with \"" +
                    CommandConstants.COMMAND_NAME_VARIABLE_START + "\"");
        }
        int result = value.resolve();
        CommandLibrary.loadVariableLibrary(super.getMyRoom());
        CommandLibrary.addUserVariable(nameString, result);
        return result;
    }

    /**
     * Overrides normal setup of a command node--establishes first child as variable
     * name, which is represented by a StringCommandNode. Rest of the arguments are
     * set up as they are before.
     */
    @Override
    public void setUp(Scanner s, Room r, String v) throws Exception {
        super.clearChildren();
        super.setMyString(v);
        String varName = s.next();
        varName = varName.toLowerCase();
        CommandNode nameNode = new StringCommandNode();
//        nameNode.setMyString(varName);
        addChild(nameNode);
        nameNode.setUp(s, r, varName);
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
