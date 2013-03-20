package model.command.turtle.queries;

import model.Room;
import model.command.CommandConstants;
import model.command.CommandNode;

/**
 * Node representing an isshowing command
 * @author james
 *
 */
public class IsShowingCommandNode extends CommandNode {

    public IsShowingCommandNode() {
        super();
        super.setMyExpectedArgs(CommandConstants.COMMAND_EXPECTED_ARGS_ZERO);
    }
    
    @Override
    public CommandNode getCopyOfInstance () {
        return new IsShowingCommandNode();
    }

    @Override
    public int resolve () {
//        System.out.printf("Returned turtle visibility status\n");
        Room room = getMyRoom();
        int result = -1;
        if (room.getTurtle().getVisibilityStatus()) {
            result = CommandConstants.COMMAND_RETURN_TRUE;
        } else {
            result = CommandConstants.COMMAND_RETURN_FALSE;
        }
        return result;
    }

}
