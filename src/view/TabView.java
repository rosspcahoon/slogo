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
public class TabView extends JPanel {

    private int myID;
    private Window myWindow;
    private GridBagConstraints myConstraints;
    private Controller myController;
    private Paintable myRenderable; //TODO: make Renderable
    private RoomView myRoomView;
    private ConsoleView myConsoleView;
    private FeedbackView myFeedbackView;
    private File myFile;
    private Dimension mySize = new Dimension(800,800);
    
    public TabView(int id, Window hostWindow) {
        setPreferredSize(mySize);
        setMinimumSize(mySize);
        this.setLayout(new GridBagLayout());
        myID = id;
        myWindow = hostWindow;
        myConstraints = new GridBagConstraints() ;
        addComponents();
    }
    
    public void setRenderable(Paintable r) {
        myRenderable = r;
    }
    
    public TabView(int id) {
        myID = id;
    }
    
    public int getID () {
        return myID;
    }
    
    public void processConsoleInput (String s) {
        myController.processCommand(this, s);
    }
    
    
    public GridBagConstraints getConstraints() {
        return myConstraints;
    }
    
    
    public void addComponents() {
        add(myConsoleView = new ConsoleView(), myConsoleView.configLayout(getConstraints()));
        add(myRoomView = new RoomView(), myRoomView.configLayout(getConstraints()));
        add(myFeedbackView = new FeedbackView(), myFeedbackView.configLayout(getConstraints()));
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
    
}
