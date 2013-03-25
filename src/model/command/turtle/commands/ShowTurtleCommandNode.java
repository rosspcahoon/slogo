package model.command.turtle.commands;

import model.Room;
import model.command.CommandConstants;
import model.command.CommandNode;

/**
 * Node representing a showturtle command
 * @author james
 *
 */
public class ShowTurtleCommandNode extends CommandNode {

    public ShowTurtleCommandNode() {
        super();
        super.setMyExpectedArgs(CommandConstants.COMMAND_EXPECTED_ARGS_ZERO);
    }
    
    @Override
    public CommandNode getCopyOfInstance () {
        return new ShowTurtleCommandNode();
    }

    @Override
    public int resolve () throws Exception {
//        System.out.printf("Turtle visibility on\n");
        Room room = getMyRoom();
        room.getTurtle().setVisibilityStatus(true);
        return CommandConstants.COMMAND_RETURN_TRUE;
    }

}
