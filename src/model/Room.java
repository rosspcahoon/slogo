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

    public void penOnOff () { 
        myTurtle.togglePen(); 
        myTurtlePenStatus = myTurtle.getPenStatus(); 
    }

    public boolean getPenStatus () { 
        return myTurtlePenStatus; 
    }

    public void visibilityOnOff () { 
        myTurtle.toggleVisibility(); 
        myTurtleVisibility = myTurtle.getVisibility(); 
    }

    public boolean getVisibility () { 
        return myTurtle.getVisibility(); 
    }

    public Location getCurrentLocation () { 
        return myTurtle.getCurrentLocation(); 
    }
    
    public Location getOldLocation () { 
        return myTurtle.getOldLocation(); 
    }

    public double getHeadDirection () { 
        return myTurtle.getHeadDirection(); 
    }

    public void rotateMoveable (double angle) { 
        myTurtle.rotate(angle);

    }

    public void moveMovable (double distance) { 
        myTurtle.move(distance); 
    }

    public void returnHome () { 
        myTurtle.returnHome(); 
    }

    public Status getState() {
        return myStatus;
    }

    //has Movable object draw a line where it goes
    public void drawLine (Graphics2D pen) {
        myTurtle.drawLine(pen); 
    }
    
    public void update() { 
        myTurtlePenStatus = getPenStatus (); 
        myTurtleLocation = getCurrentLocation ();
        myTurtleHead = getHeadDirection (); 
        myTurtleVisibility = getVisibility ();    
    }

    public void paint (Graphics2D pen) {
        myTurtle.paint(pen); 
    }
}
