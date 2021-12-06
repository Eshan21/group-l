package com.groupl.controllers.about;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AhkilAbout {
    @GetMapping("about/ahkilabout");
    public String ahkilabout() {
        return "ahkilabout";
    }
}

