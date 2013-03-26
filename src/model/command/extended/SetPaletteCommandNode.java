package model.command.extended;

import java.util.List;
import model.PenConstants;
import model.command.CommandConstants;
import model.command.CommandNode;

/**
 * Node for setpalette command
 * @author james
 *
 */
public class SetPaletteCommandNode extends CommandNode {

    public SetPaletteCommandNode() {
        super();
        super.setMyExpectedArgs(CommandConstants.COMMAND_EXPECTED_ARGS_FOUR);
    }        
    
    @Override
    public CommandNode getCopyOfInstance () {
        return new SetPaletteCommandNode();
    }
    
    @Override
    public int resolve () throws Exception {
        List<CommandNode> children = super.getChildren();
        int index = children.get(0).resolve();
        int rVal = children.get(1).resolve();
        int gVal = children.get(2).resolve();
        int bVal = children.get(3).resolve();
        int result = PenConstants.setPalette(index, rVal, gVal, bVal);
        return result;
    }



}
