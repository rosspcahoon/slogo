package model.command.turtle.queries;

import model.command.CommandConstants;
import model.command.CommandNode;

/**
 * Node representing a ycor command
 * @author james
 *
 */
public class YCorCommandNode extends CommandNode {

    public YCorCommandNode() {
        super();
        super.setMyExpectedArgs(CommandConstants.COMMAND_EXPECTED_ARGS_ZERO);
    }
    
    @Override
    public CommandNode getCopyOfInstance () {
        return new YCorCommandNode();
    }

    @Override
    public int resolve () {
        System.out.printf("Returned turtle ycor\n");
        return 0;
    }

}