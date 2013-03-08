package model;

import java.awt.Graphics2D;
import java.util.Observable;
import util.Location;


/**
 * Class for managing objects in the room 
 * @author thomasvarner
 *
 */

public class Room extends Observable implements Renderable{

    private int myID;
    private Status myStatus;
    
    private Turtle myTurtle;
    
    private boolean myTurtlePenStatus;
    private double myTurtleHead; 
    private Location myTurtleLocation;
    private boolean myTurtleVisibility; 

    
    public Room (int id) {
        myID = id;
        myTurtle = new Turtle();
    }

    public int getID () {
        return myID;
    }

    public void returnHome () { 
        myTurtle.returnHome(); 
    }

    public Status getState() {
        return myStatus;
    }
    
    public Turtle getTurtle() {
        return myTurtle;
    }
    
    public void paint(Graphics2D pen) {
        myTurtle.paint(pen);
    }
}
