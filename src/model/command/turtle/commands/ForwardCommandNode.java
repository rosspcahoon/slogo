package model.command.turtle.commands;

import java.util.List;
import model.Room;
import model.command.CommandConstants;
import model.command.CommandNode;

/**
 * Node representing a forward command
 * @author james
 *
 */
public class ForwardCommandNode extends CommandNode {

    public ForwardCommandNode() {
        super();
        super.setMyExpectedArgs(CommandConstants.COMMAND_EXPECTED_ARGS_ONE);
    }
    
    @Override
    public CommandNode getCopyOfInstance () {
        return new ForwardCommandNode();
    }
    
    @Override
    public int resolve() throws Exception {
        List<CommandNode> children = super.getChildren();
        CommandNode child = children.get(0);
        int result = child.resolve();
        if (result < 0) {
            throw new Exception("Error executing FORWARD -- argument value is negative, please use BACK");
        }
//        System.out.printf("Move turtle forward %d pixels\n", result);
        Room room = getMyRoom();
        room.getTurtle().moveForward(result);
        return result;
    }
    
}
