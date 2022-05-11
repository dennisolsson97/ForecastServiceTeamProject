package se.iths.group.forecastserviceteamproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import se.iths.group.forecastserviceteamproject.met.ForecastMet;
import se.iths.group.forecastserviceteamproject.restclients.MetClient;
import se.iths.group.forecastserviceteamproject.restclients.SmhiClient;
import se.iths.group.forecastserviceteamproject.smhi.ForecastSmhi;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ForecastService {

    @Autowired
    SmhiClient smhiClient;

    @Autowired
    MetClient metClient;

   public void getBestWeather(){

      String timeSmhi = smhiClient.getTime();

      String timeMet = metClient.getTime();

      Double temparatureMet = metClient.getTemperature();

       Double temperatureSmhi = smhiClient.getTemperature();

       Double humiditySmhi = smhiClient.getHumidity();

       Double humidity = metClient.getHumidity();

       Map<ForecastMet, ForecastSmhi> additionalProperties = new HashMap<ForecastMet, ForecastSmhi>();

       //Map<String, Object> additionalProperties = new HashMap<String, Object>();



    }
}
