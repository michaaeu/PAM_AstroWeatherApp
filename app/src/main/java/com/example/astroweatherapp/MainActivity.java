package com.example.astroweatherapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.astroweatherapp.Adapter.FragmentAdapter;

public class MainActivity extends AppCompatActivity {
    ViewPager pager;
    FragmentAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pager = findViewById(R.id.pager);
        adapter = new FragmentAdapter(getSupportFragmentManager());
        pager.setAdapter(adapter);
    }
}
