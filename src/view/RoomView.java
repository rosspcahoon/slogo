package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import model.Renderable;

/**
 * Renderables are painted in this view when passed in.
 * @author Ross Cahoon
 *
 */
@SuppressWarnings("serial")
public class RoomView extends WindowView {

    private Renderable myRoom;
    private Dimension mySize;
    private Image myBackgroundImage;
    private boolean myGridToggle;
    private java.awt.Image myGrid;

    /**
     * Constructs the RoomView, and sets the minimum size, default size of the view
     *  and sets the default border.
     *  @param hostTab is the parent view of this component
     */
    public RoomView (TabView hostTab) {
        super(hostTab);
        this.setBorder(ViewConstants.DEFAULT_BORDER);
        myGridToggle = false;

    }

    @Override
    protected void addComponents () {        
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
        if (myBackgroundImage != null) {
            pen.drawImage(myBackgroundImage, 0, 0, getSize().width, getSize().height, null);
        }
        if (myGridToggle) {
            URL url = this.getClass().getResource("/images/grid.png");
            try {
                myGrid = ImageIO.read(url);
            }
            catch (IOException e) {
                return;
            }
            pen.drawImage(myGrid, 0, 0, null);
        }
        if (myRoom != null) {
            myRoom.paint((Graphics2D) pen);
        }
    }

    /**
     * Paints the Renderable in the view.
     * @param p the Renderable that will be painted.
     */
    public void render (Renderable p) {
        myRoom = p;
        repaint();
    }

    @Override
    protected void initializeVariables () {
        mySize = ViewConstants.DEFAULT_ROOM_SIZE;
        this.setPreferredSize(mySize);
        this.setMinimumSize(mySize);
    }

    /**
     * Sets background image for the Roomview
     * @param img the image to be set.
     */
    public void setBackground(Image img) {
        myBackgroundImage = img;
        repaint();
    }
    /**
     * Toggles the reference grid for the workspace
     */
    public void toggleGrid() {
        myGridToggle ^= true;  
        repaint();
    }
}
