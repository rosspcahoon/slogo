package model.command;

/**
 * Class holding keyword strings for the command structure.
 * @author james
 *
 */
public class CommandConstants {

  //commandnames(turtlecommands)
    public static final String COMMAND_NAME_FORWARD = getLiteral("COMMAND_NAME_FORWARD");
    public static final String COMMAND_NAME_BACK = getLiteral("COMMAND_NAME_BACK");
    public static final String COMMAND_NAME_LEFT = getLiteral("COMMAND_NAME_LEFT");
    public static final String COMMAND_NAME_RIGHT = getLiteral("COMMAND_NAME_RIGHT");
    public static final String COMMAND_NAME_SET_HEADING = getLiteral("COMMAND_NAME_SET_HEADING");
    public static final String COMMAND_NAME_TOWARDS = getLiteral("COMMAND_NAME_TOWARDS");
    public static final String COMMAND_NAME_SETXY = getLiteral("COMMAND_NAME_SETXY");
    public static final String COMMAND_NAME_PENDOWN = getLiteral("COMMAND_NAME_PENDOWN");
    public static final String COMMAND_NAME_PENUP = getLiteral("COMMAND_NAME_PENUP");
    public static final String COMMAND_NAME_SHOW_TURTLE = getLiteral("COMMAND_NAME_SHOW_TURTLE");
    public static final String COMMAND_NAME_HIDE_TURTLE = getLiteral("COMMAND_NAME_HIDE_TURTLE");
    public static final String COMMAND_NAME_HOME = getLiteral("COMMAND_NAME_HOME");
    public static final String COMMAND_NAME_CLEAR_SCREEN = getLiteral("COMMAND_NAME_CLEAR_SCREEN");

    //commandaliases(turtlecommands)
    public static final String COMMAND_ALIAS_FD = getLiteral("COMMAND_ALIAS_FD");
    public static final String COMMAND_ALIAS_BK = getLiteral("COMMAND_ALIAS_BK");
    public static final String COMMAND_ALIAS_LT = getLiteral("COMMAND_ALIAS_LT");
    public static final String COMMAND_ALIAS_RT = getLiteral("COMMAND_ALIAS_RT");
    public static final String COMMAND_ALIAS_SETH = getLiteral("COMMAND_ALIAS_SETH");
    public static final String COMMAND_ALIAS_GOTO = getLiteral("COMMAND_ALIAS_GOTO");
    public static final String COMMAND_ALIAS_PD = getLiteral("COMMAND_ALIAS_PD");
    public static final String COMMAND_ALIAS_PU = getLiteral("COMMAND_ALIAS_PU");
    public static final String COMMAND_ALIAS_ST = getLiteral("COMMAND_ALIAS_ST");
    public static final String COMMAND_ALIAS_HT = getLiteral("COMMAND_ALIAS_HT");
    public static final String COMMAND_ALIAS_CS = getLiteral("COMMAND_ALIAS_CS");

    //commandnames(turtlequeries)
    public static final String COMMAND_NAME_XCOR = getLiteral("COMMAND_NAME_XCOR");
    public static final String COMMAND_NAME_YCOR = getLiteral("COMMAND_NAME_YCOR");
    public static final String COMMAND_NAME_HEADING = getLiteral("COMMAND_NAME_HEADING");
    public static final String COMMAND_NAME_IS_PENDOWN = getLiteral("COMMAND_NAME_IS_PENDOWN");
    public static final String COMMAND_NAME_IS_SHOWING = getLiteral("COMMAND_NAME_IS_SHOWING");

    //commandaliases(turtlequeries)
    public static final String COMMAND_ALIAS_PENDOWN_P = getLiteral("COMMAND_ALIAS_PENDOWN_P");
    public static final String COMMAND_ALIAS_SHOWING_P = getLiteral("COMMAND_ALIAS_SHOWING_P");

    //commandnames(math)
    public static final String COMMAND_NAME_SUM = getLiteral("COMMAND_NAME_SUM");
    public static final String COMMAND_NAME_DIFFERENCE = getLiteral("COMMAND_NAME_DIFFERENCE");
    public static final String COMMAND_NAME_PRODUCT = getLiteral("COMMAND_NAME_PRODUCT");
    public static final String COMMAND_NAME_QUOTIENT = getLiteral("COMMAND_NAME_QUOTIENT");
    public static final String COMMAND_NAME_REMAINDER = getLiteral("COMMAND_NAME_REMAINDER");
    public static final String COMMAND_NAME_MINUS = getLiteral("COMMAND_NAME_MINUS");
    public static final String COMMAND_NAME_RANDOM = getLiteral("COMMAND_NAME_RANDOM");

    //commandaliases(math)
    public static final String COMMAND_ALIAS_SUM = getLiteral("COMMAND_ALIAS_SUM");
    public static final String COMMAND_ALIAS_DIFFERENCE = getLiteral("COMMAND_ALIAS_DIFFERENCE");
    public static final String COMMAND_ALIAS_PRODUCT = getLiteral("COMMAND_ALIAS_PRODUCT");
    public static final String COMMAND_ALIAS_QUOTIENT = getLiteral("COMMAND_ALIAS_QUOTIENT");
    public static final String COMMAND_ALIAS_REMAINDER = getLiteral("COMMAND_ALIAS_REMAINDER");
    public static final String COMMAND_ALIAS_MINUS = getLiteral("COMMAND_ALIAS_MINUS");

    //commandnames(booleans)
    public static final String COMMAND_NAME_IS_LESS = getLiteral("COMMAND_NAME_IS_LESS");
    public static final String COMMAND_NAME_IS_GREATER = getLiteral("COMMAND_NAME_IS_GREATER");
    public static final String COMMAND_NAME_IS_EQUAL = getLiteral("COMMAND_NAME_IS_EQUAL");
    public static final String COMMAND_NAME_IS_NOT_EQUAL = getLiteral("COMMAND_NAME_IS_NOT_EQUAL");
    public static final String COMMAND_NAME_AND = getLiteral("COMMAND_NAME_AND");
    public static final String COMMAND_NAME_OR = getLiteral("COMMAND_NAME_OR");
    public static final String COMMAND_NAME_NOT = getLiteral("COMMAND_NAME_NOT");

    //commandaliases(booleans)
    public static final String COMMAND_ALIAS_IS_LESS = getLiteral("COMMAND_ALIAS_IS_LESS");
    public static final String COMMAND_ALIAS_IS_GREATER = getLiteral("COMMAND_ALIAS_IS_GREATER");
    public static final String COMMAND_ALIAS_IS_EQUAL = getLiteral("COMMAND_ALIAS_IS_EQUAL");
    public static final String COMMAND_ALIAS_IS_NOT_EQUAL = getLiteral("COMMAND_ALIAS_IS_NOT_EQUAL");

    //commandnames(control)
    public static final String COMMAND_NAME_LIST_OPEN = getLiteral("COMMAND_NAME_LIST_OPEN");
    public static final String COMMAND_NAME_LIST_CLOSE = getLiteral("COMMAND_NAME_LIST_CLOSE");
    public static final String COMMAND_NAME_VARIABLE_START = getLiteral("COMMAND_NAME_VARIABLE_START");
    public static final String COMMAND_NAME_MAKE = getLiteral("COMMAND_NAME_MAKE");
    public static final String COMMAND_NAME_REPEAT = getLiteral("COMMAND_NAME_REPEAT");
    public static final String COMMAND_NAME_IF = getLiteral("COMMAND_NAME_IF");
    public static final String COMMAND_NAME_IFELSE = getLiteral("COMMAND_NAME_IFELSE");
    public static final String COMMAND_NAME_TO = getLiteral("COMMAND_NAME_TO");

    //commandaliases(control)
    public static final String COMMAND_ALIAS_SET = getLiteral("COMMAND_ALIAS_SET");
    
    // command names (extended)
    public static final String COMMAND_NAME_SET_BACKGROUND = getLiteral("COMMAND_NAME_SET_BACKGROUND");
    public static final String COMMAND_NAME_SET_PEN_COLOR = getLiteral("COMMAND_NAME_SET_PEN_COLOR");
    public static final String COMMAND_NAME_SET_PEN_SIZE = getLiteral("COMMAND_NAME_SET_PEN_SIZE");
    public static final String COMMAND_NAME_SET_PEN_TYPE = getLiteral("COMMAND_NAME_SET_PEN_TYPE");
    public static final String COMMAND_NAME_SET_SHAPE = getLiteral("COMMAND_NAME_SET_SHAPE");
    public static final String COMMAND_NAME_REGISTER_SHAPE = getLiteral("COMMAND_NAME_REGISTER_SHAPE");
    public static final String COMMAND_NAME_REGISTER_COLOR = getLiteral("COMMAND_NAME_REGISTER_COLOR");
    public static final String COMMAND_NAME_SET_PALETTE = getLiteral("COMMAND_NAME_SET_PALETTE");
    public static final String COMMAND_NAME_PEN_COLOR = getLiteral("COMMAND_NAME_PEN_COLOR");
    public static final String COMMAND_NAME_SHAPE = getLiteral("COMMAND_NAME_SHAPE");
    public static final String COMMAND_NAME_STAMP = getLiteral("COMMAND_NAME_STAMP");
    public static final String COMMAND_NAME_CLEAR_STAMPS = getLiteral("COMMAND_NAME_CLEAR_STAMPS");
    public static final String COMMAND_NAME_DOTIMES = getLiteral("COMMAND_NAME_DOTIMES");
    public static final String COMMAND_NAME_FOR = getLiteral("COMMAND_NAME_FOR");
    
    // command aliases (extended)
    public static final String COMMAND_ALIAS_SET_BACKGROUND = getLiteral("COMMAND_ALIAS_SET_BACKGROUND");
    public static final String COMMAND_ALIAS_SET_PEN_COLOR = getLiteral("COMMAND_ALIAS_SET_PEN_COLOR");
    public static final String COMMAND_ALIAS_SET_PEN_SIZE = getLiteral("COMMAND_ALIAS_SET_PEN_SIZE");
    public static final String COMMAND_ALIAS_SET_PEN_TYPE = getLiteral("COMMAND_ALIAS_SET_PEN_TYPE");
    public static final String COMMAND_ALIAS_SET_SHAPE = getLiteral("COMMAND_ALIAS_SET_SHAPE");
    public static final String COMMAND_ALIAS_PEN_COLOR = getLiteral("COMMAND_ALIAS_PEN_COLOR");
    public static final String COMMAND_ALIAS_SHAPE = getLiteral("COMMAND_ALIAS_SHAPE");
    
    // command names (misc support)
    public static final String COMMAND_NAME_LAST_SHAPE_INDEX = getLiteral("COMMAND_NAME_LAST_SHAPE_INDEX");
    public static final String COMMAND_NAME_LAST_PEN_COLOR_INDEX = getLiteral("COMMAND_NAME_LAST_PEN_COLOR_INDEX");
    
    // command arg numbers
    public static final int COMMAND_EXPECTED_ARGS_ZERO = 0;
    public static final int COMMAND_EXPECTED_ARGS_ONE = 1;
    public static final int COMMAND_EXPECTED_ARGS_TWO = 2;
    public static final int COMMAND_EXPECTED_ARGS_THREE = 3;
    public static final int COMMAND_EXPECTED_ARGS_FOUR = 4;
    
    // command result ints
    public static final int COMMAND_RETURN_TRUE = 1;
    public static final int COMMAND_RETURN_FALSE = 0;
    
    // keywords used by commands
    public static final String COMMAND_REPEAT_COUNT_VAR_NAME = ":repcount";
    public static final String COMMAND_SETTER_LAST_ITEM = "last";
    
    private static String getLiteral(String s) {
        return CommandLibrary.getLiteral(s);
    }

}
