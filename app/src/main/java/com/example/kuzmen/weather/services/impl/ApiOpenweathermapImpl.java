package com.example.kuzmen.weather.services.impl;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.kuzmen.weather.services.WeatherServiceApi;
import com.example.kuzmen.weather.domain.WeatherInfo;
import com.example.kuzmen.weather.listeners.OnWeatherSearchListener;
import com.example.kuzmen.weather.utils.Config;
import com.example.kuzmen.weather.utils.JsonConverter;

import org.json.JSONObject;

import java.util.Locale;



public class ApiOpenweathermapImpl implements WeatherServiceApi {

    private static final String URL_TEMPLATE = "http://api.openweathermap.org/data/2.5/forecast/daily?lat=%f&lon=%f&cnt=%d&lang=%s&APPID=%s";
    private RequestQueue requestQueue;
    private WeatherInfo weatherInfo;
    private JsonObjectRequest jsonObjectRequest;
    private JsonConverter jsonConverter;
    private int count;
    private OnWeatherSearchListener myListener;

    public ApiOpenweathermapImpl(Context context) {
        requestQueue = Volley.newRequestQueue(context);
    }

    @Override
    public void searchWeather(Locale locale, int countDays, float latitude, float longitude) {
        jsonConverter = new JsonConverter();
        if (countDays > 16)
            count = 16;
        else
            count = countDays;
        String url = String.format(Locale.ENGLISH, URL_TEMPLATE, latitude, longitude, count, locale.getLanguage(), Config.API_KEY);

        jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                weatherInfo = jsonConverter.getWeatherInfoFromJson(response);
                myListener.onSearchWeather(weatherInfo);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        requestQueue.add(jsonObjectRequest);
    }

    @Override
    public void setOnWeatherListener(OnWeatherSearchListener listener) {
        myListener = listener;
    }

}
