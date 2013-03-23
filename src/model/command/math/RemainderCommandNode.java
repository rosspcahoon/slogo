package model.command.math;

import java.util.List;
import model.command.CommandConstants;
import model.command.CommandNode;

/**
 * Node representing a remainder command
 * @author james
 *
 */
public class RemainderCommandNode extends CommandNode {

    public RemainderCommandNode() {
        super();
        super.setMyExpectedArgs(CommandConstants.COMMAND_EXPECTED_ARGS_TWO);
    }
    
    @Override
    public CommandNode getCopyOfInstance () {
        return new RemainderCommandNode();
    }
    
    @Override
    public int resolve() throws Exception {
        List<CommandNode> children = super.getChildren();
        CommandNode one = children.get(0);
        CommandNode two = children.get(1);
        int firstOperand = one.resolve();
        int secondOperand = two.resolve();
        if (secondOperand == 0) {
            throw new Exception("Error executing REMAINDER -- divide by 0");
        }        
        int result = firstOperand % secondOperand;
//        System.out.printf("Divided %d by %d to get remainder %d\n", firstOperand, secondOperand, result);
        return result;
    }
    
}
