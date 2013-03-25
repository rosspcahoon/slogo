package model.command.turtle.commands;

import model.Room;
import model.command.CommandConstants;
import model.command.CommandNode;

/**
 * Node representing a clearscreen command
 * @author james
 *
 */
public class ClearScreenCommandNode extends CommandNode {

    public ClearScreenCommandNode() {
        super();
        super.setMyExpectedArgs(CommandConstants.COMMAND_EXPECTED_ARGS_ZERO);
    }
    
    @Override
    public CommandNode getCopyOfInstance () {
        return new ClearScreenCommandNode();
    }

    @Override
    public int resolve () throws Exception {
//        System.out.printf("Cleared screen\n");
        Room room = getMyRoom();
        int result = (int) room.clear();
        return result;
    }

}
