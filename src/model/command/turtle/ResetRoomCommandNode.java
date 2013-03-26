package model.command.turtle;

import model.Room;
import model.command.CommandConstants;
import model.command.CommandLibrary;
import model.command.CommandNode;

/**
 * Node representing a home or clearscreen command (default clearscreen)
 * @author james
 *
 */
public class ResetRoomCommandNode extends CommandNode {

    public ResetRoomCommandNode() {
        super();
        super.setMyExpectedArgs(CommandConstants.COMMAND_EXPECTED_ARGS_ZERO);
    }
    
    @Override
    public CommandNode getCopyOfInstance () {
        return new ResetRoomCommandNode();
    }

    @Override
    public int resolve () throws Exception {
        String name = CommandLibrary.getAlias(getMyString());
        Room room = getMyRoom();
        int result;
        if (name.equals(CommandConstants.COMMAND_NAME_HOME)) {
            result = (int) room.getTurtle().returnHome();
        } else {
            result = (int) room.clear();
        }
        return result;
    }

}
