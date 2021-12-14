package com.groupl.controllers;

import org.springframework.web.bind.annotation.GetMapping;

public class Draw {
    @GetMapping("/draw")   // GET request
    public String draw() {
        return "draw";
    }
}
