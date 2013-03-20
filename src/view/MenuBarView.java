package view;


import java.awt.event.KeyEvent;
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
    
    /**
     * Constructor for MenuBarView
     * @param window the parent view that component is inside of
     */
    
    public MenuBarView(Window window) {
        myWindow = window;
        addComponents();
    }

    private void addComponents () {
        this.add(makeFileMenu());
        this.add(makePreferencesMenu());
        this.add(makeHelpMenu());
    }

    private JMenu makeFileMenu() {
        JMenu result = new JMenu(Window.getResources().getString("FileMenu"));
        result.setMnemonic(KeyEvent.VK_F);
        result.add(myWindow.new NewTabAction());
        result.add(myWindow.new OpenFileAction());
        result.add(myWindow.new SaveFileAction());
        result.add(new JSeparator());
        result.add(myWindow.new QuitAction());
        return result;
    }
    
    private JMenu makePreferencesMenu() {
        JMenu result = new JMenu(Window.getResources().getString("PreferencesMenu"));
        result.setMnemonic(KeyEvent.VK_P);
        result.add(myWindow.new ChangeBackgroundAction());
        result.add(myWindow.new ToggleGridAction());
        result.add(myWindow.new ChangeTurtleAction());
        result.add(myWindow.new ChangePenAction());
        return result;
    }
    
    private JMenu makeHelpMenu() {
        JMenu result = new JMenu(Window.getResources().getString("HelpMenu"));
        result.setMnemonic(KeyEvent.VK_H);
        result.add(myWindow.new WelcomeAction());
        return result;
    }
}
