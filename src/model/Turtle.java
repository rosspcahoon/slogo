package model;

import java.awt.Dimension;
import util.Location;
import util.Pixmap;
import util.Sprite;
import util.Vector;
import java.util.Observable; 
import java.util.Observer; 
import java.awt.Graphics2D;

public class Turtle extends Sprite implements Moveable {
    
    //turtle's head (angle) in degrees 
    private double myHead; 
    
    private Location myOldLocation; 
    private Location myCurrentLocation; 
    
    //turtle's pen 
    private boolean myPenUp = false; 
    
    //is it on the screen/visible
    private boolean myVisibility = false; 
    
    //frame default sizes (as of now) 
    private static final int DEFAULT_FRAME_TOP = 250; 
    private static final int DEFAULT_FRAME_BOTTOM = -250; 
    private static final int DEFAULT_FRAME_RIGHT = 350; 
    private static final int DEFAULT_FRAME_LEFT = -350; 
    
    // need turtle image
    private static final Pixmap DEFAULT_TURTLE_IMAGE = new Pixmap("turtle.png");
    private static final Dimension DEFAULT_TURTLE_SIZE = new Dimension (20,20); 
    private static Location initialLocation = new Location(350,250); 
    private static double initialAngle = 90; 
    
    public Turtle () { 
        super(DEFAULT_TURTLE_IMAGE, initialLocation, DEFAULT_TURTLE_SIZE); 
        myOldLocation = null; 
        myCurrentLocation = initialLocation; 
        myHead = initialAngle; 
    }
 
    public void move (double distance) { 
        super.translate(new Vector(myHead, distance)); 
        setLocations();  
    }
    
    public void setLocations () { 
        myOldLocation = myCurrentLocation; 
        myCurrentLocation = new Location (super.getCenter());
    }
    
    public Location getOldLocation() { 
        return myOldLocation; 
    }
    
    public Location getCurrentLocation () { 
        return myCurrentLocation; 
    }
    
    public double getHead() { 
        return myHead; 
    }
    
    public boolean getPenStatus () { 
        return myPenUp; 
    }
    
    public void togglePen () { 
        myPenUp = !(myPenUp); 
    }
    
    public boolean getVisibilityStatus () { 
        return myVisibility; 
    }
    
    public void toggleVisibility () { 
        myVisibility = !(myVisibility); 
    }
    
    // rotates turtle by specified angle (in degrees) 
    public void rotate(Graphics2D pen, double angle) { 
        myHead += angle; 
        super.getView().paint(pen, super.getCenter(), DEFAULT_TURTLE_SIZE, angle); 
    }
    
    public void wrapAround () { 
        if (super.getBottom() > DEFAULT_FRAME_TOP) { 
            super.setCenter(super.getX(), DEFAULT_FRAME_BOTTOM - (super.getHeight() / 2)); 
        }
        if (super.getTop() < DEFAULT_FRAME_BOTTOM) { 
            super.setCenter(super.getX(), DEFAULT_FRAME_TOP + (super.getHeight() / 2)); 
        }
        if (super.getLeft() > DEFAULT_FRAME_RIGHT) { 
            super.setCenter(DEFAULT_FRAME_LEFT - (super.getWidth() / 2), super.getY()); 
        }
        if (super.getRight() < DEFAULT_FRAME_LEFT) { 
            super.setCenter(DEFAULT_FRAME_RIGHT + (super.getWidth() / 2), super.getY()); 
        }
    } 
    
    public void returnHome () { 
        super.setCenter(initialLocation); 
    }
    
    //TO-DO
    public void notifyObservers (Object arg) { 
        
    }
    
    //TO-DO
    public void addObserver (Object o) { 
        
    }
    
    //TO-DO
    public void setChanged () { 
        
    }
    
    //TO_DO
    public boolean hasChanged () { 
        return true; 
    }

    @Override
    public void moveForward (double dist) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void turnRight (double degrees) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void jumpMove (double xCoord, double yCoord) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void jumpturn (double degrees) {
        // TODO Auto-generated method stub
        
    }
}
