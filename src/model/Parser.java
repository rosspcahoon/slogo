package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Parser {

    public Parser() {

    }

    public List<String> parseString(String input) {
        ArrayList<String> parsedString = new ArrayList<String>();
        input.trim();
        String temp = input;
        int spaceIndex = input.indexOf(' ');
        while(spaceIndex > 0) {
            parsedString.add(temp.substring(0, spaceIndex));
            temp = temp.substring(spaceIndex);
            spaceIndex = temp.indexOf(' ');
        }
        return parsedString;
    }
}