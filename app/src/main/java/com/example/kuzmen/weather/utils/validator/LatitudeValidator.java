package com.example.kuzmen.weather.utils.validator;

import android.widget.TextView;

public class LatitudeValidator extends TextValidator{


    public LatitudeValidator(TextView textView) {
        super(textView);
    }

    @Override
    public void validate(TextView textView) {
        vaildateBase(textView);
    }

    public boolean onClickValidate(TextView textView){
        return vaildateBase(textView);
    }

    private boolean vaildateBase(TextView textView){
        float valueLatitude;
        boolean  isValid = false;
        try {
            valueLatitude = Float.parseFloat(textView.getText().toString());
            isValid = true;
        } catch (NumberFormatException ex) {
            valueLatitude = 0.f;
            textView.setError("Please enter correct Latitude[-90;90]");
        }
        if (valueLatitude > 90 || valueLatitude < -90) {
            textView.setError("Please enter correct Latitude[-90;90]");
            isValid = false;
        }

        return isValid;

    }
}
