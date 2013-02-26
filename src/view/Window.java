package view;

import java.awt.BorderLayout;
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
    private JMenuBar myMenuBar;
    private JFileChooser myChooser;
    private FeedbackView myFeedbackView;
    private ConsoleView myConsoleView;
    private RoomView myRoomView;
    private GridBagConstraints myConstraints;
    public static ResourceBundle myResources;
    private JPanel panel1;
    private JPanel panel3;
    

    public Window (String title, String language) {
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myChooser = new JFileChooser(System.getProperties().getProperty(USER_DIR));
        // create and arrange sub-parts of the GUI
        myResources = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + language);
        //tabs
        myTabs = new ArrayList<TabView>();
        getContentPane().setLayout(new GridBagLayout());
        // add components
        createPage1();
        createPage3();
        
        addComponents();
        pack();
        setVisible(true);
    }
    
    
    public GridBagConstraints getConstraints() {
        return myConstraints;
    }
    
    public void addComponents() {
        getContentPane().add(myMenuBar=new JMenuBar());
        configMenu();
        myTabbedPane = new JTabbedPane();
        myTabbedPane.addTab("Tab 1", new TabView(2, this));
        myTabbedPane.addTab("Tab 2", new TabView(3, this));
        getContentPane().add(myTabbedPane, configLayout());
//        getContentPane().add(myConsoleView = new ConsoleView(), myConsoleView.configLayout(myConstraints));
//        getContentPane().add(myRoomView = new RoomView(), myRoomView.configLayout(myConstraints));
//        getContentPane().add(myFeedbackView = new FeedbackView(), myFeedbackView.configLayout(myConstraints));
    }      
     private void configMenu () {
         JMenu menu = new JMenu("File");
         myMenuBar.add(menu);
         JMenuItem openFile = new JMenuItem("Open File");
         openFile.getAccessibleContext().setAccessibleDescription(
                 "This doesn't really do anything");
         menu.add(menu);
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
    public void createPage1()
    {
            panel1 = new JPanel();
            panel1.setLayout( null );

            JLabel label1 = new JLabel( "Username:" );
            label1.setBounds( 10, 15, 150, 20 );
            panel1.add( label1 );

            JTextField field = new JTextField();
            field.setBounds( 10, 35, 150, 20 );
            panel1.add( field );

            JLabel label2 = new JLabel( "Password:" );
            label2.setBounds( 10, 60, 150, 20 );
            panel1.add( label2 );

            JPasswordField fieldPass = new JPasswordField();
            fieldPass.setBounds( 10, 80, 150, 20 );
            panel1.add( fieldPass );
    }
    
    public void createPage3()
    {
            panel3 = new JPanel();
            panel3.setLayout( new GridLayout( 2, 1 ) );

            panel3.add( new JLabel( "Field 1:" ) );
            panel3.add( new TextArea() );
            panel3.add( new JLabel( "Field 2:" ) );
            panel3.add( new TextArea() );
            panel3.add( new JLabel( "Field 3:" ) );
            panel3.add( new TextArea() );
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
