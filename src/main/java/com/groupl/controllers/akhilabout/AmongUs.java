package com.groupl.controllers.akhilabout;

import java.util.ArrayList;
import java.util.Scanner;

public class AmongUs {
    private ArrayList<String> players = new ArrayList<>();
    private int count;
    static private int a = 0;
    static String playerName;
    private Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        AmongUs game = new AmongUs();
        game.round();
    }

    public void accuse(String name) {
        if (name == "mort") {
            System.out.println("CANNOT COMPREHEND");
        }
        else if (players.contains(name)) {
            updateCount();
            System.out.println(count);
            int votes = (int) (Math.random()*count + 1);
            if (votes>(count/2)) {
                System.out.println(name + " has died for your sins (with " + votes + " votes you stats student)");
                players.remove(name);
            }
            else {
                System.out.println("you got " + votes + " votes thats not enough :(:(:(:(:(");
            }

        }
        else {
            System.out.println("this man does not exist");
        }
    }

    public void kill(String name) {
        while (true) {
            if (name == "mort") {
                System.out.println("CANNOT COMPREHEND");
            } else if (players.contains(name)) {
                players.remove(name);
                break;
            } else {
                System.out.println("this man does not exist");
            }
        }
    }

    public void setPlayers(String name) {
        players.add(name);
    }

    public ArrayList<String> getPlayers() {
        return players;
    }
    public void updateCount() {
        count = players.size();
    }
    public void setUser() {
        System.out.print("hi how are you what is your name ");
        String input = s.nextLine();
        playerName = input;
        players.add(playerName);
        System.out.println("thats cool you're an imposter now :D");
    }

    public void round() {
        setUser();
        while (true) {
            updateCount();
            for (int ii=1;ii<5;ii++) {
                System.out.print("Add player #" + ii + ": ");
                String input = s.nextLine();
                setPlayers(input);
                System.out.println("");
            }
            System.out.println("kill now");
            String input = s.nextLine();
            kill(input);
            System.out.println("VOTING HAS BEGUN");
            while (true) {
                System.out.println("Accuse someone?");
                input = s.nextLine();
                int temp = players.size();
                accuse(input);
                if (players.size() < temp) break;
                System.out.println("");
            }
            if (players.contains(playerName)) {
                System.out.println("You're still alive! \n Round Continues");
            }
            if (players.size() == 1) {
                System.out.println("You WON!!!!!");
                break;
            } else if (!players.contains(playerName)){
                System.out.println("You lose");
                round();
            }
        }
    }
    public String toString() {
        String playersList = "";
        for(int ii=0;ii<players.size();ii++) {
            playersList += players.get(ii) + " ";
        }
        return playersList;
    }
}