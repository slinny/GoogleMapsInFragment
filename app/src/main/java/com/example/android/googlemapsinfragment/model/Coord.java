package com.example.android.googlemapsinfragment.model;

public class Coord {
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName("lat")
    private double lat;
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName("lon")
    private double lon;

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }
}
