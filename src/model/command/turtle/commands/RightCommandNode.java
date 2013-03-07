package model.command.turtle.commands;

import java.util.List;
import model.command.CommandConstants;
import model.command.CommandNode;

/**
 * Node representing a right command
 * @author james
 *
 */
public class RightCommandNode extends CommandNode {

    public RightCommandNode() {
        super();
        super.setMyExpectedArgs(CommandConstants.COMMAND_EXPECTED_ARGS_ONE);
    }
    
    @Override
    public CommandNode getCopyOfInstance () {
        return new RightCommandNode();
    }

    @Override
    public int resolve () {
        List<CommandNode> children = super.getChildren();
        CommandNode child = children.get(0);
        int result = child.resolve();
        System.out.printf("Turn turtle right %d degrees\n", result);
        return result;
    }

}
