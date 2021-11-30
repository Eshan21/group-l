package com.groupl.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

class LightSequence {

    private String seq = "";

    public LightSequence(String seq) {
        this.seq = seq;
    }

    /**
     * Inserts the string segment in the current sequence,
     * starting at the index ind. Returns the new sequence.
     */

    public String insertSegment(String segment, int ind) {
        return "abc";
    }

    /**
     * Updates the sequence to the value in seq
     */
    public void changeSequence(String seq) { /* implementation not shown */ }

    /**
     * Uses the current sequence to turn the light on and off
     * for the show
     */
    public void display() { /* implementation not shown */ }

    public String getSeq() {
        return seq;
    }
}

public class Lab1 {

    @GetMapping("/lab1")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {

        LightSequence ls = new LightSequence(name);
        name = ls.getSeq();
        model.addAttribute("name", name);
        return "lab1";
    }
}
