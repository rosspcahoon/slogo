package model.command.turtle.commands;

import java.util.List;
import model.Room;
import model.command.CommandConstants;
import model.command.CommandNode;

/**
 * Node representing a towards command
 * @author james
 *
 */
public class TowardsCommandNode extends CommandNode {

    public TowardsCommandNode() {
        super();
        super.setMyExpectedArgs(CommandConstants.COMMAND_EXPECTED_ARGS_TWO);
    }
    
    @Override
    public CommandNode getCopyOfInstance () {
        return new TowardsCommandNode();
    }

    @Override
    public int resolve () throws Exception {
        List<CommandNode> children = super.getChildren();
        CommandNode xChild = children.get(0);
        CommandNode yChild = children.get(1);
        int xCoord = xChild.resolve();
        int yCoord = yChild.resolve();
        Room room = getMyRoom();
        int result = (int) room.getTurtle().jumpTurn(xCoord, yCoord);
//        room.getTurtle().
//        System.out.printf("Turned turtle to face %d %d\n", xCoord, yCoord);
        return result;
    }

}
