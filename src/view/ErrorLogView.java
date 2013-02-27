package view;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.BorderFactory;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import model.Renderable;
import model.Status;

/**
 * ErrorLogView renders error messages from the Room to via a Status for display
 * @author Ross Cahoon
 *
 */
@SuppressWarnings("serial")
public class ErrorLogView extends WindowView {
    private JTextArea myTextArea;
    private GridBagConstraints myConstraints;
    private FocusListener myFocusListener;
    
    /**
     * Constructs the ErrorLogView and sets a default border
     */
    public ErrorLogView (FeedbackView hostFeedbackView) {
        super(hostFeedbackView);
        this.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
    }

    @Override
    public void addComponents () {
        makeFocusListener();
        myTextArea.setForeground(Color.RED);
        myTextArea.setFocusable(true);
        myTextArea.addFocusListener(myFocusListener);
        myTextArea.setEditable(false);

        myConstraints = new GridBagConstraints();
        JScrollPane scrollPane = new JScrollPane(myTextArea);             
        add(scrollPane, makeLayout(myConstraints));
    }

    @Override
    public GridBagConstraints configLayout(GridBagConstraints c) {
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1;
        c.weighty = 1;
        c.gridx = 1;
        c.gridy = 0;
        c.gridwidth = 1;
        c.gridheight = 1;
        return c;
    }

    protected GridBagConstraints makeLayout (GridBagConstraints c) {
        c.weightx = 1;
        c.weighty = 1;
        c.fill = GridBagConstraints.BOTH; 
        c.gridwidth = 1;
        c.gridheight = 1;
        c.gridx = 0;
        c.gridy = 0;
        return c;
    }
    private void display(String error) {
        myTextArea.setEditable(true);
        myTextArea.append(error + "\n");
        myTextArea.setEditable(false);
        notifyNewError();
    }

    private void makeFocusListener () {
        myFocusListener = new FocusListener() {
            @Override
            public void focusGained (FocusEvent e) {
                myTextArea.setEditable(true);
                myTextArea.setBackground(Color.WHITE);
                myTextArea.setEditable(false);
            }
            @Override
            public void focusLost (FocusEvent arg0) {
            }
        };
    }

    private void notifyNewError () {
        myTextArea.setEditable(true);
        myTextArea.setBackground(Color.YELLOW);
        myTextArea.setEditable(false);
    }
    /**
     * Takes in a Renderable Room and extracts any error message, if any.
     * @param p Renderable that the error message will attempt to be extracted from.
     */
    public void render (Renderable p) {
        if (((Status) p.getState()).getErrorMessage().equals("")) {
            Status thisStatus = (Status) p.getState();
            display(thisStatus.getErrorMessage());
        }
        //        Test Display
        //        for(int i =0 ; i<10; i++){
        //            display("You messed up");
        //            display("Dude, check your syntax");
        //            display("Command not found");
        //        }
    }

    @Override
    protected void initializeVariables () {
        myConstraints = new GridBagConstraints();
        myTextArea = new JTextArea();
    }

}
