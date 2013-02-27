package model;

import java.util.*;

public class Controller implements Observer {

    private Model myModel;
    private Window myView;
    private Map<Room, TabView> Room2Tab;
    private Map<TabView, Room> Tab2Room;
    
    public Controller() {
        myModel = new Model();
        myView = new Window("SLogo");
        Room2Tab = new HashMap<Room, TabView>();
        Tab2Room = new HashMap<TabView, Room>();
    }

    @Override
    public void update (Observable o, Object arg) {
        if (o instanceof Room) {

            update ((Room) o, arg);

        }
    }


    private void update(Room r, Object arg) {

        getTabForRoom(r).paint((Paintable)r);
    }

    public void processCommand (TabView t, String cmd) {
        myModel.processCommand(getRoomForTab(t), cmd);
    }
}
}
