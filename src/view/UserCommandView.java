package view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
public class UserCommandView extends WindowView {
    private JTextArea myUserCommandsArea;

    /**
     * Constructs the StateView and sets a default border
     * @param feedbackview The view in which this component resides
     */
    public UserCommandView (FeedbackView feedbackview) {
        super(feedbackview);
        this.setBorder(ViewConstants.DEFAULT_BORDER);
    }

    @Override
    protected void addComponents () {
        myUserCommandsArea.setEditable(false);
        myUserCommandsArea.append(Window.getResources().getString("UserCommandTitle") + "\n");
        EasyGridFactory.layoutHorizontal(this, new JScrollPane(myUserCommandsArea));
    }

    private void display(List<String> usercommandlist) {
        myUserCommandsArea.setEditable(true);
        myUserCommandsArea.setText("");
        myUserCommandsArea.append(Window.getResources().getString("UserCommandTitle") + ": \n");      
        for(String s: usercommandlist){
            myUserCommandsArea.append(s + "\n");
        }
        myUserCommandsArea.setEditable(false);
    }

    /**
     * Given a Renderable, it will display the current status of the Turtle is its coordinates
     * @param p the Renderable that displayed information will be extracted from.
     */
    public void render (Renderable p) {
        if (p.getState() != null) {
            Status s = (Status) p.getState();
            List<String> usercommandlist = new ArrayList<String>();
           //usercommandlist = s.getUserCommandList();
            display(usercommandlist);
        }
    }

    @Override
    protected void initializeVariables () {
        myUserCommandsArea = new JTextArea();
    }
}
