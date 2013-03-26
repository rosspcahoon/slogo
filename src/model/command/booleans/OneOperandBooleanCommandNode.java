package model.command.booleans;

import java.util.List;
import model.command.CommandConstants;
import model.command.CommandLibrary;
import model.command.CommandNode;

/**
 * Node representing one operand test commands, not
 * @author james
 *
 */
public class OneOperandBooleanCommandNode extends CommandNode {

    public OneOperandBooleanCommandNode() {
        super();
        super.setMyExpectedArgs(CommandConstants.COMMAND_EXPECTED_ARGS_ONE);
    }
    
    @Override
    public CommandNode getCopyOfInstance () {
        return new OneOperandBooleanCommandNode();
    }
    
    @Override
    public int resolve() throws Exception {
        String name = CommandLibrary.getAlias(getMyString());
        List<CommandNode> children = super.getChildren();
        CommandNode child = children.get(0);
        int childValue = child.resolve();
        int result;
        if (childValue != CommandConstants.COMMAND_RETURN_FALSE) {
            result = CommandConstants.COMMAND_RETURN_FALSE;
        } else {
            result = CommandConstants.COMMAND_RETURN_TRUE;
        }
        return result;
    }
    
}
