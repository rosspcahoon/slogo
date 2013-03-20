package model.command.turtle.commands;

import model.Room;
import model.command.CommandConstants;
import model.command.CommandNode;

/**
 * Node representing a penup command
 * @author james
 *
 */
public class PenUpCommandNode extends CommandNode {

    public PenUpCommandNode() {
        super();
        super.setMyExpectedArgs(CommandConstants.COMMAND_EXPECTED_ARGS_ZERO);
    }
    
    @Override
    public CommandNode getCopyOfInstance () {
        return new PenUpCommandNode();
    }

    @Override
    public int resolve () {
//        System.out.printf("Put turtle pen up\n");
        Room room = getMyRoom();
        room.getTurtle().setPenStatus(false);
        return CommandConstants.COMMAND_RETURN_FALSE;
    }

}
