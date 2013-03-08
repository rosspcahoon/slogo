package model;

import java.awt.Graphics2D;

/**
 * Interface for renderable objects. Renderables have an object that holds 
 * their current state, and a paint method.
 * @author mp
 *
 */
public interface Renderable {

    /**
     * returns the current state of the Renderable object
     * @return state-holding object
     */
    public Object getState();

    /**
     * paints everything in the Renderable object
     */
    public void paint(Graphics2D pen);
}

