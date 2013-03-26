package model;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import util.Pixmap;

/**
 * Image library for turtles
 * @author mp
 *
 */
public class ImageConstants {
    public static List<Pixmap> imageFiles;
    
    /**
     * filling the stock images
     */
    static {
        imageFiles = new ArrayList<Pixmap>();
        imageFiles.add(new Pixmap("turtle1.png"));
        
    }
    
    /**
     * add additional images to the list
     * @param url
     */
    public static int addImage(String url) {
        imageFiles.add(new Pixmap(url));
        return imageFiles.size()-1;
    }
    
    /**
     * returns the index of the last image in the list
     */
    public static int getLastIndex() {
        return imageFiles.size()-1;
    }
    
}