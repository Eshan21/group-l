package com.groupl.controllers.akhilabout;

import com.groupl.controllers.ishanabout.IshanAbout;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

@Controller
public class AkhilAbout {
    HashMap<String[], String> Comments = new HashMap<>();

    @GetMapping("about/akhilabout")
    public String akhilabout(Model model) {
        model.addAttribute("Comments", Comments);
        return "about/akhilabout";
    }

    @GetMapping("about/akhilabout/Unit2FRQQuestion1PartE")
    public String Wk1Q1Pe(@RequestParam(name="oldSeq", required=false, defaultValue="amongus") String oldSeq,
                          @RequestParam(name="segment", required=false, defaultValue="am") String segment,
                          Model model) {
        String newSeq = "";

        newSeq = IshanAbout.getString(oldSeq, segment, newSeq);
        model.addAttribute("newSeq", newSeq);
        model.addAttribute("Comments", Comments);
        System.out.println("Sequence: " + newSeq);
        return "about/akhilabout";
    }

    @GetMapping("about/akhilabout/Unit4FRQQuestion1")
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
        return "about/akhilabout";
    }

    @GetMapping("about/akhilabout/Unit4FRQQuestion2PartA")
    public String getPlayer2Move(@RequestParam(name="round", required=false, defaultValue="0") int round,
                                 Model model) {
        int output;
        if (round % 3 == 0) {output = 3;}
        else if (round % 2 == 0) {output = 2;}
        else {output = 1;}
        model.addAttribute("Player2Input", round);
        model.addAttribute("Player2Move", output);
        return "about/akhilabout";
    }

    @PostMapping("about/akhilabout/Unit5FRQQuestion2-1")
    @ResponseBody
    public String PasswordGenerate1(@RequestParam(name="len", required=false, defaultValue="0") int len,
                                 Model model) {
        return PasswordGenerator.PasswordGenerator(len);
    }
    
    @PostMapping("about/akhilabout/Unit5FRQQuestion2-2")
    @ResponseBody
    public String PasswordGenerate2(@RequestParam(name="len", required=false, defaultValue="0") int len,
                                    @RequestParam(name="prefix", required=false, defaultValue="0") String prefix,
                                    Model model) {
        return PasswordGenerator.PasswordGenerator(len, prefix);
    }

        
    @PostMapping("about/akhilabout/comment")
    public String postComment(@RequestParam(name="name", required = false) String name,
                              @RequestParam(name="content", required = false) String content,
                              Model model) {
        if (name == null) {
            name = "Anonymous Commenter";
        }
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        Comments.put(new String[]{name, dtf.format(now)}, content);
        model.addAttribute("Comments", Comments);
        return "about/akhilabout";
    }
}

class PasswordGenerator {
    private static int count;
    
    public static String PasswordGenerator(int len) {
        String password = "A.";
        for (int ii=0;ii<len;ii++) {
            password += (int) (Math.random() *10);
        }
        return password;
    }
    public static String PasswordGenerator(int len, String prefix) {
        String password = prefix + ".";
        for (int ii=0;ii<len;ii++) {
            password += (int) (Math.random() *10);
        }
        return password;
    }
    public static int pwCount() {
        return count;
    }
}