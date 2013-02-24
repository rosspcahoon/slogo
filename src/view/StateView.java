package view;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class StateView extends FeedbackView {

    public void display() {
        
    }
    
    public StateView () {
        make(this);
    }
    
    public JPanel make(JPanel result) {// name something better
        result.setLayout(new GridBagLayout());
        result.add(new JTextArea(20,20), makeStateLayout());
        return result;
    }
    
    protected GridBagConstraints makeStateLayout() {
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1;
        c.weighty = 1;
        return c;
    }
}
