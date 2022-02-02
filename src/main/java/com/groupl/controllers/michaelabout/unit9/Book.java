package com.groupl.controllers.michaelabout.unit9;

public class Book {
	protected String title;
	protected String author;

	public Book(String title, String author) { 
		this.title = title;
		this.author = author;
	}

	public void printBookInfo() {
		System.out.print(this);
	}

	public String toString() {
		return title + ", written by " + author;
	}

	public static void main(String args[]) {
		System.out.println("");
	}

}
