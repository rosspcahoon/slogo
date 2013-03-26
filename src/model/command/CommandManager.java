package model.command;

import java.util.ResourceBundle;
import java.util.Scanner;
import model.Room;

/**
 * The class managing the command tree structure. Responsible for scanning
 * the input and creating the command tree, then executing the commands in
 * the newly created tree.
 * Successor to the old CommandLibrary.java class.
 * @author james
 *
 */
public class CommandManager {

    private CommandNode myCurrentRoot;
    private String myCurrentInput;
    private String myCurrentError;
    private int myCurrentResult;
    private Room myCurrentRoom;
    private Scanner myCurrentScanner;
    
    /**
     * For language translation.
     */
    private static ResourceBundle ourResources;
    private static final String DEFAULT_RESOURCE_PACKAGE = "resources.";
    
    /**
     * Initializes the CommandManager's instance variables and builds its
     * command and alias libraries.
     * @param language 
     */
    public CommandManager(String language) {
        myCurrentRoot = null;
        myCurrentInput = null;
        myCurrentResult = -1;
        myCurrentScanner = null;
        myCurrentRoom = null;
        myCurrentError = null;
        
        //translation 
        ourResources = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + language);
        CommandLibrary.loadResources(ourResources);
    }
    
    /**
     * Takes the given input and creates the appropriate command tree, then
     * executes the command and returns the result.
     * @param input
     */
    public int process(Room room, String input) {
        System.out.println(input);
        myCurrentInput = input;
        myCurrentScanner = new Scanner(myCurrentInput);
        myCurrentRoom = room;
        CommandLibrary.loadVariableLibrary(room);
        CommandLibrary.loadCommandLibrary(room);
        try {
            createTree();
//            printTree();
            executeTree();
//            System.out.printf("CommandManager resolve got %d\n", myCurrentResult);
            cleanTree();
        } catch (Exception e) {
            myCurrentError = e.getMessage();            
//            System.err.println("CommandManager caught exception with message: " + myCurrentError);
//            e.printStackTrace();
            room.getState().setErrorMessage(myCurrentError);
        }
        CommandLibrary.addUserVariableLibraryToRoomStatus(room);
        CommandLibrary.addCommandLibraryToRoomStatus(room);
        return myCurrentResult;
    }
    
    /**
     * Creates the command tree from the input string.
     */
    private void createTree() throws Exception {
        String rootString = myCurrentScanner.next();
        rootString = rootString.toLowerCase();
        myCurrentRoot = CommandLibrary.getCommandNode(rootString);
        myCurrentRoot.setUp(myCurrentScanner, myCurrentRoom, rootString);
        if (myCurrentScanner.hasNext()) {
            throw new Exception("Error parsing command -- input has too many elements or is badly formed");
        }
    }
    
    /**
     * Executes the command tree appropriately.
     */
    private void executeTree() throws Exception {
        myCurrentResult = myCurrentRoot.resolve();
    }
    
    /**
     * Cleans up the tree after command execution.
     */
    private void cleanTree() {
        myCurrentScanner.close();
        myCurrentRoot = null;
        myCurrentInput = null;
        myCurrentResult = -1;
        myCurrentScanner = null;
    }
    
    /**
     * Gets the current room.
     */
    public Room getCurrentRoom() {
        return myCurrentRoom;
    }
    
    /**
     * Prints out the tree. For debugging purposes.
     */
    private void printTree() {
        printNode(myCurrentRoot);
    }
    
    /**
     * Prints out node and its children. For debugging purposes.
     */
    private void printNode(CommandNode n) {
        System.out.println(n);
        for (CommandNode child : n.getChildren()) {
            printNode(child);
        }
    }

}
