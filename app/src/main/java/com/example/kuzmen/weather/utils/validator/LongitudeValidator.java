package com.example.kuzmen.weather.utils.validator;

import android.widget.TextView;


public class LongitudeValidator extends TextValidator {
    public LongitudeValidator(TextView textView) {
        super(textView);
    }

    @Override
    public void validate(TextView textView) {
        vaildateBase(textView);
    }

    public boolean onClickValidate(TextView textView) {
        return vaildateBase(textView);
    }

    private boolean vaildateBase(TextView textView) {
        float valueLongitude;
        boolean isValid = false;
        try {
            valueLongitude = Float.parseFloat(textView.getText().toString());
            isValid = true;
        } catch (NumberFormatException ex) {
            valueLongitude = 0.f;
            textView.setError("Please enter correct Longitude[-180;180]");
        }
        if (valueLongitude > 180 || valueLongitude < -180) {
            textView.setError("Please enter correct Longitude[-180;180]");
            isValid = false;
        }

        return isValid;

    }
}
