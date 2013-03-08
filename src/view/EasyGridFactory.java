package view;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JComponent;

public class EasyGridFactory {
<<<<<<< HEAD

    /**
     * Creates horizontal grid layout with equal sized components
     * @param parent The parent container which the children will go in
     * @param children The array of children components that will be added to the parent
     */    
=======
>>>>>>> 9671166287d04548176f62c11e4f4a9fb4211ba2
    public static void layoutHorizontal(Container parent, JComponent ... children) {
        parent.setLayout(new GridBagLayout());
        int size = children.length;
        GridBagConstraints c = new GridBagConstraints();
        configureDefault(c);
        for (int i = 0; i < size; i++) {
            c.gridx = i;
            c.gridy = 0;
            parent.add(children[i], c);
        }  
    }

<<<<<<< HEAD
    /**
     * Creates vertical grid layout with equal sized components
     * @param parent The parent container which the children will go in
     * @param children The array of children components that will be added to the parent
     */ 
=======
>>>>>>> 9671166287d04548176f62c11e4f4a9fb4211ba2
    public static void layoutVertical(Container parent, JComponent ... children) {
        parent.setLayout(new GridBagLayout());
        int size = children.length;
        GridBagConstraints c = new GridBagConstraints();
        configureDefault(c);
        for (int i = 0; i < size; i++) {
            c.gridx = 0;
            c.gridy = i;
            parent.add(children[i], c);
        }  
    }

    private static void configureDefault(GridBagConstraints c) {
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1;
        c.weighty = 1;
        c.gridwidth = 1;
        c.gridheight = 1;
    }

<<<<<<< HEAD
    /**
     * The layout for the Tab for SLogo
     * @param parent The parent component that all the other components will go into, should
     *  be a TabView
     * @param roomview The RoomView for the TabView
     * @param feedback The FeedBackView for the TabView
     * @param consoleview The ConsoleView for the TabView
     */
    public static void layoutDefaultTab(Container parent, JComponent roomview,
                                        JComponent feedback, JComponent consoleview) {
=======
    public static void layoutDefaultTab(Container parent, JComponent roomview, JComponent feedback, JComponent consoleview) {
>>>>>>> 9671166287d04548176f62c11e4f4a9fb4211ba2
        parent.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;

        c.weightx = .625;
        c.weighty = .875;
        c.gridwidth = 5;
        c.gridheight = 6;
        c.gridy = 0;
        parent.add(roomview, c);        

        c.weightx = 1;
        c.weighty = .125;
        c.gridy = 7;
        c.gridheight = 1;
        c.gridwidth = 8;
        parent.add(feedback, c);

        c.weightx = .375;
        c.weighty = .875;
        c.gridwidth = 3;
        c.gridheight = 6;
        c.gridx = 5;
        c.gridy = 0;
        parent.add(consoleview, c);
    }

<<<<<<< HEAD
    /**
     * The layout for the ConsoleView for SLogo
     * @param parent The parent component that all the other components will go into, should
     *  be a ConsoleView
     *@param clearbutton The clear button used in the view
     *@param commandarea The TextArea for view that will display entered commands
     *@param enterbutton The enter button used in the view
     *@param textfield The TextField used for the view
     */
    public static void layoutDefaultConsole(Container parent, JComponent clearbutton, 
                                            JComponent commandarea, JComponent enterbutton, 
                                            JComponent textfield) {
=======
    public static void layoutDefaultConsole(Container parent, JComponent clearbutton, JComponent commandarea, JComponent enterbutton, JComponent textfield) {
>>>>>>> 9671166287d04548176f62c11e4f4a9fb4211ba2
        parent.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        c.weightx = 1;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipadx = 50;  
        c.gridx = 0;
        c.gridy = 1;
        parent.add(textfield, c);

        c.gridx = 1;
        c.weightx = 0;
        c.fill = GridBagConstraints.NONE;
        c.ipadx = 0;
        parent.add(clearbutton, c);  

        c.gridx = 2;
        parent.add(enterbutton, c);

        c.weightx = 1;
        c.weighty = 1;
        c.fill = GridBagConstraints.BOTH;
        c.ipadx = 50; 
        c.gridwidth = 3;
        c.gridx = 0;
        c.gridy = 0;
        parent.add(commandarea, c);
    }
<<<<<<< HEAD
}
=======
}
>>>>>>> 9671166287d04548176f62c11e4f4a9fb4211ba2