package io.sokolvault13.carwashforecast.ParserObjects;

public class WeatherData {

    private double latitude;
    private double longitude;
    private Currently currently;
    private Daily daily;

    public WeatherData(double latitude, double longitude, Currently currently, Daily daily) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.currently = currently;
        this.daily = daily;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public Currently getCurrently() {
        return currently;
    }

    public void setCurrently(Currently currently) {
        this.currently = currently;
    }

    public Daily getDaily() {
        return daily;
    }

    public void setDaily(Daily daily) {
        this.daily = daily;
    }

    @Override
    public String toString() {
        return "WeatherData{" +
                "latitude=" + latitude +
                ", longitude=" + longitude +
                ", currently=" + currently +
                ", daily=" + daily +
                '}';
    }
}




