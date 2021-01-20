package com.example.astroweatherapp.AstroWeather;

public class AstroWeatherInfo {
    private final String URL;
    private final String key;
    private String city;

    public AstroWeatherInfo(){
        this.URL = "api.openweathermap.org/data/2.5/weather?q=";
        this.key = "34986c4e28ef11c3a2cc09861086536b";
        this.city = "Warsaw";
    }
    public AstroWeatherInfo(String city){
        this();
        this.city = city;
    }
    public void test(){
        System.out.println("URL: " + this.URL + "\nKey: " + this.key + "\nCity: " + this.city);
    }
}
