package com.groupl.controllers.ishanabout;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;
import java.util.Scanner;

@Controller
public class IshanAbout {
    double computeBonusThreshold;

    @GetMapping("/about/ishanabout")
    public String ishanabout() {
        return "about/ishanabout";
    }


    @PostMapping("about/ishanabout/Unit4Frq2a")
    @ResponseBody
    public int Unit4Frq2a(@RequestParam(name="round", required=false, defaultValue="0") int round,
                          Model model) {
        return com.groupl.controllers.ishanabout.Unit4Frq2.a(round);
    }

    @PostMapping("about/ishanabout/Unit5Frq1a")
    @ResponseBody
    public String Unit5Frq1a(@RequestParam(name="hostname", required=false, defaultValue="0") String hostname,
                             Model model) {
        return com.groupl.controllers.ishanabout.Unit5Frq1.getHostName(hostname);
    }

    @PostMapping("about/ishanabout/Unit5Frq1b")
    @ResponseBody
    public String Unit5Frq1b(@RequestParam(name="address", required=false, defaultValue="0") String address,
                             Model model) {
        return com.groupl.controllers.ishanabout.Unit5Frq1.setAddress(address);
    }

    @PostMapping("about/ishanabout/Unit5Frq1c")
    @ResponseBody
    public String Unit5Frq1c(@RequestParam(name="person", required=false, defaultValue="0") String person,
                             Model model) {
        return com.groupl.controllers.ishanabout.Unit5Frq1.invite(person);
    }

    @PostMapping("about/ishanabout/Unit5Frq1d")
    @ResponseBody
    public String Unit5Frq1d(@RequestParam(name="address", required=false, defaultValue="0") String address,
                             Model model) {
        com.groupl.controllers.ishanabout.Unit5Frq1.invitation(address);
        return "Object initialized";
    }

    @PostMapping("about/ishanabout/Unit5FRQQuestion2-1")
    @ResponseBody
    public String PasswordGenerate1(@RequestParam(name="len", required=false, defaultValue="0") int len,
                                    Model model) {
        return PasswordGenerator.PasswordGenerator(len);
    }

    @PostMapping("about/ishanabout/Unit5FRQQuestion2-2")
    @ResponseBody
    public String PasswordGenerate2(@RequestParam(name="len", required=false, defaultValue="0") int len,
                                    @RequestParam(name="prefix", required=false, defaultValue="0") String prefix,
                                    Model model) {
        return PasswordGenerator.PasswordGenerator(len, prefix);
    }

    @PostMapping("about/ishanabout/Unit5FRQQuestion2-3")
    @ResponseBody
    public int PasswordGenerate3(Model model) {
        return PasswordGenerator.pwCount();
    }

    @GetMapping("about/ishanabout/Wk1Q1Pe")
    public String Wk1Q1Pe(@RequestParam(name="oldSeq", required=false, defaultValue="") String oldSeq,
                          @RequestParam(name="segment", required=false, defaultValue="") String segment,
                          @RequestParam(name="longestChar", required=false, defaultValue="") String longestChar,
                          Model model) {
        String newSeq = "";
        oldSeq = oldSeq + " ";
        segment = segment + " ";

        newSeq = getString(oldSeq, segment, newSeq);

        String[] longChar = Frq4(longestChar);

        String[] passwords = new String[8];
        int k = 0;
        for (String i : passwords) {
            passwords[k] = passGen();
            k++;
        }


        model.addAttribute("passwords", passwords);
        model.addAttribute("newSeq", newSeq);
        model.addAttribute("longestChar", longChar);
        return "about/ishanabout";
    }

    @GetMapping("about/ishanabout/Unit4FRQQuestion1")
    public String longestStreak(@RequestParam(name="str", required=false, defaultValue="amongus") String str,
                                Model model){
        int longestCount = 0;
        String longestChar = null;
        int currentCount = 1;
        String currentChar = null;
        String prevChar = null;
        int start = 0;
        int end = 0;
        for (int ii=0;ii<str.length();ii++) {
            currentChar = String.valueOf(str.charAt(ii));
            if (ii>0){prevChar = String.valueOf(str.charAt(ii-1));}
            if (currentChar.equals(prevChar)) {
                currentCount++;
                if (currentCount > longestCount) {
                    longestChar = currentChar;
                    longestCount = currentCount;
                }
            }
            else {
                currentCount = 1;
                currentChar = null;
            }
        }
        model.addAttribute("Unit4Q2Input", str);
        model.addAttribute("Unit4Q2Output", longestChar + " " + longestCount);
        return "about/ishanabout";
    }

    @PostMapping("about/ishanabout/Unit6Frq1")
    @ResponseBody
    public String Unit6Frq1(@RequestParam(name="words", required=false, defaultValue="0") String wordsString) {
        String[] words = wordsString.split(",");
        String output = "";
        for (String ii : words) {
            if (ii.substring(ii.length()-3, ii.length()).equals("ing")) {
                output += (ii + ", ");
            }
        }
        return output;

    }
    @PostMapping("about/ishanabout/Unit6Frq2a")
    @ResponseBody
    public double Unit6Frq2a(@RequestParam(name="items", required=false, defaultValue="0") String itemsSoldString) {
        int emoloyeeCount = itemsSoldString.split(",").length;
        int[] itemsSold = new int[emoloyeeCount];
        for (int ii=0;ii<emoloyeeCount;ii++) {
            itemsSold[ii] += Integer.parseInt(itemsSoldString.split(",")[ii]);
        }

        int total = 0;
        double threshold = 0.0;
        int lowest = 0;
        int greatest = 0;
        for (int ii : itemsSold) {
            total += ii;
            if (lowest == 0 || ii<lowest) {lowest = ii;}
            if (ii>greatest) {greatest = ii;}
        }

        threshold = ((double) (total-(greatest+lowest)))/((double) itemsSold.length-2);
        computeBonusThreshold = threshold;
        return threshold;
    }

    @PostMapping("about/ishanabout/Unit6Frq2b")
    @ResponseBody
    public String Unit6Frq2b(@RequestParam(name="items", required=false, defaultValue="0") String itemsSoldString,
                             @RequestParam(name="fixedWage", required=false, defaultValue="0") double fixedWage,
                             @RequestParam(name="perItemWage", required=false, defaultValue="0") double perItemWage) {
        int emoloyeeCount = itemsSoldString.split(",").length;
        int[] itemsSold = new int[emoloyeeCount];
        double[] wages = new double[emoloyeeCount];
        for (int ii=0;ii<emoloyeeCount;ii++) {
            itemsSold[ii] += Integer.parseInt(itemsSoldString.split(",")[ii]);
        }
        double wage = fixedWage;
        for (int ii=0;ii<itemsSold.length;ii++) {
            wage += itemsSold[ii]*1.5;
            if (((double) itemsSold[ii]) > computeBonusThreshold) {
                wage*=1.1;
            }
            wages[ii] = wage;
            wage = 10.0;
        }

        String output = "";
        for (double ii : wages) {
            output += ((Math.floor(ii*100)/100) + ", ");
        }
        return output;
    }


    public static String getString(@RequestParam(name = "oldSeq", required = false, defaultValue = "") String oldSeq, @RequestParam(name = "segment", required = false, defaultValue = "") String segment, String newSeq) {
        for (int ii=0; ii<=oldSeq.length()-segment.length(); ii++) {
            if (oldSeq.substring(ii, ii + segment.length()).equals(segment)) {
                newSeq = oldSeq.substring(0, ii) + oldSeq.substring(ii + segment.length(), oldSeq.length());
                break;
            }
        }
        return newSeq;
    }

    public static String[] Frq4(String input) {
            //Scanner s = new Scanner(System.in);
            //System.out.println("Enter input: ");
            //String input = s.nextLine();



            int startInd = 0, endInd = 0, streak = 0, highStreak = 0, fsI = 0, feI = 0;
            char character = 'x';
            for (int i = 1; i < input.length(); i++) {
                if (input.charAt(i) == input.charAt(i-1)) {
                    streak++;
                    if (i+1 == input.length() ) {
                        endInd = i;
                        highStreak = streak;
                        character = input.charAt(i);
                        fsI = startInd;
                    }
                } else {

                    if (streak > highStreak){
                        highStreak = streak;
                        streak = 0;
                        character = input.charAt(i-1);
                        fsI = startInd;
                        feI = endInd;
                    } else streak = 0;
                    startInd = i;
                    endInd = i-1;
                }
            }

            String[] output = new String[4];
            output[0] = String.valueOf(fsI);
            output[1] = String.valueOf(feI);
            output[2] = String.valueOf(highStreak);
            output[3] = String.valueOf(character);
            return output;

    }

    protected String password = "";
    protected String specialChar = "!@#?";

    Random r = new Random();

    public String passGen() {
        password += (int) (Math.random() * 10000);
        password += rndChar();
        password += rndChar();
        password += rndChar();
        password += specialChar.charAt(r.nextInt(specialChar.length()));
        return password;
    }

    private static char rndChar() {
        int rnd = (int) (Math.random() * 52); // or use Random or whatever
        char base = (rnd < 26) ? 'A' : 'a';
        return (char) (base + rnd % 26);

    }


}

class Unit5Frq1 {
    private static String hostName;
    private static String address;

    public static String getHostName(String newHostName) {
        hostName = newHostName;
        return hostName;
    }
    public static String setAddress(String newAddress) {
        address = newAddress;
        return address;
    }
    public static String invite(String person) {
        return "Dear " + person + ", please attend my event at " + address + ". See you then, " + hostName + ".";
    }
    public static void invitation(String newAddress) {
        address = newAddress;
        hostName = "Host";
    }
}

class Unit4Frq2 {
    public static int a(int round) {
        int output;
        if (round % 3 == 0) {output = 3;}
        else if (round % 2 == 0) {output = 2;}
        else {output = 1;}
        return output;
    }
    public static String b(int maxRounds, int startingCoins) {
        int currentRound = 0;
        int player1Coins = startingCoins;
        int player2Coins = startingCoins;
        String output = "";
        while (currentRound <= maxRounds && player1Coins > 3 && player2Coins > 3) {
            player1Coins -= 2;
            player2Coins -= a(currentRound);
            currentRound++;
        }
        if (player1Coins > player2Coins) {output = "player 1 wins";}
        else if (player2Coins > player1Coins) {output = "player 2 wins";}
        else if (player2Coins == player1Coins) {output = "tie";}
        return output;
    }
}

class PasswordGenerator {
    private static int count;

    public static String PasswordGenerator(int len) {
        String password = "A.";
        for (int ii=0;ii<len;ii++) {
            password += (int) (Math.random() *10);
        }
        count++;
        return password;
    }
    public static String PasswordGenerator(int len, String prefix) {
        String password = prefix + ".";
        for (int ii=0;ii<len;ii++) {
            password += (int) (Math.random() *10);
        }
        count++;
        return password;
    }
    public static int pwCount() {
        return count;
    }
}

class MineSweeper {
    private int width = 10;
    private int height = 10;
    int[][] field = new int[width][height];
    private int difficulty = 0;
    private int mineCount = (int) ((double) width*height/10-difficulty);
    Random r = new Random();

    private int[][] createField () {
        int[][] temp = new int[width][height];
        int move = 0;
        for (int i = 0; i < mineCount; i++) {
            move = r.nextInt(width*height);
            temp[move/width][move%width] = -1;
        }

        return temp;
    }


}