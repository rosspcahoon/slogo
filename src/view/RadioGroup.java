package view;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 * This class handles both the logical and visual grouping for a group of Radio Buttons.
 * It notifies the listener provided at instantiation.
 * @author Dagbedji Fagnisse
 *
 */
public class RadioGroup extends JPanel {

    private static final long serialVersionUID = 1L;
    
    private Collection<JRadioButton> myButtons;
    private ButtonGroup myGrouper;
    private ActionListener myListener;
    
    private RadioGroup(ActionListener listener) {
        myButtons = new ArrayList<JRadioButton>();
        myGrouper = new ButtonGroup();
        myListener = listener;
        this.setBorder(ViewConstants.DEFAULT_BORDER);
    }
    
    /**
     * Create a RadioGroup with the specified Radio Options
     * @param listener - listener supposed to handle events for the Radio Group
     * @param buttons - representing Radio options
     */
    public RadioGroup(ActionListener listener, JRadioButton ...buttons) {
        this(listener);
        add(buttons);
    }
    
    /**
     * Create a simple RadioGroup with the specified Radio String Options
     * @param listener - listener supposed to handle events for the Radio Group
     * @param options - representing Radio options (literals)
     */
    public RadioGroup(ActionListener listener, String ...options) {
        this(listener);
        Collection<JRadioButton> buttons = new ArrayList<JRadioButton>();
        for (String o: options) {
            JRadioButton currB = makeRadioOption(o);
            buttons.add(currB);
        }
        add(buttons);
    }
    
    private void add (JRadioButton b) {
        super.add(b);
        myButtons.add(b);
        myGrouper.add(b);
        b.addActionListener(myListener);
    }
    
    /**
     * Add the buttons passes to the RadioGroup
     * @param buttons - to be added
     */
    private void add (JRadioButton ...buttons) {
        for (JRadioButton b:buttons) {
            add(b);
        }
    }
    
    /**
     * Add the buttons passes to the RadioGroup
     * @param buttons - to be added
     */
    public void add (Collection<JRadioButton>buttons) {
        for (JRadioButton b:buttons) {
            add(b);
        }
    }
    
    private JRadioButton makeRadioOption (String option) {
        JRadioButton res = new JRadioButton(option);
        res.setActionCommand(option);
        res.setSelected(true);
        return res;
    }
}
