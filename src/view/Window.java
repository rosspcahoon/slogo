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
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Window extends JFrame {

    //TODO: Additional
    private static final String DEFAULT_RESOURCE_PACKAGE = "resources.";
    // this constant should be defined by Java, not me :( 
    private static final String USER_DIR = "user.dir";
    static final String TITLE = "SLogo"; //for default constructor
    private List<TabView> myTabs;
    private TabView activeTab;
    private JTabbedPane myTabbedPane;
    private MenuBar myMenuBar;
    private JFileChooser myChooser;
    private FeedbackView myFeedbackView;
    private ConsoleView myConsoleView;
    private RoomView myRoomView;
    private GridBagConstraints myConstraints;
    public static ResourceBundle myResources;
    private JPanel panel1;
    private JPanel panel3;
    private Dimension mySize = new Dimension(1200,800);    

    public Window (String title, String language) {
        super(title);
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
    
    public void addComponents() {
        setJMenuBar(new MenuBarView());
        myTabbedPane = new JTabbedPane();
        myTabbedPane.addTab("Tab 1", new TabView(2, this));
        myTabbedPane.addTab("Tab 2", new TabView(3, this));
        getContentPane().add(myTabbedPane, configLayout());
    }      
    
     public GridBagConstraints configLayout() {
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
    
    public void openFile() {

    }

    public void saveFile() {

    }

    public void newFile() {

    }


    public void quit() {

    }

    //    public void add (TabView t) {
    //        myTabs.add(t);
    //        getContentPane().add(t, BorderLayout.CENTER);
    //    }
}
