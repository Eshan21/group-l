package com.groupl.controllers.ahkilabout;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AkhilAbout {
    @GetMapping("about/akhilabout")
    public String ahkilabout() {
        return "about/akhilabout";
    }
}

