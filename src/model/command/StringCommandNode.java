package model.command;

/**
 * Node representing a String. Calling resolve on this will return -1, unless the
 * name of the node is a variable name, in which case calling resolve will return
 * the value of that variable as reported by the current user var library in the
 * CommandLibrary class.
 * @author james
 *
 */
public class StringCommandNode extends CommandNode {
    
    public StringCommandNode() {
        super();
        super.setMyExpectedArgs(CommandConstants.COMMAND_EXPECTED_ARGS_ZERO);        
    }

    @Override
    public CommandNode getCopyOfInstance() {
        return new StringCommandNode();
    }

    @Override
    public int resolve() throws Exception {
        if (!getMyString().substring(0, 1).equals(CommandConstants.COMMAND_NAME_VARIABLE_START)) {
            return -1;
        }     
        int result = CommandLibrary.getUserVariable(super.getMyString());
        return result;
    }
}
