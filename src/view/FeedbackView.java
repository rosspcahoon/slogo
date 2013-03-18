package view;

import java.awt.Dimension;
import model.Renderable;

/**
 * The container that StateView and ErrorLogView are contained in.
 * @author Ross Cahoon
 *
 */
@SuppressWarnings("serial")
public class FeedbackView extends WindowView {
    private ErrorLogView myErrorLogView;
    private StateView myStateView;
    private Dimension mySize = ViewConstants.DEFAULT_FEEDBACK_SIZE;

    /**
     * Constructs the FeedbackView and sets the minimum size and default size of the view.
     * @param tab is the Tabview which the current Feedback view is in
     */
    public FeedbackView (TabView tab) {
        super(tab);
        this.setPreferredSize(mySize);
        this.setMinimumSize(mySize);
    }

    @Override
    public void addComponents () {
        EasyGridFactory.layoutHorizontal(this, myStateView, myErrorLogView);
    }

    /**
     * Passes the Renderable it receives to all views it contains.
     * @param p the Renderable that all views within this one will receive
     */
    public void render (Renderable p) {
        myErrorLogView.render(p);
        myStateView.render(p);
    }

    @Override
    protected void initializeVariables () {
        myErrorLogView = new ErrorLogView(this);
        myStateView = new StateView(this);
    }
}
