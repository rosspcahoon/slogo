package view;

import java.awt.Dimension;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JPanel;

public class FeedbackView extends JPanel {

    private ErrorLogView myErrorLogView;
    private StateView myStateView;
    public static final Dimension SIZE = new Dimension(800, 600);
    
    public void display() {
        
    }
    
    public FeedbackView (){
        new FeedbackView(SIZE);
    }
    public FeedbackView (Dimension size){
        setPreferredSize(size);
    }
}
