package se.iths.group.forecastserviceteamproject.restclients;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;
import se.iths.group.forecastserviceteamproject.met.ForecastMet;
import se.iths.group.forecastserviceteamproject.weatherAPI.Forecastday;
import se.iths.group.forecastserviceteamproject.weatherAPI.WeatherAPI;

public class WeatherAPIClient {

    RestTemplate restTemplate = new RestTemplate();
    String baseUrl = "http://api.weatherapi.com/v1/forecast.json?key=17205ec47470479ead6113658221105&q=59.3110,18.0300&days=2&aqi=no&alerts=no";
    WeatherAPI weatherAPI = restTemplate.getForObject(baseUrl, WeatherAPI.class);

    public static void main(String[] args) {
        WeatherAPIClient weatherAPIClient = new WeatherAPIClient();
        weatherAPIClient.getTime();
    }

    public void getTime() {
        String time = weatherAPI.getForecast().getForecastday().get(1).getDate();
        System.out.println(time);
    }

    public void getTemperature() {
    }
}
