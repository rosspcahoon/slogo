package model.command.control;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
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
    public int resolve () {
        List<CommandNode> children = super.getChildren();
        CommandNode name = children.get(0);
        CommandNode value = children.get(1);
        StringCommandNode variable = null;
        if (name instanceof StringCommandNode) {
            variable = (StringCommandNode) name;
        } else {
            //TODO: error handling
        }
        String nameString = variable.getMyValue();
        int result = value.resolve();
        CommandLibrary.addUserVariable(nameString, result);
        System.out.printf("Made variable %s with value %d\n", nameString, result);
        return result;
    }

    /**
     * Overrides normal setup of a command node--establishes first child as variable
     * name, which is represented by a StringCommandNode. Rest of the arguments are
     * set up as they are before.
     */
    @Override
    public void setUp(Scanner s) throws NoSuchElementException {
        super.clearChildren();
        String varName = s.next();
        varName = varName.toLowerCase();
        StringCommandNode nameNode = new StringCommandNode();
        nameNode.setMyValue(varName);
        addChild(nameNode);
        nameNode.setUp(s);
        int expected = getMyExpectedArgs();
        for (int i=1; i<expected; i++) {
            String nextString = s.next();
            nextString = nextString.toLowerCase();
            CommandNode nextNode = CommandLibrary.getCommandNode(nextString);
            addChild(nextNode);
            nextNode.setUp(s);
        }
    }
}
