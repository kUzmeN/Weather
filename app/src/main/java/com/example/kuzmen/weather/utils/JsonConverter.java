package com.example.kuzmen.weather.utils;

import com.example.kuzmen.weather.domain.City;
import com.example.kuzmen.weather.domain.DayInfo;
import com.example.kuzmen.weather.domain.WeatherInfo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JsonConverter {
    private ArrayList<DayInfo> dayInfoList;
    private DayInfo dayInfo;
    private City city;
    private JSONArray responseWeatherArray;
    private JSONObject responseDayFromArray;
    private WeatherInfo weatherInfo;

    public WeatherInfo getWeatherInfoFromJson(JSONObject jsonObject) {
        weatherInfo = new WeatherInfo();
        dayInfoList = new ArrayList<>();
        city = new City();
        try {
            city.setName(jsonObject.getJSONObject("city").getString("name"));

            responseWeatherArray = jsonObject.getJSONArray("list");
            for (int i = 0; i < responseWeatherArray.length(); i++) {

                responseDayFromArray = responseWeatherArray.getJSONObject(i);
                dayInfo = new DayInfo();
                dayInfo.setDate(responseDayFromArray.getLong("dt"));
                dayInfo.setWeekDay(responseDayFromArray.getLong("dt"));
                dayInfo.setTempDay(responseDayFromArray.getJSONObject("temp").getInt("day"));
                dayInfo.setTempMax(responseDayFromArray.getJSONObject("temp").getInt("max"));
                dayInfo.setTempMin(responseDayFromArray.getJSONObject("temp").getInt("min"));
                dayInfo.setPressure(responseDayFromArray.getInt("pressure"));
                dayInfo.setHumidity(responseDayFromArray.getInt("humidity"));
                dayInfo.setMain(responseDayFromArray.getJSONArray("weather").getJSONObject(0).getString("main"));
                dayInfo.setDescription(responseDayFromArray.getJSONArray("weather").getJSONObject(0).getString("description"));
                dayInfo.setWindSpeed(responseDayFromArray.getInt("speed"));
                dayInfoList.add(dayInfo);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        weatherInfo.setCity(city);
        weatherInfo.setWeatherList(dayInfoList);
        return weatherInfo;
    }
}
