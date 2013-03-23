package view;


import controller.Controller;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.ResourceBundle;
import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.KeyStroke;
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
    private void addTab() {
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
        myTabbedPane.addTab("Tab" + tab.getID(), tab);
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
     * Open the provided file in a new tab
     * @param file2open
     */
    private void openFile (File file2open) {
        //TODO 
    }

    private void quit () {
        WindowEvent close = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(close);
    }

    private void saveFile () {
    }

    /**
     * Called by a TabView child view that will request a string to be processed as a Command
     * @param tabView The Tabview that is requesting the string to be processed
     * @param s The string to be processed
     */
    public void processCommand (TabView tabView, String s) {
        myController.processCommand(tabView, s);
    }

    /**
     * Gets the resource bundle
     *
     */
    public static ResourceBundle getResources() {
        return ourResources;
    }

    protected class NewTabAction extends AbstractAction {
        public NewTabAction() {
            super(Window.ourResources.getString("NewCommand"));
            putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_T, ActionEvent.CTRL_MASK));
        }
        @Override
        public void actionPerformed (ActionEvent e) {
            addTab();
        } 
    }

    protected class OpenFileAction extends AbstractAction {

        public OpenFileAction() {
            super(Window.ourResources.getString("OpenCommand"));
            putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
        }
        @Override
        public void actionPerformed (ActionEvent e) {
            int response = myChooser.showOpenDialog(null);
            if (response == JFileChooser.APPROVE_OPTION) {
                File file2open = myChooser.getSelectedFile();
                openFile(file2open);
            }
        }

    }

    protected class QuitAction extends AbstractAction {
        public QuitAction() {
            super(Window.ourResources.getString("QuitCommand"));
            putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.CTRL_MASK));
        }

        @Override
        public void actionPerformed (ActionEvent e) {
            quit();
        }
    }

    protected class SaveFileAction extends AbstractAction {
        public SaveFileAction () {
            super(Window.ourResources.getString("SaveCommand"));
            putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        }

        @Override
        public void actionPerformed (ActionEvent e) {
            saveFile();
        }
    }

    protected class WelcomeAction extends AbstractAction {
        WelcomeAction() {
            super(Window.ourResources.getString("WelcomeCommand"));
            putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_W, ActionEvent.CTRL_MASK));
        }

        @Override
        public void actionPerformed (ActionEvent e) {
            try {
                String url = "http://www.cs.duke.edu/courses/spring13/compsci308/assign/03_slogo/";
                java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
            }
            catch (java.io.IOException er) {
                System.out.println(er.getMessage());
            }
        }
    }

    protected class ChangeBackgroundAction extends AbstractAction {
        public ChangeBackgroundAction () {
            super(Window.ourResources.getString("ChangeBackground"));
            putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_B, ActionEvent.SHIFT_MASK));
        }

        @Override
        public void actionPerformed (ActionEvent e) {
            int response = myChooser.showOpenDialog(null);
            if (response == JFileChooser.APPROVE_OPTION) {
                Image img;
                try {
                    img = ImageIO.read(myChooser.getSelectedFile());
                    TabView temp = (TabView) myTabbedPane.getSelectedComponent();
                    if(temp != null) {
                        temp.setBackground(img);
                    }
                }
                catch (java.io.IOException er) {
                    System.out.println(er.getMessage());
                }
            }
        }
    }
    
    protected class ToggleGridAction extends AbstractAction {
        public ToggleGridAction () {
            super(Window.ourResources.getString("ReferenceCommand"));
            putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_G, ActionEvent.SHIFT_MASK));
        }
        @Override
        public void actionPerformed (ActionEvent e) {
            TabView temp = (TabView) myTabbedPane.getSelectedComponent();
            if(temp != null) {
                temp.toggleGrid();
            }
        }
    }

    protected class ChangeTurtleAction extends AbstractAction {
        public ChangeTurtleAction () {
            super(Window.ourResources.getString("ChangeTurtle"));
            putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_T, ActionEvent.SHIFT_MASK));
        }

        @Override
        public void actionPerformed (ActionEvent e) {
            int response = myChooser.showOpenDialog(null);
            if (response == JFileChooser.APPROVE_OPTION) {
                String imgURL = myChooser.getSelectedFile().getAbsolutePath();
                TabView temp = (TabView) myTabbedPane.getSelectedComponent();
                if(temp != null) {
//                        temp.setTurtle(img);
                }
                int last = registerTurtleShape(imgURL);
                setTurtleShape(last);
            }
        }

        private void setTurtleShape (int i) {
            TabView temp = (TabView) myTabbedPane.getSelectedComponent();
            myController.processCommand(temp, "setshape " + i);
        }

        private int registerTurtleShape (String imgURL) {
            TabView temp = (TabView) myTabbedPane.getSelectedComponent();
            return (int)myController.processCommand(temp, "registershape " + imgURL);
            
        }
    }

    protected class ChangePenAction extends AbstractAction {
        public ChangePenAction () {
            super(Window.ourResources.getString("ChangePenProperties"));
            putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.SHIFT_MASK));
        }

        @Override
        public void actionPerformed (ActionEvent e) {
            PenOptionsView myPOV = new PenOptionsView();
            myPOV.display();
            updatePen(myPOV.getUserDownChoice(), myPOV.getUserThicknessChoice(), 
                      myPOV.getUserTypeChoice());
        }

        private void updatePen(boolean down, String thickness, String type) {
            TabView temp = (TabView) myTabbedPane.getSelectedComponent();
            myController.processCommand(temp, down ? "pendown" : "penup");
            myController.processCommand(temp, "setpenthickness " + thickness);
            myController.processCommand(temp, "setpentype " + type);
        }
    }
    public class PenOptionsView extends JDialog {
        private Color selectedColor;
        private boolean penDown;
        private String penThickness;
        private String penType;
        private JTabbedPane povtabbedpane;
        private JPanel otherProperties;
        private JComponent penDownUI;
        private JComponent penThicknessUI; //generalize
        private JComponent penTypeUI; // generalize
        private PenOptionsView() { 
            super(Window.this, "Choose Pen Options");
            add(povtabbedpane = new JTabbedPane());
            povtabbedpane.add(new JColorChooser(), "Color");
            povtabbedpane.add(otherProperties=new JPanel(), "Other");
            
            penDownUI = new JCheckBox("Pen Down");
            ((JCheckBox) penDownUI).setSelected(true);
            otherProperties.add(penDownUI);
            
            penTypeUI = new JPanel();
            ButtonGroup grouper = new ButtonGroup();
          //Create the radio buttons.
            JRadioButton dashed = new JRadioButton("dashed"); //edit for translation
            dashed.setActionCommand("dashed");
            dashed.setSelected(true);

            JRadioButton dotted = new JRadioButton("dotted"); //edit for translation
            dotted.setActionCommand("dotted");
            dotted.setSelected(true);

            //Group the radio buttons.
            grouper.add(dashed);
            grouper.add(dotted);
            penTypeUI.add(dashed);
            penTypeUI.add(dotted);
            

            //Register a listener for the radio buttons.
//            dashed.addActionListener(this);
//            dotted.addActionListener(this);
//        public void actionPerformed(ActionEvent e) {
//            picture.setIcon(new ImageIcon("images/" 
//                                          + e.getActionCommand() 
//                                          + ".gif"));
//        }
            otherProperties.add(penTypeUI);
            
            
            penThicknessUI = new JPanel();
            ButtonGroup grouper2 = new ButtonGroup();
          //Create the radio buttons.
            JRadioButton two = new JRadioButton("2"); //edit for translation
            dashed.setActionCommand("2");
            dashed.setSelected(true);

            JRadioButton four = new JRadioButton("4"); //edit for translation
            dotted.setActionCommand("4");
            dotted.setSelected(true);

            //Group the radio buttons.
            grouper2.add(two);
            grouper2.add(four);
            penTypeUI.add(two);
            penTypeUI.add(four);
            

            //Register a listener for the radio buttons.
//            dashed.addActionListener(this);
//            dotted.addActionListener(this);
//        public void actionPerformed(ActionEvent e) {
//            picture.setIcon(new ImageIcon("images/" 
//                                          + e.getActionCommand() 
//                                          + ".gif"));
//        }
            otherProperties.add(penThicknessUI);
        }
        
        public void display() {
            setVisible(true);
//            JColorChooser.showDialog(
//                                     Window.this,"",
//                                     Color.black);
        }
        public String getUserTypeChoice () {
            // TODO Auto-generated method stub
            return "dashed";
        }
        public String getUserThicknessChoice () {
            // TODO Auto-generated method stub
            return ""+2;
        }
        public boolean getUserDownChoice () {
            // TODO Auto-generated method stub
            return true;
        }
        
    }
}
