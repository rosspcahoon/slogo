package model.command.turtle.commands;

import model.command.CommandConstants;
import model.command.CommandNode;

/**
 * Node representing a pendown command
 * @author james
 *
 */
public class PenDownCommandNode extends CommandNode {

    public PenDownCommandNode() {
        super();
        super.setMyExpectedArgs(CommandConstants.COMMAND_EXPECTED_ARGS_ZERO);
    }
    
    @Override
    public CommandNode getCopyOfInstance () {
        return new PenDownCommandNode();
    }

    @Override
    public int resolve () {
        System.out.printf("Put turtle pen down\n");
        return CommandConstants.COMMAND_RETURN_TRUE;
    }

}
