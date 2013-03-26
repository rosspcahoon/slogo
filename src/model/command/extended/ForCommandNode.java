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
public class ForCommandNode extends CommandNode {

    public ForCommandNode() {
        super();
        super.setMyExpectedArgs(CommandConstants.COMMAND_EXPECTED_ARGS_TWO);
    }
    
    @Override
    public CommandNode getCopyOfInstance () {
        return new ForCommandNode();
    }

    @Override
    public int resolve () throws Exception {
        List<CommandNode> children = super.getChildren();
        CommandNode iterations = children.get(0);
        CommandNode commands = children.get(1);
        List<CommandNode> iterationChildren = iterations.getChildren();
        if (iterationChildren.size() != CommandConstants.COMMAND_EXPECTED_ARGS_FOUR) {
            throw new Exception("Error executing FOR -- limit assignment has wrong number of arguments");
        }
        String iteratorVar = iterationChildren.get(0).getMyString();
        int iteratorStart = iterationChildren.get(1).resolve();
        int iteratorEnd = iterationChildren.get(2).resolve();
        int iteratorIncrement = iterationChildren.get(3).resolve();
        CommandLibrary.loadVariableLibrary(super.getMyRoom());
        CommandLibrary.addUserVariable(iteratorVar, iteratorStart);
        if (iteratorStart == iteratorEnd) {
            throw new Exception("Error executing FOR -- start and end equal");
        }
        if (iteratorIncrement == 0) {
            throw new Exception("Error executing FOR -- increment is zero");
        }
        if (iteratorStart < iteratorEnd && iteratorIncrement < 0) {
            throw new Exception("Error executing FOR -- infinite loop");
        }
        if (iteratorStart > iteratorEnd && iteratorIncrement > 0) {
            throw new Exception("Error executing FOR -- infinite loop");
        }
        int result = -1;
        if (iteratorStart < iteratorEnd) {
            for (int i=iteratorStart; i<iteratorEnd; i+=iteratorIncrement) {
                CommandLibrary.loadVariableLibrary(super.getMyRoom());
                CommandLibrary.addUserVariable(iteratorVar, i);
                result = commands.resolve();
            }
        } else {
            for (int i=iteratorStart; i>iteratorEnd; i+=iteratorIncrement) {
                CommandLibrary.loadVariableLibrary(super.getMyRoom());
                CommandLibrary.addUserVariable(iteratorVar, i);
                result = commands.resolve();
            }
        }
        return result;
    }

}
