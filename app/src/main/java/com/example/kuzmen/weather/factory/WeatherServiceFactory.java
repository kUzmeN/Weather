package com.example.kuzmen.weather.factory;

import android.content.Context;

import com.example.kuzmen.weather.services.WeatherService;


public interface WeatherServiceFactory {
    WeatherService createWeatherService(String type, Context context);
}
