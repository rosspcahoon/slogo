package model;

import util.Location;


/**
 * Holds information on the turtle and error message.
 * @author mp
 *
 */
public class Status {
    private String myErrorMessage;
    private double myXCoord;
    private double myYCoord;
    private double myHeading;

    /**
     * Constructor
     */
    public Status() {
        myErrorMessage = "";
        myXCoord = 0;
        myYCoord = 0;
        myHeading = 0;
    }
    
    /**
     * getter for myErrorMessage
     * @return myErrorMessage
     */
    public String getErrorMessage () {
        return myErrorMessage;
    }

    /**
     * setter for myErrorMessage
     * @param errorMessage string
     */
    public void setErrorMessage (String errorMessage) {
        this.myErrorMessage = errorMessage;
    }

    /**
     * getter for myXCoord
     * @return myXCoord
     */
    public double getMyXCoord () {
        return myXCoord;
    }

    /**
     * setter for myXCoord
     * @param xCoord coordinate
     */
    public void setMyXCoord (double xCoord) {
        this.myXCoord = xCoord;
    }

    /**
     * getter for myYCoord
     * @return myYCoord
     */
    public double getMyYCoord () {
        return myYCoord;
    }

    /**
     * setter for myYCoord
     * @param yCoord coordinate
     */
    public void setMyYCoord (double yCoord) {
        this.myYCoord = yCoord;
    }
    
    /**
     * sets the status's coordinates using a location object
     * @param loc
     */
    public void setMyCoords(Location loc) {
        myXCoord = loc.getX();
        myYCoord = loc.getY();
    }

    /**
     * getter for myHeading
     * @return myHeading
     */
    public double getMyHeading () {
        return myHeading;
    }

    /**
     * setter for myHeading
     * @param heading 
     */
    public void setMyHeading (double heading) {
        myHeading = heading;
    }



}
