package model.command.turtle.commands;

import java.util.List;
import model.Room;
import model.command.CommandConstants;
import model.command.CommandLibrary;
import model.command.CommandNode;

/**
 * Node representing a forward or back command (default forward)
 * @author james
 *
 */
public class MoveCommandNode extends CommandNode {

    public MoveCommandNode() {
        super();
        super.setMyExpectedArgs(CommandConstants.COMMAND_EXPECTED_ARGS_ONE);
    }
    
    @Override
    public CommandNode getCopyOfInstance () {
        return new MoveCommandNode();
    }
    
    @Override
    public int resolve() throws Exception {
        String name = CommandLibrary.getAlias(getMyString());
        List<CommandNode> children = super.getChildren();
        CommandNode child = children.get(0);
        int result = child.resolve();
        if (result < 0) {
            if (name.equals(CommandConstants.COMMAND_NAME_FORWARD)) {
                throw new Exception("Error executing FORWARD -- argument value is negative, please use BACK");
            } else {
                throw new Exception("Error executing BACK -- argument value is negative, please use FORWARD");
            }
        }        
        
        /**
         * Negate value if moving back.
         */
        if (name.equals(CommandConstants.COMMAND_NAME_BACK)) {
            result = - result;
        }
        Room room = getMyRoom();
        room.getTurtle().moveForward(result);
        return result;
    }
    
}
