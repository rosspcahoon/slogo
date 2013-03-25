package model.command.turtle.commands;

import model.Room;
import model.command.CommandConstants;
import model.command.CommandLibrary;
import model.command.CommandNode;

/**
 * Node representing a xcor or ycor command (default xcor)
 * @author james
 *
 */
public class CorCommandNode extends CommandNode {

    public CorCommandNode() {
        super();
        super.setMyExpectedArgs(CommandConstants.COMMAND_EXPECTED_ARGS_ZERO);
    }
    
    @Override
    public CommandNode getCopyOfInstance () {
        return new CorCommandNode();
    }

    @Override
    public int resolve () {
        String name = CommandLibrary.getAlias(getMyString());
        Room room = getMyRoom();
        int result;
        if (name.equals(CommandConstants.COMMAND_NAME_YCOR)) {
            result = (int) room.getTurtle().getCurrentLocation().getY();
        } else {
            result = (int) room.getTurtle().getCurrentLocation().getX();
        }
        return result;
    }

}
