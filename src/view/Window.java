package view;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.MenuBar;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import model.Room;
import java.util.ResourceBundle;

public class Window extends JFrame {

    //TODO: Additional
    private static final String DEFAULT_RESOURCE_PACKAGE = "resources.";
    // this constant should be defined by Java, not me :( 
    private static final String USER_DIR = "user.dir";
    static final String TITLE = "SLogo"; //for default constructor
    private List<TabView> myTabs;
    private TabView activeTab;
    private MenuBar myMenuBar;
    private JFileChooser myChooser;
    public static ResourceBundle myResources;

    public Window (String title, String language) {
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myChooser = new JFileChooser(System.getProperties().getProperty(USER_DIR));
        // create and arrange sub-parts of the GUI
        myResources = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + language);
        myTabs = new ArrayList<TabView>();
        getContentPane().setLayout(new GridBagLayout());
        // add components
        addComponents();
        pack();
        setVisible(true);
    }
    
    public void addComponents() {
        getContentPane().add(new ConsoleView(), makeConsoleLayout());
        getContentPane().add(new RoomView(), makeRoomLayout());
        getContentPane().add(new StateView(), makeStateLayout());
        getContentPane().add(new ErrorLogView(), makeErrorLayout());
    }
    
    public GridBagConstraints makeConsoleLayout() {
        System.out.println("HERE1");
        GridBagConstraints c = new GridBagConstraints();
        c.weightx = .5;
        c.weighty = 1;
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 4;
        c.gridy = 0;
        c.gridwidth = 2;
        return c;
    }
    
    public GridBagConstraints makeRoomLayout() {
        GridBagConstraints c = new GridBagConstraints();
        c.weightx = 1;
        c.weighty = 1;
        c.fill = GridBagConstraints.BOTH;
        c.ipady = 10;
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 4;
        return c;
    }
    
    public GridBagConstraints makeStateLayout() {
        GridBagConstraints c = new GridBagConstraints();
        c.weightx = 1;
        c.weighty = 1;
        c.fill = GridBagConstraints.BOTH;
        c.ipady = 10;
        c.gridx = 1;
        c.gridy = 1;
        c.gridwidth = 3;
        return c;
    }
    
    public GridBagConstraints makeErrorLayout() {
        GridBagConstraints c = new GridBagConstraints();
        c.weightx = 1;
        c.weighty = 1;
        c.fill = GridBagConstraints.BOTH;
        c.ipady = 40;
        c.ipadx = 50; 
        c.gridx = 4;
        c.gridy = 1;
        c.gridwidth = 3;
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
