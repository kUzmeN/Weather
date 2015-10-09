package com.example.kuzmen.weather.domain;

public class Coordinates {
    private float longitude;
    private float latitude;

    public Coordinates() {
    }

    public Coordinates(float longitude, float latitude) {

        this.longitude = longitude;
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    @Override
    public String toString() {
        return "com.example.kuzmen.weatherbetatrue.domain.Coordinates{" +
                "longitude=" + longitude +
                ", latitude=" + latitude +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Coordinates that = (Coordinates) o;

        if (Float.compare(that.latitude, latitude) != 0) return false;
        if (Float.compare(that.longitude, longitude) != 0) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (longitude != +0.0f ? Float.floatToIntBits(longitude) : 0);
        result = 31 * result + (latitude != +0.0f ? Float.floatToIntBits(latitude) : 0);
        return result;
    }

}
