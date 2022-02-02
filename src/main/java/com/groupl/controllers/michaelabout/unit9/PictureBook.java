package com.groupl.controllers.michaelabout.unit9;

public class PictureBook extends Book {

	private String illustrator;

	
	public PictureBook(String title, String author, String illustrator) {
		super(title, author);
		this.illustrator = illustrator;
	}

	public void printBookInfo() {
		System.out.println(this);
	}

	public String toString() {
		return title + ", written by " + author + " and illustrated by " + illustrator;

	}

	public static void main(String[] args) {
		PictureBook myBook = new PictureBook("Peter and Wendy", "J.M. Barrie", "F.D. Bedford");
		myBook.printBookInfo();
	}
}
