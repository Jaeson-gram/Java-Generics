package com.Challenge;

public class MyMain {
    public static void main(String[] args) {
        var nationalNGPArks = new Park[]{
                new Park("Port Harcourt", "51.0901, -112.5105"),
                new Park("Calabar Local", "63.4102, -71.9914"),
                new Park("Gwagwalada, Abuja", "61.5151, -112.5151"),
        };

        Layer<Park> parkLayer = new Layer<>(nationalNGPArks);
        parkLayer.renderLayer();

        System.out.println("-".repeat(25));
        var majorRivers = new River[]{
                new River("Mississippi", "47.2348, -95.2348",  "35.1556, -90.0659"),
                new River("Niger River", "41.2234, -18.4474", "19.6185, -17.6161")
        };

        Layer<River> riverLayer = new Layer<>(majorRivers);
        riverLayer.addElements(new River("Benue River", "21.2121, -16.7119", "71.2988, -14.7119"));

        riverLayer.renderLayer();
    }
}
