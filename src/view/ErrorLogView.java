package view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import javax.swing.BorderFactory;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import model.Renderable;

@SuppressWarnings("serial")
public class ErrorLogView extends WindowView {
    private JTextArea myTextArea;
    private GridBagConstraints myConstraints;

    public ErrorLogView () {
        this.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
    }

    @Override
    public void addComponents () {
        myConstraints = new GridBagConstraints();
        myTextArea = new JTextArea();
        myTextArea.setEditable(false);
        myConstraints = new GridBagConstraints();
        JScrollPane scrollPane = new JScrollPane(myTextArea);             
        add(scrollPane, makeLayout(myConstraints));
    }

    @Override
    public GridBagConstraints configLayout(GridBagConstraints c) {
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1;
        c.weighty = 1;
        c.gridx = 1;
        c.gridy = 0;
        c.gridwidth = 1;
        c.gridheight = 1;
        return c;
    }

    protected GridBagConstraints makeLayout (GridBagConstraints c) {
        c.weightx = 1;
        c.weighty = 1;
        c.fill = GridBagConstraints.BOTH; 
        c.gridwidth = 1;
        c.gridheight = 1;
        c.gridx = 0;
        c.gridy = 0;
        return c;
    }
    public void display() {

    }

    public void render (Renderable p) {
        p.getState();
        //TODO;
    }
}
