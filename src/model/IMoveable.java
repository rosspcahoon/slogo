package model;

/**
 * Interface for moveable objects. moveable objects can move in space, or rotate.
 * movements can be in relative or absolute quantities.
 * @author mp
 *
 */
public interface IMoveable {
    
    /**
     * moves the object to the specified coordinates
     * @param xCoord
     * @param yCoord
     * @return distance moved
     */
    public double jumpMove(double xCoord, double yCoord);
    
    /**
     * rotates the object to the input absolute degrees
     * @param degrees
     * @return degrees rotated
     */
    public double jumpTurn(double degrees);
    
    /**
     * sets the pen status (up/down) of this moveable object
     * @param bool
     * @return 0 for up 1 for down
     */
    public int setPenStatus(boolean bool);
    
    /**
     * returns the pen's status
     * @return 0 - up /// 1 - down
     */
    public boolean getPenStatus();
    
    /**
     * return this moveable object's heading
     * @return heading
     */
    public double getHeading();
    
    /**
     * turns right the input degrees (negative is a left turn)
     * @param degrees
     * @return degrees turned
     */
    public double turnRight(double degrees);
    
    /**
     * moves this moveable object forward the input number of pixels
     * @param dist
     * @return distance moved
     */
    public double moveForward(double dist);

}
