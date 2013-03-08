package model.command;

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
    private int myCurrentResult;
    private Room myCurrentRoom;
    private Scanner myCurrentScanner;
    
    /**
     * Initializes the CommandManager's instance variables and builds its
     * command and alias libraries.
     */
    public CommandManager() {
        myCurrentRoot = null;
        myCurrentInput = null;
        myCurrentResult = -1;
        myCurrentScanner = null;
        myCurrentRoom = null;
    }
    
    /**
     * Takes the given input and creates the appropriate command tree, then
     * executes the command and returns the result.
     * @param input
     */
    public int process(Room room, String input) {
        myCurrentInput = input;
        myCurrentScanner = new Scanner(myCurrentInput);
        myCurrentRoom = room;
        createTree();
//        printTree();
        executeTree();
        System.out.printf("CommandManager resolve got %d\n", myCurrentResult);
        cleanTree();
        return -1;
    }
    
    /**
     * Creates the command tree from the input string.
     */
    private void createTree() {
        String rootString = myCurrentScanner.next();
        rootString = rootString.toLowerCase();
        myCurrentRoot = CommandLibrary.getCommandNode(rootString);
        myCurrentRoot.setUp(myCurrentScanner);
        if (myCurrentScanner.hasNext()) {
            //TODO: throw bad input error
        }
    }
    
    /**
     * Executes the command tree appropriately.
     */
    private void executeTree() {
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
    
    public static void main(String[] args) {
        CommandManager test = new CommandManager();
        test.process(null, "if random 2 [ fd 50 rt 30 ]");
        System.out.println();
        test.process(null, "ifelse random 2 [ fd 50 rt 30 ] [ bk sum 10 random 5 ]");
        System.out.println();
        test.process(null, "repeat random 5 [ fd 50 ]");
        System.out.println();
    }
}
