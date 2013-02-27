package model;

import java.awt.Graphics2D;

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
