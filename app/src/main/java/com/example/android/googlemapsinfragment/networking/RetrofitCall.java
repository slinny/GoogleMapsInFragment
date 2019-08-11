package com.example.android.googlemapsinfragment.networking;

public class RetrofitCall {
    private static final String BASE_URL = "https://raw.githubusercontent.com";

    public static CityService getAllCities() {
        return RetrofitClient.getRetrofitClient(BASE_URL).create(CityService.class);
    }
}
