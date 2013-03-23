package model;

import java.awt.Dimension;
import java.util.List;
import java.util.ArrayList;
import java.awt.Graphics2D;
import java.awt.Color;
import static java.lang.Math.*;
import util.Location;
import util.Pixmap;
import util.Vector;

/**
 * Class for basic moveable characters/actors. Gives objects access to
 * environment bounds, and basic methods for movement (relative movement and 
 * absolute movement methods included for spacial movement and rotation).
 * @author mp
 *
 */
public class Actor extends Doodad implements Renderable, IMoveable {

    //frame default sizes (as of now)--will remove/replace 
    private static final int DEFAULT_FRAME_TOP = 0; 
    private static final int DEFAULT_FRAME_BOTTOM = 600; 
    private static final int DEFAULT_FRAME_RIGHT = 875; 
    private static final int DEFAULT_FRAME_LEFT = 0; 
    // need turtle image
    private static final Pixmap DEFAULT_TURTLE_IMAGE = new Pixmap("turtle1.png");
    private static final Dimension DEFAULT_TURTLE_SIZE = new Dimension (20,20); 
    private static Location myInitialLocation = new Location(451, 300); 
    private static double myInitialAngle = 0; 
    private static double myMagnitude = 0; 
    
    //Moveable's line trail 
    private boolean myPenDown = true; 
    private List<PenTrail> myTrail;
    private float myPenThickness;
    private float myDashWidth;
    private boolean myDoubleLineOn;
    
    private int myFrameTop;
    private int myFrameBottom;
    private int myFrameRight;
    private int myFrameLeft;
    
    //is it on the screen/visible
    private boolean myVisibility = false; 
    
    private Status myStatus;
    //Moveable's location, magnitude (initialized) and angle/head direction
    private double myHeading;
    private Color myPenColor;

    
    /**
     * Constructor
     */
    public Actor (double angle) { 
        this(DEFAULT_TURTLE_IMAGE, myInitialLocation, DEFAULT_TURTLE_SIZE, angle);       
    }
    
    public Actor (Pixmap image, Location center, Dimension size, double angle) {
        super(image, center, size, angle);  
        myTrail = new ArrayList<PenTrail>();
        myFrameTop = DEFAULT_FRAME_TOP;
        myFrameBottom = DEFAULT_FRAME_BOTTOM;
        myFrameRight = DEFAULT_FRAME_RIGHT;
        myFrameLeft = DEFAULT_FRAME_LEFT;
        myPenThickness = (float)2.0;
        myDashWidth = (float)4.0;
        myDoubleLineOn = true;
    }
    
    /**
     * Draws line from old location to current location.
     * Should be called after location have been updated.
     * @param pen
     */
    public void makeLine () { 
        PenTrail.makeLine(super.getOldLocation().getX(), super.getCurrentLocation().getX(),
                          super.getOldLocation().getY(), super.getCurrentLocation().getY(), 
                          myPenDown, myPenThickness, myDashWidth, myDoubleLineOn, myTrail); 
    }
    
    public void addLine(PenTrail trail) {
        myTrail.add(trail);
    }
    
    /**
     * updates the Status object that is associated with this turtle object.
     * @param stat
     */
    public void updateStatus(Status stat) {
        stat.setMyHeading(getHeading());
        if(getCurrentLocation()!= null) {
            stat.setMyCoords(getCurrentLocation());
        }
    }
    
    /**
     * setter for myStatus Status object
     * @param state
     */
    public void setState(Status state) {
        myStatus = state;
    }
    
    /**
     * getter for myStatus Status object
     */
    public Status getState() {
        return myStatus;
    }
    
    /**
     * updates myStatus to the turtle's current state, and paints the turtle.
     */
    public void paint(Graphics2D pen) {
        updateStatus(myStatus);
        pen.setColor(myPenColor);
        super.paint(pen);
        for(PenTrail penT: myTrail) {
            penT.drawLine(pen);
        }
    }
    
    /**
     * sets myPenColor which will be used by the pen that paints this Actor
     * @param i index of penColors in PenConstants
     */
    public void setPenColor(int i) {
        myPenColor = PenConstants.penColors.get(i);
    }
    
    
    /**
     * moves forward the given distance (negative numbers move backwards)
     * @param dist
     */
    @Override
    public double moveForward(double dist) {
        Location currentLoc = getCurrentLocation();
  //      updateOldLocation();
        Vector moveVector = wrapAround(dist);
        currentLoc.translate(moveVector);
        makeLine();
        return dist;
    }
    
    /**
     * turns right the specified number of degrees (negative value is a left turn)
     * @param degrees
     */
    @Override
    public double turnRight(double degrees) {
        getHeadingVector().turn(-degrees);
        return degrees;
    }
    
    /**
     * moves the actor/object to the specified absolute coordinates
     * @param xCoord
     * @param yCoord
     */
    @Override
    public double jumpMove(double xCoord, double yCoord) {
        Location newLoc = new Location(xCoord, yCoord);
        double dist = getCurrentLocation().difference(newLoc).getMagnitude();
        setCurrentLocation(new Location(xCoord, yCoord));
        return dist;
    }
    
    /**
     * re-orient the actor/object to face the input coordinates
     * @param xCoord
     * @param yCoord
     * @return
     */
    public double jumpTurn(double xCoord, double yCoord) {
        double xDiff = getCurrentLocation().getX() - xCoord;
        double yDiff = getCurrentLocation().getY() - yCoord;
        double angle = tan(yDiff / xDiff);
        return turnRight(angle);
    }
    
    /**
     * re-orients the actor/object to the specified absolute degrees
     * @param degrees
     */
    @Override
    public double jumpTurn(double degrees) {
        double difference = degrees - getHeading();
        setHeading(degrees);
        return difference;
    }
    
    /**
     * returns the state of this object's pen trail.
     * true - the pen is down, and a trail will be drawn when the object moves
     * false - the pen is up, no trail will be drawn
     * @return myPenDown
     */
    @Override
    public boolean getPenStatus() { 
        return myPenDown; 
    }
    
    /**
     * set's this moveable object's pen status. true = pen down. false = pen up
     * @param bool
     */
    @Override
    public int setPenStatus(boolean bool) {
        myPenDown = bool;
        if (bool) {
            return 1;
        }
        return 0;
    }
    
    /**
     * clears the lines held in myTrail
     */
    public void clearLines() {
        myTrail.clear();
    }
    
    /**
     * check for x coordinate wraparound. returns the distance to move in the x
     * coordinate after the wraparound is done.
     * @param xLoc
     * @return distance to move after wrap
     */
    public double checkX(double xLoc) {
        updateOldLocation();
        if(xLoc < myFrameLeft) {
            setCurrentLocation(new Location(myFrameLeft, getCurrentLocation().getY()));
            makeLine();
            updateOldLocation();
            setCurrentLocation(new Location(myFrameRight, getCurrentLocation().getY()));
            setOldLocation(new Location(myFrameRight, getCurrentLocation().getY()));
            return xLoc - myFrameLeft;
        }
        if(xLoc > myFrameRight) {
            setCurrentLocation(new Location(myFrameRight, getCurrentLocation().getY()));
            makeLine();
            updateOldLocation();
            setCurrentLocation(new Location(myFrameLeft, getCurrentLocation().getY()));
            setOldLocation(new Location(myFrameLeft, getCurrentLocation().getY()));
            return myFrameRight - xLoc;
        }
        return getCurrentLocation().getX() - xLoc;
    }
    
    /**
     * check for y coordinate wraparound. returns the distance to move in the y
     * coordinate after the wraparound is done.
     * @param yLoc
     * @return distance to move after wrap
     */
    public double checkY(double yLoc) {
        updateOldLocation();
        if(yLoc < myFrameTop) {
            setCurrentLocation(new Location(getCurrentLocation().getX(), myFrameTop));
            makeLine();
            updateOldLocation();
            setCurrentLocation(new Location(getCurrentLocation().getX(), myFrameBottom));
            setOldLocation(new Location(getCurrentLocation().getX(), myFrameBottom));
            return yLoc - myFrameTop;
        }
        if(yLoc > myFrameBottom - 100) {
            setCurrentLocation(new Location(getCurrentLocation().getX(), myFrameBottom));
            makeLine();
            updateOldLocation();
            setCurrentLocation(new Location(getCurrentLocation().getX(), myFrameTop));
            setOldLocation(new Location(getCurrentLocation().getX(), myFrameTop));
            return myFrameBottom - yLoc;
        }
        return getCurrentLocation().getY() - yLoc;
    }
    
    public Vector wrapAround(double distMove) {
        Vector vec = new Vector(getHeading(), distMove);
        double deltaX = vec.getXChange();
        double deltaY = vec.getYChange();
        double currentX = getCurrentLocation().getX();
        double currentY = getCurrentLocation().getY();
        double excessX = checkX(deltaX + currentX);
        double excessY = checkY(deltaY + currentY);
        Vector moveVector = new Vector(new Location(excessX, 0), new Location(0, excessY));
        return moveVector;
    }
    
}
