package model.command.extended;

import java.awt.Color;
import java.util.List;
import model.ImageConstants;
import model.PenConstants;
import model.command.CommandConstants;
import model.command.CommandLibrary;
import model.command.CommandNode;

/**
 * Node for graphics commands, registercolor, registershape (default registershape)
 * @author james
 *
 */
public class RegisterGraphicsCommandNode extends CommandNode {

    public RegisterGraphicsCommandNode() {
        super();
        super.setMyExpectedArgs(CommandConstants.COMMAND_EXPECTED_ARGS_ONE);
    }        
    
    @Override
    public CommandNode getCopyOfInstance () {
        return new RegisterGraphicsCommandNode();
    }
    
    @Override
    public int resolve () throws Exception {
        String name = CommandLibrary.getAlias(getMyString());
        List<CommandNode> children = super.getChildren();
        CommandNode child = children.get(0);
        int childValue = child.resolve();                
        if (name.equals(CommandConstants.COMMAND_NAME_REGISTER_COLOR)) {
            int result = PenConstants.addColor(new Color(childValue));
            return result;
        } else {
            String path = child.getMyString();
            int result = ImageConstants.addImage(path);
            return result;
        }
    }



}
