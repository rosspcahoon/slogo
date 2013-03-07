package model;

import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.Graphics2D; 

/**
 * 
 * @author Matt Parides, Thomas Varner
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
    
    private boolean myPenUp = false;
    
    public PenTrail () { 
        super (0,0,0,0); 
    }
    
    public PenTrail (Point2D point1, Point2D point2) { 
        super (point1, point2); 
        myP1 = point1; 
        myP2 = point2;    
    }
    
    public PenTrail (double x1, double x2, double y1, double y2) { 
        super (x1, x2, y1, y2); 
        myX1 = x1; 
        myX2 = x2; 
        myY1 = y1; 
        myY2 = y2; 
    }

    public boolean getPenStatus () { 
        return myPenUp; 
    }
    
    public void togglePen () { 
        myPenUp = !(myPenUp); 
    }
    
    public Rectangle2D getBounds2D () {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Point2D getP1 () {
        // TODO Auto-generated method stub
        return myP1; 
    }

    @Override
    public Point2D getP2 () {
        // TODO Auto-generated method stub
        return myP2; 
    }

    @Override
    public double getX1 () {
        // TODO Auto-generated method stub
        return myX1; 
    }

    @Override
    public double getX2 () {
        // TODO Auto-generated method stub
        return myX2; 
    }

    @Override
    public double getY1 () {
        // TODO Auto-generated method stub
        return myY1; 
    }

    @Override
    public double getY2 () {
        // TODO Auto-generated method stub
        return myY2; 
    }

    @Override
    public void setLine (double x1, double x2, double y1, double y2) {
        super.setLine (x1, x2, y1, y2); 
    }
    
    public void drawLine (Graphics2D pen) { 
        pen.drawLine(myX1, myX2, myY1, myY2); 
    }

}