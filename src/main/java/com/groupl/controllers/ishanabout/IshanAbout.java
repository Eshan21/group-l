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
    @GetMapping("/about/ishanabout")
    public String ishanabout() {
        return "about/ishanabout";
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
