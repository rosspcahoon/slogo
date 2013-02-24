package view;

import java.awt.GridBagConstraints;

@SuppressWarnings("serial")
public class StateView extends FeedbackView {
    
    public StateView () {
        super();
        addComponents();
    }
    
    @Override
    public void addComponents () {
    }
    
    public static GridBagConstraints configLayout(GridBagConstraints c) {
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1;
        c.weighty = 1;
        c.gridx = 0;
        c.gridy = 0;
        return c;
    }

    public void display() {
        
    }
}
