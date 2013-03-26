package model.command;

/**
 * Node representing a single number or value.
 * @author james
 *
 */
public class NumberCommandNode extends CommandNode {
    
    private int myValue;
    
    public NumberCommandNode() {
        super();
        super.setMyExpectedArgs(CommandConstants.COMMAND_EXPECTED_ARGS_ZERO);        
    }
    
    public NumberCommandNode(int value) {
        super();
        super.setMyExpectedArgs(CommandConstants.COMMAND_EXPECTED_ARGS_ZERO);
        myValue = value;
    }

    @Override
    public CommandNode getCopyOfInstance() {
        return new NumberCommandNode();
    }

    @Override
    public int resolve() {
        return myValue;
    }
    
    public void setMyValue(int value) {
        myValue = value;
    }
}
