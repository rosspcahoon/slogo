package view;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;


@SuppressWarnings("serial")
public class ConsoleView extends WindowView {
    private JTextField myTextField; 
    private JTextArea myCommandField;
    private List<String> myCommandsHistory;
    private GridBagConstraints myConstraints;
    private Dimension mySize = new Dimension(300,700);

    public ConsoleView () {
        this.setPreferredSize(mySize);
        this.setMinimumSize(mySize);
        this.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
    }

    public void addComponents () {
        myConstraints = new GridBagConstraints();
        add(myTextField = new JTextField(), makeTextLayout(myConstraints));
        add(new JButton(Window.myResources.getString("ClearCommand")), makeClearLayout(myConstraints));
        add(new JButton(Window.myResources.getString("ActionCommand")), makeEnterLayout(myConstraints));
        add(myCommandField = new JTextArea(), makeCommandLayout(myConstraints));
    }

    @Override
    public GridBagConstraints configLayout(GridBagConstraints c) {
        c.fill = GridBagConstraints.BOTH;
        c.weightx = .375;
        c.weighty = .875;
        c.gridwidth = 3;
        c.gridheight = 6;
        c.gridx = 5;
        c.gridy = 0;
        return c;
    }

    public void updateCommandDisplay() {

    }

    public String getCommandInput() {
        return "";
    }

    public void saveCommandInput() {
        // a bit unsure abt this
    }

    protected GridBagConstraints makeCommandLayout (GridBagConstraints c) {
        c.weightx = 1;
        c.weighty = 1;
        c.fill = GridBagConstraints.BOTH;
        c.ipadx = 50; 
        c.gridwidth = 3;
        c.gridx = 0;
        c.gridy = 0;
        return c;
    }

    protected GridBagConstraints makeTextLayout (GridBagConstraints c) {
        c.weightx = 1;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipadx = 50;  
        c.gridx = 0;
        c.gridy = 1;
        return c;
    }

    public GridBagConstraints makeClearLayout(GridBagConstraints c) {
        //c.fill = GridBagConstraints.BOTH;
        //c.weightx = 0.5;
        c.gridx = 1;
        c.gridy = 1;
        return c;        
    }

    public GridBagConstraints makeEnterLayout (GridBagConstraints c) {
        //  c.fill = GridBagConstraints.BOTH;
        //c.weightx = 0.5;
        c.gridx = 2;
        c.gridy = 1;
        return c;
    }
}


