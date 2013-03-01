package model;

import java.awt.Graphics2D;
import java.util.Observable;
import util.Location;

public class Room extends Observable implements Renderable{

    private int myID;
    //    private Turtle myTurtle;
    private Status myStatus;
    private Turtle myTurtle;
    private boolean myTurtlePenStatus;
    private double myTurtleHead; 
    private Location myTurtleLocation;
    private boolean myTurtleVisibility; 


    public Room (int id) {
        myID = id;
        myTurtle = new Turtle();
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

    public void visibilityOnOff () { 
        myTurtle.toggleVisibility(); 
        myTurtleVisibility = myTurtle.getVisibilityStatus(); 
    }

    public boolean getVisibility () { 
        return myTurtleVisibility; 
    }

    public Location getTurtleLocation () { 
        return myTurtleLocation; 
    }

    public double getTurtleHead () { 
        return myTurtleHead; 
    }

    public void rotateTurtle(Graphics2D pen, double angle) { 
        myTurtleHead += angle; 
        myTurtle.rotate(pen, angle); 
    }

    public void moveTurtleForward(double distance) { 
        myTurtle.move(distance); 
    }

    public void returnHome () { 
        myTurtle.returnHome(); 
    }

    public Status getState() {
        return myStatus;
    }

    // draws line wherever turtle goes (if pen is on) 
    public void paint(Graphics2D pen) {
        myTurtle.paint(pen);
        if(myTurtle.getOldLocation() != null){
            pen.drawLine((int) myTurtle.getOldLocation().getX(), (int) myTurtle.getOldLocation().getY(), (int) 
                         myTurtle.getCurrentLocation().getX(),(int) myTurtle.getCurrentLocation().getY());
        }
    }
}
