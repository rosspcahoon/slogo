package model;

import java.awt.Graphics2D;
import java.util.Observable;
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

    /**
     * Constructor
     * @param id
     */
    public Room (int id) {
        myID = id;
        myTurtle = new Actor(0);
        myTurtle.setPenColor(0);
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
    public double returnHome () { 
        double distance = myTurtle.returnHome(); 
        return distance;
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
    
    /**
     * clears the lines and moves the actor back to its initial location
     * @return dist - distance moved
     */
    public double clear() {
        double dist = returnHome();
        myTurtle.clearLines();
        return dist;
    }
}
