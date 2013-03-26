package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import model.PenConstants;
import model.command.CommandConstants;

/**
 * This specialized UI is intended to allow the user to specify 
 * Pen Properties: type, thickness, active. 
 * @author Dagbedji Fagnisse
 *
 */
public class PenOptionsView extends JDialog {

    private static final long serialVersionUID = 7800762411110902427L;
    private Window myParent;
    private boolean myPenDown;
    private String myPenThickness;
    private String myPenType;
    private JComponent myPenDownUI;
    private JComponent myPenThicknessUI;
    private JComponent myPenTypeUI;
    
    /**
     * Instantiate a view that can be used to set properties of a pen
     * @param w - Parent window
     */
    public PenOptionsView(Window w) { 
        super(w, "Choose Pen Options");
        super.setSize(ViewConstants.DEFAULT_PEN_OPTIONS_VIEW_SIZE);
        myParent = w;
        setModalityType(DEFAULT_MODALITY_TYPE);
        
        myPenDownUI = new JCheckBox("Pen Down");
        ((JCheckBox) myPenDownUI).setSelected(true);
        ((JCheckBox) myPenDownUI).addItemListener(new PenDownListener());
        
        myPenTypeUI = new RadioGroup(new PenTypeListener(), PenConstants.PEN_TYPE_NAME_NORMAL, 
                                     PenConstants.PEN_TYPE_NAME_DASHED, 
                                     PenConstants.PEN_TYPE_NAME_DOUBLE);

        myPenThicknessUI = new RadioGroup(new PenThicknessListener(), "2", "4", "6");
        
        EasyGridFactory.layoutVertical(this, myPenDownUI, myPenThicknessUI, myPenTypeUI);
    }
    
    
    /**
     * Set visible
     */
    public void display() {
        setVisible(true);
    }
    
    
    private String updateUserTypeChoice (String type) {
        myPenType = type;
        int index = PenConstants.getIndexForPenTypeName(type);
        myParent.processCommand(CommandConstants.COMMAND_NAME_SET_PEN_TYPE + " " + index);
        return myPenType;
    }
    private String updateUserThicknessChoice (String thickness) {
        myPenThickness = thickness;
        myParent.processCommand(CommandConstants.COMMAND_NAME_SET_PEN_SIZE + " " + thickness);
        return myPenThickness;
    }
    private boolean updateUserDownChoice (boolean down) {
        myPenDown = down;
        myParent.processCommand(myPenDown ? "pendown" : "penup");
        return myPenDown;
    }
    
    private class PenTypeListener implements ActionListener {

        @Override
        public void actionPerformed (ActionEvent e) {
            updateUserTypeChoice(e.getActionCommand());
        }
        
    }
    
    private class PenThicknessListener implements ActionListener {

        @Override
        public void actionPerformed (ActionEvent e) {
            updateUserThicknessChoice(e.getActionCommand());
        }
        
    }
    
    private class PenDownListener implements ItemListener {

        @Override
        public void itemStateChanged (ItemEvent e) {
            boolean checked = e.getStateChange() == ItemEvent.SELECTED;
            updateUserDownChoice(checked);
        }
        
    }
    
}
