package model;

import java.awt.Graphics2D;
import java.util.Observable;
import util.Location;
import model.Actor;


/**
 * Class for managing objects in the room 
 * @author thomasvarner, Matthew Parides
 *
 */

public class Room extends Observable implements Renderable{

    private int myID;
    private Status myStatus;
    
    private Actor myTurtle;
    
    private boolean myTurtlePenStatus;
    private double myTurtleHead; 
    private Location myTurtleLocation;
    private boolean myTurtleVisibility; 

    /**
     * Constructor
     * @param id
     */
    public Room (int id) {
        myID = id;
        myTurtle = new Actor(0);
        myStatus = new Status();
    }

    /**
     * getter for this room's number ID
     * @return myID
     */
    public int getID () {
        return myID;
    }

    /**
     * returns the turtle to its initial location
     */
    public void returnHome () { 
        myTurtle.returnHome(); 
    }

    /**
     * getter for myStatus Status object
     * @return myStatus
     */
    public Status getState() {
        return myStatus;
    }
    
    /**
     * getter for myTurtle Turtle object
     * @return myTurtle
     */
    public Actor getTurtle() {
        return myTurtle;
    }
    
    /**
     * paints all RoomObjects in this room.
     */
    public void paint(Graphics2D pen) {
        myTurtle.setState(myStatus);
        myTurtle.paint(pen);
        myStatus = myTurtle.getState();
    }
}
