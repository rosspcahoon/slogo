package model;

import java.awt.Graphics2D;
import java.util.Observable;
import util.Location;
import util.Pixmap; 

public class Room extends Observable implements Renderable{

    private int myID;
    private Turtle myTurtle;
    private boolean myTurtlePenStatus;
    private double myTurtleHead; 
    private Location myTurtleLocation;
    
    private Status myStatus;
    
    
    
    
    public Room (int id) {
        myID = id;
        myTurtle = new Turtle();
        myTurtlePenStatus = myTurtle.getPenStatus(); 
        myTurtleLocation = myTurtle.getCenter(); 
        myTurtleHead = myTurtle.getHead(); 
    }
    
    public int getID () {
        return myID;
    }
    
    public void penOnOff () { 
        myTurtle.togglePen(); 
        myTurtlePenStatus = myTurtle.getPenStatus(); 
    }
    
    public boolean penStatus () { 
        return myTurtlePenStatus; 
    }
    
    public Location getTurtleLocation () { 
        return myTurtleLocation; 
    }
    
    public double getTurtleHead () { 
        return myTurtleHead; 
    }
    
    public void rotateTurtle(Graphics2D pen, double angle) { 
        
        myTurtle.rotate(pen, angle); 
    }
    
    public void moveTurtleForward(double distance) { 
        myTurtle.move(distance); 
    }
    
    public Status getState() {
        return myStatus;
    }
    
    // draws line wherever turtle goes (if pen is on) 
    public void paint(Graphics2D pen) {
        myTurtle.paint(pen);
        pen.drawLine((int) myTurtle.getOldLocation().getX(), (int) myTurtle.getOldLocation().getY(), (int) 
                     myTurtle.getCurrentLocation().getX(),(int) myTurtle.getCurrentLocation().getY());
    }
    
}
