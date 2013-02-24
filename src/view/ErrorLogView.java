package view;

import java.awt.GridBagConstraints;

public class ErrorLogView extends FeedbackView {
    
    public ErrorLogView () {
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
        c.gridx = 1;
        c.gridy = 0;
        return c;
    }

    public void display() {
        
    }
}
