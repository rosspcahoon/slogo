package model;

import java.awt.Dimension;
import java.util.Observable;
import util.Location;
import util.Pixmap;
import util.Sprite; 
import util.Vector;

/**
 * Abstract class for objects in a room. Basic functionality for a "turtle" actor
 * @author james, mp
 *
 */
public abstract class Doodad extends Sprite implements IRoomObject {

    
    private Location myCurrentLocation;  
    private Location myOldLocation = null; 
    private Location myInitialLocation; 
    private boolean myVisibility;
    private boolean myPenStatus;
     
    
    /**
     * Constructor
     * @param image
     * @param center
     * @param size
     */
    public Doodad (Pixmap image, Location center, Dimension size) {
         super(image, center, size);
         myCurrentLocation = center;
         myInitialLocation = center; 
     }
    
    /**
     * Constructor
     * @param image
     * @param center
     * @param size
     * @param vector
     */
    public Doodad (Pixmap image, Location center, Dimension size, Vector vector) { 
        super (image, center, size, vector); 
        myCurrentLocation = center;
        myInitialLocation = center; 
    }
     
    /**
     * setter for this room object's current location
     * @param location Location object
     */
    public void setCurrentLocation (Location location) { 
        myOldLocation = myCurrentLocation;
        myCurrentLocation = location; 
    }
    
    @Override
    public Location getCurrentLocation () { 
        return myCurrentLocation; 
    }
    
    /**
     * getter for this room object's previous location.
     * @return myOldLocation Location object
     */
    public Location getOldLocation () { 
        return myOldLocation; 
    }
    
    
    /**
     * getter for this room object's initial location (point of initialization)
     * @return myIntialLocation Location object
     */
    public Location getInitialLocation () { 
        return myInitialLocation; 
    }
    
    /**
     * updates the current and previous locations (presumably after the object
     * changes position).
     */
    public void updateLocations () { 
        myOldLocation = myCurrentLocation; 
        myCurrentLocation = new Location (super.getCenter ());
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
    
}
