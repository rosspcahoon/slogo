package model;

import java.util.ArrayList;
import java.util.List;
import util.Pixmap;

public class ImageConstants {
    public static List<Pixmap> imageFiles;
    
    static {
        imageFiles = new ArrayList<Pixmap>();
        imageFiles.add(new Pixmap("turtle1.png"));
        
    }
    
    public static void addImage(String url) {
        imageFiles.add(new Pixmap(url));
    }
    
}