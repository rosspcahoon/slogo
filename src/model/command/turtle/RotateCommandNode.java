package model.command.turtle;

import java.util.List;
import model.Room;
import model.command.CommandConstants;
import model.command.CommandLibrary;
import model.command.CommandNode;

/**
 * Node representing a left or right command (default right)
 * @author james
 *
 */
public class RotateCommandNode extends CommandNode {

    public RotateCommandNode() {
        super();
        super.setMyExpectedArgs(CommandConstants.COMMAND_EXPECTED_ARGS_ONE);
    }
    
    @Override
    public CommandNode getCopyOfInstance () {
        return new RotateCommandNode();
    }

    @Override
    public int resolve () throws Exception {
        String name = CommandLibrary.getAlias(getMyString());
        List<CommandNode> children = super.getChildren();
        CommandNode child = children.get(0);
        int result = child.resolve();
        if (result < 0) {
            if (name.equals(CommandConstants.COMMAND_NAME_LEFT)) {
                throw new Exception("Error executing LEFT -- argument value is negative, please use RIGHT");
            } else {
                throw new Exception("Error executing RIGHT -- argument value is negative, please use LEFT");
            }
        }
        
        /**
         * Negate result if turning left.
         */
        if (name.equals(CommandConstants.COMMAND_NAME_LEFT)) {
            result = - result;
        }
        
        Room room = getMyRoom();
        room.getTurtle().turnRight(result);
        return result;
    }

}
