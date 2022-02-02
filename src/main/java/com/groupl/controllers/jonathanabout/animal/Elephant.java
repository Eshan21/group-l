package com.groupl.controllers.jonathanabout.animal;

public class Elephant extends Herbivore {
    private double tusklen;

    public Elephant(String name, float tusklen) {
        super("elephant", name);
        this.tusklen = tusklen;
    }

    public String toString() {
        return super.toString() +
               String.format(" with tusks %s meters long", tusklen);
    }
}

