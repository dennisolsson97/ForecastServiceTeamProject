package se.iths.group.forecastserviceteamproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.iths.group.forecastserviceteamproject.restclients.MetClient;
import se.iths.group.forecastserviceteamproject.restclients.SmhiClient;
import se.iths.group.forecastserviceteamproject.restclients.WeatherAPIClient;

import java.util.*;

@Service
public class ForecastService {

    @Autowired
    SmhiClient smhiClient;

    @Autowired
    MetClient metClient;

    @Autowired
    WeatherAPIClient weatherAPIClient;


    public WeatherForecast getBestWeather() {


        WeatherForecast metiForecast = new WeatherForecast("METI", metClient.getTemperature(), metClient.getHumidity(), metClient.getTime());
        WeatherForecast smhiForecast = new WeatherForecast("SMHI", smhiClient.getTemperature(), smhiClient.getHumidity(), smhiClient.getTime());
        WeatherForecast wapiForecast = new WeatherForecast("WeatherAPI", weatherAPIClient.getTemperature(), weatherAPIClient.getHumidity(), weatherAPIClient.getTime());

        List<WeatherForecast> forecasts = new ArrayList<>();

        forecasts.add(metiForecast);
        forecasts.add(smhiForecast);
        forecasts.add(wapiForecast);

        Comparator<WeatherForecast> sortByTemperature = ((o1, o2) -> (int) (o2.getTemperature() - o1.getTemperature()));
        Comparator<WeatherForecast> sortByHumidity = ((o1, o2) -> (int) (o2.getHumidity() - o1.getHumidity()));

        forecasts.sort(sortByTemperature);

        if (forecasts.get(0).getTemperature() == forecasts.get(2).getTemperature()) {

            forecasts.sort(sortByHumidity);

        } else if (forecasts.get(0).getTemperature() == forecasts.get(1).getTemperature()) {
            forecasts.remove(2);
            forecasts.sort(sortByHumidity);

        }

        WeatherForecast bestWeatherForecast = forecasts.get(0);

        return bestWeatherForecast;

    }




}
