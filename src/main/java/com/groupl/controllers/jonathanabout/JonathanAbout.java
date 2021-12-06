package com.groupl.controllers.about;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class JonathanAbout {
    @GetMapping("/about/jonathanabout");
    public String jonathanabout() {
        return "jonathanabout";
    }
}

