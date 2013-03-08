package model;

import java.awt.Dimension; 
import java.awt.Graphics2D;
import util.Location;
import util.Pixmap;
import util.Sprite; 
import util.Vector;
import model.BasicRoomObject;

/**
 * interface for movable characters/actors
 * @author mp
 *
 */
public abstract class BasicMoveable extends BasicRoomObject implements IMoveable{

    
  //Moveable's pen 
    private boolean myPenDown = true; 
    
    //is it on the screen/visible
    private boolean myVisibility = false; 
    
    //frame default sizes (as of now)--will remove/replace 
    private static final int DEFAULT_FRAME_TOP = 250; 
    private static final int DEFAULT_FRAME_BOTTOM = -250; 
    private static final int DEFAULT_FRAME_RIGHT = 350; 
    private static final int DEFAULT_FRAME_LEFT = -350; 
    
    //Moveable's location, magnitude (initialized) and angle/head direction
    private double myHeading;
    private static double myMagnitude = 0; 
    
    public BasicMoveable (Pixmap image, Location center, Dimension size, double angle) { 
        super(image, center, size, new Vector(angle, myMagnitude)); 
        myHeading = angle; 
    }
    /**
     * moves forward the given distance (negative numbers move backwards)
     * @param dist
     */
    @Override
    public double moveForward(double dist) {
        getCurrentLocation().translate(new Vector(myHeading, dist));
        return dist;
    }
    
    /**
     * turns right the specified number of degrees (negative value is a left turn)
     * @param degrees
     */
    @Override
    public double turnRight(double degrees) {
        myHeading += degrees;
        return degrees;
    }
    
    /**
     * moves the actor/object to the specified absolute coordinates
     * @param xCoord
     * @param yCoord
     */
    @Override
    public double jumpMove(double xCoord, double yCoord) {
        Location newLoc = new Location(xCoord, yCoord);
        double dist = getCurrentLocation().difference(newLoc).getMagnitude();
        setCurrentLocation(new Location(xCoord, yCoord));
        return dist;
    }
    
    /**
     * re-orients the actor/object to the specified absolute degrees
     * @param degrees
     */
    @Override
    public double jumpTurn(double degrees) {
        double difference = degrees - myHeading;
        myHeading = degrees;
        return difference;
    }
    
    /**
     * returns this moveable object's heading
     * @return heading
     */
    @Override
    public double getHeading() {
         return myHeading;
    }
    
    /**
     * returns the state of this object's pen trail.
     * true - the pen is down, and a trail will be drawn when the object moves
     * false - the pen is up, no trail will be drawn
     * @return myPenDown
     */
    @Override
    public boolean getPenStatus() { 
        return myPenDown; 
    }
    
    /**
     * set's this moveable object's pen status. true = pen down. false = pen up
     * @param bool
     */
    @Override
    public int setPenStatus(boolean bool) {
        myPenDown = bool;
        if (bool) {
            return 1;
        }
        return 0;
    }

}
