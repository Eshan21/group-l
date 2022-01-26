package com.groupl.controllers.jonathanabout;

import java.util.ArrayList;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class JonathanAbout {
    @PostMapping("/about/jonathan-user-names")
    public String getUserNames(@RequestParam String fname,
                                   @RequestParam String lname,
                                   @RequestParam String setNames,
                                   Model model) {
        UserName username = new UserName(fname, lname);

        if (!isNullOrEmpty(setNames)) {
            username.setAvailableUserNames(setNames.split(","));
        }

        model.addAttribute("possibleNames", username.getPossibleNames());
        model.addAttribute("fname");
        model.addAttribute("lname");
        model.addAttribute("setNames");
        model.addAttribute("userNames", true);

        return "/about/jonathanabout";
    }

    @PostMapping("/about/jonathan-farm-plots")
    public String getFarmPlots(@RequestParam String plots,
                               @RequestParam String highestYield,
                               @RequestParam String sameCrop,
                               Model model) {
        System.out.println(plots);
        String[] plotrow = plots.split("/");
        int len = plotrow.length;
        ArrayList<Plot>[] plotarr = new ArrayList[len];

        for (int i = 0; i < len; i++) {
            plotarr[i] = new ArrayList<Plot>();
            for (String row: plotrow[i].split(",")) {
                plotarr[i].add(new Plot(row.split(" ")));
            }
        }

        ExperimentalFarm farm = new ExperimentalFarm(plotarr);

        model.addAttribute("resHighestYield", farm.getHighestYield(highestYield));
        model.addAttribute("resSameCrop", farm.sameCrop(Integer.parseInt(sameCrop)));
        model.addAttribute("plots", plots);
        model.addAttribute("farmPlots", true);

        return "/about/jonathanabout";
    }

    @PostMapping("/about/jonathan-compute-wages")
    public String getWordParse(@RequestParam String addItems,
                               @RequestParam String fixedWage,
                               @RequestParam String perItemWage,
                               Model model) {
        Payroll payroll = new Payroll();

        String[] addItemsArr = addItems.split(",");
        int[] itemsSold = new int[addItemsArr.length];

        int i = 0;
        for (String items : addItemsArr) {
            itemsSold[i] = Integer.parseInt(items);
            i++;
        }
        
        payroll.setItemsSold(itemsSold);

        payroll.computeWages(Double.parseDouble(fixedWage), Double.parseDouble(perItemWage));

        model.addAttribute("addItems");
        model.addAttribute("fixedWage");
        model.addAttribute("perItemWage");
        model.addAttribute("wages", payroll.getWages());
        model.addAttribute("

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
        model.addAttribute("invitation", true);

        return "/about/jonathanabout";
    }
    
    @PostMapping("/about/jonathan-longest-streak")
    public String getLongestStreak(@RequestParam String streak, Model model) {
        String result = LongestStreak.longestStreak(streak);

        System.out.println(result);

        model.addAttribute("longestStreakResult", result);
        model.addAttribute("longestStreak", true);

        return "/about/jonathanabout";
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
        model.addAttribute("genPass", true);

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
        model.addAttribute("attending", true);

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
        model.addAttribute("lightSeq", true);

        return "/about/jonathanabout";
    }
    
    @PostMapping("/about/jonathan-coin-game")
    public String runGame(@RequestParam String rounds,
                          @RequestParam String startingCoins,
                          Model model) {
        CoinGame game = new CoinGame(Integer.parseInt(startingCoins), Integer.parseInt(rounds));
        String result = game.playGame();

        model.addAttribute("coinGameResult", result);
        model.addAttribute("coinGame", true);

        return "/about/jonathanabout";
    }

    @GetMapping("/about/jonathanabout")
    public String jonathanabout() {
        return "/about/jonathanabout";
    }

    public boolean isNullOrEmpty(String s) {
        return s == null || s.trim().isEmpty();
    }
}

