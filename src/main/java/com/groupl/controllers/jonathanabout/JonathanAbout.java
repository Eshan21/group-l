package com.groupl.controllers.jonathanabout;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class JonathanAbout {
    @PostMapping("/about/jonathanabout")
    public String jonathanabout(@RequestParam(required=false) String formtype,
                                @RequestParam(required=false) String seq,
                                @RequestParam(required=false) String insseq,
                                @RequestParam(required=false) String insidx,
                                @RequestParam(required=false) String rmfirst,
                                Model model
                                ) {

    @GetMapping("/about/jonathanabout")
    public String jonathanabout(Model model) {

        model.addAttribute("project", new Project());

        return "/about/jonathanabout";
    }

    @PostMapping("/about/jonathanabout")
    public String jonathanabout(@ModelAttribute Project project) {

        if (project.seq != null) {
            if (project.insseq != null && project.insidx != null) {
                int idx = Integer.parseInt(project.insidx);
                String str1 = project.seq.substring(0, idx);
                String str2 = project.seq.substring(idx);

                project.seq = new String(str1 + project.insseq + str2);
            } else if (project.rmfirst != null) {
                seq.replaceFirst(project.rmfirst, "");
            }
        }

        return "/about/jonathanabout";
    }

}

