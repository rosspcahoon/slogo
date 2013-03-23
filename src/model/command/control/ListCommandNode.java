package model.command.control;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import model.Room;
import model.command.CommandConstants;
import model.command.CommandLibrary;
import model.command.CommandNode;

/**
 * Command node representing the contents of a list as defined by brackets.
 * @author james
 *
 */
public class ListCommandNode extends CommandNode {

    public ListCommandNode() {
        super();
    }
    
    @Override
    public CommandNode getCopyOfInstance () {
        return new ListCommandNode();
    }

    @Override
    public int resolve () throws Exception {
        List<CommandNode> children = super.getChildren();
        int result = 0;
        for (CommandNode child : children) {
            result = child.resolve();
        }
//        System.out.printf("Executed command list with final command returning %d\n", result);
        return result;
    }
    
    /**
     * Override the default setUp method in CommandNode. Because ListCommandNode is
     * not initialized with the knowledge of how many children it will have, we must
     * create its children until we encounter its end.
     */
    @Override
    public void setUp(Scanner s, Room r) throws Exception {
        setMyRoom(r);
        int expected = 0;
        String nextString;
        try {
            nextString = s.next();
        } catch (NoSuchElementException e) {
            throw new Exception("Error parsing command -- bracketed list contents badly formed");
        }
        while (!nextString.equals(CommandConstants.COMMAND_NAME_LIST_CLOSE)) {           
            System.out.println("nextString: " + nextString);
            nextString = nextString.toLowerCase();
            CommandNode nextNode = CommandLibrary.getCommandNode(nextString);
            addChild(nextNode);
            nextNode.setUp(s, r);
            expected++;
            try {
                nextString = s.next();
            } catch (NoSuchElementException e) {
                throw new Exception("Error parsing command -- bracketed list not closed with \"" + 
                        CommandConstants.COMMAND_NAME_LIST_CLOSE + "\"");
            }
        } 
        super.setMyExpectedArgs(expected);
    }

}
