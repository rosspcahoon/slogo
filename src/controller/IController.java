package controller;

import java.util.Observable;
import view.TabView;
import model.Room;

public interface IController {
    
    abstract void update (Observable o, Object arg);
    
    abstract void update(Room r);
    
    abstract void update(TabView t, Object arg);

}
