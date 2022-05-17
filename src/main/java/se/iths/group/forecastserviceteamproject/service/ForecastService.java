package se.iths.group.forecastserviceteamproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.iths.group.forecastserviceteamproject.business.model.weatherforecast.WeatherForecast;
import se.iths.group.forecastserviceteamproject.dao.restclients.met.MetClient;
import se.iths.group.forecastserviceteamproject.dao.restclients.smhi.SmhiClient;
import se.iths.group.forecastserviceteamproject.dao.restclients.weatherAPI.WeatherAPIClient;

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


    public WeatherForecast getBestWeather() {


        WeatherForecast metiForecast = new WeatherForecast("METI", metClient.getTemperature(), metClient.getHumidity(), metClient.getTime());
        WeatherForecast smhiForecast = new WeatherForecast("SMHI", smhiClient.getTemperature(), smhiClient.getHumidity(), smhiClient.getTime());
        WeatherForecast wapiForecast = new WeatherForecast("WeatherAPI", weatherAPIClient.getTemperature(), weatherAPIClient.getHumidity(), weatherAPIClient.getTime());

        List<WeatherForecast> forecasts = new ArrayList<>();

        forecasts.add(metiForecast);
        forecasts.add(smhiForecast);
        forecasts.add(wapiForecast);

        Comparator<WeatherForecast> sortByTemperature = (o1, o2) -> (o2.getTemperature().compareTo(o1.getTemperature()));
        Comparator<WeatherForecast> sortByHumidity = (o1, o2) -> (o2.getHumidity().compareTo(o1.getHumidity()));

        forecasts.sort(sortByTemperature);



        if (Double.compare(forecasts.get(0).getTemperature(), forecasts.get(2).getTemperature()) == 0) {

            forecasts.sort(sortByHumidity);

        } else if (Double.compare(forecasts.get(0).getTemperature(), forecasts.get(1).getTemperature()) == 0) {
            forecasts.remove(2);
            forecasts.sort(sortByHumidity);
        }

        WeatherForecast bestWeatherForecast = forecasts.get(0);

        return bestWeatherForecast;

    }


}
