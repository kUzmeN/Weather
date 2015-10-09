package com.example.kuzmen.weather.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kuzmen.weather.R;
import com.example.kuzmen.weather.utils.Config;

/**
 *  WeatherDetailActivity contains detailed information about the weather.
 */
public class WeatherDetailActivity extends Activity {
    private String main;
    private String cityName;
    private String weekDay;
    private String tempDay;
    private String maxTemp;
    private String minTemp;
    private String pressure;
    private String humidity;
    private String windSpeed;
    private String description;

    private ImageView tvImage;
    private TextView tvCity;
    private TextView tvWeekDay;
    private TextView tvDescription;
    private TextView tvTempDay;
    private TextView tvMaxTemp;
    private TextView tvMinTemp;
    private TextView tvPressure;
    private TextView tvHumidity;
    private TextView tvWindSpeed;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_detail);

        Intent intent = getIntent();

        main = intent.getStringExtra(Config.MAIN);
        cityName = intent.getStringExtra(Config.CITY);
        weekDay = intent.getStringExtra(Config.WEEAKDAY);
        tempDay = intent.getStringExtra(Config.TEMPDAY);
        maxTemp = intent.getStringExtra(Config.MAXTEMP);
        minTemp = intent.getStringExtra(Config.MINTEMP);
        pressure = intent.getStringExtra(Config.PRESSURE);
        humidity = intent.getStringExtra(Config.HUMIDITY);
        windSpeed = intent.getStringExtra(Config.WINDSPEED);
        description = intent.getStringExtra(Config.DESCRIPTION);


        tvImage = (ImageView) findViewById(R.id.imageView);
        tvCity = (TextView) findViewById(R.id.tvDetailCity);
        tvWeekDay = (TextView) findViewById(R.id.tvDetailWeekDay);
        tvDescription = (TextView) findViewById(R.id.tvDetailDescription);
        tvTempDay = (TextView) findViewById(R.id.tvDetailTempDay);
        tvMaxTemp = (TextView) findViewById(R.id.tvDetailTempMax);
        tvMinTemp = (TextView) findViewById(R.id.tvDetailTempMin);
        tvPressure = (TextView) findViewById(R.id.tvDetailPressure);
        tvHumidity = (TextView) findViewById(R.id.tvDetailHumidity);
        tvWindSpeed = (TextView) findViewById(R.id.tvDetailWindSpeed);


        tvCity.setText(cityName);
        tvWeekDay.setText(weekDay);
        tvDescription.setText(description);
        tvTempDay.setText(tempDay);
        tvMaxTemp.setText(maxTemp + "/");
        tvMinTemp.setText(minTemp);
        tvPressure.setText(pressure + getApplicationContext().getResources().getString(R.string.measurePressure));
        tvHumidity.setText(humidity + "%");
        tvWindSpeed.setText(windSpeed + getApplicationContext().getResources().getString(R.string.measureWindSpeed));
        setImageView(main);

    }


    private void setImageView(String type) {
        switch (type) {
            case Config.CLEAR:
                tvImage.setImageResource(R.drawable.sunny);
                break;
            case Config.RAIN:
                tvImage.setImageResource(R.drawable.rain);
                break;
            case Config.CLOUDS:
                tvImage.setImageResource(R.drawable.cloudy);
                break;

            default:
                tvImage.setImageResource(R.drawable.cloudy);
                break;
        }

    }


}
