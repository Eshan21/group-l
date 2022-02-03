package com.groupl.controllers.michaelabout.unit9_2;

public class Elephant extends Herbivore {
	private double length;
	private Herbivore animal;

	public Elephant(String name, double length) {
		super("elephant", name);
		this.length = length;
	}

	public String toString() {
		return super.toString() + " with tusks " + length + " meters long";
	}

	
}
