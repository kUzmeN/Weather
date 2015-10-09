package com.example.kuzmen.weather.domain;

public class DayInfo {

    private String date;
    private String weekDay;
    private String tempDay;
    private String tempMin;
    private String tempMax;
    private int pressure;
    private int humidity;
    private int windSpeed;
    private String Main;
    private String Description;

    public DayInfo() {

    }

    public DayInfo(String date, String weekDay, String tempDay, String tempMin, String tempMax, int pressure, int humidity, int windSpeed, String main) {
        this.date = date;
        this.weekDay = weekDay;
        this.tempDay = tempDay;
        this.tempMin = tempMin;
        this.tempMax = tempMax;
        this.pressure = pressure;
        this.humidity = humidity;
        this.windSpeed = windSpeed;
        Main = main;
    }

    public String getTempMin() {
        return tempMin;
    }

    public void setTempMin(int tempMin) {
        this.tempMin = Integer.toString(tempMin - 273) + (char) 176;
    }

    public String getTempMax() {
        return tempMax;
    }

    public void setTempMax(int tempMax) {
        this.tempMax = Integer.toString(tempMax - 273) + (char) 176;
    }

    public String getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(Long date) {
        this.weekDay = new java.text.SimpleDateFormat("EEEE").format(date * 1000);
    }

    public String getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = new java.text.SimpleDateFormat("dd.MM").format(date * 1000);
    }

    public String getTempDay() {
        return tempDay;
    }

    public void setTempDay(int tempAvg) {
        this.tempDay = Integer.toString(tempAvg - 273) + (char) 176;
    }

    public int getPressure() {
        return pressure;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public int getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(int windSpeed) {
        this.windSpeed = windSpeed;
    }

    public String getMain() {
        return Main;
    }

    public void setMain(String main) {
        Main = main;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }


}
