package model;

import util.Location;
import util.Vector;

/**
 * interface for room objects. Room objects have a location and a visibility
 * state
 * @author mp
 *
 */
public interface IRoomObject {
    
    /**
     * sets this object's show status.
     * true = object will show
     * false = object will not show
     * @param bool
     */
    public void setVisibilityStatus(boolean bool);
    
    
    /**
     * gets this object's visibility status
     * @return boolean true = showing false = not showing
     */
    public boolean getVisibilityStatus();
    
    /**
     * return this object's current Location
     * @return current location Location object
     */
    public Location getCurrentLocation ();
    
    /**
     * return this moveable object's heading
     * @return heading
     */
    public double getHeading();

}
