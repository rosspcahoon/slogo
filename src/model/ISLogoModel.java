package model;


public interface ISLogoModel {

    /**
     * Process the string provided and take the necessary steps.
     * TODO: 
     * @param s
     * @return
     */
    abstract boolean processCommand (Room r, String s);
    
}
