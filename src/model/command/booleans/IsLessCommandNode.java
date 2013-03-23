package model.command.booleans;

import java.util.List;
import model.command.CommandConstants;
import model.command.CommandNode;

/**
 * Node representing a LESS test command
 * @author james
 *
 */
public class IsLessCommandNode extends CommandNode {

    public IsLessCommandNode() {
        super();
        super.setMyExpectedArgs(CommandConstants.COMMAND_EXPECTED_ARGS_TWO);
    }
    
    @Override
    public CommandNode getCopyOfInstance () {
        return new IsLessCommandNode();
    }
    
    @Override
    public int resolve() throws Exception {
        List<CommandNode> children = super.getChildren();
        CommandNode childOne = children.get(0);
        CommandNode childTwo = children.get(1);
        int firstOperand = childOne.resolve();
        int secondOperand = childTwo.resolve();
        int result;
        if (firstOperand < secondOperand) {
            result = CommandConstants.COMMAND_RETURN_TRUE;
        } else {
            result = CommandConstants.COMMAND_RETURN_FALSE;
        }
//        System.out.printf("Checked if %d less than %d, got %d\n", firstOperand, secondOperand, result);
        return result;
    }
    
}
