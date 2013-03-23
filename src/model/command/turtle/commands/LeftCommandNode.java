package model.command.turtle.commands;

import java.util.List;
import model.Room;
import model.command.CommandConstants;
import model.command.CommandNode;

/**
 * Node representing a left command
 * @author james
 *
 */
public class LeftCommandNode extends CommandNode {

    public LeftCommandNode() {
        super();
        super.setMyExpectedArgs(CommandConstants.COMMAND_EXPECTED_ARGS_ONE);
    }
    
    @Override
    public CommandNode getCopyOfInstance () {
        return new LeftCommandNode();
    }

    @Override
    public int resolve () throws Exception {
        List<CommandNode> children = super.getChildren();
        CommandNode child = children.get(0);
        int result = child.resolve();
        if (result < 0) {
            throw new Exception("Error executing LEFT -- argument value is negative, please use RIGHT");
        }
//        System.out.printf("Turn turtle left %d degrees\n", result);
        Room room = getMyRoom();
        room.getTurtle().turnRight(-result);
        return result;
    }

}
