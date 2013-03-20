package model.command.turtle.queries;

import model.Room;
import model.command.CommandConstants;
import model.command.CommandNode;

/**
 * Node representing a xcor command
 * @author james
 *
 */
public class XCorCommandNode extends CommandNode {

    public XCorCommandNode() {
        super();
        super.setMyExpectedArgs(CommandConstants.COMMAND_EXPECTED_ARGS_ZERO);
    }
    
    @Override
    public CommandNode getCopyOfInstance () {
        return new XCorCommandNode();
    }

    @Override
    public int resolve () {
//        System.out.printf("Returned turtle xcor\n");
        Room room = getMyRoom();
        int result = (int) room.getTurtle().getCurrentLocation().getX();
        return result;
    }

}
