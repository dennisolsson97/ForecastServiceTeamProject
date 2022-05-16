package se.iths.group.forecastserviceteamproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.iths.group.forecastserviceteamproject.business.model.weatherforecast.WeatherForecast;
import se.iths.group.forecastserviceteamproject.dao.restclients.MetClient;
import se.iths.group.forecastserviceteamproject.dao.restclients.SmhiClient;
import se.iths.group.forecastserviceteamproject.dao.restclients.WeatherAPIClient;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ForecastService {

    @Autowired
    SmhiClient smhiClient;

    @Autowired
    MetClient metClient;

    @Autowired
    WeatherAPIClient weatherAPIClient;

    public ForecastService(SmhiClient smhiClient, MetClient metClient, WeatherAPIClient weatherAPIClient) {
        this.smhiClient = smhiClient;
        this.metClient = metClient;
        this.weatherAPIClient = weatherAPIClient;
    }

    public WeatherForecast getBestWeather() {


        WeatherForecast metiForecast = new WeatherForecast("METI", metClient.getTemperature(), metClient.getHumidity(), metClient.getTime());
        WeatherForecast smhiForecast = new WeatherForecast("SMHI", smhiClient.getTemperature(), smhiClient.getHumidity(), smhiClient.getTime());
        WeatherForecast wapiForecast = new WeatherForecast("WeatherAPI", weatherAPIClient.getTemperature(), weatherAPIClient.getHumidity(), weatherAPIClient.getTime());

        List<WeatherForecast> forecasts = new ArrayList<>();

        forecasts.add(metiForecast);
        forecasts.add(smhiForecast);
        forecasts.add(wapiForecast);


        forecasts = forecasts.stream().sorted((e1, e2) -> Double.compare( e2.getTemperature(), e1.getTemperature())).collect(Collectors.toList());



        if (Double.compare(forecasts.get(0).getTemperature(), forecasts.get(2).getTemperature()) == 0) {

            forecasts = forecasts.stream().sorted((e1, e2) -> Double.compare( e2.getHumidity(), e1.getHumidity())).collect(Collectors.toList());


        } else if (Double.compare(forecasts.get(0).getTemperature(), forecasts.get(1).getTemperature()) == 0) {
            forecasts.remove(2);
            forecasts = forecasts.stream().sorted((e1, e2) -> Double.compare( e2.getHumidity(), e1.getHumidity())).collect(Collectors.toList());

        }

        WeatherForecast bestWeatherForecast = forecasts.get(0);

        return bestWeatherForecast;

    }










}
