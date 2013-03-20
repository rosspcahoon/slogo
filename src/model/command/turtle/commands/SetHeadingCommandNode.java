package model.command.turtle.commands;

import java.util.List;
import model.Room;
import model.command.CommandConstants;
import model.command.CommandNode;

/**
 * Node representing a setheading command
 * @author james
 *
 */
public class SetHeadingCommandNode extends CommandNode {

    public SetHeadingCommandNode() {
        super();
        super.setMyExpectedArgs(CommandConstants.COMMAND_EXPECTED_ARGS_ONE);
    }
    
    @Override
    public CommandNode getCopyOfInstance () {
        return new SetHeadingCommandNode();
    }

    @Override
    public int resolve () {
        List<CommandNode> children = super.getChildren();
        CommandNode child = children.get(0);
        int result = child.resolve();
//        System.out.printf("Set turtle heading to %d degrees\n", result);
        Room room = getMyRoom();
        room.getTurtle().jumpTurn(result);
        return result;
    }

}
