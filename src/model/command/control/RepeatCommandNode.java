package model.command.control;

import java.util.List;
import java.util.Scanner;
import model.command.CommandConstants;
import model.command.CommandLibrary;
import model.command.CommandNode;

/**
 * Command node representing a repeat command
 * @author james
 *
 */
public class RepeatCommandNode extends CommandNode {

    public RepeatCommandNode() {
        super();
        super.setMyExpectedArgs(CommandConstants.COMMAND_EXPECTED_ARGS_TWO);
    }
    
    @Override
    public CommandNode getCopyOfInstance () {
        return new RepeatCommandNode();
    }

    @Override
    public int resolve () {
        List<CommandNode> children = super.getChildren();
        CommandNode iterations = children.get(0);
        CommandNode commands = children.get(1);
        int numIterations = iterations.resolve();
        int result = -1;
        for (int i=0; i<numIterations; i++) {
            result = commands.resolve();
        }
        System.out.printf("Repeated %d times, returning %d\n", numIterations, result);
        return result;
    }

}
