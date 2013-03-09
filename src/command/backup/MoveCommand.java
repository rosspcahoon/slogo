package command.backup;

import model.BasicMoveable;
import model.Room;
import model.BasicRoomObject;

@Deprecated
public class MoveCommand extends Command {

    public MoveCommand () {
        super(CommandConstants.COMMAND_EXPECTED_ARGS_TWO);
    }

    @Override
    public void addProperties (String[] args) {
        if (!checkArgsLength(args)) {
            return;
        }
        String arg0 = args[0];
        double arg1 = Double.parseDouble(args[1]);
        if (arg0.equals(CommandConstants.COMMAND_NAME_FORWARD)){ 
            addProperty(CommandConstants.COMMAND_ARG_PIXELS, arg1);
        } else if (arg0.equals(CommandConstants.COMMAND_NAME_BACK)) {
            addProperty(CommandConstants.COMMAND_ARG_PIXELS, -arg1);
        } else if (arg0.equals(CommandConstants.COMMAND_NAME_LEFT)) {
            addProperty(CommandConstants.COMMAND_ARG_DEGREES, arg1);
        } else if (arg0.equals(CommandConstants.COMMAND_NAME_RIGHT)) {
            addProperty(CommandConstants.COMMAND_ARG_DEGREES, -arg1);
        }
    }

    @Override
    public void execute (Room r, BasicRoomObject o) {
        if (!(o instanceof BasicMoveable)) {
            //TODO: add error reporting
            return;
        }
        BasicMoveable m = (BasicMoveable) o;
        Double distance = getProperty(CommandConstants.COMMAND_ARG_PIXELS);
        Double degrees = getProperty(CommandConstants.COMMAND_ARG_DEGREES); 
        if (distance != null) {
            m.moveForward(distance);
        } else {
            m.turnRight(degrees);
        }
        r.notifyObservers();
    }

}
