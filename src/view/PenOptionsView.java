package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JRadioButton;

/**
 * TODO
 * @author Dagbedji Fagnisse
 *
 */
public class PenOptionsView extends JDialog {
    /**
     * TODO
     */
    private static final long serialVersionUID = 7800762411110902427L;
    private Window myParent;
    private boolean myPenDown;
    private String myPenThickness;
    private String myPenType;
    private JComponent myPenDownUI;
    private JComponent myPenThicknessUI;
    private JComponent myPenTypeUI;
    
    /**
     * TODO
     * @param w - 
     */
    public PenOptionsView(Window w) { 
        super(w, "Choose Pen Options");
        super.setSize(ViewConstants.DEFAULT_PEN_OPTIONS_VIEW_SIZE);
        myParent = w;
        setModalityType(DEFAULT_MODALITY_TYPE);
        
        myPenDownUI = new JCheckBox("Pen Down");
        ((JCheckBox) myPenDownUI).setSelected(true);
        ((JCheckBox) myPenDownUI).addItemListener(new PenDownListener());
        
        JRadioButton dashed = makeRadioOption("dashed");
        JRadioButton dotted = makeRadioOption("dotted");
        myPenTypeUI = new RadioGroup(myPenType, new PenTypeListener(), dashed, dotted);
        
        JRadioButton two = makeRadioOption("2");
        JRadioButton four = makeRadioOption("4");
        myPenThicknessUI = new RadioGroup(myPenThickness, new PenThicknessListener(), two, four);
        EasyGridFactory.layoutVertical(this, myPenDownUI, myPenThicknessUI, myPenTypeUI);
    }
    
    private JRadioButton makeRadioOption (String option) {
        JRadioButton res = new JRadioButton(option);
        res.setActionCommand(option);
        res.setSelected(true);
        return res;
    }
    
    /**
     * Set visible
     */
    public void display() {
        setVisible(true);
    }
    
    
    private String updateUserTypeChoice (String type) {
        myPenType = type;
        myParent.processCommand("setpentype " + myPenType);
        return myPenType;
    }
    private String updateUserThicknessChoice (String thickness) {
        myPenThickness = thickness;
        myParent.processCommand("setpenthickness " + thickness);
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
