package model.command.booleans;

import java.util.List;
import model.command.CommandConstants;
import model.command.CommandNode;

/**
 * Node representing a NOT test command
 * @author james
 *
 */
public class NotCommandNode extends CommandNode {

    public NotCommandNode() {
        super();
        super.setMyExpectedArgs(CommandConstants.COMMAND_EXPECTED_ARGS_ONE);
    }
    
    @Override
    public CommandNode getCopyOfInstance () {
        return new NotCommandNode();
    }
    
    @Override
    public int resolve() throws Exception {
        List<CommandNode> children = super.getChildren();
        CommandNode child = children.get(0);
        int childValue = child.resolve();
        int result;
        if (childValue > CommandConstants.COMMAND_RETURN_FALSE) {
            result = CommandConstants.COMMAND_RETURN_FALSE;
        } else {
            result = CommandConstants.COMMAND_RETURN_TRUE;
        }
//        System.out.printf("Checked if NOT %d, got %d\n", childValue, result);
        return result;
    }
    
}
