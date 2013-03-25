package view;

import java.util.HashMap;
import java.util.Map;
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
public class VariableView extends WindowView {
    private JTextArea myVariableArea;
    private String myVariableTitle = Window.getResources().getString("VariableTitle");

    /**
     * Constructs the StateView and sets a default border
     * @param feedbackview The view in which this component resides
     */
    public VariableView (FeedbackView feedbackview) {
        super(feedbackview);
        this.setBorder(ViewConstants.DEFAULT_BORDER);
    }

    @Override
    protected void addComponents () {
        myVariableArea.setEditable(false);
        myVariableArea.append(myVariableTitle + "\n");
        EasyGridFactory.layoutHorizontal(this, new JScrollPane(myVariableArea));
    }

    private void display(Map<String, Integer> varlist) {
        myVariableArea.setEditable(true);
        myVariableArea.setText("");
        myVariableArea.append(myVariableTitle + ": \n");      
        for (String s: varlist.keySet()) {
            myVariableArea.append(s + " " + varlist.get(s) + "\n");
        }
        myVariableArea.setEditable(false);
    }

    /**
     * Given a Renderable, it will display the current status of the Turtle is its coordinates
     * @param p the Renderable that displayed information will be extracted from.
     */
    public void render (Renderable p) {
        if (p.getState() != null) {
            Status s = (Status) p.getState();
            Map<String, Integer> varlist = new HashMap<String, Integer>();
            varlist = s.getVariableMap();
            display(varlist);
        }
    }

    @Override
    protected void initializeVariables () {
        myVariableArea = new JTextArea();
    }
}
