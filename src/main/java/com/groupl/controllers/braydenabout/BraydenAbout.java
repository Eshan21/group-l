package com.groupl.controllers.braydenabout;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

@Controller
public class BraydenAbout {
    @GetMapping("/about/braydenabout")
    public String braydenabout(Model model) {
        return "about/braydenabout";
    }

    @GetMapping("/about/braydenabout/frq2014")
    public String braydenaboutfrq2014(Model model) {
        return "brayden2014FRQ";
    }
}

