package model.command.control;

import java.util.List;
import java.util.Scanner;
import model.command.CommandConstants;
import model.command.CommandLibrary;
import model.command.CommandNode;

/**
 * Command node representing the contents of a list as defined by brackets.
 * @author james
 *
 */
public class ListCommandNode extends CommandNode {

    public ListCommandNode() {
        super();
    }
    
    @Override
    public CommandNode getCopyOfInstance () {
        return new ListCommandNode();
    }

    @Override
    public int resolve () {
        List<CommandNode> children = super.getChildren();
        int result = 0;
        for (CommandNode child : children) {
            result = child.resolve();
        }
        System.out.printf("Executed command list with final command returning %d\n", result);
        return result;
    }
    
    /**
     * Override the default setUp method in CommandNode. Because ListCommandNode is
     * not initialized with the knowledge of how many children it will have, we must
     * create its children until we encounter its end.
     */
    @Override
    public void setUp(Scanner s) {
        int expected = 0;
        while (s.hasNext()) {
            String nextString = s.next();
            if (nextString.equals(CommandConstants.COMMAND_NAME_LIST_CLOSE)) {
                break;
            }
            nextString = nextString.toLowerCase();
            CommandNode nextNode = CommandLibrary.getCommandNode(nextString);
            addChild(nextNode);
            nextNode.setUp(s);
            expected++;
        }
        super.setMyExpectedArgs(expected);
    }

}
