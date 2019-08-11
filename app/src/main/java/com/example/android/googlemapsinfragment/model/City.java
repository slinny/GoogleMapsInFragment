package com.example.android.googlemapsinfragment.model;

import android.support.annotation.NonNull;

import java.io.Serializable;

public abstract class City implements Comparable<City>, Serializable {

    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName("coord")
    private Coord coord;
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName("_id")
    private int Id;
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName("name")
    private String name;
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName("country")
    private String country;

    public Coord getCoord() {
        return coord;
    }

    public void setCoord(Coord coord) {
        this.coord = coord;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public int compareTo(@NonNull City city) {
        int cityName = this.getName().toLowerCase().compareTo(city.getName().toLowerCase());
        return cityName;
    }
}
