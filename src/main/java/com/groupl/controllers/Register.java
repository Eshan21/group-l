package com.groupl.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Register {
    @GetMapping("/register")
    public String register_page() {
        return "register";
    }

    @PostMapping("/register")
    public String register(@RequestParam String username,
                           @RequestParam String password) {
        System.out.println("Recieved username: " + username + 
                           ", password: " + password);

        return "register";
    }
}

