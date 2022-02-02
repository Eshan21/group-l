package com.groupl.controllers.michaelabout.unit9;

import java.util.ArrayList;

class test {

	public static void main(String args[]) {
		ArrayList<Book> myLibrary = new ArrayList<Book>();
                Book book1 = new Book("Frankenstein", "MaryShelley");
                Book book2 = new PictureBook("The Wonderful Wizard of Oz", "L. Frank Baurn", "W.W. Denslow");
                myLibrary.add(book1);
                myLibrary.add(book2);

		BookListing listing1 = new BookListing(book1, 10.99);
		listing1.printDescription();

		BookListing listing2 = new BookListing(book2, 12.99);
		listing2.printDescription();
		
	}

}
