package view;


import controller.Controller;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.ResourceBundle;
import javax.imageio.ImageIO;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JTabbedPane;
import model.Renderable;

/**
 * The manager for all the views of SLogo
 * @author Ross Cahoon, Dagbedji Fagnisse
 *
 */
@SuppressWarnings("serial")
public class Window extends JFrame {

    private static ResourceBundle ourResources;
    private static final String DEFAULT_RESOURCE_PACKAGE = "resources.";
    private static final String USER_DIR = "user.dir";
    private Controller myController;
    private JTabbedPane myTabbedPane;
    private JMenuBar myMenuBar;
    private JFileChooser myChooser;
    private Dimension mySize = ViewConstants.DEFAULT_WINDOW_SIZE;
    
    /**
     * Constructor for Window
     * @param title The title of the View
     * @param language The display language for the window
     * @param controller The Controller responsible for this view
     */
    public Window (String title, String language, Controller controller) {
        super(title);
        this.setResizable(false);
        setPreferredSize(mySize);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // create and arrange sub-parts of the GUI
        ourResources = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + language);
        myController = controller;
        myChooser = new JFileChooser(System.getProperties().getProperty(USER_DIR));
        //tabs
        getContentPane().setLayout(new GridBagLayout());       
        addComponents();
        pack();
        setVisible(true);
    }    

    /**
     * Way to initialize tab creation from the window
     */
    public void addTab() {
        myController.newSLogoSession();
    }

    protected void addComponents() {
        myMenuBar = new MenuBarView(this);
        myTabbedPane = new JTabbedPane();
        setJMenuBar(myMenuBar);
        EasyGridFactory.layoutHorizontal(this, myTabbedPane);
    }

    /**
     * Adds a tab to the view
     * @param tab The tab to be added
     * @param p The Renderable that it is associated with
     */
    public void addTab (TabView tab, Renderable p) {
        myTabbedPane.addTab(getLiteral("TabTitle") + " " + (tab.getID() + 1), tab);
        tab.setRenderable(p);
    }
    /**
     * Returns the JFileChooser for this View
     * @return
     */
    public JFileChooser getChooser () {
        return myChooser;
    }

    /**
     * Load the specified file in a new tab - TODO
     * @param file2open
     */
    private void loadFile (File file2open) {
        return;
    }

    /**
     * Close the window
     */
    public void quit () {
        WindowEvent close = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(close);
    }
    
    /**
     * Save the active workspace - TODO
     */
    public void saveFile () {
        return;
    }

    /**
     * Called by a TabView child view that will request a string to be processed as a Command
     * @param tabView The Tabview that is requesting the string to be processed
     * @param s The string to be processed
     */
    public int processCommand (TabView tabView, String s) {
        return myController.processCommand(tabView, s);
    }
    
    /**
     * Called by a non TabView child view that will request a string to be processed as a Command
     * Uses the active tab
     * @param s The string to be processed
     */
    public int processCommand (String s) {
        TabView temp = (TabView) myTabbedPane.getSelectedComponent();
        return processCommand(temp, s);
    }

    /**
     * Gets the resource bundle
     *
     */
    public static ResourceBundle getResources() {
        return ourResources;
    }
    
    /**
     * Helper Method available to lookup values in the Resources
     * @param s - string literal to be looked up (key)
     * @return the string literal specified in the relevant properties file
     */
    public static String getLiteral(String s) {
        return Window.ourResources.getString(s);
    }
    
    /**
     * To be refactored, used to delegate logic for retrieving current pen color
     * @return
     */
    public Color getCurrentPenColor() {
        return Color.BLACK;
    }

    /**
     * Initiate the opening of a file
     */
    public void openFile () {
        int response = myChooser.showOpenDialog(null);
        if (response == JFileChooser.APPROVE_OPTION) {
            File file2open = myChooser.getSelectedFile();
            loadFile(file2open);
        }
    }

    /**
     * Initiate the change of background
     */
    public void changeBackground() {
        int response = myChooser.showOpenDialog(null);
        if (response == JFileChooser.APPROVE_OPTION) {
            Image img;
            try {
                img = ImageIO.read(myChooser.getSelectedFile());
                TabView temp = (TabView) myTabbedPane.getSelectedComponent();
                if (temp != null) {
                    temp.setBackground(img);
                }
            }
            catch (java.io.IOException er) {
                System.out.println(er.getMessage());
            }
        }
    }
    
    /**
     * Toggle the grid off or on
     */
    public void toggleGrid() {
        TabView temp = (TabView) myTabbedPane.getSelectedComponent();
        if (temp != null) {
            temp.toggleGrid();
        }
    }
    
    /**
     * Set the turtle shape
     */
    public void setTurtleShape () {
        int response = myChooser.showOpenDialog(null);
        if (response == JFileChooser.APPROVE_OPTION) {
            String imgURL = myChooser.getSelectedFile().getAbsolutePath();
            TabView temp = (TabView) myTabbedPane.getSelectedComponent();
            if (temp != null) {
                return;
            }
            int last = registerTurtleShape(imgURL);
            setTurtleShape(last);
        }
    }

    private void setTurtleShape (int i) {
        TabView temp = (TabView) myTabbedPane.getSelectedComponent();
        processCommand(temp, "setshape " + i);
    }

    private int registerTurtleShape (String imgURL) {
        return processCommand(
                     getLiteral("COMMAND_NAME_REGISTER_SHAPE") + " " + imgURL);
    }
    
    /**
     * Change the color of the pen
     */
    public void changePenColor() {
        Color result = JColorChooser.showDialog(this, getLiteral("ChangePenColor"), 
                                                getCurrentPenColor());
        int pos = processCommand(getLiteral("COMMAND_NAME_LAST_PEN_COLOR_INDEX"));
        processCommand(getLiteral("COMMAND_NAME_SET_PALETTE") +
                                 " " + pos + " " 
                                 + result.getRed() + " "
                                 + result.getGreen() + " "
                                 + result.getBlue());
        processCommand(getLiteral("COMMAND_NAME_SET_PEN_COLOR") + " " + pos);
    }
    
    /**
     * 
     * @return - number of tabs
     */
    public int getTabCount() {
        return myTabbedPane.getTabCount();
    }
    
}
