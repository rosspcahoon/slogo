package view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import model.Renderable;

/**
 * The container that StateView and ErrorLogView are contained in.
 * @author Ross Cahoon
 *
 */
@SuppressWarnings("serial")
public class FeedbackView extends WindowView {
    private GridBagConstraints myConstraints;
    private ErrorLogView myErrorLogView;
    private StateView myStateView;
    private Dimension mySize = new Dimension(800, 100);

    /**
     * Constructs the FeedbackView and sets the minimum size and default size of the view.
     */
    public FeedbackView () {
        this.setPreferredSize(mySize);
        this.setMinimumSize(mySize);
    }

    @Override
    public void addComponents () {
        myConstraints = new GridBagConstraints();
        myErrorLogView = new ErrorLogView();
        myStateView = new StateView();
        add(myErrorLogView, myErrorLogView.configLayout(myConstraints));
        add(myStateView, myStateView.configLayout(myConstraints));
    }

    @Override
    public GridBagConstraints configLayout (GridBagConstraints c) {
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1;
        c.weighty = .125;
        c.gridx = 0;
        c.gridy = 7;
        c.gridheight = 1;
        c.gridwidth = 8;
        return c;
    }
    /**
     * Passes the Renderable it receives to all views it contains.
     * @param p the Renderable that all views within this one will receive
     */
    public void render (Renderable p) {
        myErrorLogView.render(p);
        myStateView.render(p);

    }


}
