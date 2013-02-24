package view;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ErrorLogView extends FeedbackView {
    
    public ErrorLogView () {
        //super();
        make(this);
    }
    
    public JPanel make(JPanel result) {// name something better
        result.setLayout(new GridBagLayout());
        result.add(new JTextArea(20, 20), makeErrorLayout());
        return result;
    }
    
    protected GridBagConstraints makeErrorLayout() {
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1;
        c.weighty = 1;
        return c;
    }

    public void display() {
        
    }
}
