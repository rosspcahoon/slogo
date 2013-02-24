package view;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Set;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.Timer;
import model.Room;


public class RoomView extends JPanel {

  //default serialization ID
    private static final long serialVersionUID = 1L;
     //animate 25 times per second if possible
    public static final int FRAMES_PER_SECOND = 25;
    // better way to think about timed events (in milliseconds)
    public static final int ONE_SECOND = 1000;
    public static final int DEFAULT_DELAY = ONE_SECOND / FRAMES_PER_SECOND;
    //
    public static final Dimension SIZE = new Dimension(800, 600);
    // only one so that it maintains user's preferences
    private static final JFileChooser INPUT_CHOOSER =
            new JFileChooser(System.getProperties().getProperty("user.dir"));
    
    // game to be animated
    private Room myRoom;
    
    public RoomView() {
        make(this);
        this.setBorder(BorderFactory.createEmptyBorder(0,10,10,10)); 
    }

    public JPanel make(JPanel result) {// name something better
        result.setLayout(new GridBagLayout());
        result.add(new JTextArea(20,20), makeLayout());
        return result;
    }
    
    protected GridBagConstraints makeLayout() {
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1;
        c.weighty = 1;
        return c;
    }

    /**
     * Paint the contents of the canvas.
     * 
     * Never called by you directly, instead called by Java runtime
     * when area of screen covered by this container needs to be
     * displayed (i.e., creation, uncovering, change in status)
     * 
     * @param pen used to paint shape on the screen
     */
    @Override
    public void paintComponent (Graphics pen) {
        pen.setColor(Color.WHITE);
        pen.fillRect(0, 0, getSize().width, getSize().height);
        // first time needs to be special cased :(
        if (myRoom != null) {
            myRoom.paint((Graphics2D) pen);
        }
    }
    
    public void update() {
        
    }
    
}
