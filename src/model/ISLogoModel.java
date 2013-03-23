package model;


/**
 * interface for Slogo models. models control the workflow used to process 
 * commands
 * @author mp
 *
 */
public interface ISLogoModel {

    /**
     * Process the string provided and take the necessary steps.
     * TODO: 
     * @param s
     * @return
     */
    abstract int processCommand (Room r, String s);
    
}
