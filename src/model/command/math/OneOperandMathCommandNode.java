package model.command.math;

import java.util.List;
import java.util.Random;
import model.command.CommandConstants;
import model.command.CommandLibrary;
import model.command.CommandNode;

/**
 * Node representing one operand math commands, random or minus (default minus)
 * @author james
 *
 */
public class OneOperandMathCommandNode extends CommandNode {

    public OneOperandMathCommandNode() {
        super();
        super.setMyExpectedArgs(CommandConstants.COMMAND_EXPECTED_ARGS_ONE);
    }
    
    @Override
    public CommandNode getCopyOfInstance () {
        return new OneOperandMathCommandNode();
    }
    
    @Override
    public int resolve() throws Exception {
        String name = CommandLibrary.getAlias(getMyString());
        List<CommandNode> children = super.getChildren();
        CommandNode child = children.get(0);
        int childValue = child.resolve();
        int result;
        if (name.equals(CommandConstants.COMMAND_NAME_RANDOM)) {
            if (childValue <= 0) {
                throw new Exception("Error executing RANDOM -- cannot execute on a nonpositive");
            }
            Random random = new Random();
            result = random.nextInt(childValue);
        } else {
            result = -childValue;
        }
        return result;
    }
    
}
