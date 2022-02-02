package com.groupl.controllers.jonathanabout;

import java.util.ArrayList;

public class WordParse {
    public static Object[] parse(String[] words) {
        ArrayList<String> res = new ArrayList<String>();

        for (String word : words) {
            int len = word.length();
            if (len >= 3) {
                if (word.substring(len - 3).equals("ing")) {
                    res.add(word);
                    System.out.println("Added '" + word + "'");
                }
            }
        }
        
        return res.toArray();
    }
}

