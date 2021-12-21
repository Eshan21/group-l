package com.groupl.controllers.michaelabout;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

@Controller
public class MichaelAbout {
    @GetMapping("/about/michaelabout")
    public String michaelabout(Model model) {
        return "about/michaelabout";
    }

    @GetMapping("/about/michaelabout/frq2")
    public String frq2(@RequestParam(name="userInput", required=false, defaultValue="Y0u-willneverGUESSthisString") String userInput,
                       @RequestParam(name="wantsToRemove", required=false, defaultValue="Y0u-willneverGUESSthisString") String subtract,
                       Model model) {

        if("Y0u-willneverGUESSthisString" == userInput || "Y0u-willneverGUESSthisString" == subtract) {
            return "about/michaelabout";
        }

        String[] words = subtract.split(" ");

        String newString = userInput;

        System.out.println(newString);
        System.out.println(subtract);

        for (String characters : words) {

            newString = newString.replaceAll(characters, "");
            
        }

        model.addAttribute("newString", newString);

        return "about/michaelabout";

    }
}

