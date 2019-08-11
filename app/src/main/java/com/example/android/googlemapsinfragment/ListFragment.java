package com.example.android.googlemapsinfragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.googlemapsinfragment.model.City;
import com.example.android.googlemapsinfragment.recyclerview.CityAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListFragment extends Fragment implements SearchView.OnQueryTextListener{

    private static OnInputFragmentInteractionListener mListener;
    private View rootView;
    private RecyclerView cityRecyclerview;
    private CityAdapter cityAdapter;
    private List<City> cityList = new ArrayList<>();
    private LinearLayoutManager linearLayoutManager;
    private SearchView searchView;


    public ListFragment() {
        // Required empty public constructor
    }

    public static ListFragment newInstance() {
        ListFragment fragment = new ListFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_list, container, false);

        Bundle bundle = getArguments();
        cityList = (List<City>) bundle.getSerializable("citylist");
        Log.d("listlength", String.valueOf(cityList.size()));

        searchView = rootView.findViewById(R.id.searchview);
        searchView.setOnQueryTextListener(this);

        cityRecyclerview = rootView.findViewById(R.id.recyclerview_city);

        cityAdapter = new CityAdapter(cityList);
        cityRecyclerview.setAdapter(cityAdapter);
        linearLayoutManager = new LinearLayoutManager(getActivity());
        cityRecyclerview.setLayoutManager(linearLayoutManager);

        return rootView;
    }

    public static void onButtonPressed(City city) {
        if (mListener != null) {
            mListener.onInputFragmentInteraction(city);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnInputFragmentInteractionListener) {
            mListener = (OnInputFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnInputFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnInputFragmentInteractionListener {
        void onInputFragmentInteraction(City city);
    }


    @Override
    public boolean onQueryTextSubmit(String s) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String s) {
        List<City> newCityList = new ArrayList<>();
        for(City city : cityList) {
            if(city.getName().toLowerCase().startsWith(s.toLowerCase())) {
                newCityList.add(city);
            }
        }
        cityAdapter.setData(newCityList);
        return false;
    }
}
