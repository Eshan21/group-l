package com.groupl.controllers.about;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MichaelAbout {
    @GetMapping("/about/michaelabout");
    public String michaelabout() {
        return "michaelabout";
    }
}

