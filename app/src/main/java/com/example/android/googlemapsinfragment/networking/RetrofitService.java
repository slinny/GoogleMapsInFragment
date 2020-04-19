package com.example.android.googlemapsinfragment.networking;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitService {
    private static final String BASE_URL = "https://raw.githubusercontent.com";
    private static CityService cityService;

    public static CityService getCities(){
        if (cityService == null) {
            cityService = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(CityService.class);
        }
        return cityService;
    }
}