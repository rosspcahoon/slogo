package model;

/**
 * Interface for objects in a room.
 * @author james, mp
 *
 */
public interface RoomObject {

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
    
}
