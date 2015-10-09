package com.example.kuzmen.weather.factory;

import com.example.kuzmen.weather.listeners.SetOnSearchWeatherListener;

import java.util.Locale;

public interface WeatherService extends SetOnSearchWeatherListener {

    void searchWeather(Locale locale, int countDays, float latitude, float longitude);

}