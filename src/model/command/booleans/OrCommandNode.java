package model.command.booleans;

import java.util.List;
import model.command.CommandConstants;
import model.command.CommandNode;

/**
 * Node representing an OR test command
 * @author james
 *
 */
public class OrCommandNode extends CommandNode {

    public OrCommandNode() {
        super();
        super.setMyExpectedArgs(CommandConstants.COMMAND_EXPECTED_ARGS_TWO);
    }
    
    @Override
    public CommandNode getCopyOfInstance () {
        return new OrCommandNode();
    }
    
    @Override
    public int resolve() {
        List<CommandNode> children = super.getChildren();
        CommandNode childOne = children.get(0);
        CommandNode childTwo = children.get(1);
        int firstOperand = childOne.resolve();
        int secondOperand = childTwo.resolve();
        int result;
        if (firstOperand > CommandConstants.COMMAND_RETURN_FALSE || secondOperand > CommandConstants.COMMAND_RETURN_FALSE) {
            result = CommandConstants.COMMAND_RETURN_TRUE;
        } else {
            result = CommandConstants.COMMAND_RETURN_FALSE;
        }
//        System.out.printf("Checked if %d OR %d, got %d\n", firstOperand, secondOperand, result);
        return result;
    }
    
}
