package model.command.control;

import java.util.List;
import java.util.Scanner;
import model.command.CommandConstants;
import model.command.CommandLibrary;
import model.command.CommandNode;

/**
 * Command node representing the an IFELSE command.
 * @author james
 *
 */
public class IfElseCommandNode extends CommandNode {

    public IfElseCommandNode() {
        super();
        super.setMyExpectedArgs(CommandConstants.COMMAND_EXPECTED_ARGS_THREE);
    }
    
    @Override
    public CommandNode getCopyOfInstance () {
        return new IfElseCommandNode();
    }

    @Override
    public int resolve () throws Exception {
        List<CommandNode> children = super.getChildren();
        CommandNode condition = children.get(0);
        CommandNode trueCommands = children.get(1);
        CommandNode falseCommands = children.get(2);
        int conditionResult = condition.resolve();
        int result = -1;
        if (conditionResult != CommandConstants.COMMAND_RETURN_FALSE) {
            result = trueCommands.resolve();
        } else {
            result = falseCommands.resolve();
        }
//        System.out.printf("If condition evaluated to %d, returning %d\n", conditionResult, result);
        return result;
    }

}
