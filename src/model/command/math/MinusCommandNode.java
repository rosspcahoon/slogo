package model.command.math;

import java.util.List;
import model.command.CommandConstants;
import model.command.CommandNode;

/**
 * Node representing a minus command
 * @author james
 *
 */
public class MinusCommandNode extends CommandNode {

    public MinusCommandNode() {
        super();
        super.setMyExpectedArgs(CommandConstants.COMMAND_EXPECTED_ARGS_ONE);
    }
    
    @Override
    public CommandNode getCopyOfInstance () {
        return new MinusCommandNode();
    }
    
    @Override
    public int resolve() {
        List<CommandNode> children = super.getChildren();
        CommandNode child = children.get(0);
        int childValue = child.resolve();
        int result = -childValue;
        System.out.printf("Negated %d to get %d\n", childValue, result);
        return result;
    }
    
}
