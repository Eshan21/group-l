package com.groupl.controllers.about;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IshanAbout {
    @GetMapping("/about/ishanabout")
    public String ishanabout() {
        return "ishanabout";
    }
}

