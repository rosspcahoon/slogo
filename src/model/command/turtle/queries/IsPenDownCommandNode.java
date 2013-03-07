package model.command.turtle.queries;

import model.command.CommandConstants;
import model.command.CommandNode;

/**
 * Node representing a ispendown command
 * @author james
 *
 */
public class IsPenDownCommandNode extends CommandNode {

    public IsPenDownCommandNode() {
        super();
        super.setMyExpectedArgs(CommandConstants.COMMAND_EXPECTED_ARGS_ZERO);
    }
    
    @Override
    public CommandNode getCopyOfInstance () {
        return new IsPenDownCommandNode();
    }

    @Override
    public int resolve () {
        System.out.printf("Returned turtle pen status\n");
        return 0;
    }

}
