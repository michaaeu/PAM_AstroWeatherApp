package com.example.astroweatherapp.Fragments;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.astroweatherapp.Data.AstroInfo;
import com.example.astroweatherapp.Data.DataSettings;
import com.example.astroweatherapp.R;

public class MoonFragment extends Fragment {

    private TextView moonriseTime;
    private TextView moonsetTime;
    private TextView moonFull;
    private TextView moonNew;
    private TextView moonPhase;
    private TextView synodicMonthDay;

    private DataSettings dataSettings;
    private AstroInfo astroInfo;

    public MoonFragment() {
        // Required empty public constructor
    }

    private void initLayout(View view){
        moonriseTime = view.findViewById(R.id.moonrise_time);
        moonsetTime = view.findViewById(R.id.moonset_time);
        moonFull = view.findViewById(R.id.full_moon);
        moonNew = view.findViewById(R.id.moon_new);
        moonPhase = view.findViewById(R.id.moon_phase);
        synodicMonthDay = view.findViewById(R.id.synodic_month_day);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_moon, container, false);


        return view;
    }
}
