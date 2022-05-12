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

    public ForecastService(SmhiClient smhiClient, MetClient metClient, WeatherAPIClient weatherAPIClient) {
        this.smhiClient = smhiClient;
        this.metClient = metClient;
        this.weatherAPIClient = weatherAPIClient;
    }

    public static void main(String[] args) {
        SmhiClient smhiClient = new SmhiClient();
        MetClient metClient = new MetClient();
        WeatherAPIClient wheatherAPi = new WeatherAPIClient();

        ForecastService forecastService = new ForecastService(smhiClient, metClient, wheatherAPi);
        forecastService.getBestWeather();
    }

    public WeatherAttributes getBestWeather() {


        WeatherAttributes metAttributes = new WeatherAttributes("METI", metClient.getTemperature(), metClient.getHumidity(), metClient.getTime());
        WeatherAttributes smhiAttributes = new WeatherAttributes("SMHI", smhiClient.getTemperature(), smhiClient.getHumidity(), smhiClient.getTime());
        WeatherAttributes apiAttributes = new WeatherAttributes("WeatherAPI", weatherAPIClient.getTemperature(), weatherAPIClient.getHumidity(), weatherAPIClient.getTime());

        List<WeatherAttributes> attributes = new ArrayList<>();

        attributes.add(metAttributes);
        attributes.add(smhiAttributes);
        attributes.add(apiAttributes);

        Comparator<WeatherAttributes> sortByTemperature = ((o1, o2) -> (int) (o2.getTemperature() - o1.getTemperature()));
        Comparator<WeatherAttributes> sortByHumidity = ((o1, o2) -> (int) (o2.getHumidity() - o1.getHumidity()));

        attributes.sort(sortByTemperature);

        if (attributes.get(0).getTemperature() == attributes.get(2).getTemperature()) {

            attributes.sort(sortByHumidity);

        } else if (attributes.get(0).getTemperature() == attributes.get(1).getTemperature()) {
            attributes.remove(2);
            attributes.sort(sortByHumidity);

        }

        WeatherAttributes bestWeatherValue = attributes.get(0);

        System.out.println(metAttributes);
        System.out.println(smhiAttributes);
        System.out.println(apiAttributes);

        System.out.println(bestWeatherValue);


        return bestWeatherValue;
    }




}
