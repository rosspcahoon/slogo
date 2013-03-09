package view;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JPanel;

/**
 * This class is responsible for refining JPanel and 
 * making it convenient to use with a specific Layout Manager
 * (it could have been called as well SLogoViewContainer)
 * It is also responsible for requiring explicitation of parent-child relations
 * 
 * @author Ross Cahoon, Dagbedji Fagnisse
 *
 */
@SuppressWarnings("serial")
public abstract class WindowView extends JPanel {

    private GridBagConstraints myConstraints;
    private Container myParent;

    private WindowView () {
        setLayoutManager();
        myConstraints = new GridBagConstraints();
        this.setBorder(ViewConstants.DEFAULT_BORDER);
        initializeVariables(); 
        addComponents();
    }
    
    
    /**
     * Constructor for WindowView
     * @param parent the parent of the View being created
     */
    public WindowView (Container parent) {
        this();
        myParent = parent;
    }
    
    /**
     * Returns the parent component of this component
     */    
    public Container getParent() {
        return myParent;
    }

    
    private void setLayoutManager() {
        this.setLayout(new GridBagLayout());
        myConstraints = new GridBagConstraints();
        this.setBorder(ViewConstants.DEFAULT_BORDER);
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
     * - Template step used in the constructor
     */
    protected abstract void initializeVariables ();

    /**
     * Add the components previously initialized according to layout rules
     * - Template step used in the constructor
     */
    protected abstract void addComponents ();
}


