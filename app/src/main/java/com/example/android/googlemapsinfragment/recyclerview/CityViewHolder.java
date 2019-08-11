package com.example.android.googlemapsinfragment.recyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.android.googlemapsinfragment.R;
import com.example.android.googlemapsinfragment.model.City;

class CityViewHolder extends RecyclerView.ViewHolder{

    private TextView cityTextView;

    public CityViewHolder(@NonNull View itemView) {
        super(itemView);
        cityTextView = itemView.findViewById(R.id.city_text_view);
    }

    public void onBind(final City response) {
        cityTextView.setText(response.getName() + ", " + response.getCountry());
    }
}
