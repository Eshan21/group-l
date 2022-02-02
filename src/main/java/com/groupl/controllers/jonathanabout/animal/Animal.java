package com.groupl.controllers.jonathanabout.animal;

public class Animal {
    private String type;
    private String species;
    private String name;

    public Animal(String type, String species, String name) {
        this.type = type;
        this.species = species;
        this.name = name;
    }

    public String toString() {
        return String.format("%s the %s is a %s", name, species, type);
    }
}

