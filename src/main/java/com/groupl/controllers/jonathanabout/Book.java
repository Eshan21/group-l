package com.groupl.controllers.jonathanabout;

public class Book
{
    private String title;
    private String author;
    
    public
    Book(String title, String author)
    {
        this.title = title;
        this.author =  author;
    }

    public String
    getBookInfo()
    {
        return String.format(
            "%s written by %s",
            title, author);
    }

    public String
    getTitle()
    {
        return title;
    }

    public String
    getAuthor()
    {
        return author;
    }
}

