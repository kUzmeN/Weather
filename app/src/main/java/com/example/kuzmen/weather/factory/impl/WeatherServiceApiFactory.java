package com.example.kuzmen.weather.factory.impl;

import android.content.Context;

import com.example.kuzmen.weather.factory.WeatherService;
import com.example.kuzmen.weather.factory.WeatherServiceFactory;

public class WeatherServiceApiFactory implements WeatherServiceFactory {
    public static final String OPENWEATHERMAP = "openweathermap";

    @Override
    public WeatherService createWeatherService(String type, Context context) {
        if (type.equals(OPENWEATHERMAP)) {
            return new ApiOpenweathermapImpl(context);
        }
        return null;
    }
}
