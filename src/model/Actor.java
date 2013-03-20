package model;

import java.awt.Dimension;
import util.Location;
import util.Pixmap;
import util.Sprite;
import util.Vector;
import java.util.Observable; 
import java.util.Observer; 
import java.awt.Graphics2D;
import model.PenTrail;
import model.Doodad;

/**
 * Class for basic moveable characters/actors. Gives objects access to
 * environment bounds, and basic methods for movement (relative movement and 
 * absolute movement methods included for spacial movement and rotation).
 * @author mp
 *
 */
public class Actor extends Doodad implements Renderable, IMoveable {

    //frame default sizes (as of now)--will remove/replace 
    private static final int DEFAULT_FRAME_TOP = 250; 
    private static final int DEFAULT_FRAME_BOTTOM = -250; 
    private static final int DEFAULT_FRAME_RIGHT = 350; 
    private static final int DEFAULT_FRAME_LEFT = -350; 
    // need turtle image
    private static final Pixmap DEFAULT_TURTLE_IMAGE = new Pixmap("turtle1.png");
    private static final Dimension DEFAULT_TURTLE_SIZE = new Dimension (20,20); 
    private static Location myInitialLocation = new Location(350,250); 
    private static double myInitialAngle = 0; 
    //Moveable's pen 
    private boolean myPenDown = true; 
    
    //is it on the screen/visible
    private boolean myVisibility = false; 
    
    private Status myStatus;
    //Moveable's location, magnitude (initialized) and angle/head direction
    private double myHeading;
    private static double myMagnitude = 0; 
    
    /**
     * Constructor
     */
    public Actor (double angle) { 
        super (DEFAULT_TURTLE_IMAGE, myInitialLocation, DEFAULT_TURTLE_SIZE); 
        myHeading = angle;
    }
    
    public Actor (Pixmap image, Location center, Dimension size, double angle) {
        super(image, center, size, new Vector(angle, myMagnitude)); 
        myHeading = angle; 
    }
    
    /**
     * Draws line from old location to current location.
     * Should be called after location have been updated.
     * @param pen
     */
    public void drawLine (Graphics2D pen) { 
        
        
        PenTrail penTrail = new PenTrail (super.getOldLocation().getX(), super.getCurrentLocation().getX(),
                                          super.getOldLocation().getY(), super.getCurrentLocation().getY()); 
        if (getPenStatus()) { 
            penTrail.drawLine(pen); 
        }
    }
    
    /**
     * updates the Status object that is associated with this turtle object.
     * @param stat
     */
    public void updateStatus(Status stat) {
        stat.setMyHeading(getHeading());
        if(getCurrentLocation()!= null) {
            stat.setMyCoords(getCurrentLocation());
        }
    }
    
    /**
     * setter for myStatus Status object
     * @param state
     */
    public void setState(Status state) {
        myStatus = state;
    }
    
    /**
     * getter for myStatus Status object
     */
    public Status getState() {
        return myStatus;
    }
    
    /**
     * updates myStatus to the turtle's current state, and paints the turtle.
     */
    public void paint(Graphics2D pen) {
        updateStatus(myStatus);
        super.paint(pen);
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
