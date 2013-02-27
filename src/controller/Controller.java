package controller;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JFrame;
import view.Paintable;
import view.RoomView;
import view.TabView;
import view.Window;
import model.Model;
import model.Room;
import model.Status;
import model.Renderable;

/**
 * The controller is responsible for interfacing between the View and the Model.
 * Among other things, it is responsible for handling events from the View, and
 * ensuring that the model components are kept in sync.
 * @author SLogo team 3
 *
 */

public class Controller implements Observer {

    private Window myView;
    private Model myModel;
    private Map<Room, TabView> myRoom2Tab;
    private Map<TabView, Room> myTab2Room;

    /**
     * Constructor
     */
    public Controller() {
        myModel = new Model();
        myView = new Window("SLogo", "English", this);
        myRoom2Tab = new HashMap<Room, TabView>();
        myTab2Room = new HashMap<TabView, Room>();
    }
    
    /**
     * Initialize the GUI.
     */

    public void start() {
        //Welcome message
        myView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myView.pack();
        myView.setVisible(true);
    }
    
    /**
     * 
     */
    public void newSLogoSession() {
        initializeRoom();
    }

    /**
     * Load a file in a specific tab
     * @param f
     */
    private void loadFile (TabView t, File f) {

    }

    @Override
    public void update (Observable o, Object arg) {
        if (o instanceof Room) {
            update((Room) o, arg);
        }
    }

    /**
     * return the Room Object corresponding to the input TabView
     * @param t
     * @return
     */
    private Room getRoomForTab (TabView t) {
        return myTab2Room.get(t);
    }

    private TabView getTabForRoom (Room r) {
        return myRoom2Tab.get(r);
    }
    
    private void update(Room r, Object arg) {
        getTabForRoom(r).setRenderable((Paintable) r);
    }

    /**
     * Model side notify - calls to view to render
     * @param r - updated room
     */
    private void update(Room r) {
        getTabForRoom(r).render((Renderable) r);
    }

    /**
     * View side notify - calls model to process the input command
     * @param t
     * @param arg
     */
    private void update(TabView t, Object arg) {
        if (arg instanceof File) {
            loadFile(t, (File)arg);
        }
        if (arg instanceof String) {
//            myModel.processCommand(getRoomForTab(t), (String) arg);
        }
    }

    /**
     * calls model to process the input string command
     * @param t
     * @param cmd
     */
    public void processCommand (TabView t, String cmd) {
        Room room = getRoomForTab(t);
        myModel.processCommand(room, cmd);
        t.setRenderable((Paintable) room);
    }

    
    /**
     * Add a new room with id based on already existing rooms.
     */
    private void initializeRoom() {
        int id = myRoom2Tab.size();
        initializeRoom(id);
    }

    /**
     * Initialize a room with the ID provided
     * also initialize a corresponding Tab in the view.
     * @param id
     */
    private void initializeRoom (int id) {
        Room theRoom = new Room(id);
        TabView associatedTab = new TabView(id, myView);
        myRoom2Tab.put(theRoom, associatedTab);
        myTab2Room.put(associatedTab, theRoom);
        theRoom.addObserver(this);
        myView.addTab(associatedTab);
    }

}
