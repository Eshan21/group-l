package com.groupl.controllers.jonathanabout;

public class AttendingPerson {
    private boolean rsvp;
    private int selection;

    public AttendingPerson(boolean rsvp, int selection) {
        this.rsvp = rsvp;
        this.selection = selection;
    }

    public boolean isAttending() {
        return this.rsvp;
    }

    public String getSelection() {
        switch(selection) {
            case 1  : return "beef";
            case 2  : return "chicken";
            case 3  : return "pasta";
            default : return "fish";
        }
    }
}

