package model.command.control;

import java.util.List;
import java.util.Scanner;
import model.command.CommandConstants;
import model.command.CommandLibrary;
import model.command.CommandNode;

/**
 * Command node representing an IF command.
 * @author james
 *
 */
public class IfCommandNode extends CommandNode {

    public IfCommandNode() {
        super();
        super.setMyExpectedArgs(CommandConstants.COMMAND_EXPECTED_ARGS_TWO);
    }
    
    @Override
    public CommandNode getCopyOfInstance () {
        return new IfCommandNode();
    }

    @Override
    public int resolve () throws Exception {
        List<CommandNode> children = super.getChildren();
        CommandNode condition = children.get(0);
        CommandNode commands = children.get(1);
        int conditionResult = condition.resolve();
        int result = -1;
        if (conditionResult != CommandConstants.COMMAND_RETURN_FALSE) {
            result = commands.resolve();
        }
//        System.out.printf("If condition evaluated to %d, returning %d\n", conditionResult, result);
        return result;
    }

}
