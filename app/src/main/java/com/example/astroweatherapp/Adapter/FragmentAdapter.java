package com.example.astroweatherapp.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.astroweatherapp.Fragments.MoonFragment;
import com.example.astroweatherapp.Fragments.SunFragment;


public class FragmentAdapter extends FragmentPagerAdapter {

    public FragmentAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new SunFragment();
            case 1:
                return new MoonFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }
}