package model;

/**
 * interface for movable characters/actors
 * @author mp
 *
 */
public interface Moveable extends RoomObject {

    /**
     * moves forward the given distance (negative numbers move backwards)
     * @param dist
     */
    public void moveForward(double dist);
    
    /**
     * turns right the specified number of degrees
     * @param degrees
     */
    public void turnRight(double degrees);
    
    /**
     * moves the actor/object to the specified absolute coordinates
     * @param xCoord
     * @param yCoord
     */
    public void jumpMove(double xCoord, double yCoord);
    
    /**
     * re-orients the actor/object to the specified absolute degrees
     * @param degrees
     */
    public void jumpturn(double degrees);

}
