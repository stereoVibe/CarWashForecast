package io.sokolvault13.carwashforecast.ParserObjects;

public class Datum {
    private long time;
    private String summary;
    private double precipIntensity;
    private double precipProbability;
    private double temperature;
    private double temperatureMin;
    private double dewPoint;
    private double humidity;
    private double windSpeed;
    private double cloudCover;
    private double pressure;

    public Datum(long time,
                 String summary,
                 long precipIntensity,
                 long precipProbability,
                 double temperature,
                 double dewPoint,
                 double humidity,
                 double windSpeed,
                 double cloudCover,
                 double pressure) {
        this.time = time;
        this.summary = summary;
        this.precipIntensity = precipIntensity;
        this.precipProbability = precipProbability;
        this.temperature = temperature;
        this.dewPoint = dewPoint;
        this.humidity = humidity;
        this.windSpeed = windSpeed;
        this.cloudCover = cloudCover;
        this.pressure = pressure;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public double getPrecipIntensity() {
        return precipIntensity;
    }

    public void setPrecipIntensity(long precipIntensity) {
        this.precipIntensity = precipIntensity;
    }

    public double getPrecipProbability() {
        return precipProbability;
    }

    public void setPrecipProbability(long precipProbability) {
        this.precipProbability = precipProbability;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getDewPoint() {
        return dewPoint;
    }

    public void setDewPoint(double dewPoint) {
        this.dewPoint = dewPoint;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public double getCloudCover() {
        return cloudCover;
    }

    public void setCloudCover(double cloudCover) {
        this.cloudCover = cloudCover;
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public double getTemperatureMin() {
        return temperatureMin;
    }

    public void setTemperatureMin(double temperatureMin) {
        this.temperatureMin = temperatureMin;
    }

    @Override
    public String toString() {
        return "Datum{" +
                "time=" + time +
                ", summary='" + summary + '\'' +
                ", precipIntensity=" + precipIntensity +
                ", precipProbability=" + precipProbability +
                ", temperature=" + temperature +
                ", temperatureMin=" + temperatureMin +
                ", dewPoint=" + dewPoint +
                ", humidity=" + humidity +
                ", windSpeed=" + windSpeed +
                ", cloudCover=" + cloudCover +
                ", pressure=" + pressure +
                '}';
    }
}
