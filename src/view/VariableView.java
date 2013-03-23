package view;

import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import model.Renderable;
import model.Status;

/**
 * 
 * @author Ross Cahoon
 *
 */
@SuppressWarnings("serial")
public class VariableView extends WindowView {

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
        EasyGridFactory.layoutVertical(this, new JTextArea(Window.getResources().getString("VariableTitle")));        
    }

    private void display(HashMap<String, Integer> varlist) {
        JComponent[] variablePanels;
        variablePanels = new JComponent[varlist.size()];
        this.removeAll();
        int count = 0;        
        for(String s: varlist.keySet()){
            
            JPanel tempPanel = new JPanel();
            EasyGridFactory.layoutHorizontal(tempPanel, new JTextArea("s"), new JTextField(varlist.get(s)));
            variablePanels[count] = tempPanel;
            count++;
        }
        
//        EasyGridFactory.layoutVertical(this, new JTextArea(Window.getResources().getString("VariableTitle")), variablePanels));  
        EasyGridFactory.layoutVertical(this, new JTextArea(Window.getResources().getString("VariableTitle")));  
    }

    /**
     * Given a Renderable, it will display the current status of the Turtle is its coordinates
     * @param p the Renderable that displayed information will be extracted from.
     */
    public void render (Renderable p) {
        if (p.getState() != null) {
//            Status s = (Status) p.getState();
            //All hypothetical
            HashMap<String, Integer> varlist = new HashMap<String, Integer>();
//            Hasn't been added to Status object yet
//            varlist = s.getVariables();
            display(varlist);
        }
    }

    @Override
    protected void initializeVariables () {
    }
}
