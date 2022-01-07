package com.groupl.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Login {
    @GetMapping("/login")
    public String login_page() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password) {
        System.out.println("Recieved username: " + username +
                           ", password: " + password);

        return "home";
    }
}

