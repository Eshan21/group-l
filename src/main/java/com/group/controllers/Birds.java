package com.group.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

public class Birds {
    @GetMapping("/birds")
    public String birds() {
        return "birds";
    }
}

