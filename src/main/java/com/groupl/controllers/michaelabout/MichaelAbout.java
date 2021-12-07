package com.groupl.controllers.about;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class MichaelAbout {
    @GetMapping("/about/michaelabout")
    public String michaelabout(Model model) {
        return "about/michaelabout";
    }
}

