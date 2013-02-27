package command;

import model.Room;

public class ForwardCommand extends Command {

    public ForwardCommand () {
        super(CommandConstants.COMMAND_FORWARD_EXPECTED_ARGS);
    }

    @Override
    public void addProperties (String[] args) {
        if (!checkArgsLength(args)) {
            // TODO: add code for updating room error status
            return;
        }
        double pixels = Double.parseDouble(args[1]);
        addProperty(CommandConstants.COMMAND_FORWARD_ARG_PIXELS, pixels);
    }

    @Override
    public void execute (Room r) {
        // TODO: implement this with Thomas' methods
    }

}
