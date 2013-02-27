package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.MenuBar;
import java.awt.TextArea;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javax.swing.AbstractAction;
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
    private JTabbedPane myTabbedPane;
    private JMenuBar myMenuBar;
    private JFileChooser myChooser;
    private GridBagConstraints myConstraints;
    public static ResourceBundle myResources;
    private Dimension mySize = new Dimension(1200,700);    

    public Window (String title, String language, Controller controller) {
        super(title);
        this.setResizable(false);
        setPreferredSize(mySize);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // create and arrange sub-parts of the GUI
        myResources = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + language);
        myController=controller;
        myChooser = new JFileChooser(System.getProperties().getProperty(USER_DIR));
        //tabs
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
    private void addTab() {
        myController.newSLogoSession();
    }

    protected void addComponents() {
        setJMenuBar(myMenuBar=new MenuBarView(this));
        getContentPane().add(myTabbedPane=new JTabbedPane(), configLayout());
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

    /**
     * Open the provided file in a new tab
     * @param file2open
     */
    private void openFile (File file2open) {
        //TODO use the
    }

    private void quit () {
        WindowEvent close = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(close);
    }

    private void saveFile () {
        // TODO Auto-generated method stub
        
    }
    
    protected class NewTabAction extends AbstractAction {
        public NewTabAction() {
            super(Window.myResources.getString("NewCommand"));
        }
        @Override
        public void actionPerformed (ActionEvent e) {
            addTab();
        } 
    }
    
    protected class OpenFileAction extends AbstractAction {

        public OpenFileAction() {
            super(Window.myResources.getString("OpenCommand"));
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
            super(Window.myResources.getString("QuitCommand"));
        }

        @Override
        public void actionPerformed (ActionEvent e) {
            quit();
        }
    }
    
    protected class SaveFileAction extends AbstractAction {
        public SaveFileAction () {
            super(Window.myResources.getString("SaveCommand"));
        }

        @Override
        public void actionPerformed (ActionEvent e) {
            saveFile();
        }
    }
    
    protected class WelcomeAction extends AbstractAction {
        WelcomeAction() {
            super(Window.myResources.getString("WelcomeCommand"));
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
}
