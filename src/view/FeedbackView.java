package view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import model.Renderable;

@SuppressWarnings("serial")
public class FeedbackView extends WindowView {
    private GridBagConstraints myConstraints;
    private ErrorLogView myErrorLogView;
    private StateView myStateView;
    private Dimension mySize = new Dimension(800,100);
    
    public FeedbackView (){
        this.setPreferredSize(mySize);
        this.setMinimumSize(mySize);
    }
    
    @Override
    public void addComponents (){
        myConstraints = new GridBagConstraints();        
        add(myErrorLogView = new ErrorLogView(), myErrorLogView.configLayout(myConstraints));
        add(myStateView = new StateView(), myStateView.configLayout(myConstraints));
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

    public void render (Renderable p) {
        myErrorLogView.render(p);
        myStateView.render(p);
        
    }
    
    
}
