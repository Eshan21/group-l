package com.groupl.controllers.ahkilabout;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
public class AkhilAbout {
    HashMap<String[], String> Comments = new HashMap<>();

    @GetMapping("about/akhilabout")
    public String akhilabout(Model model) {
        model.addAttribute("Comments", Comments);
        return "about/akhilabout";
    }

    @GetMapping("about/akhilabout/Wk1Q1Pe")
    public String Wk1Q1Pe(@RequestParam(name="oldSeq", required=false, defaultValue="amongus") String oldSeq,
                          @RequestParam(name="segment", required=false, defaultValue="am") String segment,
                          Model model) {
        String newSeq = "";

        for (int ii=0; ii<=oldSeq.length()-segment.length(); ii++) {
            if (oldSeq.substring(ii, ii + segment.length()).equals(segment)) {
                newSeq = oldSeq.substring(0, ii) + oldSeq.substring(ii + segment.length(), oldSeq.length());
                break;
            }
        }
        model.addAttribute("newSeq", newSeq);
        model.addAttribute("Comments", Comments);
        System.out.println("Sequence: " + newSeq);
        return "about/akhilabout";
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


