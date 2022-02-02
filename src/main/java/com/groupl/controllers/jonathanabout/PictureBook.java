package com.groupl.controllers.jonathanabout;

public class PictureBook
extends Book
{
    private String illustrator;

    public
    PictureBook(String title, String author, String illustrator)
    {
        super(title, author);
        this.illustrator = illustrator;
    }

    public String
    getIllustrator()
    {
        return illustrator;
    }

    public String
    getBookInfo()
    {
        return String.format(
                "%s, written by %s and illustrated by %s",
                super.getTitle(),
                super.getAuthor(),
                illustrator);
    }
}
