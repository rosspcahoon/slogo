package model;

import java.awt.Dimension;
import util.Location;
import util.Pixmap;
import util.Sprite;
import util.Vector;
import java.util.Observable; 
import java.util.Observer; 
import java.awt.Graphics2D;

/**
 * "Turtle" actor in slogo display. Turtles are moveable objects that can 
 * be moved, rotated, draw trails, and be set to show or be invisible.
 * @author mp, tv
 *
 */
public class Turtle extends Sprite implements Moveable {
        
    //frame default sizes (as of now) 
    private static final int DEFAULT_FRAME_TOP = 250; 
    private static final int DEFAULT_FRAME_BOTTOM = -250; 
    private static final int DEFAULT_FRAME_RIGHT = 350; 
    private static final int DEFAULT_FRAME_LEFT = -350; 
    private static final double initialAngle = 90; 
    
    // need turtle image
    private static final Pixmap DEFAULT_TURTLE_IMAGE = new Pixmap ("turtle.png");
    private static final Dimension DEFAULT_TURTLE_SIZE = new Dimension (20, 20); 
    private static final Location initialLocation = new Location (350, 250); 

    //turtle's head (angle) in degrees 
    private double myHeading; 
    
    private Location myOldLocation; 
    private Location myCurrentLocation; 
    
    //turtle's pen 
    private boolean myPenDown; 
    
    //is it on the screen/visible
    private boolean myVisibility; 
    

    /**
     * Constructor
     */
    public Turtle () { 
        super(DEFAULT_TURTLE_IMAGE, initialLocation, DEFAULT_TURTLE_SIZE); 
        myOldLocation = null; 
        myCurrentLocation = initialLocation; 
        myHeading = initialAngle; 
        myPenDown = true;
        myVisibility = true;
    }
 
    
    public void setLocations () { 
        myOldLocation = myCurrentLocation; 
        myCurrentLocation = new Location (super.getCenter());
    }
    
    public Location getOldLocation() { 
        return myOldLocation; 
    }
    
    @Override
    public double getXCoord() {
        return myCurrentLocation.getX();
    }
    
    @Override
    public double getYCoord() {
        return myCurrentLocation.getY();
    }
    
    
    public Location getCurrentLocation () { 
        return myCurrentLocation; 
    }
    
    @Override
    public double getHeading() { 
        return myHeading; 
    }
    
    @Override
    public boolean penDownStatus () { 
        return myPenDown; 
    }
    
    @Override
    public void setPenStatus (boolean bool) { 
        myPenDown = bool;
    }
    
    @Override
    public boolean getVisibilityStatus () { 
        return myVisibility; 
    }
    
    @Override
    public void setVisibilityStatus(boolean bool){
        myVisibility = bool;
    }
    
    // rotates turtle by specified angle (in degrees) 
    public void rotate(Graphics2D pen, double angle) { 
        myHeading += angle; 
        super.getView().paint(pen, super.getCenter(), DEFAULT_TURTLE_SIZE, angle); 
    }
    
    public void wrapAround () { 
        if (super.getBottom() > DEFAULT_FRAME_TOP) { 
            super.setCenter(super.getX(), DEFAULT_FRAME_BOTTOM - (super.getHeight() / 2)); 
        }
        if (super.getTop() < DEFAULT_FRAME_BOTTOM) { 
            super.setCenter(super.getX(), DEFAULT_FRAME_TOP + (super.getHeight() / 2)); 
        }
        if (super.getLeft() > DEFAULT_FRAME_RIGHT) { 
            super.setCenter(DEFAULT_FRAME_LEFT - (super.getWidth() / 2), super.getY()); 
        }
        if (super.getRight() < DEFAULT_FRAME_LEFT) { 
            super.setCenter(DEFAULT_FRAME_RIGHT + (super.getWidth() / 2), super.getY()); 
        }
    } 
    
    /**
     * returns this turtle to the position it was created at
     */
    public void returnHome () { 
        super.setCenter(initialLocation); 
    }

    
    //TO-DO
    public void addObserver (Object o) { 
        
    }
    
    //TO-DO
    public void setChanged () { 
        
    }
    
    //TO_DO
    public boolean hasChanged () { 
        return true; 
    }

    @Override
    public void moveForward (double dist) {
        myCurrentLocation.translate(new Vector(myHeading, dist));
        
    }

    @Override
    public void turnRight (double degrees) {
        myHeading += degrees;
        
    }

    @Override
    public void jumpMove (double xCoord, double yCoord) {
        myCurrentLocation = new Location(xCoord, yCoord);
        
    }

    @Override
    public void jumpTurn (double degrees) {
        myHeading = degrees;
        
    }
}
