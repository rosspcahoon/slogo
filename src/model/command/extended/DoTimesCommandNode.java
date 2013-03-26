package model.command.extended;

import java.util.List;
import model.command.CommandConstants;
import model.command.CommandLibrary;
import model.command.CommandNode;

/**
 * Command node representing a repeat command
 * @author james
 *
 */
public class DoTimesCommandNode extends CommandNode {

    public DoTimesCommandNode() {
        super();
        super.setMyExpectedArgs(CommandConstants.COMMAND_EXPECTED_ARGS_TWO);
    }
    
    @Override
    public CommandNode getCopyOfInstance () {
        return new DoTimesCommandNode();
    }

    @Override
    public int resolve () throws Exception {
        List<CommandNode> children = super.getChildren();
        CommandNode iterations = children.get(0);
        CommandNode commands = children.get(1);
        List<CommandNode> iterationChildren = iterations.getChildren();
        if (iterationChildren.size() != CommandConstants.COMMAND_EXPECTED_ARGS_TWO) {
            throw new Exception("Error executing DOTIMES -- limit assignment has wrong number of arguments");
        }
        String iteratorVar = iterationChildren.get(0).getMyString();
        CommandLibrary.loadVariableLibrary(super.getMyRoom());
        CommandLibrary.addUserVariable(iteratorVar, 0);
        int limit = iterationChildren.get(1).resolve();
        if (limit <= 0) {
            throw new Exception("Error executing DOTIMES -- limit nonpositive");
        }
        int result = -1;
        for (int i=0; i<limit; i++) {
            CommandLibrary.loadVariableLibrary(super.getMyRoom());
            CommandLibrary.addUserVariable(iteratorVar, i);
            result = commands.resolve();
        }
        return result;
    }

}
