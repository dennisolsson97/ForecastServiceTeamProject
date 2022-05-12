package se.iths.group.forecastserviceteamproject.restclients;

import org.springframework.web.client.RestTemplate;
import se.iths.group.forecastserviceteamproject.weatherAPI.ForecastWeatherAPI;

import java.time.LocalTime;

public class WeatherAPIClient {

    RestTemplate restTemplate = new RestTemplate();
    String baseUrl = "http://api.weatherapi.com/v1/forecast.json?key=17205ec47470479ead6113658221105&q=59.3110,18.0300&days=2&aqi=no&alerts=no";
    ForecastWeatherAPI weatherAPI = restTemplate.getForObject(baseUrl, ForecastWeatherAPI.class);

    LocalTime localTime = LocalTime.now();

    public static void main(String[] args) {
        WeatherAPIClient weatherAPIClient = new WeatherAPIClient();
        weatherAPIClient.getTime();
        weatherAPIClient.getTemperature();
        weatherAPIClient.getHumidity();

    }

    public String getTime() {
        String localTimeString = localTime.toString();
        System.out.println(localTimeString);
        String local = localTimeString.substring(0, 2);
        // System.out.println(local);
        Integer hourNow = Integer.parseInt(local);

        String time = weatherAPI.getForecast().getForecastday().get(1).getHour().get(hourNow).getTime();

        return time;

    }

    public double getTemperature() {
        String localTimeString = localTime.toString();
        String local = localTimeString.substring(0, 2);
        Integer hourNow = Integer.parseInt(local);

        double temperature = weatherAPI.getForecast()
                .getForecastday()
                .get(1)
                .getHour()
                .get(hourNow)
                .getTempC();

        return temperature;

    }

    public double getHumidity() {
        String localTimeString = localTime.toString();
        String local = localTimeString.substring(0, 2);
        Integer hourNow = Integer.parseInt(local);

        double humidity = weatherAPI
                .getForecast()
                .getForecastday()
                .get(1)
                .getHour()
                .get(hourNow)
                .getHumidity();

        return humidity;
    }
}
