package model.command.turtle;

import model.Room;
import model.command.CommandConstants;
import model.command.CommandNode;

/**
 * Node representing a penup, pendown, or penstatus query command (default penstatus)
 * @author james
 *
 */
public class PenCommandNode extends CommandNode {

    public PenCommandNode() {
        super();
        super.setMyExpectedArgs(CommandConstants.COMMAND_EXPECTED_ARGS_ZERO);
    }
    
    @Override
    public CommandNode getCopyOfInstance () {
        return new PenCommandNode();
    }

    @Override
    public int resolve () throws Exception {
        Room room = getMyRoom();
        if (getMyString().equals(CommandConstants.COMMAND_NAME_PENDOWN)) {
            room.getTurtle().setPenStatus(true);
            return CommandConstants.COMMAND_RETURN_TRUE;
        } else if (getMyString().equals(CommandConstants.COMMAND_NAME_PENUP)) {
            room.getTurtle().setPenStatus(false);
            return CommandConstants.COMMAND_RETURN_FALSE;
        } else {
            if (room.getTurtle().getPenStatus()) {
                return CommandConstants.COMMAND_RETURN_TRUE;
            } else {
                return CommandConstants.COMMAND_RETURN_FALSE;
            }
        }
    }

}
