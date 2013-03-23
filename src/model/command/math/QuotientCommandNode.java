package model.command.math;

import java.util.List;
import model.command.CommandConstants;
import model.command.CommandNode;

/**
 * Node representing a quotient command
 * @author james
 *
 */
public class QuotientCommandNode extends CommandNode {

    public QuotientCommandNode() {
        super();
        super.setMyExpectedArgs(CommandConstants.COMMAND_EXPECTED_ARGS_TWO);
    }
    
    @Override
    public CommandNode getCopyOfInstance () {
        return new QuotientCommandNode();
    }
    
    @Override
    public int resolve() throws Exception {
        List<CommandNode> children = super.getChildren();
        CommandNode one = children.get(0);
        CommandNode two = children.get(1);
        int firstOperand = one.resolve();
        int secondOperand = two.resolve();
        int result = firstOperand / secondOperand;
//        System.out.printf("Divided %d by %d to get %d\n", firstOperand, secondOperand, result);
        return result;
    }
    
}
