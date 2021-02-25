package com.example.astroweatherapp.AstroWeather;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;

import com.google.android.gms.maps.model.LatLng;

import java.io.IOException;
import java.util.List;

public class AstroWeatherInfo {

    private final String URL;
    private final String key;
    public String city;
    public LatLng cords;

    public AstroWeatherInfo(){
        this.URL = "api.openweathermap.org/data/2.5/weather?q=";
        this.key = "34986c4e28ef11c3a2cc09861086536b";
        this.city = "Warsaw";
    }

    @Override
    public String toString() {
        return "URL: " + this.URL + "\nKey: " + this.key + "\nCity: " + this.city;
    }

    public void getLocationFromAddress(Context context) {
        Geocoder coder = new Geocoder(context);
        List<Address> address;
        LatLng geoPoint = null;

        try {
            // May throw an IOException
            address = coder.getFromLocationName(this.city, 5);
            if (address == null) {
                return;
            }
            Address location = address.get(0);
            geoPoint = new LatLng(location.getLatitude(), location.getLongitude() );

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        cords = geoPoint;
    }
}
