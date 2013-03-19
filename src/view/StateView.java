package view;

import javax.swing.JScrollPane;
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
    private JTextArea myTextArea;

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
        myTextArea.setEditable(false);
        EasyGridFactory.layoutVertical(this, new JScrollPane(myTextArea));
    }

    private void display(double[] array) {
        myTextArea.setEditable(true);
        myTextArea.setText("");
        myTextArea.append(Window.getResources().getString("FeedbackPosition") + 
                          "(" + array[0] + ", " + array[1] + ")      ");
        myTextArea.append(Window.getResources().getString("FeedbackHeading") + array[2] + "\n");
        myTextArea.setEditable(false);
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
        myTextArea = new JTextArea();
    }
}
