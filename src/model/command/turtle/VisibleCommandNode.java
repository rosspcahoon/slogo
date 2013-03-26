package model.command.turtle;

import model.Room;
import model.command.CommandConstants;
import model.command.CommandLibrary;
import model.command.CommandNode;

/**
 * Node representing a showturtle, hideturtle, or isshowing command (default isshowing)
 * @author james
 *
 */
public class VisibleCommandNode extends CommandNode {

    public VisibleCommandNode() {
        super();
        super.setMyExpectedArgs(CommandConstants.COMMAND_EXPECTED_ARGS_ZERO);
    }
    
    @Override
    public CommandNode getCopyOfInstance () {
        return new VisibleCommandNode();
    }

    @Override
    public int resolve () throws Exception {
        String name = CommandLibrary.getAlias(getMyString());
        Room room = getMyRoom();
        if (name.equals(CommandConstants.COMMAND_NAME_SHOW_TURTLE)) {
            room.getTurtle().setVisibilityStatus(true);
            return CommandConstants.COMMAND_RETURN_TRUE;
        } else if (name.equals(CommandConstants.COMMAND_NAME_HIDE_TURTLE)) {
            room.getTurtle().setVisibilityStatus(false);
            return CommandConstants.COMMAND_RETURN_FALSE;
        } else {
            if (room.getTurtle().getVisibilityStatus()) {
                return CommandConstants.COMMAND_RETURN_TRUE;
            } else {
                return CommandConstants.COMMAND_RETURN_FALSE;
            }            
        }               
    }

}
