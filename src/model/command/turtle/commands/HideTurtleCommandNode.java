package model.command.turtle.commands;

import model.command.CommandConstants;
import model.command.CommandNode;

/**
 * Node representing a hideturtle command
 * @author james
 *
 */
public class HideTurtleCommandNode extends CommandNode {

    public HideTurtleCommandNode() {
        super();
        super.setMyExpectedArgs(CommandConstants.COMMAND_EXPECTED_ARGS_ZERO);
    }
    
    @Override
    public CommandNode getCopyOfInstance () {
        return new HideTurtleCommandNode();
    }

    @Override
    public int resolve () {
        System.out.printf("Turtle visibility off\n");
        return CommandConstants.COMMAND_RETURN_FALSE;
    }

}
