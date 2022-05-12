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


        WeatherAttributes metAttributes = new WeatherAttributes(metClient.getTemperature(), metClient.getHumidity(), metClient.getTime());
        WeatherAttributes smhiAttributes = new WeatherAttributes(smhiClient.getTemperature(), smhiClient.getHumidity(), smhiClient.getTime());
        WeatherAttributes apiAttributes = new WeatherAttributes(weatherAPIClient.getTemperature(), weatherAPIClient.getHumidity(), weatherAPIClient.getTime());

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

        System.out.println(bestWeatherValue);


        return bestWeatherValue;
    }


    public Map getBestWeather2() {

        String timeSmhi = smhiClient.getTime();

        String timeMet = metClient.getTime();

        Double timeSMhiDouble = Double.parseDouble(timeSmhi);

        Double timeMetDouble = Double.parseDouble(timeMet);

        Double temparatureMet = metClient.getTemperature();

        Double temperatureSmhi = smhiClient.getTemperature();

        Double temperatureWeatherAPI = weatherAPIClient.getTemperature();

        Double smhiHumidity = smhiClient.getHumidity();

        Double metHumidity = metClient.getHumidity();

        Map<String, Double> mapSmhi = new HashMap<String, Double>();

        mapSmhi.put("Time", timeSMhiDouble);
        mapSmhi.put("Temperature", temperatureSmhi);
        mapSmhi.put("Humidity", smhiHumidity);

        List<Double> temperatures = new ArrayList<>();

        temperatures.add(temparatureMet);

        temperatures.add(temperatureSmhi);

        temperatures.add(temperatureWeatherAPI);

        Collections.sort(temperatures);

      /*  for (Double t:temperatures) {
            System.out.println(t);
        }*/

        Double bestWheatherValue = temperatures.get(2);

        if (temperatures.get(2) == temperatures.get(1) || temperatures.get(2) == temperatures.get(0)) {

            // bestWheatherValue =
        }


        Double humiditySmhi = smhiClient.getHumidity();

        Double humidity = metClient.getHumidity();

        //Map<String,> additionalProperties = new HashMap<ForecastMet, ForecastSmhi>();

        //Map<String, Object> additionalProperties = new HashMap<String, Object>();

        return mapSmhi;

    }
}
