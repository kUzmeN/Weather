package com.example.kuzmen.weather.activities;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.kuzmen.weather.R;
import com.example.kuzmen.weather.adapters.WeatherListAdapter;
import com.example.kuzmen.weather.domain.City;
import com.example.kuzmen.weather.domain.DayInfo;
import com.example.kuzmen.weather.domain.WeatherInfo;
import com.example.kuzmen.weather.factory.WeatherService;
import com.example.kuzmen.weather.factory.WeatherServiceFactory;
import com.example.kuzmen.weather.factory.impl.WeatherServiceApiFactory;
import com.example.kuzmen.weather.listeners.OnWeatherSearchListener;
import com.example.kuzmen.weather.utils.Config;

import java.util.ArrayList;
import java.util.Locale;

/**
 * В ListWeatherActivity , мы получаем координаты с предыдущей MainActivity
 * отправляем запрос и получаем ответ с данными о погоде.
 */

public class WeatherListActivity extends Activity implements OnWeatherSearchListener {

    private City city;
    private DayInfo dayInfo;
    private float latitude;
    private float longitude;
    private int countDaysForRequest = 5;
    private ListView listWeather;
    private WeatherListAdapter weatherListAdapter;
    private ArrayList<DayInfo> arrayListForListView;
    private WeatherService weatherService;
    private WeatherServiceFactory serviceCreator;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_list);
        listWeather = (ListView) findViewById(R.id.lvWeatherList);

        Intent intent = getIntent();
        latitude = intent.getFloatExtra(Config.LATITUDE, 53.9f);
        longitude = intent.getFloatExtra(Config.LONGITUDE, 27.56f);

        serviceCreator = new WeatherServiceApiFactory();
        weatherService = serviceCreator.createWeatherService(WeatherServiceApiFactory.OPENWEATHERMAP, this);
        weatherService.setOnWeatherListener(this);

        final Locale current = getResources().getConfiguration().locale;

        listWeather.setOnScrollListener(new AbsListView.OnScrollListener() {
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            public void onScroll(AbsListView view, int firstVisibleItem,
                                 int visibleItemCount, int totalItemCount) {
                if (totalItemCount > 0 && totalItemCount < 16) {
                    boolean loadMore = firstVisibleItem + visibleItemCount >= totalItemCount;
                    if (loadMore) {
                        countDaysForRequest = countDaysForRequest + 1;
                        weatherService.searchWeather(current, countDaysForRequest, latitude, longitude);
                    }
                } else if (totalItemCount == 0) {
                    weatherService.searchWeather(current, countDaysForRequest, latitude, longitude);
                }
            }
        });


        listWeather.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View clickView, int position, long id) {

                dayInfo = arrayListForListView.get(position);

                Intent intent = new Intent(getApplicationContext(), WeatherDetailActivity.class);

                intent.putExtra(Config.CITY, city.getName());
                intent.putExtra(Config.WEEAKDAY, dayInfo.getWeekDay());
                intent.putExtra(Config.MAIN, dayInfo.getMain());
                intent.putExtra(Config.DESCRIPTION, dayInfo.getDescription());
                intent.putExtra(Config.TEMPDAY, dayInfo.getTempDay());
                intent.putExtra(Config.MAXTEMP, dayInfo.getTempMax());
                intent.putExtra(Config.MINTEMP, dayInfo.getTempMin());
                intent.putExtra(Config.PRESSURE, String.valueOf(dayInfo.getPressure()));
                intent.putExtra(Config.HUMIDITY, String.valueOf(dayInfo.getHumidity()));
                intent.putExtra(Config.WINDSPEED, String.valueOf(dayInfo.getWindSpeed()));

                startActivity(intent);
            }
        });

    }


    @Override
    public void onSearchWeather(WeatherInfo weatherInfo) {
        city = weatherInfo.getCity();
        arrayListForListView = weatherInfo.getWeatherList();
        if (weatherListAdapter == null) {
            weatherListAdapter = new WeatherListAdapter(this, arrayListForListView);
            listWeather.setAdapter(weatherListAdapter);
        } else {
            weatherListAdapter.add(arrayListForListView);
            weatherListAdapter.notifyDataSetChanged();

        }
    }


}
