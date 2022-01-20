package com.groupl.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminPanel {
    @GetMapping("/adminPanel")
    public String AdminPanel() {
        return "adminPanel";
    }
}

