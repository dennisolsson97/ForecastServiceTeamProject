package se.iths.group.forecastserviceteamproject.service;

public class WeatherForecast {

    private String name;

    private Double temperature;

    private Double humidity;

    private String time;


    public WeatherForecast(String name, Double temperature, Double humidity, String time) {
        this.name = name;
        this.temperature = temperature;
        this.humidity = humidity;
        this.time = time;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Double getHumidity() {
        return humidity;
    }

    public void setHumidity(Double humidity) {
        this.humidity = humidity;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "WeatherAttributes{" +
                "name='" + name + '\'' +
                ", temperature=" + temperature +
                ", humidity=" + humidity +
                ", time='" + time + '\'' +
                '}';
    }
}
