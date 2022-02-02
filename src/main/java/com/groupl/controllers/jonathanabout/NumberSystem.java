package com.groupl.controllers.jonathanabout;

import java.util.ArrayList;
import java.util.HashSet;

public class NumberSystem {
    public static HashSet factors(int a) {
        HashSet<Integer> set = new HashSet();

        for(int i = a; i > 0; i--){
            if(a % i == 0){
                set.add(i);
            }
        }

        return set;
    }

    public static int gcf(int a, int b) {
        HashSet<Integer> seta = factors(a);
        HashSet<Integer> setb = factors(b);
        ArrayList<Integer> cf = new ArrayList();

        int max = -1;

        for(int val : seta){
            if(setb.contains(val)){
                if(max < val){
                    max = val;
                }
            }
        }
        
        return max;
    }

    public static String reduceFraction(int numerator, int denominator) {
        int val = gcf(numerator, denominator);
        int newNumer = numerator / val;
        int newDenom = denominator / val;

        if (newDenom == 1) {
            return Integer.toString(newNumer);
        }

        return String.format("%s / %s", newNumer, newDenom);
    }
}

