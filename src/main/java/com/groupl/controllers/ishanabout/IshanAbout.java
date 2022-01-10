package com.groupl.controllers.ishanabout;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Scanner;

@Controller
public class IshanAbout {
    @GetMapping("/about/ishanabout")
    public String ishanabout() {
        return "about/ishanabout";
    }

    @GetMapping("about/ishanabout/Wk1Q1Pe")
    public String Wk1Q1Pe(@RequestParam(name="oldSeq", required=false, defaultValue="") String oldSeq,
                          @RequestParam(name="segment", required=false, defaultValue="") String segment,
                          @RequestParam(name="longestChar", required=false, defaultValue="") String longestChar,
                          Model model) {
        String newSeq = "";
        oldSeq = oldSeq + " ";
        segment = segment + " ";

        for (int ii=0; ii<=oldSeq.length()-segment.length(); ii++) {
            if (oldSeq.substring(ii, ii + segment.length()).equals(segment)) {
                newSeq = oldSeq.substring(0, ii) + oldSeq.substring(ii + segment.length(), oldSeq.length());
                break;
            }
        }

        String[] longChar = Frq4(longestChar);

        model.addAttribute("newSeq", newSeq);
        model.addAttribute("longestChar", longChar);
        return "about/ishanabout";
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

}

