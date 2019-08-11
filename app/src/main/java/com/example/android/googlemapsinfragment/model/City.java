package com.example.android.googlemapsinfragment.model;

public abstract class City {

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
}
