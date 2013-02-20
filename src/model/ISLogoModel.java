package model;

public interface ISLogoModel {

    /**
     * Process the string provided and take the necessary steps.
     * TODO: 
     * @param s
     * @return
     */
    public boolean process (String s);
    
    /**
     * TODO: consider better name, responsible for painting model elements
     * @return
     */
    public boolean display();
}
