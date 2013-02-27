package view;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;
import java.util.Stack;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * This class is responsible for handling user-input for a given SLogo environment.
 * @author Ross Cahoon, Dagbedji Fagnisse
 *
 */
@SuppressWarnings("serial")
public class ConsoleView extends WindowView {
    
    private class CommandsHistoryListener implements KeyListener {

        @Override
        public void keyPressed (KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_UP && !myCommandsHistory.isEmpty()) {
                String s = myCommandsHistory.pop();
                myHistoryBrowsingHelper.push(s);
                myTextField.setText(s);
            }
            if (e.getKeyCode() == KeyEvent.VK_DOWN && !myHistoryBrowsingHelper.isEmpty()) {
                String s = myHistoryBrowsingHelper.pop();
                myCommandsHistory.push(s);
                myTextField.setText(s);
            }
            
        }

        @Override
        public void keyReleased (KeyEvent e) {
           
        }

        @Override
        public void keyTyped (KeyEvent e) {
            
        }
        
    }
    private class GetCommandInputAction implements ActionListener {

        @Override
        public void actionPerformed (ActionEvent e) {
            String result = myTextField.getText();
            if (!result.equals("")) {
                resyncCommandsHistory();
                myCommandsHistory.add(result);
                process(result);
                myTextField.setText("");
                myCommandField.append(result + "\n");
                myCommandField.setCaretPosition(myCommandField.getText().length());
            }
        }
        
    }
    public static final int WIDTH = 300;
    public static final int HEIGHT = 700;
    public static final int BORDER_WIDTH = 5; 
    private TabView myTabView;
    private JTextField myTextField;
    private JTextArea myCommandField;
    private Stack<String> myCommandsHistory;
    private Stack<String> myHistoryBrowsingHelper;

    private GridBagConstraints myConstraints;
    
    private Dimension mySize = new Dimension(WIDTH, HEIGHT);


    /**
     * Default constructor
     * @param tab - container for this ConsoleView
     */
    public ConsoleView (TabView tab) {
        super(tab);
        this.setPreferredSize(mySize);
        this.setMinimumSize(mySize);
        this.setBorder(BorderFactory.createEmptyBorder(BORDER_WIDTH, 
                                                       BORDER_WIDTH, BORDER_WIDTH, BORDER_WIDTH));
    }
    
    @Override
    protected void addComponents () {
        add(myTextField, makeTextLayout(myConstraints));
        add(makeClear(), makeClearLayout(myConstraints));
        add(makeSubmit(), makeEnterLayout(myConstraints));
        add(myCommandField, makeCommandLayout(myConstraints));
    }

    @Override
    public GridBagConstraints configLayout(GridBagConstraints c) {
        double [] weightdata = {.375, .875};
        int [] griddata = {3, 6, 5, 0};
        editGridBagConstraints(c, GridBagConstraints.BOTH , weightdata, griddata );
        return c;
    }
    
    public void editGridBagConstraints (GridBagConstraints c, int fill, double[] weight_xy, int[] grid_whxy) {
        c.fill = fill;
        c.weightx = weight_xy[0];
        c.weighty = weight_xy[1];
        c.gridwidth = grid_whxy[0];
        c.gridheight = grid_whxy[1];
        c.gridx = grid_whxy[2];
        c.gridy = grid_whxy[3];
    }
    
    @Override
    protected void initializeVariables () {
        myConstraints = new GridBagConstraints();
        myTextField = new JTextField();
        myTextField.addActionListener(new GetCommandInputAction());
        myTextField.addKeyListener(new CommandsHistoryListener());
        myCommandField = new JTextArea();
        myCommandField.setEditable(false);
        myCommandsHistory = new Stack<String>();
        myHistoryBrowsingHelper = new Stack<String>();
    }
    
    protected JButton makeClear () {
        JButton result = new JButton(Window.myResources.getString("ClearCommand"));
        result.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e) {
                myTextField.setText("");
            }
        });
        return result;
    }
    
    protected GridBagConstraints makeClearLayout(GridBagConstraints c) {
        //c.fill = GridBagConstraints.BOTH;
        //c.weightx = 0.5;
        c.gridx = 1;
        c.gridy = 1;
        return c;        
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

    protected GridBagConstraints makeEnterLayout (GridBagConstraints c) {
        //  c.fill = GridBagConstraints.BOTH;
        //c.weightx = 0.5;
        c.gridx = 2;
        c.gridy = 1;
        return c;
    }

    protected JButton makeSubmit () {
        JButton result = new JButton(Window.myResources.getString("ActionCommand"));
        result.addActionListener(new GetCommandInputAction());
        return result;
    }

    protected GridBagConstraints makeTextLayout (GridBagConstraints c) {
        c.weightx = 1;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipadx = 50;  
        c.gridx = 0;
        c.gridy = 1;
        return c;
    }

    private void process (String result) {
        ((TabView) getParent()).processConsoleInput(result);
    }

    /**
     * Used when done browsing history (using arrow up/down)
     */
    protected void resyncCommandsHistory() {
        while (!myHistoryBrowsingHelper.isEmpty()) {
            myCommandsHistory.push(myHistoryBrowsingHelper.pop());
        }
    }
}


