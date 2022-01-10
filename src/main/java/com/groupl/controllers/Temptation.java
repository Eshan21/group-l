package com.groupl.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.ArrayList;

@Controller
public class Temptation {
    HashMap<String[], String> Comments = new HashMap<>();
    public int score = 0;
    ArrayList<String> images = new ArrayList<String>();

    @GetMapping("/temp")
    public String temp(Model model) {
        model.addAttribute("Comments", Comments);
        model.addAttribute("score", score);
        model.addAttribute("images", images);
        return "temp";
    }

    @PostMapping("/temp")
    public String postComment(@RequestParam(name="name", required = false, defaultValue = "Anonymous User") String name,
                              @RequestParam(name="content", required = false) String content,
                              Model model) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        Comments.put(new String[]{name, dtf.format(now)}, content);
        model.addAttribute("Comments", Comments);
        model.addAttribute("score", score);
        model.addAttribute("images", images);
        return "temp";
    }

    @PostMapping("/temp/voteUp")
    @ResponseBody
    public int voteUp() {
        score++;
        return score;
    }
    @PostMapping("/temp/voteDn")
    @ResponseBody
    public int voteDn() {
        score--;
        return score;
    }

    @PostMapping("/temp/imagePost")
    @ResponseBody
    public void imagePost(@RequestParam(required=false) String imageURL) {
        images.add(imageURL);
    }
}

