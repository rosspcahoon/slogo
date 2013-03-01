package view;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JPanel;

/**
 * This class is responsible for refining JPanel and 
 * making it convenient to use with a specific Layout Manager
 * (it could have been called as well SLogoViewContainer)
 * It is also responsible for requiring explicitation of parent-child relations
 * 
 * @author Ross, Cahoon, Dagbedji Fagnisse
 *
 */
@SuppressWarnings("serial")
public abstract class WindowView extends JPanel {

    private GridBagConstraints myConstraints;
    private Container myParent;

    private WindowView () {
        setLayoutManager();
        initializeVariables(); 
        addComponents();
    }
    
    public Container getParent() {
        return myParent;
    }
    
    public WindowView (Container parent) {
        this();
        myParent = parent;
    }
    
    private void setLayoutManager() {
        this.setLayout(new GridBagLayout());
        myConstraints = new GridBagConstraints();
        this.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
    }
    
    /**
     * 
     * @return the constraints for this Layout
     */
    protected GridBagConstraints getConstraints() {
        return myConstraints;
    }

    /**
     * Initialize components variables instances variables 
     * - Template component used in the constructor
     */
    protected abstract void initializeVariables ();

    /**
     * Add the components initialized according to layout rules
     */
    protected abstract void addComponents ();

    public GridBagConstraints configLayout(GridBagConstraints c) {
        return new GridBagConstraints();
    }
}


