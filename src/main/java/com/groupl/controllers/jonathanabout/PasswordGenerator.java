package com.groupl.controllers.jonathanabout;

import java.math.BigDecimal;
import java.math.BigInteger;

public class PasswordGenerator {
    private static int genCount;
    private String prefix;
    private int numlen;

    public PasswordGenerator(String prefix, int numlen) {
        this.prefix = prefix;
        this.numlen = numlen;
    }

    public PasswordGenerator(int numlen) {
        this.prefix = "A";
        this.numlen = numlen;
    }

    public String getPrefix() {
        return this.prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public int getNumlen() {
        return this.numlen;
    }

    public void setNumlen(int numlen) {
        this.numlen = numlen;
    }

    public static int genCount() {
        return genCount;
    }

    public String pwGen() {
        if (this.numlen == 0) {
            return String.format("%s.", prefix);
        }
        BigInteger randInt = BigInteger.ZERO;

        int blocks = this.numlen / 16;
        for (int i = 1; i <= blocks + 1; i++) {
            BigInteger randPart = BigDecimal.valueOf(Math.random())
                                            .multiply(BigDecimal.TEN.pow(16 * i))
                                            .toBigInteger();
            randInt = randInt.add(randPart);
        }

        randInt = randInt.divide(BigInteger.TEN.pow(16 - (this.numlen % 16)));

        System.out.println(randInt);

        this.genCount++;

        return String.format("%s.%d", prefix, randInt);
    }
}


