package se.iths.group.forecastserviceteamproject.service;

public class WeatherAttributes {

   private Double temperature;

   private Double humidity;

   private String time;

    public WeatherAttributes(Double temperature, Double humidity, String time) {
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

    @Override
    public String toString() {
        return "WeatherAttributes{" +
                "temperature=" + temperature +
                ", humidity=" + humidity +
                ", time='" + time + '\'' +
                '}';
    }
}
