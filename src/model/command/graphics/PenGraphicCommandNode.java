package model.command.graphics;

import java.util.List;
import model.Room;
import model.command.CommandConstants;
import model.command.CommandLibrary;
import model.command.CommandNode;

public class PenGraphicCommandNode extends CommandNode {

    public PenGraphicCommandNode() {
        super();
        super.setMyExpectedArgs(CommandConstants.COMMAND_EXPECTED_ARGS_ONE);
    }        
    
    @Override
    public CommandNode getCopyOfInstance () {
        return new PenGraphicCommandNode();
    }
    
    @Override
    public int resolve () throws Exception {
        String name = CommandLibrary.getAlias(getMyString());
        List<CommandNode> children = super.getChildren();
        CommandNode child = children.get(0);
        int result = child.resolve();                
        
        if (name.equals(CommandConstants.COMMAND_NAME_BACK)) {
            result = - result;
        }
        Room room = getMyRoom();
        room.getTurtle().moveForward(result);
        return result;
    }



}
