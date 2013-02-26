package view;

import java.awt.BorderLayout;
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
import model.Room;

public class TabView extends JPanel {

    private int myID;
    private Window myWindow;
    private GridBagConstraints myConstraints;
    private Controller myController;
    private RoomView myRoomView;
    private ConsoleView myConsoleView;
    private FeedbackView myFeedbackView;
    private File myFile;
    
    public TabView(int id, Window hostWindow) {
        this.setLayout(new GridBagLayout());
        myID = id;
        myWindow = hostWindow;
        myConstraints = new GridBagConstraints() ;
        addComponents();
//        myConsoleView = new ConsoleView();
//        myFeedbackView = new FeedbackView();
//        getContentPane().add(myRoomView, BorderLayout.CENTER);
//        getContentPane().add(myConsoleView, BorderLayout.CENTER);
//        getContentPane().add(myFeedbackView, BorderLayout.CENTER);
    }
    
    public TabView(int id) {
        myID = id;
    }
    
    public int getID () {
        return myID;
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
    
    private void listen2WorkspaceInput() {
        if (userHasSubmittedInput()) {
            myController.processCommand(this, myConsoleView.getCommandInput());
        }
    }
    
    private boolean userHasSubmittedInput () {
        // TODO Auto-generated method stub
        return false;
    }

    public void paint(Paintable p) {
        p.paint();
    }
    
}
