package com.example.android.googlemapsinfragment.networking;

import com.example.android.googlemapsinfragment.model.City;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CityService {
    @GET("/joinpursuit/Pursuit-Core-Android-Unit6-CTA-Bank-Locator/master/location.json")
    Call<List<City>> getAllCities();
}

