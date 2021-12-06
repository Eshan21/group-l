package com.groupl.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Temptation {
    @GetMapping("/temp")
    public String temp() {
        return "temp";
    }
}

