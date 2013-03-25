package model.command.turtle.commands;

import model.Room;
import model.command.CommandConstants;
import model.command.CommandNode;

/**
 * Node representing a heading command
 * @author james
 *
 */
public class HeadingCommandNode extends CommandNode {

    public HeadingCommandNode() {
        super();
        super.setMyExpectedArgs(CommandConstants.COMMAND_EXPECTED_ARGS_ZERO);
    }
    
    @Override
    public CommandNode getCopyOfInstance () {
        return new HeadingCommandNode();
    }

    @Override
    public int resolve () {
        Room room = getMyRoom();
        int result = (int) room.getTurtle().getHeading();
        return result;
    }

}
