package view;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public abstract class WindowView extends JPanel {

    public WindowView () {
        this.setLayout(new GridBagLayout());
        this.setBorder(BorderFactory.createEmptyBorder(5,5,5,5)); 
        addComponents();
    }

    public void addComponents () {
    }

    public static GridBagConstraints configLayout(GridBagConstraints c) {
        return new GridBagConstraints();
    }
}


