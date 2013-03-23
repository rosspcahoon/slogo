package view;

import javax.swing.JTextArea;
import model.Renderable;
import model.Status;

/**
 * 
 * @author Ross Cahoon
 *
 */
@SuppressWarnings("serial")
public class StateView extends WindowView {
    private JTextArea myFeedbackText;

    /**
     * Constructs the StateView and sets a default border
     * @param feedbackview The view in which this component resides
     */
    public StateView (FeedbackView feedbackview) {
        super(feedbackview);
        this.setBorder(ViewConstants.DEFAULT_BORDER);
    }

    @Override
    protected void addComponents () {
        myFeedbackText.setEditable(false);
        EasyGridFactory.layoutHorizontal(this, myFeedbackText);        
    }

    private void display(double[] array) {
        myFeedbackText.setEditable(true);
        myFeedbackText.setText("");
        myFeedbackText.append(Window.getResources().getString("FeedbackPosition") + 
                         "(" + array[0] + ", " + array[1] + ")" + "\n");
        myFeedbackText.append(Window.getResources().getString("FeedbackHeading") + array[2] + "\n");
        myFeedbackText.setEditable(false);
    }

    /**
     * Given a Renderable, it will display the current status of the Turtle is its coordinates
     * @param p the Renderable that displayed information will be extracted from.
     */
    public void render (Renderable p) {
        if (p.getState() != null) {
            Status s = (Status) p.getState();
            double[] statusArray = {s.getMyXCoord(), s.getMyYCoord(), s.getMyHeading()};
            display(statusArray);
        }
    }

    @Override
    protected void initializeVariables () {
        myFeedbackText = new JTextArea();
    }
}
