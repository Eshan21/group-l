package com.groupl.controllers.akhilabout;

public class Book { 
    private String title;
    private String author;    
    public Book(String t, String a) {
        title = t;
        author = a;
    }    
    public String printBookInfo() {
        return title + ", written by " + author;
    }
}
class PictureBook extends Book {
    private String illustrator;
    public PictureBook (String t, String a, String i) {
        super(t, a);
        this.illustrator = i;
    }
    public String printBookInfo() {
        return super.printBookInfo() + " and illustrated by " + illustrator;
    }
}
class BookListing {
    private Book book;
    private double value;
    public BookListing(Book book, double value) {
        this.book = book;
        this.value = value;
    }
    public String printDescription() {
        return book.printBookInfo() + ", $" + value;
    }
}