package com.groupl.controllers.jonathanabout;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.groupl.controllers.jonathanabout.animal.Animal;
import com.groupl.controllers.jonathanabout.animal.Elephant;
import com.groupl.controllers.jonathanabout.animal.Carnivore;
import com.groupl.controllers.jonathanabout.animal.Herbivore;

@Controller
public class JonathanAbout {
    @PostMapping("/about/jonathan-number-system")
    public String
    numberSystem(@RequestParam int numA,
                 @RequestParam int numB,
                 Model model)
    {
        model.addAttribute("numA", numA);
        model.addAttribute("numB", numB);
        model.addAttribute("gcf", NumberSystem.gcf(numA, numB));
        model.addAttribute("reducedFraction", NumberSystem.reduceFraction(numA, numB));
        model.addAttribute("numberSystem", true);

        return "/about/jonathanabout";
    }

    @PostMapping("/about/jonathan-books")
    public String
    getBooks(@RequestParam String books,
             Model model)
    {
        String[] bookArr = books.split("/");
        ArrayList<Book> bookList = new ArrayList();

        for(String bookStr : bookArr){
            System.out.println("bookStr: " + bookStr);
            List<String> attr = Arrays.asList(bookStr.split(","));

            Book book = null;
            if(attr.size() == 3){
                System.out.println("Picture Book");
                // Picture book (title, author, illustrator)
                book = new PictureBook(attr.get(0), attr.get(1), attr.get(2));
            } else if(attr.size() == 2){
                // Regular book (title, author)
                book = new Book(attr.get(0), attr.get(1));
            } else { 
                System.out.println("Expected at least 2 arguments");
            }

            System.out.println(book.getBookInfo());
            bookList.add(book);
        }

        model.addAttribute("bookList", bookList);
        model.addAttribute("book", true);

        return "/about/jonathanabout";
    }

    @PostMapping("/about/jonathan-animal")
    public String
    getAnimal(@RequestParam String type,
              @RequestParam String species,
              @RequestParam String name,
              @RequestParam(required = false) String tusklen,
              Model model)
    {
        Animal animal = new Animal(type, species, name);

        if(!isNullOrEmpty(tusklen)){
            animal = new Elephant(name, Float.parseFloat(tusklen));
        } else if(species.equals("carnivore")){
            animal = new Carnivore(species, name);
        } else if(species.equals("herbivore")){
            animal = new Herbivore(species, name);
        }

        model.addAttribute("type", type);
        model.addAttribute("species", species);
        model.addAttribute("name", name);
        model.addAttribute("animal", animal);

        return "/about/jonathanabout";
    }

    @PostMapping("/about/jonathan-farm-plots")
    public String
    getFarmPlots(@RequestParam String plots,
                 @RequestParam String highestYield,
                 @RequestParam String sameCrop,
                 Model model)
    {
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
        model.addAttribute("fname", fname);
        model.addAttribute("lname", lname);
        model.addAttribute("setNames", setNames);
        model.addAttribute("userNames", true);

        return "/about/jonathanabout";
    }

    @PostMapping("/about/jonathan-word-parse")
    public String getWordParse(@RequestParam String words,
                               Model model) {
        Object[] resWords = WordParse.parse(words.split(","));

        for (Object word : resWords) {
            System.out.println(word);
        }
        model.addAttribute("resWords", resWords);
        model.addAttribute("wordParse", true);

        return "/about/jonathanabout";
    }

    @PostMapping("/about/jonathan-payroll")
    public String getPayroll(@RequestParam String addItems,
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

        model.addAttribute("addItems", addItems);
        model.addAttribute("fixedWage", fixedWage);
        model.addAttribute("perItemWage", perItemWage);
        model.addAttribute("resWages", payroll.getWages());
        model.addAttribute("payroll", true);

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

