package model;

import java.awt.Dimension; 
import java.util.Observable;
import util.Location;
import util.Pixmap;
import util.Sprite; 
import util.Vector;
import java.awt.Graphics2D;

/**
 * Abstract class for objects in a room. Basic functionality for a "turtle" actor
 * @author james, mp
 *
 */
public abstract class Doodad extends Sprite implements IRoomObject {

    
    private Location myCurrentLocation;  
    private Location myOldLocation; 
    private Location myInitialLocation; 
    private boolean myVisibility;
    private boolean myPenStatus;
    private Vector myHeading;
     
    
    /**
     * Constructor
     * @param image
     * @param center
     * @param size
     */
    public Doodad (Pixmap image, Location center, Dimension size) {
         super(image, center, size);
         myCurrentLocation = center;
         myOldLocation = center;
         myInitialLocation = center; 
         myHeading = new Vector(0, 0);
     }
    
    /**
     * Constructor
     * @param image
     * @param center
     * @param size
     * @param vector
     */
    public Doodad (Pixmap image, Location center, Dimension size, double heading) { 
        this(image,center,size);
        myHeading = new Vector(heading, 0);
    }
     
    /**
     * setter for this room object's current location
     * @param location Location object
     */
    public void setCurrentLocation (Location location) { 
//        System.out.println(myCurrentLocation);
//        System.out.println(myOldLocation);
        myCurrentLocation = location; 
    }
    
    @Override
    public Location getCurrentLocation () { 
        return myCurrentLocation; 
    }
    
    /**
     * sets the heading of this object
     * @param heading
     */
    public void setHeading(double heading) {
        myHeading.setDirection(heading);
    }
    
    /**
     * return the heading of this object
     * @return myHeading
     */
    @Override
    public double getHeading() {
        return myHeading.getDirection();
    }
    
    /**
     * getter for this room object's previous location.
     * @return myOldLocation Location object
     */
    public Location getOldLocation () { 
        return myOldLocation; 
    }
    
    public void setOldLocation(Location loc) {
        myOldLocation = loc;
        System.out.println(myOldLocation);
        System.out.println(myCurrentLocation);
    }
    
    /**
     * getter for this room object's initial location (point of initialization)
     * @return myIntialLocation Location object
     */
    public Location getInitialLocation () { 
        return myInitialLocation; 
    }
    
    /**
     * updates the old location with the current Location (generally used before
     * the object is moved)
     */
    public void updateOldLocation () { 
        Location temp = new Location(myCurrentLocation);
        myOldLocation = temp; 
    }
    
    /**
     * returns the object to the position it was initialized at.
     */
    public double returnHome () { 
        double distanceMoved = distance(myInitialLocation);
        super.setCenter(myInitialLocation); 
        return distanceMoved;
    }
    
    /**
     * sets this object's show status.
     * true = object will show
     * false = object will not show
     * @param bool
     */
    @Override
    public void setVisibilityStatus(boolean bool) {
        myVisibility = bool;
    }
    
    /**
     * gets this object's visibility status
     * @return boolean true = showing false = not showing
     */
    @Override
    public boolean getVisibilityStatus() {
        return myVisibility; 
    }
    
    public void paint(Graphics2D pen) {
        super.setCenter(myCurrentLocation);
        super.paint(pen, myHeading.getDirection());
    }
    
    public Vector getHeadingVector() {
        return myHeading;
    }
    
}
