public class Animal {

	protected String kind;
	protected String animal;
	protected String name;

	public Animal(String kind, String animal, String name) {

		this.kind = kind;
		this.animal = animal;
		this.name = name;

	}

	public String toString() {
		return name + " the " + animal + " is a " + kind;
	}

}
