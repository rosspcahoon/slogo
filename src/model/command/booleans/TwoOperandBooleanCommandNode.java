package model.command.booleans;

import java.util.List;
import model.command.CommandConstants;
import model.command.CommandLibrary;
import model.command.CommandNode;

/**
 * Node representing two operand boolean test commands, and, isequal, isgreater, isless, isnotequal,
 * or or (default or)
 * @author james
 *
 */
public class TwoOperandBooleanCommandNode extends CommandNode {

    public TwoOperandBooleanCommandNode() {
        super();
        super.setMyExpectedArgs(CommandConstants.COMMAND_EXPECTED_ARGS_TWO);
    }
    
    @Override
    public CommandNode getCopyOfInstance () {
        return new TwoOperandBooleanCommandNode();
    }
    
    @Override
    public int resolve() throws Exception {
        String name = CommandLibrary.getAlias(getMyString());
        List<CommandNode> children = super.getChildren();
        CommandNode childOne = children.get(0);
        CommandNode childTwo = children.get(1);
        int firstOperand = childOne.resolve();
        int secondOperand = childTwo.resolve();
        int result;
        if (name.equals(CommandConstants.COMMAND_NAME_AND)) {
            if (firstOperand > CommandConstants.COMMAND_RETURN_FALSE && secondOperand > CommandConstants.COMMAND_RETURN_FALSE) {
                result = CommandConstants.COMMAND_RETURN_TRUE;
            } else {
                result = CommandConstants.COMMAND_RETURN_FALSE;
            }
        } else if (name.equals(CommandConstants.COMMAND_NAME_IS_EQUAL)) {
            if (firstOperand == secondOperand) {
                result = CommandConstants.COMMAND_RETURN_TRUE;
            } else {
                result = CommandConstants.COMMAND_RETURN_FALSE;
            }
        } else if (name.equals(CommandConstants.COMMAND_NAME_IS_GREATER)) {
            if (firstOperand > secondOperand) {
                result = CommandConstants.COMMAND_RETURN_TRUE;
            } else {
                result = CommandConstants.COMMAND_RETURN_FALSE;
            }
        } else if (name.equals(CommandConstants.COMMAND_NAME_IS_LESS)) {
            if (firstOperand < secondOperand) {
                result = CommandConstants.COMMAND_RETURN_TRUE;
            } else {
                result = CommandConstants.COMMAND_RETURN_FALSE;
            }
        } else if (name.equals(CommandConstants.COMMAND_NAME_IS_NOT_EQUAL)) {
            if (firstOperand != secondOperand) {
                result = CommandConstants.COMMAND_RETURN_TRUE;
            } else {
                result = CommandConstants.COMMAND_RETURN_FALSE;
            }
        } else {
            if (firstOperand > CommandConstants.COMMAND_RETURN_FALSE || secondOperand > CommandConstants.COMMAND_RETURN_FALSE) {
                result = CommandConstants.COMMAND_RETURN_TRUE;
            } else {
                result = CommandConstants.COMMAND_RETURN_FALSE;
            }
        }
        return result;
    }
    
}
