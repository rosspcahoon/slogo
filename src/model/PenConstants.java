package model;

import java.util.ArrayList;
import java.awt.Color;


public class PenConstants {
    
    public static ArrayList<Color> penColors;
   // ArrayList<>

    static {
        penColors = new ArrayList<Color>();
        penColors.add(Color.BLACK);
        penColors.add(Color.BLUE);
        penColors.add(Color.CYAN);
        penColors.add(Color.DARK_GRAY);
        penColors.add(Color.GRAY);
        penColors.add(Color.GREEN);
        penColors.add(Color.LIGHT_GRAY);
        penColors.add(Color.MAGENTA);
        penColors.add(Color.ORANGE);
        penColors.add(Color.PINK);
        penColors.add(Color.RED);
        penColors.add(Color.WHITE);
        penColors.add(Color.YELLOW);
        
    }
    
    public static void addColor(Color color) {
        penColors.add(color);
    }
}
