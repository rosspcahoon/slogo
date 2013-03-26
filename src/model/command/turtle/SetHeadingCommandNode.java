package model.command.turtle;

import java.util.List;
import model.Room;
import model.command.CommandConstants;
import model.command.CommandNode;

/**
 * Node representing a setheading command
 * @author james
 *
 */
public class SetHeadingCommandNode extends CommandNode {

    public SetHeadingCommandNode() {
        super();
        super.setMyExpectedArgs(CommandConstants.COMMAND_EXPECTED_ARGS_ONE);
    }
    
    @Override
    public CommandNode getCopyOfInstance () {
        return new SetHeadingCommandNode();
    }

    @Override
    public int resolve () throws Exception {
        List<CommandNode> children = super.getChildren();
        CommandNode child = children.get(0);
        int result = child.resolve();
        if (result < 0 || result > 360) {
            throw new Exception("Error executing SETHEADING -- argument value out of bounds, must be between [0, 360]");
        }
//        System.out.printf("Set turtle heading to %d degrees\n", result);
        Room room = getMyRoom();
        result = (int) room.getTurtle().jumpTurn(result);
        return result;
    }

}
