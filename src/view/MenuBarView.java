package view;


import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JSeparator;


/**
 * This class is responsible for setting up the menu bar for a specific window.
 * @author Ross Cahoon, Dagbedji Fagnisse
 *
 */
@SuppressWarnings("serial")
public class MenuBarView extends JMenuBar {
    private Window myWindow;
    
    public MenuBarView(Window window) {
        myWindow = window;
        addComponents();
    }

    private void addComponents () {
        this.add(makeFileMenu());
        this.add(makeHelpMenu());
    }

    private JMenu makeFileMenu() {
        JMenu result = new JMenu(Window.myResources.getString("FileMenu"));
        result.add(myWindow.new NewTabAction());
        result.add(myWindow.new OpenFileAction());
        result.add(myWindow.new SaveFileAction());
        result.add(new JSeparator());
        result.add(myWindow.new QuitAction());
        return result;
    }
    
    private JMenu makeHelpMenu() {
        JMenu result = new JMenu(Window.myResources.getString("HelpMenu"));
        result.add(myWindow.new WelcomeAction());
        return result;
    }
    

}
