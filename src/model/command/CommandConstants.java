package model.command;

/**
 * Class holding keyword strings for the command structure.
 * @author james
 *
 */
public class CommandConstants {

    // command names (turtle commands)
    public static final String COMMAND_NAME_FORWARD = "forward";
    public static final String COMMAND_NAME_BACK = "back";
    public static final String COMMAND_NAME_LEFT = "left";
    public static final String COMMAND_NAME_RIGHT = "right";
    public static final String COMMAND_NAME_SET_HEADING = "setheading";
    public static final String COMMAND_NAME_TOWARDS = "towards";
    public static final String COMMAND_NAME_SETXY = "setxy";
    public static final String COMMAND_NAME_PENDOWN = "pendown";
    public static final String COMMAND_NAME_PENUP = "penup";
    public static final String COMMAND_NAME_SHOW_TURTLE = "showturtle";
    public static final String COMMAND_NAME_HIDE_TURTLE = "hideturtle";
    public static final String COMMAND_NAME_HOME = "home";
    public static final String COMMAND_NAME_CLEAR_SCREEN = "clearscreen";
    
    // command aliases (turtle commands)
    public static final String COMMAND_ALIAS_FD = "fd";
    public static final String COMMAND_ALIAS_BK = "bk";
    public static final String COMMAND_ALIAS_LT = "lt";
    public static final String COMMAND_ALIAS_RT = "rt";
    public static final String COMMAND_ALIAS_SETH = "seth";
    public static final String COMMAND_ALIAS_GOTO = "goto"; 
    public static final String COMMAND_ALIAS_PD = "pd";
    public static final String COMMAND_ALIAS_PU = "pu";
    public static final String COMMAND_ALIAS_ST = "st";
    public static final String COMMAND_ALIAS_HT = "ht";
    public static final String COMMAND_ALIAS_CS = "cs";
    
    // command names (turtle queries)
    public static final String COMMAND_NAME_XCOR = "xcor";
    public static final String COMMAND_NAME_YCOR = "ycor";
    public static final String COMMAND_NAME_HEADING = "heading";
    public static final String COMMAND_NAME_IS_PENDOWN = "pendown?";
    public static final String COMMAND_NAME_IS_SHOWING = "showing?";
    
    // command aliases (turtle queries)
    public static final String COMMAND_ALIAS_PENDOWN_P = "pendownp";
    public static final String COMMAND_ALIAS_SHOWING_P = "showingp";
    
    // command names (math)
    public static final String COMMAND_NAME_SUM = "sum";
    public static final String COMMAND_NAME_DIFFERENCE = "difference";
    public static final String COMMAND_NAME_PRODUCT = "product";
    public static final String COMMAND_NAME_QUOTIENT = "quotient";
    public static final String COMMAND_NAME_REMAINDER = "remainder";
    public static final String COMMAND_NAME_MINUS = "minus";
    public static final String COMMAND_NAME_RANDOM = "random";
    
    // command aliases (math)
    public static final String COMMAND_ALIAS_SUM = "+";
    public static final String COMMAND_ALIAS_DIFFERENCE = "-";
    public static final String COMMAND_ALIAS_PRODUCT = "*";
    public static final String COMMAND_ALIAS_QUOTIENT = "/";
    public static final String COMMAND_ALIAS_REMAINDER = "%";
    public static final String COMMAND_ALIAS_MINUS = "~";
    
    // command names (booleans)
    public static final String COMMAND_NAME_IS_LESS = "less?";
    public static final String COMMAND_NAME_IS_GREATER = "greater?";
    public static final String COMMAND_NAME_IS_EQUAL = "equal?";
    public static final String COMMAND_NAME_IS_NOT_EQUAL = "notequal?";
    public static final String COMMAND_NAME_AND = "and";
    public static final String COMMAND_NAME_OR = "or";
    public static final String COMMAND_NAME_NOT = "not";
    
    // command aliases (booleans)
    public static final String COMMAND_ALIAS_IS_LESS = "lessp";
    public static final String COMMAND_ALIAS_IS_GREATER = "greaterp";
    public static final String COMMAND_ALIAS_IS_EQUAL = "equalp";
    public static final String COMMAND_ALIAS_IS_NOT_EQUAL = "notequalp";

    // command names (control)
    public static final String COMMAND_NAME_LIST_OPEN = "[";
    public static final String COMMAND_NAME_LIST_CLOSE = "]";
    public static final String COMMAND_NAME_VARIABLE_START = ":";
    public static final String COMMAND_NAME_MAKE = "make";
    public static final String COMMAND_NAME_REPEAT = "repeat";
    public static final String COMMAND_NAME_IF = "if";
    public static final String COMMAND_NAME_IFELSE = "ifelse";
    public static final String COMMAND_NAME_TO = "to";
    
    // command aliases (control)
    public static final String COMMAND_ALIAS_SET = "set";
    
    // command arg numbers
    public static final int COMMAND_EXPECTED_ARGS_ZERO = 0;
    public static final int COMMAND_EXPECTED_ARGS_ONE = 1;
    public static final int COMMAND_EXPECTED_ARGS_TWO = 2;
    public static final int COMMAND_EXPECTED_ARGS_THREE = 3;
    
    // command result ints
    public static final int COMMAND_RETURN_TRUE = 1;
    public static final int COMMAND_RETURN_FALSE = 0;

}
