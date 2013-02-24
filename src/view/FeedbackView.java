package view;

import java.awt.GridBagConstraints;

@SuppressWarnings("serial")
public class FeedbackView extends WindowView {
    private GridBagConstraints myConstraints;
    private ErrorLogView myErrorLogView;
    private StateView myStateView;
    
    public FeedbackView (){
        super();
        addComponents();
        System.out.println("Printing in FeedbackView");
    }
    
    @Override
    public void addComponents (){
        myConstraints = new GridBagConstraints();        
        add(myErrorLogView = new ErrorLogView(), myErrorLogView.configLayout(myConstraints));
        add(myStateView = new StateView(), myStateView.configLayout(myConstraints));
    }
    
    @Override
    public GridBagConstraints configLayout (GridBagConstraints c) {
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.weighty = 1;
        c.gridx = 0;
        c.gridy = 6;
        c.gridwidth = 6;
        c.gridheight = 1;
        return c;
    }
}
