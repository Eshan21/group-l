package com.groupl.controllers.akhilabout;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AkhilAbout {
    @GetMapping("about/akhilabout")
    public String akhilabout() {
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
        System.out.println("Sequence: " + newSeq);
        return "about/akhilabout";
    }
}


