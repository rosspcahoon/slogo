package model;

public interface IMoveable {
    
    public double jumpMove(double xCoord, double yCoord);
    
    public double jumpTurn(double degrees);
    
    public int setPenStatus(boolean bool);
    
    public boolean getPenStatus();
    
    public double getHeading();
    
    public double turnRight(double degrees);
    
    public double moveForward(double dist);

}
