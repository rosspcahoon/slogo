package model;

import java.awt.Dimension;
import util.Location;
import util.Pixmap;
import util.Sprite;
import util.Vector;
import java.util.Observable; 
import java.util.Observer; 
import java.awt.Graphics2D;
import model.PenTrail;

/**
 * "Turtle" actor in slogo display. Turtles are moveable objects that can 
 * be moved, rotated, draw trails, and be set to show or be invisible.
 * @author mp, tv
 *
 */

public class Turtle extends BasicMoveable implements Renderable {

    // need turtle image
    private static final Pixmap DEFAULT_TURTLE_IMAGE = new Pixmap("turtle.png");
    private static final Dimension DEFAULT_TURTLE_SIZE = new Dimension (20,20); 
    private static Location myInitialLocation = new Location(350,250); 
    private static double myInitialAngle = 90; 
    
    
    public Turtle () { 
        super (DEFAULT_TURTLE_IMAGE, myInitialLocation, DEFAULT_TURTLE_SIZE, myInitialAngle); 
    }
    
    /**
     * Draws line from old location to current location.
     * Should be called after location have been updated.
     * @param pen
     */
    public void drawLine (Graphics2D pen) { 
        
        
        PenTrail penTrail = new PenTrail (super.getOldLocation().getX(), super.getCurrentLocation().getX(),
                                          super.getOldLocation().getY(), super.getCurrentLocation().getY()); 
        if (getPenStatus()) { 
            penTrail.drawLine(pen); 
        }
    }
    
    public void updateStatus(Status stat) {
        stat.setMyHeading(getHeading());
        stat.setMyCoords(getCurrentLocation());
    }
    
    public Object getState() {
        return null;
    }
    
    public void paint(Graphics2D pen) {
        drawLine(pen);
        super.paint(pen);
    }
    
    
    
    
}
