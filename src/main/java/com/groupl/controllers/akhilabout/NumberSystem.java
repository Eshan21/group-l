package com.groupl.controllers.akhilabout;

public class NumberSystem {
    public static int gcf(int a, int b) {
        if (a%b==0) {
            return (b);
        }
        else {
            return gcf(b, a%b);
        }
    }
    public static String reducefraction(int numerator, int denominator) {
        if (numerator%denominator==0) {
            return numerator + "/" + denominator + " reduces to " + numerator/denominator;
        }
        else {
            int gcf = gcf(numerator, denominator);
            return numerator + "/" + denominator + " reduces to " + numerator/gcf + "/" + denominator/gcf;
        }
    }
}