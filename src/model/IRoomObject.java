package model;

import util.Location;

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
    
    public Location getCurrentLocation ();

}
