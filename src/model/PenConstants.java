package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.awt.Color;

/**
 * Pen color constants for actor trails
 * @author mp
 *
 */
public class PenConstants {
        
    public static ArrayList<Color> penColors;

    public static final float PEN_DASH_SPACE = (float) 4.0;
    public static final float PEN_DASH_NO_SPACE = (float) 0.0;
    public static final float PEN_DEFAULT_THICKNESS = (float) 2.0;
    
    public static final String PEN_TYPE_NAME_NORMAL = "normal";
    public static final String PEN_TYPE_NAME_DASHED = "dashed";
    public static final String PEN_TYPE_NAME_DOUBLE = "double";
    
    public static final int PEN_TYPE_INDEX_NORMAL = 0;
    public static final int PEN_TYPE_INDEX_DASHED = 1;
    public static final int PEN_TYPE_INDEX_DOUBLE = 2;
    
    private static final Map<String,Integer> PEN_TYPE_NAME_TO_INDEX_MAP = new HashMap<String,Integer>();
    
    /**
     * filling the stock colors
     */
    static {
        PEN_TYPE_NAME_TO_INDEX_MAP.put(PEN_TYPE_NAME_NORMAL, PEN_TYPE_INDEX_NORMAL);
        PEN_TYPE_NAME_TO_INDEX_MAP.put(PEN_TYPE_NAME_DASHED, PEN_TYPE_INDEX_DASHED);
        PEN_TYPE_NAME_TO_INDEX_MAP.put(PEN_TYPE_NAME_DOUBLE, PEN_TYPE_INDEX_DOUBLE);
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
    
    /**
     * add additional colors to the list
     * @param color
     */
    public static int addColor(Color color) {
        penColors.add(color);
        return penColors.size()-1;
    }
    
    /**
     * returns the index of the last color in the list
     */
    public static int getLastIndex() {
        return penColors.size()-1;
    }
    
    /**
     * modify the RGB values of a color in the list
     */
    public static int setPalette(int i, int r, int g, int b) {
        Color color = new Color(r, g, b);
        penColors.remove(i);
        penColors.add(i, color);
        return i;
    }
    
    /**
     * gets the appropriate index for the pen type name
     */
    public static int getIndexForPenTypeName(String name) {
        if (!PEN_TYPE_NAME_TO_INDEX_MAP.containsKey(name)) {
            return -1;
        }
        return PEN_TYPE_NAME_TO_INDEX_MAP.get(name);
    }
}
