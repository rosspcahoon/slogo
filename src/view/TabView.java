package view;


import controller.Controller;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import model.Renderable;

/**
 * Where the info for one session is. TODO: rename it Tab (maybe - tabview gets confusing).
 * It can be also understood as a "Rendered Room" as its key responsibilities are to
 * paint the room, hold the console (+history) for it, and display feedback info for the room.
 * @author Ross Cahoon, Dagbedji Fagnisse
 *
 */
@SuppressWarnings("serial")
public class TabView extends WindowView {

    private int myID;
    @SuppressWarnings("unused")
    private Window myWindow;
    @SuppressWarnings("unused")
    private GridBagConstraints myConstraints;
    @SuppressWarnings("unused")
    private Controller myController;
    @SuppressWarnings("unused")
    private Renderable myRenderable;
    private RoomView myRoomView;
    private ConsoleView myConsoleView;
    private FeedbackView myFeedbackView;
    private Dimension mySize = ViewConstants.DEFAULT_TAB_SIZE;

    private TabView(Window hostWindow) {
        super(hostWindow);
        setPreferredSize(mySize);
        setMinimumSize(mySize);
    }

    /**
     * Constructor for Tabview
     * @param id the ID for Tab, should be unique.
     * @param hostWindow the parent window which this component resides
     */
    public TabView(int id, Window hostWindow) {     
        this(hostWindow);
        myID = id;       
    }

    /**
     * Set the Renderable for this component
     * @param renderableRoom the Renderable to be set
     */
    public void setRenderable(Renderable renderableRoom) {
        myRenderable = renderableRoom;
    }

    /**
     * Get the ID for this component
     * @return the id of the component
     */
    public int getID () {
        return myID;
    }

    /**
     * Take in a string and send it to Window to process it as a command.
     * @param s The string to be parsed.
     */
    public void processConsoleInput (String s) {
        ((Window) getParent()).processCommand(this, s);
    }    

    //TODO: fix so that it inherits from 'WindowView'
    protected void addComponents() {
        EasyGridFactory.layoutDefaultTab(this, myRoomView, myFeedbackView, myConsoleView);
    }
<<<<<<< HEAD
=======

>>>>>>> 9671166287d04548176f62c11e4f4a9fb4211ba2

    /**
     * Takes in a Renderable and passes it to the views that will output information about it
     * @param p the renderable that will be passed in to be displayed
     */
    public void render(Renderable p) {
        myRoomView.render(p);
        myFeedbackView.render(p);
    }

    /**
     * Initializes the children views of the component
     */
    @Override
    protected void initializeVariables () {
        myConsoleView = new ConsoleView(this);
        myRoomView = new RoomView(this);
        myFeedbackView = new FeedbackView(this);
    }

}
