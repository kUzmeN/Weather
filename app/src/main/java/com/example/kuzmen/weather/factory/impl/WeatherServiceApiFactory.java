package com.example.kuzmen.weather.factory.impl;

import android.content.Context;

import com.example.kuzmen.weather.factory.WeatherServiceFactory;
import com.example.kuzmen.weather.services.impl.ApiOpenweathermapImpl;
import com.example.kuzmen.weather.services.WeatherService;

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
