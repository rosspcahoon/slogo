package command;

import model.Room;

public class LeftCommand extends Command {

    public LeftCommand () {
        super(CommandConstants.COMMAND_EXPECTED_ARGS_TWO);
    }

    @Override
    public void addProperties (String[] args) {
        if (!checkArgsLength(args)) {
            // TODO: add code for updating room error status
            return;
        }
        double pixels = Double.parseDouble(args[1]);
        addProperty(CommandConstants.COMMAND_ARG_PIXELS, pixels);
    }

    @Override
    public void execute (Room r) {
        double degrees = getProperty(CommandConstants.COMMAND_ARG_PIXELS);
        // why do I need a Graphics2D object here? TODO: remove need for that
        // r.rotateTurtle(null, degrees);
        r.notifyObservers();
    }

}
