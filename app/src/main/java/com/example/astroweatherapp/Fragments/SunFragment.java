package com.example.astroweatherapp.Fragments;

import android.os.Bundle;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.astroweatherapp.Data.AstroInfo;
import com.example.astroweatherapp.Data.DataSettings;
import com.example.astroweatherapp.R;

public class SunFragment extends Fragment {
    private DataSettings dataSettings;
    private AstroInfo astroInfo;

    private TextView sunriseTime;
    private TextView sunriseAzim;
    private TextView sunsetTime;
    private TextView sunsetAzim;
    private TextView twilightTime;
    private TextView dawnTime;

    public SunFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sun, container, false);
        initLayout(view);
        initData();
        refreshData();

        return view;
    }

    private void initLayout(View view){
        sunriseTime = view.findViewById(R.id.sunrise_time);
        sunriseAzim = view.findViewById(R.id.sunrise_Azim);
        sunsetTime = view.findViewById(R.id.sunset_time);
        sunsetAzim = view.findViewById(R.id.sunset_Azim);
        twilightTime = view.findViewById(R.id.full_moon);
        dawnTime = view.findViewById(R.id.moon_phase);
    }

    private void initData() {
        dataSettings = DataSettings.getInstance();
        astroInfo = new AstroInfo(dataSettings.longitude, dataSettings.latitude);
    }

    private void refreshData() {
        updateTextFields();
        final int time = dataSettings.delay*1000*60;
        final Handler sunHandler = new Handler();
        sunHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                sunHandler.postDelayed(this,time);
                astroInfo = new AstroInfo(dataSettings.longitude, dataSettings.latitude);
                updateTextFields();
            }
        },time);
    }

    private void updateTextFields() {
        String[] layoutValues = astroInfo.getSunInfo();
        sunriseTime.setText(layoutValues[0]);
        sunriseAzim.setText(layoutValues[1]);
        sunsetTime.setText(layoutValues[2]);
        sunsetAzim.setText(layoutValues[3]);
        twilightTime.setText(layoutValues[4]);
        dawnTime.setText(layoutValues[5]);
    }
}
