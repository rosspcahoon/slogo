package view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

/**
 * Class holding keyword strings for the view package
 * @author Ross
 *
 */
public class ViewConstants {

    /**
     * The size for Window objects
     */
    public static final Dimension DEFAULT_WINDOW_SIZE = new Dimension(1200, 700);

    /**
     * The size for TabView objects
     */
    public static final Dimension DEFAULT_TAB_SIZE = new Dimension(800, 800);

    /**
     * The size for FeedBackView objects
     */
    public static final Dimension DEFAULT_FEEDBACK_SIZE = new Dimension(800, 100);

    /**
     * The size for RoomView objects
     */
    public static final Dimension DEFAULT_ROOM_SIZE = new Dimension(500, 700);

    /**
     * The border size for views
     */
    public static final Border DEFAULT_BORDER_SIZE = BorderFactory.createEmptyBorder(5, 5, 5, 5);

    //GridBagConstraints
    private static GridBagConstraints ourConstraints = new GridBagConstraints();

    /**
     * Gets constraints for RoomView
     */
    public static final GridBagConstraints DEFAULT_ROOM_CONSTRAINTS = 
            roomConstraints(ourConstraints);

    /**
     * Gets constraints for FeedBackView
     */
    public static final GridBagConstraints DEFAULT_FEEDBACK_CONSTRAINTS = 
            feedbackConstraints(ourConstraints);

    /**
     * Gets constraints for ConsoleView
     */
    public static final GridBagConstraints DEFAULT_CONSOLE_CONSTRAINTS = 
            consoleConstraints(ourConstraints);
    /**
     * Gets constraints for textfield
     */
    public static final GridBagConstraints DEFAULT_TEXTFIELD_CONSTRAINTS = 
            textFieldConstraints(ourConstraints);

    /**
     * Gets constraints for clear button
     */
    public static final GridBagConstraints DEFAULT_CLEAR_CONSTRAINTS = 
            clearConstraints(ourConstraints);

    /**
     * Gets constraints for enter button
     */
    public static final GridBagConstraints DEFAULT_ENTER_CONSTRAINTS = 
            enterConstraints(ourConstraints);
    
    /**
     * Gets constraints for command area
     */
    public static final GridBagConstraints DEFAULT_COMMAND_CONSTRAINTS = 
            commandConstraints(ourConstraints);

    private static GridBagConstraints roomConstraints (GridBagConstraints c) {
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.weightx = .625;
        c.weighty = .875;
        c.gridwidth = 5;
        c.gridheight = 6;
        c.gridy = 0;
        return c;
    }

    private static GridBagConstraints feedbackConstraints (GridBagConstraints c) {
        c.weightx = 1;
        c.weighty = .125;
        c.gridy = 7;
        c.gridheight = 1;
        c.gridwidth = 8;
        return c;
    }

    private static GridBagConstraints consoleConstraints(GridBagConstraints c) {
        c.weightx = .375;
        c.weighty = .875;
        c.gridwidth = 3;
        c.gridheight = 6;
        c.gridx = 5;
        c.gridy = 0;
        return c;
    }

    private static GridBagConstraints textFieldConstraints(GridBagConstraints c) {
        c.weightx = 1;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipadx = 50;  
        c.gridx = 0;
        c.gridy = 1;
        return c;
    }

    private static GridBagConstraints clearConstraints(GridBagConstraints c) {
        c.gridx = 1;
        c.weightx = 0;
        c.fill = GridBagConstraints.NONE;
        c.ipadx = 0;
        return c;  
    }
    private static GridBagConstraints enterConstraints(GridBagConstraints c) {
        c.gridx = 2;
        return c;
    }

    private static GridBagConstraints commandConstraints(GridBagConstraints c) {
        c.weightx = 1;
        c.weighty = 1;
        c.fill = GridBagConstraints.BOTH;
        c.ipadx = 50; 
        c.gridwidth = 3;
        c.gridx = 0;
        c.gridy = 0;
        return c;
    }
<<<<<<< HEAD
}
=======
}
>>>>>>> 9671166287d04548176f62c11e4f4a9fb4211ba2
