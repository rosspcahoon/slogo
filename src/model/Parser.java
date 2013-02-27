package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Parser {

    public Parser() {

    }

    public String[] parseString(String input) {
        input.trim();
        String[] output = input.split(" ");
        return output;
        
    }
}