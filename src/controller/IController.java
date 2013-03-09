package controller;

import java.util.Observable;
import view.TabView;
import model.Room;

/**
 * interface for the controller in slogo
 * @author mp
 *
 */
public interface IController {
    
    /**
     * update for observable objects
     * @param o
     * @param arg
     */
    abstract void update (Observable o, Object arg);
    
//    abstract void update(Room r);
    
//    abstract void update(TabView t, Object arg);

}
