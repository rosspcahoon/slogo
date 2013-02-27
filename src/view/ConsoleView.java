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


@SuppressWarnings("serial")
public class ConsoleView extends WindowView {
    private TabView myTabView;
    private JTextField myTextField; 
    private JTextArea myCommandField;
    private Stack<String> myCommandsHistory;
    private Stack<String> historyBrowserHelper;
    private GridBagConstraints myConstraints;
    private Dimension mySize = new Dimension(300,700);

    public ConsoleView () {
        this.setPreferredSize(mySize);
        this.setMinimumSize(mySize);
        this.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        myCommandsHistory = new Stack<String>();
        historyBrowserHelper = new Stack<String>();
    }

    public void addComponents () {
        myConstraints = new GridBagConstraints();
        add(myTextField = new JTextField(), makeTextLayout(myConstraints));
        myTextField.addActionListener(new GetCommandInputAction());
        myTextField.addKeyListener(new CommandsHistoryListener());
        add(makeClear(), makeClearLayout(myConstraints));
        add(makeSubmit(), makeEnterLayout(myConstraints));
        add(myCommandField = new JTextArea(), makeCommandLayout(myConstraints));
        myCommandField.setEditable(false);
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

    public void resyncCommandsHistory() {
        while (!historyBrowserHelper.isEmpty()) {
            myCommandsHistory.push(historyBrowserHelper.pop());
        }
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
    
    protected JButton makeSubmit () {
        JButton result = new JButton(Window.myResources.getString("ActionCommand"));
        result.addActionListener(new GetCommandInputAction());
        return result;
    }
    
    private class GetCommandInputAction implements ActionListener {

        @Override
        public void actionPerformed (ActionEvent e) {
            String result= myTextField.getText();
            if (result != "") {
                resyncCommandsHistory();
                myCommandsHistory.add(result);
    //            process(result);
                myTextField.setText("");
                myCommandField.append(result+"\n");
                myCommandField.setCaretPosition(myCommandField.getText().length());
            }
        }
        
    }
    
    private class CommandsHistoryListener implements KeyListener {

        @Override
        public void keyTyped (KeyEvent e) {
            
        }

        @Override
        public void keyPressed (KeyEvent e) {
            if (e.getKeyCode()==KeyEvent.VK_UP && !myCommandsHistory.isEmpty()) {
                String s = myCommandsHistory.pop();
                historyBrowserHelper.push(s);
                myTextField.setText(s);
            }
            if (e.getKeyCode()==KeyEvent.VK_DOWN && !historyBrowserHelper.isEmpty()) {
                String s =historyBrowserHelper.pop();
                myCommandsHistory.push(s);
                myTextField.setText(s);
            }
            
        }

        @Override
        public void keyReleased (KeyEvent e) {
            // TODO Auto-generated method stub
            
        }
        
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


