package model.command.turtle;

import java.util.List;
import model.Room;
import model.command.CommandConstants;
import model.command.CommandNode;

/**
 * Node representing a setxy command
 * @author james
 *
 */
public class SetXYCommandNode extends CommandNode {

    public SetXYCommandNode() {
        super();
        super.setMyExpectedArgs(CommandConstants.COMMAND_EXPECTED_ARGS_TWO);
    }
    
    @Override
    public CommandNode getCopyOfInstance () {
        return new SetXYCommandNode();
    }

    @Override
    public int resolve () throws Exception {
        List<CommandNode> children = super.getChildren();
        CommandNode xChild = children.get(0);
        CommandNode yChild = children.get(1);
        int xCoord = xChild.resolve();
        int yCoord = yChild.resolve();
        // TODO: do not allow turtle to move out of bounds
//        System.out.printf("Moved turtle to location %d %d\n", xCoord, yCoord);
        Room room = getMyRoom();
        int result = (int) room.getTurtle().jumpMove(xCoord, yCoord);
        return result;
    }

}
