package com.groupl.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Birds {
    @GetMapping("/birds")
    public String birds() {
        return "birds";
    }
}

