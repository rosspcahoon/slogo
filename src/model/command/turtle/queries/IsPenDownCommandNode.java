package model.command.turtle.queries;

import model.Room;
import model.command.CommandConstants;
import model.command.CommandNode;

/**
 * Node representing a ispendown command
 * @author james
 *
 */
public class IsPenDownCommandNode extends CommandNode {

    public IsPenDownCommandNode() {
        super();
        super.setMyExpectedArgs(CommandConstants.COMMAND_EXPECTED_ARGS_ZERO);
    }
    
    @Override
    public CommandNode getCopyOfInstance () {
        return new IsPenDownCommandNode();
    }

    @Override
    public int resolve () {
//        System.out.printf("Returned turtle pen status\n");
        Room room = getMyRoom();
        int result = -1;
        if (room.getTurtle().getPenStatus()) {
            result = CommandConstants.COMMAND_RETURN_TRUE;
        } else {
            result = CommandConstants.COMMAND_RETURN_FALSE;
        }
        return result;
    }

}
