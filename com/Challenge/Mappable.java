package com.Challenge;

public interface Mappable {
    void render();

    static double[] stringToLatLon(String location){
        var splits = location.split(",");

        var latitude = Double.valueOf(splits[0]);
        var longitude = Double.valueOf(splits[1]);

        return new double[]{latitude, longitude};
    }

}
