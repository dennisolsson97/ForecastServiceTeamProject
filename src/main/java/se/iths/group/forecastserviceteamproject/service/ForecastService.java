package se.iths.group.forecastserviceteamproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import se.iths.group.forecastserviceteamproject.met.ForecastMet;
import se.iths.group.forecastserviceteamproject.restclients.MetClient;
import se.iths.group.forecastserviceteamproject.restclients.SmhiClient;
import se.iths.group.forecastserviceteamproject.restclients.WeatherAPIClient;
import se.iths.group.forecastserviceteamproject.smhi.ForecastSmhi;

import java.util.*;

public class ForecastService {

    @Autowired
    SmhiClient smhiClient;

    @Autowired
    MetClient metClient;

    @Autowired
    WeatherAPIClient weatherAPIClient;

    public static void main(String[] args) {
        ForecastService forecastService = new ForecastService();
        forecastService.getBestWeather();
    }

    public void getBestWeather() {

        String timeSmhi = smhiClient.getTime();

        String timeMet = metClient.getTime();

        Double temparatureMet = metClient.getTemperature();

        Double temperatureSmhi = smhiClient.getTemperature();

        Double temperatureWeatherAPI = weatherAPIClient.getTemperature();

        List<Double> temperatures = new ArrayList<>();

        temperatures.add(temparatureMet);

        temperatures.add(temperatureSmhi);

        temperatures.add(temperatureWeatherAPI);

        Collections.sort(temperatures);

        for (Double t:temperatures) {
            System.out.println(t);
        }


        Double humiditySmhi = smhiClient.getHumidity();

        Double humidity = metClient.getHumidity();

        //Map<String,> additionalProperties = new HashMap<ForecastMet, ForecastSmhi>();

        //Map<String, Object> additionalProperties = new HashMap<String, Object>();


    }
}
