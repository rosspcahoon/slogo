package model.command;

import java.util.Scanner;

/**
 * The class managing the command tree structure. Responsible for scanning
 * the input and creating the command tree, then executing the commands in
 * the newly created tree.
 * Successor to the CommandLibrary.java class.
 * @author james
 *
 */
public class CommandManager {

    private CommandNode myCurrentRoot;
    private String myCurrentInput;
    private int myCurrentResult;
    private Scanner myScanner;
    
    /**
     * Initializes the CommandManager's instance variables and builds its
     * command and alias libraries.
     */
    public CommandManager() {
        myCurrentRoot = null;
        myCurrentInput = null;
        myCurrentResult = -1;
        myScanner = null;
    }
    
    /**
     * Takes the given input and creates the appropriate command tree, then
     * executes the command and returns the result.
     * @param input
     */
    public int process(String input) {
        //TODO: finish implementing
        myCurrentInput = input;
        myScanner = new Scanner(myCurrentInput);
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
        //TODO: finish implementing
        String rootString = myScanner.next();
        rootString = rootString.toLowerCase();
        myCurrentRoot = CommandLibrary.getCommandNode(rootString);
        myCurrentRoot.setUp(myScanner);
    }
    
    /**
     * Executes the command tree appropriately.
     */
    private void executeTree() {
        //TODO: implement
        myCurrentResult = myCurrentRoot.resolve();
    }
    
    /**
     * Cleans up the tree after command execution.
     */
    private void cleanTree() {
        myScanner.close();
        myCurrentRoot = null;
        myCurrentInput = null;
        myCurrentResult = -1;
        myScanner = null;
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
    
//    public static void main(String[] args) {
//        CommandManager test = new CommandManager();
//        test.process("fd random sum 50 10");
//        System.out.println();
//        test.process("bk quotient product random 50 10 sum random 30 minus 10");
//        System.out.println();
//        test.process("bk / * random 50 10 + random 30 ~ 10");
//        System.out.println();
//        test.process("pENdoWn?");
//        System.out.println();
//    }
}
