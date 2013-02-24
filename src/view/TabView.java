package view;

import java.awt.BorderLayout;
import java.io.File;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import controller.Controller;
import model.Room;

public class TabView extends JComponent {

    private int myID;
    private Controller myController;
    private RoomView myRoomView;
    private ConsoleView myConsoleView;
    private FeedbackView myFeedbackView;
    private File myFile;
    
    public TabView(int id, Controller con) {
        myID = id;
        myController = con;
        myRoomView = new RoomView();
//        myConsoleView = new ConsoleView();
//        myFeedbackView = new FeedbackView();
//        getContentPane().add(myRoomView, BorderLayout.CENTER);
//        getContentPane().add(myConsoleView, BorderLayout.CENTER);
//        getContentPane().add(myFeedbackView, BorderLayout.CENTER);
    }
    
    public int getID () {
        return myID;
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
