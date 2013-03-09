package model.command.turtle.commands;

import model.command.CommandConstants;
import model.command.CommandNode;

/**
 * Node representing a clearscreen command
 * @author james
 *
 */
public class ClearScreenCommandNode extends CommandNode {

    public ClearScreenCommandNode() {
        super();
        super.setMyExpectedArgs(CommandConstants.COMMAND_EXPECTED_ARGS_ZERO);
    }
    
    @Override
    public CommandNode getCopyOfInstance () {
        return new ClearScreenCommandNode();
    }

    @Override
    public int resolve () {
        System.out.printf("Cleared screen\n");
        return 0;
    }

}
