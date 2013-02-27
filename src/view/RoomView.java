package view;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import javax.swing.BorderFactory;
import javax.swing.JTextArea;
import model.Renderable;

/**
 * Renderables are painted in this view when passed in.
 * @author Ross Cahoon
 *
 */
@SuppressWarnings("serial")
public class RoomView extends WindowView {

    private Renderable myRoom;
    private Dimension mySize = new Dimension(500, 700);
    
    /**
     * Constructs the RoomView, and sets the minimum size, default size of the view
     *  and sets the default border.
     */
    public RoomView () {
        this.setPreferredSize(mySize);
        this.setMinimumSize(mySize);
        this.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5)); 
    }

    @Override
    public void addComponents () {
        add(new JTextArea(2, 2));
    }

    @Override
    public GridBagConstraints configLayout (GridBagConstraints c) {
        c.fill = GridBagConstraints.BOTH;
        c.weightx = .625;
        c.weighty = .875;
        c.gridwidth = 5;
        c.gridheight = 6;
        c.gridx = 0;
        c.gridy = 0;
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

    /**
     * Paints the Renderable in the view.
     * @param p
     */
    public void render (Renderable p) {
        myRoom = p;
        repaint();
    }
}
