class test2 {

	public static void main(String args[]) {
		Animal lisa = new Animal("carnivore", "lion", "Lisa");
		System.out.println(
				lisa.toString()
		);

		Herbivore gary = new Herbivore("giraffe", "Gary");
		System.out.println(
				gary.toString()
		);

		Elephant percy = new Elephant("Percy", 2.0);
		System.out.println(
				percy.toString()
		);


	}
}
