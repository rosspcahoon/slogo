package view;


import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Image;
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
    private Window myWindow;
    @SuppressWarnings("unused")
    private GridBagConstraints myConstraints;
    private Renderable myRenderable;
    private RoomView myRoomView;
    private ConsoleView myConsoleView;
    private FeedbackView myFeedbackView;
    private Dimension mySize = ViewConstants.DEFAULT_TAB_SIZE;

    private TabView(Window hostWindow) {
        super(hostWindow);
        setWindow();
        setPreferredSize(mySize);
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

    private void setWindow() {
        myWindow = (Window) getParent();
    }

    /**
     * Set the Renderable for this component
     * @param renderableRoom the Renderable to be set
     */
    public void setRenderable(Renderable renderableRoom) {
        myRenderable = renderableRoom;
        render(myRenderable);
    }

    /**
     * Sets background image for the Roomview
     * @param img the image to be set.
     */
    public void setBackground(Image img) {
        myRoomView.setBackground(img);
    }
    /**
     * Toggles the reference grid for the workspace
     */
    public void toggleGrid() {
        myRoomView.toggleGrid();
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
        myWindow.processCommand(this, s);
    }    

    protected void addComponents() {
        EasyGridFactory.layoutDefaultTab(this, myRoomView, myFeedbackView, myConsoleView);
    }

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
