package model.command.math;

import java.util.List;
import model.command.CommandConstants;
import model.command.CommandLibrary;
import model.command.CommandNode;

/**
 * Node representing two operand math commands, sum, difference, product, quotient, or remainder
 * (default remainder)
 * @author james
 *
 */
public class TwoOperandMathCommandNode extends CommandNode {

    public TwoOperandMathCommandNode() {
        super();
        super.setMyExpectedArgs(CommandConstants.COMMAND_EXPECTED_ARGS_TWO);
    }
    
    @Override
    public CommandNode getCopyOfInstance () {
        return new TwoOperandMathCommandNode();
    }
    
    @Override
    public int resolve() throws Exception {
        String name = CommandLibrary.getAlias(getMyString());
        List<CommandNode> children = super.getChildren();
        CommandNode one = children.get(0);
        CommandNode two = children.get(1);
        int firstOperand = one.resolve();
        int secondOperand = two.resolve();
        int result;
        if (name.equals(CommandConstants.COMMAND_NAME_SUM)){
            result = firstOperand + secondOperand;
        } else if (name.equals(CommandConstants.COMMAND_NAME_DIFFERENCE)) {
            result = firstOperand - secondOperand;
        } else if (name.equals(CommandConstants.COMMAND_NAME_PRODUCT)) {
            result = firstOperand * secondOperand;
        } else if (name.equals(CommandConstants.COMMAND_NAME_QUOTIENT)) {
            if (secondOperand == 0) {
                throw new Exception("Error executing QUOTIENT -- divide by 0");
            }
            result = firstOperand / secondOperand;
        } else {
            if (secondOperand == 0) {
                throw new Exception("Error executing REMAINDER -- divide by 0");
            }        
            result = firstOperand % secondOperand;
        }
        return result;
    }
    
}
