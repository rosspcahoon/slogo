package model.command.extended;

import java.util.List;
import model.ImageConstants;
import model.PenConstants;
import model.Room;
import model.command.CommandConstants;
import model.command.CommandLibrary;
import model.command.CommandNode;

/**
 * Node for set graphics commands, setpencolor, setshape, setpenthickness, setpentype (default setpentype)
 * @author james
 *
 */
public class SetGraphicsCommandNode extends CommandNode {

    public SetGraphicsCommandNode() {
        super();
        super.setMyExpectedArgs(CommandConstants.COMMAND_EXPECTED_ARGS_ONE);
    }        
    
    @Override
    public CommandNode getCopyOfInstance () {
        return new SetGraphicsCommandNode();
    }
    
    @Override
    public int resolve () throws Exception {
        String name = CommandLibrary.getAlias(getMyString());
        List<CommandNode> children = super.getChildren();
        Room room = getMyRoom();
        CommandNode child = children.get(0);
        int childValue = child.resolve();                
        if (name.equals(CommandConstants.COMMAND_NAME_SET_PEN_COLOR)) {
            if (childValue == -1) {
                if (child.getMyString().equals(CommandConstants.COMMAND_SETTER_LAST_ITEM)) {
                    room.getTurtle().setPenColor(PenConstants.getLastIndex());
                } else {
                    throw new Exception("Error executing SETPENCOLOR -- color index could not be interpreted");
                }
            }
            try {
                room.getTurtle().setPenColor(childValue);
                return childValue;
            } catch (IndexOutOfBoundsException e) {
                throw new Exception("Error executing SETPENCOLOR -- color index out of bounds");
            }
        } else if (name.equals(CommandConstants.COMMAND_NAME_SET_SHAPE)) {
            if (childValue == -1) {
                if (child.getMyString().equals(CommandConstants.COMMAND_SETTER_LAST_ITEM)) {
                    room.getTurtle().setShape(ImageConstants.getLastIndex());
                } else {
                    throw new Exception("Error executing SETSHAPE -- color index could not be interpreted");
                }
            }
            try {
                room.getTurtle().setShape(childValue);
                return childValue;
            } catch (IndexOutOfBoundsException e) {
                throw new Exception("Error executing SETSHAPE -- color index out of bounds");
            }
        } else if (name.equals(CommandConstants.COMMAND_NAME_SET_PEN_SIZE)) {
            room.getTurtle().setPenThickness(childValue);
            return childValue;
        } else {
            if (childValue == PenConstants.PEN_TYPE_INDEX_NORMAL) {
                room.getTurtle().setDashWidth(PenConstants.PEN_DASH_NO_SPACE);
                room.getTurtle().setDoubleLine(false);
                return childValue;
            } else if (childValue == PenConstants.PEN_TYPE_INDEX_DASHED) {
                room.getTurtle().setDashWidth(PenConstants.PEN_DASH_SPACE);
                return childValue;
            } else if (childValue == PenConstants.PEN_TYPE_INDEX_DOUBLE) {
                room.getTurtle().setDoubleLine(true);
                return childValue;
            } else {
                throw new Exception("Error executing SETPENTYPE -- invalid type index");
            }
        }
    }



}
