package com.groupl.controllers.jonathanabout;

public class Invitation {
    private String hostname;
    private String address;

    public Invitation(String hostname, String address) {
        this.hostname = hostname;
        this.address = address;
    }

    public Invitation(String address) {
        this.hostname = "Host";
        this.address = address;
    }

    public String getHostname() {
        return this.hostname;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public String getMessage(String name) {
        return String.format("Dear %s,\n" + 
                "\nplease attend my event at %s. See you then %s.\n" + 
                "\nSincerely,\n" +
                "%s" , name, this.address, name, this.hostname);
    }
}


