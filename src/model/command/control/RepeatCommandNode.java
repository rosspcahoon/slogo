package model.command.control;

import java.util.List;
import model.command.CommandConstants;
import model.command.CommandLibrary;
import model.command.CommandNode;

/**
 * Command node representing a repeat command
 * @author james
 *
 */
public class RepeatCommandNode extends CommandNode {

    public RepeatCommandNode() {
        super();
        super.setMyExpectedArgs(CommandConstants.COMMAND_EXPECTED_ARGS_TWO);
    }
    
    @Override
    public CommandNode getCopyOfInstance () {
        return new RepeatCommandNode();
    }

    @Override
    public int resolve () throws Exception {
        List<CommandNode> children = super.getChildren();
        CommandNode iterations = children.get(0);
        CommandNode commands = children.get(1);
        int numIterations = iterations.resolve();
        if (numIterations <= 0) {
            throw new Exception("Error executing REPEAT -- number of iterations nonpositive");
        }
        int result = -1;
        for (int i=0; i<numIterations; i++) {
            String currentKey = CommandLibrary.getCurrentParameterLibraryKey();
            CommandLibrary.loadVariableLibrary(super.getMyRoom());
            CommandLibrary.addUserVariable(CommandConstants.COMMAND_REPEAT_COUNT_VAR_NAME, i+1);
            if (currentKey != null) {
                CommandLibrary.loadParameterLibrary(currentKey);
            }
            result = commands.resolve();
        }
        return result;
    }

}
