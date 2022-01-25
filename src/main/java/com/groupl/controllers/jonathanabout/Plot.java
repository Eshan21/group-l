package com.groupl.controllers.jonathanabout;

class Plot {
    private String crop;
    private int yield;

    public Plot(String crop, int yield) {
        System.out.println("Added plot crop: " + crop + " yield: " + yield);
        this.crop = crop;
        this.yield = yield;
    }

    public Plot(String[] arr) {
        System.out.println("Added plot crop: " + arr[0] + " yield: " + arr[1]);
        this.crop = arr[0];
        this.yield = Integer.parseInt(arr[1]);
    }

    public String getCrop() {
        return crop;
    }

    public int getYield() {
        return yield;
    }
}

