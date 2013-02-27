package view;

import java.awt.event.ActionEvent;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.AbstractAction;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JSeparator;


@SuppressWarnings("serial")
public class MenuBarView extends JMenuBar {
    private JFileChooser myChooser;
    private Window myWindow;
    
    public MenuBarView(Window window) {
        myWindow = window;
        myChooser = window.getChooser();
        addComponents();
    }

    public void addComponents () {
        this.add(makeFileMenu());
    }

    @SuppressWarnings("serial")
    public JMenu makeFileMenu() {
        JMenu result = new JMenu(Window.myResources.getString("FileMenu"));
        result.add(Window.myResources.getString("SaveCommand"));
        result.add(new NewTabAction());
        result.add(new OpenFileAction());
        result.add(new JSeparator());
        result.add(Window.myResources.getString("QuitCommand"));
        return result;
    }
    
    class NewTabAction extends AbstractAction {
        public NewTabAction() {
            super(Window.myResources.getString("NewCommand"));
        }
        @Override
        public void actionPerformed (ActionEvent e) {
            myWindow.addTab();
        } 
    }
    
    class OpenFileAction extends AbstractAction {

        public OpenFileAction() {
            super(Window.myResources.getString("OpenCommand"));
        }
        @Override
        public void actionPerformed (ActionEvent e) {
            int response = myChooser.showOpenDialog(null);
            if (response == JFileChooser.APPROVE_OPTION) {
//                myWindow.addTab(response);
            }
        }
        
    }

}
