package model;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
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
    private Map<String, Integer> myUserVariables;
    private Map<String, List<String>> myUserCommands;

    /**
     * Constructor
     */
    public Status() {
        myErrorMessage = "";
        myXCoord = 0;
        myYCoord = 0;
        myHeading = 0;
        myUserVariables = new HashMap<String, Integer>();
        myUserCommands = new HashMap<String, List<String>>();
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
    
    /**
     * adds a user variable the the user variable list
     * @param name
     * @param i
     */
    public void addVariable(String name, Integer i) {
        myUserVariables.put(name,i);
    }
    
    /**
     * adds a user-defined command to the user command list
     */
    public void addCommandName(String name, List<String> params) {
        myUserCommands.put(name, params);
    }
    
    /**
     * returns the user variables held in this status object
     * @return myUserVariables
     */
    public Map<String, Integer> getVariableMap() {
        return myUserVariables;
    }
    
    public Map<String, List<String>> getUserCommands() {
        return myUserCommands;
    }



}
