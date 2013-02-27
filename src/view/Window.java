package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.MenuBar;
import java.awt.TextArea;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import controller.Controller;

@SuppressWarnings("serial")
public class Window extends JFrame {

    //TODO: Additional
    private static final String DEFAULT_RESOURCE_PACKAGE = "resources.";
    // this constant should be defined by Java, not me :( 
    private static final String USER_DIR = "user.dir";
    static final String TITLE = "SLogo"; //for default constructor
    private Controller myController;
    private List<TabView> myTabs;
    private TabView activeTab;
    private JTabbedPane myTabbedPane;
    private JMenuBar myMenuBar;
    private JFileChooser myChooser;
    private GridBagConstraints myConstraints;
    public static ResourceBundle myResources;
    private Dimension mySize = new Dimension(1200,700);    

    public Window (String title, String language, Controller controller) {
        super(title);
        myController=controller;
        this.setResizable(false);
        setPreferredSize(mySize);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myChooser = new JFileChooser(System.getProperties().getProperty(USER_DIR));
        // create and arrange sub-parts of the GUI
        myResources = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + language);
        //tabs
        myTabs = new ArrayList<TabView>();
        getContentPane().setLayout(new GridBagLayout());       
        addComponents();
        pack();
        setVisible(true);
    }    

    public GridBagConstraints getConstraints() {
        return myConstraints;
    }
    
    /**
     * Way to initialize tab creation from the window
     */
    public void addTab() {
        myController.newSLogoSession();
    }

    protected void addComponents() {
        setJMenuBar(myMenuBar=new MenuBarView(this));
        configMenu();
        getContentPane().add(myTabbedPane=new JTabbedPane(), configLayout());
    }
 
     private void configMenu () {
         JMenu menu = new JMenu("File");
         myMenuBar.add(menu);
         JMenuItem openFile = new JMenuItem("Open File");
         openFile.getAccessibleContext().setAccessibleDescription(
                 "This doesn't really do anything");
         menu.add(menu);
    }


    private GridBagConstraints configLayout() {
         GridBagConstraints c = new GridBagConstraints();
         c.fill = GridBagConstraints.BOTH;
         c.weightx = 1;
         c.weighty = 1;
         c.gridwidth = 1;
         c.gridheight = 1;
         c.gridx = 0;
         c.gridy = 0;
         return c;
     }

//    public void add (TabView t) {
//        myTabs.add(t);
//        myTabbedPane.addTab(t, configTabLayout());
//    }
    
    private GridBagConstraints configTabLayout() {
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1;
        c.weighty = 1;
        c.gridwidth = 1;
        c.gridheight = 1;
        c.gridx = 0;
        c.gridy = 0;
        return c;
    }
    
    public void addTab (TabView tab) {
        myTabbedPane.addTab("Tab"+tab.getID(), tab);
    }

    public JFileChooser getChooser () {
        return myChooser;
    }
}
