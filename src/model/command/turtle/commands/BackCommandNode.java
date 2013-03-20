package model.command.turtle.commands;

import java.util.List;
import model.Room;
import model.command.CommandConstants;
import model.command.CommandNode;

/**
 * Node representing a back command
 * @author james
 *
 */
public class BackCommandNode extends CommandNode {

    public BackCommandNode() {
        super();
        super.setMyExpectedArgs(CommandConstants.COMMAND_EXPECTED_ARGS_ONE);
    }
    
    @Override
    public CommandNode getCopyOfInstance () {
        return new BackCommandNode();
    }
    
    @Override
    public int resolve() {
        List<CommandNode> children = super.getChildren();
        CommandNode child = children.get(0);
        int result = child.resolve();
//        System.out.printf("Move turtle backward %d pixels\n", result);
        Room room = getMyRoom();
        room.getTurtle().moveForward(-result);
        return result;
    }
    
}
