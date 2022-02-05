package com.groupl.controllers.michaelabout;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import java.io.*; 
import java.util.*; 
import org.json.simple.JSONObject; 
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

import com.groupl.controllers.michaelabout.unit7.*;
import com.groupl.controllers.michaelabout.unit8.*;
import com.groupl.controllers.michaelabout.unit9.*;
import com.groupl.controllers.michaelabout.unit9_2.*;
import com.groupl.controllers.michaelabout.unit10.*;

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

    @PostMapping("about/michaelabout/unit4-q1")
    @ResponseBody
    public String longestStreakf(@RequestParam(name="unit4-frq1-text", required=false, defaultValue="amongus") String text,
                                     Model model){
		char longestChar = text.charAt(0);
		int streak = 1;
		int longestStreak = 1;

		for(int i = 0; i < text.length() - 1; i++) {

			if(text.charAt(i) == text.charAt(i + 1)) {
				streak++;
				if(streak > longestStreak) {
					longestStreak = streak;
					longestChar = text.charAt(i);
				}
			} else {
				streak = 1;
			}
			
		}

        JSONObject jo = new JSONObject(); 
        jo.put("userin", text); 
        jo.put("unit4-frq1-longestChar", Character.toString(longestChar)); 
        jo.put("unit4-frq1-longestStreak", longestStreak); 

        return jo.toString();
    }

    @GetMapping("about/michaelabout/Unit4FRQQuestion2PartA")
    public String getPlayer2Move(@RequestParam(name="round", required=false, defaultValue="0") int round,
                                 Model model) {
        int output;
        if (round % 3 == 0) {output = 3;}
        else if (round % 2 == 0) {output = 2;}
        else {output = 1;}
        model.addAttribute("Player2Input", round);
        model.addAttribute("Player2Move", output);
        return "about/michaelabout";
    }


    private PasswordGenerator pg;

    @PostMapping("about/michaelabout/unit5-q2")
    @ResponseBody
    public String genPassword(
        @RequestParam(name="unit5-ques2-pass-prefix", required=false, defaultValue="amongus") String passPrefix,
        @RequestParam(name="unit5-ques2-pass-length", required=false, defaultValue="amongus") String passLength,
        @RequestParam(name="createNew", required=false, defaultValue="amongus") boolean createNew,
                                     Model model){
        if(pg == null || createNew) {
            pg = new PasswordGenerator(Integer.parseInt(passLength), passPrefix);
            pg.clearPasswordList();
        }

        pg.pwGen();

        JSONObject jo = new JSONObject(); 
        jo.put("passwords", pg.getGeneratedPassword()); 

        return jo.toString();
    }

    @PostMapping("about/michaelabout/unit6-q2b")
    @ResponseBody
    public String genPassword(
        @RequestParam(name="unit6-ques2-sold-count", required=false, defaultValue="a") String soldList,
        @RequestParam(name="unit6-ques2-fixed-wage", required=false, defaultValue="ab") String fixedWage,
        @RequestParam(name="unit6-ques2-per-item-wage", required=false, defaultValue="ac") String perItemWage,
                                     Model model){

        Pattern pattern = Pattern.compile(",");
        int[] itemSoldList = pattern.splitAsStream(soldList) 
                                .mapToInt(Integer::parseInt)
                                .toArray();

        Payroll pr = new Payroll(itemSoldList);
        double threshold = pr.computeBonusThreshold();
        pr.computeWages(Double.parseDouble(fixedWage), Double.parseDouble(perItemWage));
        JSONObject jo = new JSONObject(); 
        jo.put("threshold", threshold);
        jo.put("wages", DoubleStream.of(pr.wages).boxed().collect(Collectors.toList())); 

        return jo.toString();
    }

    @PostMapping("about/michaelabout/unit7-q1b")
    @ResponseBody
    public String genPassword(
        @RequestParam(name="unit7-ques1-username", required=true) String username_input,
        @RequestParam(name="unit7-ques1-used", required=false, defaultValue = "") String used_names,
                                     Model model){

        String[] temp = username_input.split(" "); 
        String firstName = temp[0];
        String lastName = temp[1];

        UserName person = new UserName(firstName, lastName);
        String[] used = used_names.split(" ");
        person.setAvailableUserNames(used);

        JSONObject jo = new JSONObject(); 
        jo.put("usernames", person.getPossibleNames());

        return jo.toString();
    }

    @PostMapping("about/michaelabout/unit8-q1")
    @ResponseBody
    public String unit8q1(
        @RequestParam(name="unit8-ques1-cropList", required=true) String cropListInput,
        @RequestParam(name="unit8-ques1-mostYieldType", required=true) String mostYieldType,
                                     Model model){
        
        // 
        String[] row = cropListInput.split("/");
        int column_length = row[0].split(",").length;

        Plot[][] cropList = new Plot[row.length][column_length];
        for (int i = 0; i < row.length; i++) {
            String[] column = row[i].split(",");
            for (int j = 0; j < column.length; j++) {
                String[] item = column[j].split(" ");
                cropList[i][j] = new Plot(item[0], Integer.parseInt(item[1]));
            }
        }

        // System.out.println("fuckoffbitch2");

		ExperimentalFarm ef = new ExperimentalFarm(cropList);
		String cropType = ef.getHighestYield(mostYieldType).getCropType();

        JSONObject jo = new JSONObject(); 
        jo.put("cropType", cropType);

        return jo.toString();
    }


    private ArrayList<Book> myLibrary = new ArrayList<Book>();

    @PostMapping("about/michaelabout/unit9-q1")
    @ResponseBody
    public String unit9q1(
        @RequestParam(name="unit9-ques1-bookType", required=true) String bookType,
        @RequestParam(name="unit9-ques1-bookDescription", required=true) String bookDescription,
                                     Model model){
        String output = new String();
        String[] temp;
        switch (bookType) {
            case "Book":
                temp = bookDescription.split(",");
                output = new Book(temp[0], temp[1]).toString();
                break;
            case "Picture book":
                temp = bookDescription.split(",");
                output = new PictureBook(temp[0], temp[1], temp[2]).toString();
                break;
            default:
                return "error";
        }
        return output;
    }

    @PostMapping("about/michaelabout/unit9-q2")
    @ResponseBody
    public String unit9q2(
        @RequestParam(name="unit9-ques2-animalType", required=true) String animalType,
        @RequestParam(name="unit9-ques2-animalDescription", required=true) String animalDescription,
                                     Model model){
        String output = new String();
        String[] temp;
        switch (animalType) {
            case "Animal":
                temp = animalDescription.split(",");
                output = new Animal(temp[0], temp[1], temp[2]).toString();
                break;
            case "Herbivore":
                temp = animalDescription.split(",");
                output = new Herbivore(temp[0], temp[1]).toString();
                break;
            case "Elephant":
                temp = animalDescription.split(",");
                output = new Elephant(temp[0], Double.parseDouble(temp[1])).toString();
                break;
            default:
                return "error";
        }
        return output;
    }

    @PostMapping("about/michaelabout/unit10-q1")
    @ResponseBody
    public String unit10q1(
        @RequestParam(name="unit10-ques1-numerator", required=true) String numerator,
        @RequestParam(name="unit10-ques1-denominator", required=false, defaultValue = "") String denominator,
                                     Model model){
        JSONObject jo = new JSONObject();
        jo.put("output", NumberSystem.reduceFraction(Integer.parseInt(numerator), Integer.parseInt(denominator)));

        return jo.toString();

    }
}
