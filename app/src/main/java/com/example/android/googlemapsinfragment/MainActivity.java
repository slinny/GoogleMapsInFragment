package com.example.android.googlemapsinfragment;

import android.content.pm.ActivityInfo;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.android.googlemapsinfragment.model.City;
import com.example.android.googlemapsinfragment.networking.CityService;
import com.example.android.googlemapsinfragment.networking.RetrofitService;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements ListFragment.OnInputFragmentInteractionListener{

    private CityService cityService;
    private ProgressBar progressBar;
    private List<City> cityList = new ArrayList<>();
    private FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR);

        frameLayout = findViewById(R.id.main_container);
        frameLayout.setVisibility(View.GONE);

        cityService = RetrofitService.getCities();
        progressBar = findViewById(R.id.progress_bar);

        cityService.getAllCities().enqueue(new Callback<List<City>>() {

            @Override
            public void onResponse(Call<List<City>> call, final Response<List<City>> response) {
                cityList= response.body();
                Log.d("mainlength", String.valueOf(cityList.size()));
                Collections.sort(cityList);
                progressBar.setVisibility(View.GONE);
                frameLayout.setVisibility(View.VISIBLE);
                Bundle bundle = new Bundle();
                bundle.putSerializable("citylist", (Serializable) cityList);

                ListFragment listFragment = new ListFragment();
                listFragment.setArguments(bundle);
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.main_container, listFragment);
                fragmentTransaction.addToBackStack(getResources().getString(R.string.list_fragment));
                fragmentTransaction.commit();;
            }

            @Override
            public void onFailure(Call<List<City>> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"Network Failure",Toast.LENGTH_LONG).show();
                t.printStackTrace();
            }
        });
    }

    @Override
    public void onInputFragmentInteraction(City city) {
        MapFragment mapFragment = MapFragment.newInstance(city.getCoord().getLat(),city.getCoord().getLon(),city.getName(),city.getCountry());
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.main_container, mapFragment)
                .addToBackStack(getResources().getString(R.string.map_fragment)).commit();
    }
}
