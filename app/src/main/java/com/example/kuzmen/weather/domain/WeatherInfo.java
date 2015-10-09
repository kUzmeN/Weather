package com.example.kuzmen.weather.domain;

import java.util.ArrayList;


public class WeatherInfo {
    private City city;
    private ArrayList<DayInfo> weatherList;

    public WeatherInfo(City city, ArrayList<DayInfo> weatherList) {
        this.city = city;
        this.weatherList = weatherList;
    }

    public WeatherInfo() {


    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public ArrayList<DayInfo> getWeatherList() {
        return weatherList;
    }

    public void setWeatherList(ArrayList<DayInfo> weatherList) {
        this.weatherList = weatherList;
    }
}
