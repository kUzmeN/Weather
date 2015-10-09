package com.example.kuzmen.weather.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.kuzmen.weather.R;
import com.example.kuzmen.weather.utils.Config;
import com.example.kuzmen.weather.utils.validator.LatitudeValidator;
import com.example.kuzmen.weather.utils.validator.LongitudeValidator;

/**
 * MainActivity which takes coordinates and starts the WeatherListActivity
 */
public class MainActivity extends Activity {
    EditText edtLatitude;
    EditText edtLongitude;
    LatitudeValidator latitudeValidator;
    LongitudeValidator longitudeValidator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtLatitude = (EditText) findViewById(R.id.edtLatitude);
        edtLongitude = (EditText) findViewById(R.id.edtLongitude);

        // set coordinates for default location
        edtLatitude.setText("53.9");
        edtLongitude.setText("27.57");

        latitudeValidator = new LatitudeValidator(edtLatitude);
        longitudeValidator = new LongitudeValidator(edtLongitude);

        edtLatitude.addTextChangedListener(latitudeValidator);
        edtLongitude.addTextChangedListener(longitudeValidator);


    }


    public void onClickSearch(View v) {
        Intent intent = new Intent(this, WeatherListActivity.class);

        boolean latitudeValid = latitudeValidator.onClickValidate(edtLatitude);
        boolean longitudeValid = longitudeValidator.onClickValidate(edtLongitude);
        if (latitudeValid == true && longitudeValid == true) {
            intent.putExtra(Config.LATITUDE, Float.parseFloat(edtLatitude.getText().toString()));
            intent.putExtra(Config.LONGITUDE, Float.parseFloat(edtLongitude.getText().toString()));
            startActivity(intent);
        }


    }


}
