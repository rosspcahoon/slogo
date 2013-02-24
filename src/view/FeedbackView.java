package view;

import java.awt.GridBagConstraints;

@SuppressWarnings("serial")
public class FeedbackView extends WindowView {
    private GridBagConstraints myConstraints;
    
    public FeedbackView (){
        super();
    }
    
    @Override
    public void addComponents (){
        add(new ErrorLogView(), ErrorLogView.configLayout(myConstraints));
        add(new StateView(), StateView.configLayout(myConstraints));
    }
}
