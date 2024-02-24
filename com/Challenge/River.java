package com.Challenge;

public class River extends Line{

    private String name;

    public River(String name, String... locations) {
        super(locations);
        this.name = name;
    }

    @Override
    public String toString() {
//        return super.toString();

        return name + " River";
    }
}