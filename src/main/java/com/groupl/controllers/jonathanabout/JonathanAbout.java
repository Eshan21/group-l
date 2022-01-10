package com.groupl.controllers.jonathanabout;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class JonathanAbout {
    @GetMapping("/about/jonathanabout")
    public String jonathanabout() {
        return "/about/jonathanabout";
    }

    public boolean isNullOrEmpty(String s) {
        return s == null || s.trim().isEmpty();
    }

    @PostMapping("/about/jonathan-gen-pass")
    public String getInvitation(@RequestParam (required = false) String prefix,
                                @RequestParam String numlen,
                                Model model) {
        PasswordGenerator passGen;
        if (isNullOrEmpty(prefix)) {
            passGen = new PasswordGenerator(Integer.parseInt(numlen));
        } else {
            passGen = new PasswordGenerator(prefix, Integer.parseInt(numlen));
        }

        String pass = passGen.pwGen();
        int count = PasswordGenerator.genCount();

        model.addAttribute("passGenPass", pass);
        model.addAttribute("passGenCount", count);
        model.addAttribute("passGenPrefix", prefix);
        model.addAttribute("passGenNumlen", numlen);

        return "/about/jonathanabout";
    }

    @PostMapping("/about/jonathan-invitation")
    public String getInvitation(@RequestParam String name,
                                @RequestParam (required = false) String hostname,
                                @RequestParam String address,
                                @RequestParam (required = false) String changeHostname,
                                @RequestParam (required = false) String changeAddress,
                                Model model) {
        // Run with address only if hostname is not provided
        Invitation inv;

        if (isNullOrEmpty(hostname)) {
            inv = new Invitation(address);
        } else {
            inv = new Invitation(hostname, address);
        }

        if (!isNullOrEmpty(changeHostname)) {
            inv.setHostname(changeHostname);
        }

        if (!isNullOrEmpty(changeAddress)) {
            inv.setAddress(changeAddress);
        }

        String message = inv.getMessage(name);

        model.addAttribute("invMsg", message);
        model.addAttribute("hostname", inv.getHostname());
        model.addAttribute("address", inv.getAddress());

        return "/about/jonathanabout";
    }

    @PostMapping("/about/jonathan-light-seq")
    public String setLightSequence(@RequestParam String seq,
                                   @RequestParam(required = false) String changeLightSeq,
                                   @RequestParam(required = false) String insertLightSeq,
                                   @RequestParam(required = false) String insertIdxLightSeq,
                                   @RequestParam(required = false) String rmFirstLightSeq,
                                   Model model) {
        LightSeq lightSeq = new LightSeq(seq);

        if (!isNullOrEmpty(changeLightSeq)) {
            lightSeq.changeSeq(changeLightSeq);
        }
        
        if (!isNullOrEmpty(insertLightSeq)) {
            lightSeq.insertSegment(insertLightSeq, Integer.parseInt(insertIdxLightSeq));
        }

        if (!isNullOrEmpty(rmFirstLightSeq)) {
            lightSeq.rmFirstSeq(rmFirstLightSeq);
        }

        String result = lightSeq.getSeq();
        model.addAttribute("lightSeqResult", result);

        return "/about/jonathanabout";
    }
    
    @PostMapping("/about/jonathan-attending")
    public String gotoEvent(@RequestParam(required = false) String rsvp,
                          @RequestParam String selection,
                          Model model) {
        boolean attending;

        if (!isNullOrEmpty(rsvp)) {
            attending = true;
        } else {
            attending = false;
        }

        AttendingPerson person = new AttendingPerson(attending, Integer.parseInt(selection));

        String result;

        if (person.isAttending()) {
            result = "Thanks for attending. You will be served " + person.getSelection();
        } else {
            result = "Sorry you can't make it.";
        }

        model.addAttribute("attendingResult", result);

        return "/about/jonathanabout";
    }
    
    @PostMapping("/about/jonathan-coin-game")
    public String runGame(@RequestParam String rounds,
                          @RequestParam String startingCoins,
                          Model model) {
        CoinGame game = new CoinGame(Integer.parseInt(startingCoins), Integer.parseInt(rounds));
        String result = game.playGame();

        model.addAttribute("coinGameResult", result);

        return "/about/jonathanabout";
    }
    
    @PostMapping("/about/jonathan-longest-streak")
    public String getLongestStreak(@RequestParam String streak, Model model) {
        String result = LongestStreak.longestStreak(streak);

        System.out.println(result);

        model.addAttribute("longestStreakResult", result);

        return "/about/jonathanabout";
    }
}

