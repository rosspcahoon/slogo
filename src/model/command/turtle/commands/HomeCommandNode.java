package model.command.turtle.commands;

import model.Room;
import model.command.CommandConstants;
import model.command.CommandNode;

/**
 * Node representing a home command
 * @author james
 *
 */
public class HomeCommandNode extends CommandNode {

    public HomeCommandNode() {
        super();
        super.setMyExpectedArgs(CommandConstants.COMMAND_EXPECTED_ARGS_ZERO);
    }
    
    @Override
    public CommandNode getCopyOfInstance () {
        return new HomeCommandNode();
    }

    @Override
    public int resolve () throws Exception {
//        System.out.printf("Moved turtle home\n");
        Room room = getMyRoom();
        int result = (int) room.getTurtle().returnHome();
        return result;
    }

}
