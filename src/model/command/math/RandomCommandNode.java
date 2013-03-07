package model.command.math;

import java.util.List;
import java.util.Random;
import model.command.CommandConstants;
import model.command.CommandNode;

/**
 * Node representing a random command
 * @author james
 *
 */
public class RandomCommandNode extends CommandNode {

    public RandomCommandNode() {
        super();
        super.setMyExpectedArgs(CommandConstants.COMMAND_EXPECTED_ARGS_ONE);
    }
    
    @Override
    public CommandNode getCopyOfInstance () {
        return new RandomCommandNode();
    }
    
    @Override
    public int resolve() {
        List<CommandNode> children = super.getChildren();
        CommandNode child = children.get(0);
        int childValue = child.resolve();
        Random random = new Random();
        int result = random.nextInt(childValue);
        System.out.printf("Random number up to %d got %d\n", childValue, result);
        return result;
    }
    
}
