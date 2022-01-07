package com.groupl.controllers.jonathanabout;

public class LightSeq {
    private String seq;

    // Constructs a LightSequence instance with a sequence
    public LightSeq(String seq) {
        this.seq = seq;
    }

    // Getter for seq
    public String getSeq() {
        return this.seq;
    }

    // Insert a segment into the light sequence
    public void insertSegment(String segment, int idx) {
        String p1 = this.seq.substring(0, idx);
        String p2 = this.seq.substring(idx, segment.length());

        this.seq = p1.concat(segment).concat(p2);
    }

    // Setter for seq
    public void changeSeq(String seq) {
        this.seq = seq;
    }

    // Remove the first occurrence of a String in the sequence
    public void rmFirstSeq(String seq) {
        this.seq = this.seq.replaceFirst(seq, "");
    }

    // Display the light sequence
    public void display() {
        System.out.println(this.seq);
    }
}

