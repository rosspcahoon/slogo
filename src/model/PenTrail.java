package model;

import java.util.List;
import java.util.ArrayList;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.Color;
import java.awt.Graphics2D; 
import java.awt.BasicStroke;
import util.Location;
import util.Vector;

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
    private BasicStroke myStroke;
    private Color myPenColor;
    
    /**
     * Constructor
     */
    public PenTrail () { 
        this (0,0,0,0, true, (float)1.0, Color.BLACK); 
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
        myPenColor = Color.BLACK;
    }
    
    /**
     * Constructor
     * @param x1
     * @param x2
     * @param y1
     * @param y2
     */
    public PenTrail (double x1, double x2, double y1, double y2, boolean pen,
                     float thickness, float[] dashSize, Color color) { 
        super (x1, x2, y1, y2); 
        myX1 = x1; 
        myX2 = x2; 
        myY1 = y1; 
        myY2 = y2; 
        myPenDown = pen;
        myStroke = new BasicStroke(thickness, BasicStroke.CAP_BUTT, 
                                   BasicStroke.JOIN_BEVEL, 0,dashSize, (float)0);
        myPenColor = color;
    }
    
    /**
     * Constructor
     * @param x1
     * @param x2
     * @param y1
     * @param y2
     */
    public PenTrail (double x1, double x2, double y1, double y2, boolean pen,
                     float thickness, Color color) { 
        super (x1, x2, y1, y2); 
        myX1 = x1; 
        myX2 = x2; 
        myY1 = y1; 
        myY2 = y2; 
        myPenDown = pen;
        myStroke = new BasicStroke(thickness, BasicStroke.CAP_BUTT, 
                                   BasicStroke.JOIN_BEVEL);
        myPenColor = color;
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
    
    /**
     * uses input coordinates to create a parallel line "dist" pixels away from
     * the original
     * @param x1
     * @param x2
     * @param y1
     * @param y2
     * @param dist
     * @return array of parallel line's coordinates
     */
    private static double[] translateParallelCoordinates(double x1, double x2, double y1,
                                                  double y2, double dist) {
        double[] coords = new double[4];
        Vector vec = new Vector(new Point2D.Double(x1, y1), new Point2D.Double(x2,y2));
        vec.turn(90);
        vec.setMagnitude(dist);
        Location loc1 = new Location(x1, y1);
        Location loc2 = new Location(x2, y2);
        loc1.translate(vec);
        loc2.translate(vec);
        coords[0] = loc1.getX();
        coords[1] = loc2.getX();
        coords[2] = loc1.getY();
        coords[3] = loc2.getY();
        return coords;
        
    }
    
    /**
     * constructs a line from the input states
     * @param x1
     * @param x2
     * @param y1
     * @param y2
     * @param pen - pen down
     * @param penThick - pen thickness
     * @param dashWidth - distance between dashes
     * @param doubleLine - double line state (true = 2 lines)
     * @param trails - list to add new lines to
     * @param color - pen color
     */
    public static void makeLine(double x1, double x2, double y1, double y2, 
                                boolean pen, float penThick, float dashWidth,
                                boolean doubleLine, List<PenTrail> trails, Color color) {
        float[] dash = new float[1];
        dash[0] = dashWidth;
        if (pen) {
            if (dashWidth == 0) {
                PenTrail trail = new PenTrail(x1, x2, y1, y2, pen, penThick, color);
                trails.add(trail);
                if (doubleLine) {
                    double[] coordinates =
                            translateParallelCoordinates(x1, x2, y1, y2, (double) penThick * 2);
                    PenTrail trail2 = new PenTrail(coordinates[0], coordinates[1],
                                                   coordinates[2], coordinates[3],
                                                   pen, penThick, color);
                    trails.add(trail2);
                }
            }
            else {
                PenTrail trail = new PenTrail(x1, x2, y1, y2, pen, penThick, dash, color);
                trails.add(trail);
                if (doubleLine) {
                    double[] coordinates =
                            translateParallelCoordinates(x1, x2, y1, y2, (double) penThick * 2);
                    PenTrail trail2 = new PenTrail(coordinates[0], coordinates[1],
                                                   coordinates[2], coordinates[3],
                                                   pen, penThick, dash, color);
                    trails.add(trail2);
                }
            }
        }
        
        
    }

    @Override
    public void setLine (double x1, double x2, double y1, double y2) {
        super.setLine (x1, x2, y1, y2); 
    }
    
    /**
     * draws this penTrail.
     * @param pen
     */
    public void drawLine (Graphics2D pen) {
        pen.setColor(myPenColor);
        pen.setStroke(myStroke);
//        System.out.println(myStroke.getDashPhase());
        if(myPenDown) {
            pen.drawLine((int)myX1, (int)myY1, (int)myX2, (int)myY2); 
        }
    }

}