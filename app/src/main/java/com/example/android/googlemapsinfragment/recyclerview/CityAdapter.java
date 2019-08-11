package com.example.android.googlemapsinfragment.recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.googlemapsinfragment.ListFragment;
import com.example.android.googlemapsinfragment.R;
import com.example.android.googlemapsinfragment.model.City;

import java.util.List;

public class CityAdapter extends RecyclerView.Adapter<CityViewHolder> {

    private List<City> cityList;
    private Context context;
    private ListFragment listFragment;

    public ListFragment.OnInputFragmentInteractionListener listener;

//    private final OnItemClickListener listener = new OnItemClickListener() {
//        @Override
//        public void onItemClick(City city) {
//
//        }
//    };

    public CityAdapter(List<City> cityList){
        this.cityList = cityList;
    }

//    public CityAdapter(List<City> cityList, OnItemClickListener listener){
//        this.cityList = cityList;
//        this.listener = listener;
//    }

    @NonNull
    @Override
    public CityViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, final int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.itemview_layout,viewGroup,false);
        return new CityViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CityViewHolder cityViewHolder, int i) {
        final City city = cityList.get(i);
        cityViewHolder.onBind(city);

        cityViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    listFragment.onButtonPressed(city);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return cityList.size();
    }

    public void setData(List<City> newCityList) {
        this.cityList = newCityList;
        notifyDataSetChanged();
    }
}
