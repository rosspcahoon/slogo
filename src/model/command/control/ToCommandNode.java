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
public class ToCommandNode extends CommandNode {

    public ToCommandNode() {
        super();
        super.setMyExpectedArgs(CommandConstants.COMMAND_EXPECTED_ARGS_TWO);
    }
    
    @Override
    public CommandNode getCopyOfInstance () {
        return new ToCommandNode();
    }

    @Override
    public int resolve () {
        List<CommandNode> children = super.getChildren();
        CommandNode condition = children.get(0);
        CommandNode commands = children.get(1);
        int conditionResult = condition.resolve();
        int result = -1;
        if (conditionResult > CommandConstants.COMMAND_RETURN_FALSE) {
            result = commands.resolve();
        }
        System.out.printf("If condition evaluated to %d, returning %d\n", conditionResult, result);
        return result;
    }

}
