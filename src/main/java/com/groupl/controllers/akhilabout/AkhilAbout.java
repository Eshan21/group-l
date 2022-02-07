package com.groupl.controllers.akhilabout;

import com.groupl.controllers.akhilabout.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

@Controller
public class AkhilAbout {
    HashMap<String[], String> Comments = new HashMap<>();
    double computeBonusThreshold;
    Unit2Frq1 gradShow = new Unit2Frq1("0101 0101 0101");

    @GetMapping("about/akhilabout")
    public String akhilabout(Model model) {
        model.addAttribute("Comments", Comments);
        return "about/akhilabout";
    }

    @PostMapping("about/akhilabout/Unit2Frq1a")
    @ResponseBody
    public String Unit2Frq1a() {
        gradShow.setGradShow("0101 0101 0101");
        return "Initialized object gradShow with sequence of \"0101 0101 0101\"";
    }

    @PostMapping("about/akhilabout/Unit2Frq1b")
    @ResponseBody
    public String Unit2Frq1b() {
        return gradShow.getGradShow();
    }

    @PostMapping("about/akhilabout/Unit2Frq1c")
    @ResponseBody
    public String Unit2Frq1c(@RequestParam(name="gradShow", required=false, defaultValue="amongus") String gradShow) {
        this.gradShow.setGradShow(gradShow);
        return "Changed gradShow sequence to " + gradShow;
    }

    @PostMapping("about/akhilabout/Unit2Frq1d")
    @ResponseBody
    public String Unit2Frq1d(@RequestParam(name="segment", required=false, defaultValue="amongus") String segment,
                             @RequestParam(name="index", required=false, defaultValue="amongus") int index) {
        gradShow.insert(segment, index);
        return gradShow.getGradShow();
    }

    @GetMapping("about/akhilabout/Unit2Frq1e")
    public String Unit2Frq1e(@RequestParam(name="oldSeq", required=false, defaultValue="amongus") String oldSeq,
                          @RequestParam(name="segment", required=false, defaultValue="am") String segment,
                          Model model) {
        String newSeq = "";

        for (int ii=0; ii<=oldSeq.length()-segment.length(); ii++) {
            if (oldSeq.substring(ii, ii + segment.length()).equals(segment)) {
                newSeq = oldSeq.substring(0, ii) + oldSeq.substring(ii + segment.length(), oldSeq.length());
                break;
            }
        }
        model.addAttribute("newSeq", newSeq);
        model.addAttribute("Comments", Comments);
        System.out.println("Sequence: " + newSeq);
        return "about/akhilabout";
    }

    @GetMapping("about/akhilabout/Unit4FRQQuestion1")
    public String longestStreak(@RequestParam(name="str", required=false, defaultValue="amongus") String str,
                                     Model model){
        int longestCount = 0;
        String longestChar = null;
        int currentCount = 1;
        String currentChar = null;
        String prevChar = null;
        int start = 0;
        int end = 0;
        for (int ii=0;ii<str.length();ii++) {
            currentChar = String.valueOf(str.charAt(ii));
            if (ii>0){prevChar = String.valueOf(str.charAt(ii-1));}
            if (currentChar.equals(prevChar)) {
                currentCount++;
                if (currentCount > longestCount) {
                    longestChar = currentChar;
                    longestCount = currentCount;
                }
            }
            else {
                currentCount = 1;
                currentChar = null;
            }
        }
        model.addAttribute("Unit4Q2Input", str);
        model.addAttribute("Unit4Q2Output", longestChar + " " + longestCount);
        return "about/akhilabout";
    }


    @PostMapping("about/akhilabout/Unit3Frq1a")
    @ResponseBody
    public String Unit3Frq1a(@RequestParam(name="rsvp", required=false, defaultValue="0") String rsvp,
                                 Model model) {
        String output = "";
        if (rsvp.toUpperCase().equals("TRUE")) {output = "attending";}
        else if (rsvp.toUpperCase().equals("FALSE")) {output = "not attending";}
        else {output = "what";}
        return output;
    }

    @PostMapping("about/akhilabout/Unit3Frq1b")
    @ResponseBody
    public String Unit3Frq1b(@RequestParam(name="selection", required=false, defaultValue="0") int selection,
                                 Model model) {
        String output = "";
        String options[] = {"beef", "chicken", "pasta"};
        if (selection < 4 && selection > 0) {output = (options[selection-1]);} else {output = ("fish");} 
        return output;
    }

    @PostMapping("about/akhilabout/Unit3Frq1c")
    @ResponseBody
    public String Unit3Frq1c(@RequestParam(name="rsvp", required=false, defaultValue="0") Boolean rsvp,
                             @RequestParam(name="selection", required=false, defaultValue="0") int selection,
                             Model model) {
        String option1 = "";
        String options[] = {"beef", "chicken", "pasta"};
        if (rsvp) {
            if (selection < 4) {
                option1 = "Thanks for attending. You will be served " + options[selection-1] + ".";
            }
            else {option1 = "Sorry you can't make it.";}
        }
        return option1;
    }

    @PostMapping("about/akhilabout/Unit3Frq1d")
    @ResponseBody
    public String Unit3Frq1d(@RequestParam(name="option1", required=false, defaultValue="0") String option1,
                             @RequestParam(name="option2", required=false, defaultValue="0") String option2,
                             Model model) {
        String output = "";
        if (option1.equals(option2)) {output = ("true");}
        else {output = ("false");}
        return output;
    }

    @PostMapping("about/akhilabout/Unit4Frq2a")
    @ResponseBody
    public int Unit4Frq2a(@RequestParam(name="round", required=false, defaultValue="0") int round,
                                 Model model) {
        return Unit4Frq2.a(round);
    }

    @PostMapping("about/akhilabout/Unit4Frq2b")
    @ResponseBody
    public String Unit4Frq2b(@RequestParam(name="maxRounds", required=false, defaultValue="0") int maxRounds,
                          @RequestParam(name="startingCoins", required=false, defaultValue="0") int startingCoins,
                          Model model) {
        return Unit4Frq2.b(maxRounds, startingCoins);
    }

    @PostMapping("about/akhilabout/Unit5Frq1a")
    @ResponseBody
    public String Unit5Frq1a(@RequestParam(name="hostname", required=false, defaultValue="0") String hostname,
                                 Model model) {
        Unit5Frq1.setHostName(hostname);
        return Unit5Frq1.getHostName();
    }

    @PostMapping("about/akhilabout/Unit5Frq1b")
    @ResponseBody
    public String Unit5Frq1b(@RequestParam(name="address", required=false, defaultValue="0") String address,
                                 Model model) {
        return Unit5Frq1.setAddress(address);
    }

    @PostMapping("about/akhilabout/Unit5Frq1c")
    @ResponseBody
    public String Unit5Frq1c(@RequestParam(name="person", required=false, defaultValue="0") String person,
                                 Model model) {
        return Unit5Frq1.invite(person);
    }

    @PostMapping("about/akhilabout/Unit5Frq1d")
    @ResponseBody
    public String Unit5Frq1d(@RequestParam(name="address", required=false, defaultValue="0") String address,
                                 Model model) {
        Unit5Frq1.Unit5Frq1(address);
        return "Object initialized";
    }

    @PostMapping("about/akhilabout/Unit5FRQQuestion2-1")
    @ResponseBody
    public String PasswordGenerate1(@RequestParam(name="len", required=false, defaultValue="0") int len,
                                 Model model) {
        return PasswordGenerator.PasswordGenerator(len);
    }
    
    @PostMapping("about/akhilabout/Unit5FRQQuestion2-2")
    @ResponseBody
    public String PasswordGenerate2(@RequestParam(name="len", required=false, defaultValue="0") int len,
                                    @RequestParam(name="prefix", required=false, defaultValue="0") String prefix,
                                    Model model) {
        return PasswordGenerator.PasswordGenerator(len, prefix);
    }

    @PostMapping("about/akhilabout/Unit5FRQQuestion2-3")
    @ResponseBody
    public int PasswordGenerate3(Model model) {
        return PasswordGenerator.pwCount();
    }

    @PostMapping("about/akhilabout/Unit6Frq1")
    @ResponseBody
    public String Unit6Frq1(@RequestParam(name="words", required=false, defaultValue="0") String wordsString) {
        String[] words = wordsString.split(",");
        String output = "";
        for (String ii : words) {
            if (ii.substring(ii.length()-3, ii.length()).equals("ing")) {
                output += (ii + ", ");
            }
        }
        return output;

    }
    @PostMapping("about/akhilabout/Unit6Frq2a")
    @ResponseBody
    public double Unit6Frq2a(@RequestParam(name="items", required=false, defaultValue="0") String itemsSoldString) {
        int emoloyeeCount = itemsSoldString.split(",").length;
        int[] itemsSold = new int[emoloyeeCount];
        for (int ii=0;ii<emoloyeeCount;ii++) {
            itemsSold[ii] += Integer.parseInt(itemsSoldString.split(",")[ii]);
        }

        int total = 0;
        double threshold = 0.0;
        int lowest = 0;
        int greatest = 0;
        for (int ii : itemsSold) {
            total += ii;
            if (lowest == 0 || ii<lowest) {lowest = ii;}
            if (ii>greatest) {greatest = ii;}
        }

        threshold = ((double) (total-(greatest+lowest)))/((double) itemsSold.length-2);
        computeBonusThreshold = threshold;
        return threshold;
    }

    @PostMapping("about/akhilabout/Unit6Frq2b")
    @ResponseBody
    public String Unit6Frq2b(@RequestParam(name="items", required=false, defaultValue="0") String itemsSoldString,
                             @RequestParam(name="fixedWage", required=false, defaultValue="0") double fixedWage,
                             @RequestParam(name="perItemWage", required=false, defaultValue="0") double perItemWage) {
        int emoloyeeCount = itemsSoldString.split(",").length;
        int[] itemsSold = new int[emoloyeeCount];
        double[] wages = new double[emoloyeeCount];
        for (int ii=0;ii<emoloyeeCount;ii++) {
            itemsSold[ii] += Integer.parseInt(itemsSoldString.split(",")[ii]);
        }
        double wage = fixedWage;
        for (int ii=0;ii<itemsSold.length;ii++) {
            wage += itemsSold[ii]*1.5;
            if (((double) itemsSold[ii]) > computeBonusThreshold) {
            wage*=1.1;
        }
        wages[ii] = wage;
        wage = 10.0;
        }

        String output = "";
        for (double ii : wages) {
            output += ((Math.floor(ii*100)/100) + ", ");
        }
        return output;
    }

    @PostMapping("about/akhilabout/Unit7Frq1a")
    @ResponseBody
    public String Unit7Frq1a(@RequestParam(name="firstName", required = false) String firstName,
    @RequestParam(name="lastName", required = false) String lastName) {
        String possibleNames = "";
        for (int ii=1;ii<=firstName.length();ii++) {
            possibleNames += lastName + firstName.substring(0, ii) + ", ";
        }
        possibleNames = possibleNames.substring(0, possibleNames.length()-2);
        return possibleNames;
    }

    @PostMapping("about/akhilabout/Unit7Frq1b")
    @ResponseBody
    public String Unit7Frq1b(@RequestParam(name="usedNames", required = false) String usedNames,
    @RequestParam(name="possibleNames", required = false) String possibleNames) {
        String possibleNamesNew = "";
        String[] possibleNamesArr = possibleNames.split(", ");
        String[] userNamesArr = usedNames.split(", ");
        int n = 0;
        for (String ii : userNamesArr) {
            n = 0;
            for (String jj : possibleNamesArr) {
                if (jj.equals(ii)) {
                    n+=1;
                }
            }
            if (n==0) {
                possibleNamesNew += ii + ", ";
            }
        }
        return possibleNamesNew;
    }

    @PostMapping("about/akhilabout/Unit8Frq1a")
    @ResponseBody
    public String Unit8Frq1a(
        @RequestParam(name="1", required = false) String plot1,
        @RequestParam(name="2", required = false) String plot2,
        @RequestParam(name="3", required = false) String plot3,
        @RequestParam(name="4", required = false) String plot4,
        @RequestParam(name="5", required = false) String plot5,
        @RequestParam(name="6", required = false) String plot6,
        @RequestParam(name="7", required = false) String plot7,
        @RequestParam(name="8", required = false) String plot8,
        @RequestParam(name="9", required = false) String plot9,
        @RequestParam(name="c", required = false) String c
    ) {
        Plot output = null;
        String plots[] = {plot1, plot2, plot3, plot4, plot5, plot6, plot7, plot8, plot9};
        Plot farmPlots[][] = new Plot[3][3];
        for (int i=0;i<farmPlots.length;i++) {
            for (int j=0;j<farmPlots[i].length;j++) {
                farmPlots[i][j] = new Plot(plots[i*3+j].split(",")[0], Integer.parseInt(plots[i*3+j].split(",")[1]));
            }
        }
        for (Plot[] ii : farmPlots) {
            for (Plot jj : ii) {
                if (jj.getCropType().equals(c)) {
                    if (output == null || jj.getCropYield()>output.getCropYield()) {
                        output = jj;
                    }
                }
            }
        }
        if (output != null)
            return output.getCropType() + "," + output.getCropYield();
        return "null";
    }

    @PostMapping("about/akhilabout/Unit8Frq1b")
    @ResponseBody
    public String Unit8Frq1b(
        @RequestParam(name="1", required = false) String plot1,
        @RequestParam(name="2", required = false) String plot2,
        @RequestParam(name="3", required = false) String plot3,
        @RequestParam(name="4", required = false) String plot4,
        @RequestParam(name="5", required = false) String plot5,
        @RequestParam(name="6", required = false) String plot6,
        @RequestParam(name="7", required = false) String plot7,
        @RequestParam(name="8", required = false) String plot8,
        @RequestParam(name="9", required = false) String plot9,
        @RequestParam(name="col", required = false) int col
    ) {
        Plot output = null;
        if (col<0 || col>2) {
            return "Column value must be between 0 and 2, inclusive";
        }
        String plots[] = {plot1, plot2, plot3, plot4, plot5, plot6, plot7, plot8, plot9};
        Plot farmPlots[][] = new Plot[3][3];
        for (int i=0;i<farmPlots.length;i++) {
            for (int j=0;j<farmPlots[i].length;j++) {
                farmPlots[i][j] = new Plot(plots[i*3+j].split(",")[0], Integer.parseInt(plots[i*3+j].split(",")[1]));
            }
        }
        String type = farmPlots[0][col].getCropType();
        for (Plot[] ii : farmPlots) {
            if (!ii[col].getCropType().equals(type)) {
                return "false";
            }
        }
        return "true"; 
    }
    @PostMapping("about/akhilabout/Unit9Frq1a")
    @ResponseBody
    public String Unit9Frq1a(
        @RequestParam(name="title", required = false) String title,
        @RequestParam(name="author", required = false) String author,
        @RequestParam(name="illustrator", required = false) String illustrator 
    ) {
        PictureBook book = new PictureBook(title, author, illustrator);
        return book.printBookInfo();
    }

    @PostMapping("about/akhilabout/Unit9Frq1c")
    @ResponseBody
    public String Unit9Frq1c(
        @RequestParam(name="title", required = false) String title,
        @RequestParam(name="author", required = false) String author,
        @RequestParam(name="value", required = false) double value
    ) {
        Book book = new Book(title, author);
        BookListing bookListing = new BookListing(book, value);
        return bookListing.printDescription();
    }

    @PostMapping("about/akhilabout/Unit9Frq1b")
    @ResponseBody
    public String Unit9Frq1b(
        @RequestParam(name="book1Title", required = false) String book1Title,
        @RequestParam(name="book1Author", required = false) String book1Author,
        @RequestParam(name="book2Title", required = false) String book2Title,
        @RequestParam(name="book2Author", required = false) String book2Author,
        @RequestParam(name="book2Illustrator", required = false) String book2Illustrator 
    ) {
        Book book = new Book(book1Title, book1Author);
        PictureBook pictureBook = new PictureBook(book2Title, book2Author, book2Illustrator);
        return "Book1: " + book.printBookInfo() + "\n" + "Book2: " + pictureBook.printBookInfo();
    }

    @PostMapping("about/akhilabout/Unit9Frq2a")
    @ResponseBody
    public String Unit9Frq2a(
        @RequestParam(name="diet", required = false) String diet,
        @RequestParam(name="species", required = false) String species,
        @RequestParam(name="name", required = false) String name
    ) {
        Animal animal = new Animal(diet, species, name);
        return animal.toString();
    }
    @PostMapping("about/akhilabout/Unit9Frq2b")
    @ResponseBody
    public String Unit9Frq2b(
        @RequestParam(name="species", required = false) String species,
        @RequestParam(name="name", required = false) String name
    ) {
        Herbivore herbivore = new Herbivore(species, name);
        return herbivore.toString();
    }
    @PostMapping("about/akhilabout/Unit9Frq2c")
    @ResponseBody
    public String Unit9Frq2c(
        @RequestParam(name="name", required = false) String name,
        @RequestParam(name="tuskLength", required = false) double tuskLength
    ) {
        Elephant elephant = new Elephant(name, tuskLength);
        return elephant.toString();
    }
    @PostMapping("about/akhilabout/Unit10Frq1a")
    @ResponseBody
    public String Unit10Frq1a(
        @RequestParam(name="a", required = false) int a,
        @RequestParam(name="b", required = false) int b
    ) {
        return "The GCF of " + a + " and " + b + " is " + NumberSystem.gcf(a, b);
    }
    @PostMapping("about/akhilabout/Unit10Frq1b")
    @ResponseBody
    public String Unit10Frqba(
        @RequestParam(name="numerator", required = false) int numerator,
        @RequestParam(name="denominator", required = false) int denominator
    ) {
        return NumberSystem.reducefraction(numerator, denominator);
    }

    @PostMapping("about/akhilabout/comment")
    public String postComment(@RequestParam(name="name", required = false) String name,
                              @RequestParam(name="content", required = false) String content,
                              Model model) {
        if (name == null) {
            name = "Anonymous Commenter";
        }
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        Comments.put(new String[]{name, dtf.format(now)}, content);
        model.addAttribute("Comments", Comments);
        return "about/akhilabout";
    }
}

class Unit2Frq1 {
    private String gradShow;
    private String funVariable;

    public Unit2Frq1(String gradShow) {
        this.gradShow = gradShow;
    }
    public Unit2Frq1(String gradShow, String funVariable) {
        this.gradShow = gradShow;
        this.funVariable = funVariable;
    }
    public void setGradShow(String gradShow) {
        this.gradShow = gradShow;
    }
    public String getGradShow() {
        return(gradShow);
    }
    public void insert(String segment, int index) {
        gradShow = gradShow.substring(0, index) + segment + gradShow.substring(index, gradShow.length());
    }
}

class Unit4Frq2 {
    public static int a(int round) {
        int output;
        if (round % 3 == 0) {output = 3;}
        else if (round % 2 == 0) {output = 2;}
        else {output = 1;}
        return output;
    }
    public static String b(int maxRounds, int startingCoins) {
        int currentRound = 0;
        int player1Coins = startingCoins;
        int player2Coins = startingCoins;
        String output = "";
        while (currentRound <= maxRounds && player1Coins > 3 && player2Coins > 3) {
            player1Coins -= 2;
            player2Coins -= a(currentRound);
            currentRound++; 
        }
        if (player1Coins > player2Coins) {output = "player 1 wins";}
        else if (player2Coins > player1Coins) {output = "player 2 wins";}
        else if (player2Coins == player1Coins) {output = "tie";}
        return output;
    }
}

class Unit5Frq1 {
    private static String hostName;
    private static String address;

    public static String getHostName() {
        return hostName;
    }
    public static void setHostName(String newHostName) {
        hostName = newHostName;
    }
    public static String setAddress(String newAddress) {
        address = newAddress;
        return address;
    }
    public static String invite(String person) {
        return "Dear " + person + ", please attend my event at " + address + ". See you then, " + hostName + ".";
    }
    public static void Unit5Frq1(String newAddress) {
        address = newAddress;
        hostName = "Host";
    }
}

class PasswordGenerator {
    private static int count;
    
    public static String PasswordGenerator(int len) {
        String password = "A.";
        for (int ii=0;ii<len;ii++) {
            password += (int) (Math.random() *10);
        }
        count++;
        return password;
    }
    public static String PasswordGenerator(int len, String prefix) {
        String password = prefix + ".";
        for (int ii=0;ii<len;ii++) {
            password += (int) (Math.random() *10);
        }
        count++;
        return password;
    }
    public static int pwCount() {
        return count;
    }
}

class Plot {
    private String cropType;
    private int cropYield;

    public Plot(String cropType, int cropYield) {
        this.cropType = cropType;
        this.cropYield = cropYield;
    }
    public String getCropType() {
        return this.cropType;
    }
    public int getCropYield() {
        return this.cropYield;
    }
}