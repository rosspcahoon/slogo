package view;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
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
    private FocusListener myFocusListener;

    /**
     * Constructs the ErrorLogView and sets a default border
     * @param hostFeedbackView the view that creates this view, its parent
     */
    public ErrorLogView (FeedbackView hostFeedbackView) {
        super(hostFeedbackView);
        this.setBorder(ViewConstants.DEFAULT_BORDER);
    }

    @Override
    public void addComponents () {
        makeFocusListener();
        myTextArea.setForeground(Color.RED);
        myTextArea.setFocusable(true);
        myTextArea.addFocusListener(myFocusListener);
        myTextArea.setEditable(false);

        EasyGridFactory.layoutVertical(this, new JScrollPane(myTextArea));
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
        if (((Status) p.getState()) != null) {
            Status thisStatus = (Status) p.getState();
            if (thisStatus.getErrorMessage() != null) {
                display(thisStatus.getErrorMessage());
            }
        }
    }

    @Override
    protected void initializeVariables () {
        myTextArea = new JTextArea();
    }

}
