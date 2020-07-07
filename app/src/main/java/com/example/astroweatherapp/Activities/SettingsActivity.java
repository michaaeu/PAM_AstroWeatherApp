package com.example.astroweatherapp.Activities;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.astroweatherapp.R;

public class SettingsActivity extends AppCompatActivity {

    Spinner refreshPeriodSpinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        refreshPeriodSpinner = findViewById(R.id.periodSpinner);

        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(SettingsActivity.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.refresh_periods));
        stringArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        refreshPeriodSpinner.setAdapter(stringArrayAdapter);

    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        //This is used to hide/show 'Status Bar' & 'System Bar'. Swip bar to get it as visible.
        View decorView = getWindow().getDecorView();
        if (hasFocus) {
            decorView.setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
    }
}
