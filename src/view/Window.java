package view;

import java.awt.BorderLayout;
import java.awt.MenuBar;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import model.Room;

public class Window extends JFrame {

  //TODO: Additional
    static final String TITLE = "SLogo"; //for default constructor
    private List<TabView> myTabs;
    private TabView activeTab;
    private MenuBar myMenuBar;
    
    public Window (String s) {
        super(s);
        myTabs=new ArrayList<TabView>();
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
