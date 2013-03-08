package model;

import java.awt.Dimension;
import java.util.Observable;
import util.Location;
import util.Pixmap;
import util.Sprite; 
import util.Vector;

/**
 * Interface for objects in a room.
 * @author james, mp
 *
 */
public abstract class BasicRoomObject extends Sprite implements IRoomObject {

    
    private Location myCurrentLocation;  
    private Location myOldLocation = null; 
    private Location myInitialLocation; 
    private boolean myVisibility;
    private boolean myPenStatus;
     
    public BasicRoomObject (Pixmap image, Location center, Dimension size) {
         super(image, center, size);
         myCurrentLocation = center;
         myInitialLocation = center; 
     }
    
    public BasicRoomObject (Pixmap image, Location center, Dimension size, Vector vector) { 
        super (image, center, size, vector); 
    }
     
    public void setCurrentLocation (Location location) { 
        myOldLocation = myCurrentLocation;
        myCurrentLocation = location; 
    }
    
    @Override
    public Location getCurrentLocation () { 
        return myCurrentLocation; 
    }
    
    public Location getOldLocation () { 
        return myOldLocation; 
    }
    
    public void setInitialLocation (Location location ) { 
        myInitialLocation = location; 
    }
    
    public Location getInitialLocation () { 
        return myInitialLocation; 
    }
    
    public void updateLocations () { 
        myOldLocation = myCurrentLocation; 
        myCurrentLocation = new Location (super.getCenter ());
    }
    
    public void returnHome () { 
        super.setCenter(myInitialLocation); 
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
