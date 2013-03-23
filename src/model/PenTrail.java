package model;

import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.Color;
import java.awt.Graphics2D; 

/**
 * 
 * @author Thomas Varner
 *
 */

public class PenTrail extends Line2D.Double {

    /**
     * @param args
     */
    
    private Point2D myP1; 
    private Point2D myP2; 
    private double myX1; 
    private double myX2; 
    private double myY1; 
    private double myY2; 
    
    private boolean myPenDown;
    
    /**
     * Constructor
     */
    public PenTrail () { 
        this (0,0,0,0, true); 
    }
    
    /**
     * Constructor
     * @param point1
     * @param point2
     */
    public PenTrail (Point2D point1, Point2D point2) { 
        super (point1, point2); 
        myP1 = point1; 
        myP2 = point2;    
        myPenDown = true;
    }
    
    /**
     * Constructor
     * @param x1
     * @param x2
     * @param y1
     * @param y2
     */
    public PenTrail (double x1, double x2, double y1, double y2, boolean pen) { 
        super (x1, x2, y1, y2); 
        myX1 = x1; 
        myX2 = x2; 
        myY1 = y1; 
        myY2 = y2; 
        myPenDown = pen;
    }

    /**
     * getter for the pen's status
     * @return myPenUp
     */
    public boolean getPenStatus () { 
        return myPenDown; 
    }
    
    /**
     * toggle for pen
     */
    public void togglePen () { 
        myPenDown = !(myPenDown); 
    }
    
    public Rectangle2D getBounds2D () {
        return null;
    }

    @Override
    public Point2D getP1 () {
        return myP1; 
    }

    @Override
    public Point2D getP2 () {
        return myP2; 
    }

    @Override
    public double getX1 () {
        return myX1; 
    }

    @Override
    public double getX2 () {
        return myX2; 
    }

    @Override
    public double getY1 () {
        return myY1; 
    }

    @Override
    public double getY2 () {
        return myY2; 
    }

    @Override
    public void setLine (double x1, double x2, double y1, double y2) {
        super.setLine (x1, x2, y1, y2); 
    }
    
    public void drawLine (Graphics2D pen) {
        pen.setColor(Color.BLACK);
        if(myPenDown) {
            pen.drawLine((int)myX1, (int)myY1, (int)myX2, (int)myY2); 
        }
    }

}