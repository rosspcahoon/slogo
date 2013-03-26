package controller;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.Model;
import model.Renderable;
import model.Room;
import view.TabView;
import view.Window;

/**
 * The controller is responsible for interfacing between the View and the Model.
 * Among other things, it is responsible for handling events from the View, and
 * ensuring that the model components are kept in sync.
 * @author SLogo team 3
 *
 */

public class Controller implements Observer, IController {

    private Window myView;
    private Model myModel;
    private Map<Room, TabView> myRoom2Tab;
    private Map<TabView, Room> myTab2Room;

    /**
     * Constructor
     */
    public Controller() {
        String[] languages = {"English", "French"};
        int n = JOptionPane.showOptionDialog(null,
                            "Choose a language", "Language Selection",
                            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
                            null, languages, languages[0]);
        String language = languages[n];
        myModel = new Model(language);
        myView = new Window("SLogo", language, this);
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
     * Load a file in a specific tab - TODO
     * @param f - File to be loaded.
     * @param t - Tab where file is to be loaded.
     */
    public void loadFile (TabView t, File f) {

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
        getTabForRoom(r).setRenderable((Renderable) r);
    }


    /**
     * calls model to process the input string command
     * @param t - 
     * @param cmd - command to process
     * @return ret - return int from command process
     */
    public int processCommand (TabView t, String cmd) {
        Room room = getRoomForTab(t);
        int ret = myModel.processCommand(room, cmd);
        t.setRenderable((Renderable) room);
        return ret;
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
        myView.addTab(associatedTab, (Renderable) theRoom);
        
    }

}
