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
    private ActionLibrary myActionLibrary;
    
    /**
     * Constructor for MenuBarView
     * @param window the parent view that component is inside of
     */
    
    public MenuBarView(Window window) {
        myWindow = window;
        myActionLibrary = new ActionLibrary(myWindow);
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
        result.add(myActionLibrary.new NewTabAction());
        result.add(myActionLibrary.new OpenFileAction());
        result.add(myActionLibrary.new SaveFileAction());
        result.add(new JSeparator());
        result.add(myActionLibrary.new QuitAction());
        return result;
    }
    
    private JMenu makePreferencesMenu() {
        JMenu result = new JMenu(Window.getResources().getString("PreferencesMenu"));
        result.setMnemonic(KeyEvent.VK_P);
        result.add(myActionLibrary.new ChangeBackgroundAction());
        result.add(myActionLibrary.new ToggleGridAction());
        result.add(myActionLibrary.new ChangeTurtleAction());
        result.add(new JSeparator());
        result.add(myActionLibrary.new ChangePenColorAction());
        result.add(myActionLibrary.new ChangePenPropertiesAction());
        return result;
    }
    
    private JMenu makeHelpMenu() {
        JMenu result = new JMenu(Window.getResources().getString("HelpMenu"));
        result.setMnemonic(KeyEvent.VK_H);
        result.add(myActionLibrary.new WebInfoAction());
        return result;
    }
}
