package model.command.math;

import java.util.List;
import model.command.CommandConstants;
import model.command.CommandNode;

/**
 * Node representing a difference command
 * @author james
 *
 */
public class DifferenceCommandNode extends CommandNode {

    public DifferenceCommandNode() {
        super();
        super.setMyExpectedArgs(CommandConstants.COMMAND_EXPECTED_ARGS_TWO);
    }
    
    @Override
    public CommandNode getCopyOfInstance () {
        return new DifferenceCommandNode();
    }
    
    @Override
    public int resolve() {
        List<CommandNode> children = super.getChildren();
        CommandNode one = children.get(0);
        CommandNode two = children.get(1);
        int firstOperand = one.resolve();
        int secondOperand = two.resolve();
        int result = firstOperand - secondOperand;
//        System.out.printf("Subtracted %d from %d to get %d\n", secondOperand, firstOperand, result);
        return result;
    }
    
}
