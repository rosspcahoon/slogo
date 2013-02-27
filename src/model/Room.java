package model;

import java.awt.Graphics2D;
import java.util.Observable;

public class Room extends Observable implements Renderable{

    private int myID;
    private Turtle myTurtle;
    private Status myStatus;
    
    public Room (int id) {
        myID = id;
        myTurtle = new Turtle();
    }

    public int getID () {
        return myID;
    }
    
    @Override
    public Status getState() {
        return myStatus;
    }
    
    @Override
    public void paint(Graphics2D pen) {
        myTurtle.paint(pen);
        pen.drawLine((int) myTurtle.getOldX(), (int) myTurtle.getOldY(), (int) 
                     myTurtle.getCurrentX(),(int) myTurtle.getCurrentY());
    }
}
