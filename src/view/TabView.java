package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.io.File;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import controller.Controller;
import model.Renderable;
import model.Room;

/**
 * Where the info for one session is. TODO: rename it Tab (maybe - tabview gets confusing).
 * It can be also understood as a "Rendered Room" as its key responsibilities are to
 * paint the room, hold the console (+history) for it, and display feedback info for the room.
 * @author Ross Cahoon, Dagbedji Fagnisse
 *
 */
public class TabView extends WindowView {

    private int myID;
    private Window myWindow;
    private Renderable myRenderable; //TODO: make Renderable
    private RoomView myRoomView;
    private ConsoleView myConsoleView;
    private FeedbackView myFeedbackView;
    private File myFile;
    private Dimension mySize = new Dimension(800,800);
    
    public TabView(Window hostWindow) {
        super(hostWindow);
        setPreferredSize(mySize);
        setMinimumSize(mySize);
    }
    
    public TabView(int id, Window hostWindow) {     
        this(hostWindow);
        myID = id;       
    }
    
    public void setRenderable(Renderable renderableRoom) {
        myRenderable = renderableRoom;
    }
    
    public int getID () {
        return myID;
    }
    
    public void processConsoleInput (String s) {
        ((Window) getParent()).processCommand(this, s);
    }
    
    
    
    //TODO: fix so that it inherits from 'WindowView'
    protected void addComponents() {
        add(myConsoleView, myConsoleView.configLayout(getConstraints()));
        add(myRoomView, myRoomView.configLayout(getConstraints()));
        add(myFeedbackView, myFeedbackView.configLayout(getConstraints()));
    }
    
    
    private void display() {
        
    }

    public void update () {
        display();
    }

    public void render(Renderable p) {
        myRoomView.render(p);
        myFeedbackView.render(p);
    }

    @Override
    protected void initializeVariables () {
         myConsoleView = new ConsoleView(this);
         myRoomView = new RoomView(this);
         myFeedbackView = new FeedbackView(this);
    }
    
}
