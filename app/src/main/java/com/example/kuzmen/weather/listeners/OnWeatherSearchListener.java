package com.example.kuzmen.weather.listeners;

import com.example.kuzmen.weather.domain.WeatherInfo;

public interface OnWeatherSearchListener {
    void onSearchWeather(WeatherInfo weatherInfo);
}