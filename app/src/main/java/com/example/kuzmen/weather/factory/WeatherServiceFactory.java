package com.example.kuzmen.weather.factory;

import android.content.Context;


public interface WeatherServiceFactory {
    WeatherService createWeatherService(String type, Context context);
}
