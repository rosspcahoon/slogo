/**
 * 
 */
package view;

/**
 * @author Dagbedji Fagnisse
 *
 */
public interface ISLogoView {
    
    /**
     * Update the view to display an error message
     * @param e
     * @return
     */
    public boolean update(Error e);
    
    /**
     * Update based on the model provided at instantiation (?)
     * @return
     */
    public boolean update();
    
}
