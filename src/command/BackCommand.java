package command;

import model.Room;

public class BackCommand extends Command {

    public BackCommand () {
        super(CommandConstants.COMMAND_EXPECTED_ARGS_TWO);
    }

    @Override
    public void addProperties (String[] args) {
        if (!checkArgsLength(args)) {
            return;
        }
        double pixels = Double.parseDouble(args[1]);
        addProperty(CommandConstants.COMMAND_ARG_PIXELS, pixels);
    }

    @Override
    public void execute (Room r) {
        double distance = - getProperty(CommandConstants.COMMAND_ARG_PIXELS);
        r.moveTurtleForward(distance);
        r.notifyObservers();
    }

}
