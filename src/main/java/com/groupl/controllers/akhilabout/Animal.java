package com.groupl.controllers.akhilabout;

public class Animal {
    private String diet;
    private String species;
    private String name;
    public Animal(String diet, String species, String name) {
        this.diet = diet;
        this.species = species;
        this.name = name;
    }
    public String toString() {
        return name + " the " + species + " is a " + diet;
    } 
}
class Herbivore extends Animal {
    public Herbivore(String species, String name) {
        super("herbivore", species, name);
    }
}
class Elephant extends Herbivore {
    private double tuskLength;
    public Elephant(String name, double tuskLength) {
        super("elephant", name);
        this.tuskLength = tuskLength;
    }
    public String toString() {
        return super.toString() + " with tusks " + tuskLength + " meters long";
    }
}