package model.command.extended;

import model.Room;
import model.command.CommandConstants;
import model.command.CommandLibrary;
import model.command.CommandNode;

/**
 * Node for graphics query commands, pencolor, shape, (default shape)
 * @author james
 *
 */
public class GetGraphicsCommandNode extends CommandNode {

    public GetGraphicsCommandNode() {
        super();
        super.setMyExpectedArgs(CommandConstants.COMMAND_EXPECTED_ARGS_ZERO);
    }        
    
    @Override
    public CommandNode getCopyOfInstance () {
        return new GetGraphicsCommandNode();
    }
    
    @Override
    public int resolve () throws Exception {
        String name = CommandLibrary.getAlias(getMyString());
        Room room = getMyRoom();
        if (name.equals(CommandConstants.COMMAND_NAME_PEN_COLOR)) {
            int result = room.getTurtle().getPenIndex();
            return result;
        } else {
            int result = room.getTurtle().getShapeIndex();
            return result;
        }
    }



}
