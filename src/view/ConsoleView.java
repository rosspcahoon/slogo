package view;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.List;
import java.util.ResourceBundle;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class ConsoleView extends JPanel {
    private JTextField myTextField; 


    public ConsoleView () {
        make(this);
    }
    private List<String> myCommandsHistory;

    public void updateCommandDisplay() {

    }

    public String getCommandInput() {
        return "";
    }

    public void saveCommandInput() {
        // a bit unsure abt this
    }

    public JPanel make(JPanel result) {// name something better
        result.setLayout(new GridBagLayout());
        result.add(myTextField = new JTextField(), makeTextLayout());
        result.add(new JButton(Window.myResources.getString("ClearCommand")), makeClearLayout());
        result.add(new JButton(Window.myResources.getString("ActionCommand")), makeEnterLayout());
        return result;
    }

    protected GridBagConstraints makeTextLayout () {
        GridBagConstraints c = new GridBagConstraints(); 
        c.weightx = 0.5;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipadx = 50;  
        c.gridx = 0;
        c.gridy = 1;
        return c;
    }

    public GridBagConstraints makeClearLayout() {
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 1;
        c.gridy = 1;
        return c;        
    }

    public GridBagConstraints makeEnterLayout() {
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 2;
        c.gridy = 1;
        return c;
    }
}


