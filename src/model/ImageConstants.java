package model;

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
    public static void addImage(String url) {
        imageFiles.add(new Pixmap(url));
    }
    
}