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
     * turns right the specified number of degrees (negative value is a left turn)
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
    public void jumpTurn(double degrees);
    
    /**
     * returns this moveable object's x coordinate
     * @return x Coordinate
     */
    public double getXCoord();
    
    /**
     * returns this moveable object's y coordinate
     * @return y Coordinate
     */
    public double getYCoord();
    
    /**
     * returns this moveable object's heading
     * @return heading
     */
    public double getHeading();
    
    /**
     * returns the state of this object's pen trail.
     * true - the pen is down, and a trail will be drawn when the object moves
     * false - the pen is up, no trail will be drawn
     * @return
     */
    public boolean penDownStatus();
    
    /**
     * set's this moveable object's pen status. true = pen down. false = pen up
     * @param bool
     */
    public void setPenStatus(boolean bool);

}
