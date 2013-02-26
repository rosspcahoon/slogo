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

    public MenuBarView(JFileChooser chooser) {
        myChooser = chooser;
        addComponents();
    }

    public void addComponents () {
        this.add(makeFileMenu());
    }

    @SuppressWarnings("serial")
    public JMenu makeFileMenu() {
        JMenu result = new JMenu(Window.myResources.getString("FileMenu"));
        result.add(Window.myResources.getString("SaveCommand"));
        result.add(Window.myResources.getString("NewCommand"));
//        {
//            public void actionPerformed (ActionEvent e) {
//                try {
//                    int response = myChooser.showOpenDialog(null);
//                    if (response == JFileChooser.APPROVE_OPTION) {
//                    }
//                }
//                catch (IOException io) {
//                }
//            }
//        };
        result.add(Window.myResources.getString("OpenCommand"));
        result.add(new JSeparator());
        result.add(Window.myResources.getString("QuitCommand"));
        return result;
    }

}
