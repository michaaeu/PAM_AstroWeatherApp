package com.example.astroweatherapp.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.astroweatherapp.Adapter.FragmentAdapter;
import com.example.astroweatherapp.AstroWeather.AstroWeatherInfo;
import com.example.astroweatherapp.R;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    AstroWeatherInfo astroWeatherInfo;
    ViewPager pager;
    FragmentAdapter adapter;

    TextView currentLocationTextView;
    TextView currentTimeTextView;
    public Context context;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getApplicationContext();
        setContentView(R.layout.activity_main);

        // Astro Weather Info
        astroWeatherInfo = new AstroWeatherInfo();

        // Fragments Pager
        pager = findViewById(R.id.pager);
        adapter = new FragmentAdapter(getSupportFragmentManager());
        pager.setAdapter(adapter);

        // Location
        currentLocationTextView = findViewById(R.id.location);
        astroWeatherInfo.getLocationFromAddress(context);
        currentLocationTextView.setText(new DecimalFormat(".###").format(astroWeatherInfo.cords.latitude) + ", " + new DecimalFormat(".###").format(astroWeatherInfo.cords.longitude));

        System.out.println("TEST");

        // Timer
        Runnable timer = new CurrentTimeRunner();
        Thread myThread= new Thread(timer);
        myThread.start();

        setWindow();
    }

    public void updateTimer() {
        runOnUiThread(new Runnable() {
            public void run() {
                try{
                    currentTimeTextView = findViewById(R.id.current_time);
                    Date date = new Date();
                    @SuppressLint("SimpleDateFormat") String curTime = new SimpleDateFormat("HH:mm:ss").format(date);
                    currentTimeTextView.setText(curTime);
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    class CurrentTimeRunner implements Runnable{
        // @Override
        public void run() {
            while(!Thread.currentThread().isInterrupted()){
                try {
                    updateTimer();
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }catch(Exception e){
                }
            }
        }
    }

    public void setWindow() {
        //This is used to hide/show 'Status Bar' & 'System Bar'. Swip bar to get it as visible.
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
    }

    public void settingsButton(View view) {
        Intent intent = new Intent(this, SettingsActivity.class);
        this.startActivity(intent);
    }
}
