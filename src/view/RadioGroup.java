package view;

import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 * This class handles both the logical and visual grouping for a group of Radio Buttons
 * @author Dagbedji Fagnisse
 *
 */
public class RadioGroup extends JPanel {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    private ButtonGroup myGrouper;
    private ActionListener myListener;
    private String myVar;
    
    /**
     * Create a RadioGroup with the specified Radio Options
     * @var
     * @listener
     * @param buttons - representing Radio options
     */
    public RadioGroup(String var, ActionListener listener, JRadioButton ...buttons) {
        myGrouper = new ButtonGroup();
        myListener = listener;
        add(buttons);
        this.setBorder(ViewConstants.DEFAULT_BORDER);
    }
    
    private void add (JRadioButton b) {
        super.add(b);
        myGrouper.add(b);
        b.addActionListener(myListener);
    }
    
    /**
     * Add the buttons passes to the RadioGroup
     * @param buttons - to be added
     */
    public void add (JRadioButton ...buttons) {
        for (JRadioButton b:buttons) {
            add(b);
        }
    }
}
