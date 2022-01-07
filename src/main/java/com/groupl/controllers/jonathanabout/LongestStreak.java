package com.groupl.controllers.jonathanabout;

import java.util.ArrayList;
import java.util.List;

class LongestStreak {
    static String longestStreak(String str) {
        char prev = 'a';
        ArrayList<Character> charr = new ArrayList<Character>();
        ArrayList<Integer> chcount = new ArrayList<Integer>();
        ArrayList<Character> chtype = new ArrayList<Character>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (c != prev && i != 0) {
                chcount.add(charr.size());
                chtype.add(charr.get(0));
                charr.clear();
                prev = c;
            }

            charr.add(c);
        }

        int max = 0;
        char max_ch = 'a';
        for (int i = 0; i < chcount.size(); i++) {
            int val = chcount.get(i);
            if (val > max) {
                max = val;
                max_ch = chtype.get(i);
            }
        }
        
        if (max > 0) {
            return String.format("Char: %c, Length: %d", max_ch, max);
        } else {
            return "No valid characters found";
        }
    }
}

