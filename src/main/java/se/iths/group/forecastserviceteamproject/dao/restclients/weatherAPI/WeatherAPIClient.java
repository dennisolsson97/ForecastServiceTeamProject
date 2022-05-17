package se.iths.group.forecastserviceteamproject.dao.restclients.weatherAPI;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import se.iths.group.forecastserviceteamproject.dao.restclients.weatherAPI.ForecastWeatherAPI;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Component
public class WeatherAPIClient {

    RestTemplate restTemplate = new RestTemplate();
    String baseUrl = "http://api.weatherapi.com/v1/forecast.json?key=17205ec47470479ead6113658221105&q=59.3110,18.0300&days=2&aqi=no&alerts=no";
    ForecastWeatherAPI weatherAPI = restTemplate.getForObject(baseUrl, ForecastWeatherAPI.class);

    LocalTime localTime = LocalTime.now();
    String localTimeString = localTime.toString();
    String hourNowString = localTimeString.substring(0, 2);
    Integer hourNow = Integer.parseInt(hourNowString);

    public String getTime() {


        String time = weatherAPI.getForecast().getForecastday().get(1).getHour().get(hourNow).getTime();

        LocalDateTime time2 = LocalDateTime.parse(time, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));

        time = time2.minusHours(2).toString();

        time = time + "Z";

        return time;

    }

    public Double getTemperature() {

        double temperature = weatherAPI.getForecast()
                .getForecastday()
                .get(1)
                .getHour()
                .get(hourNow)
                .getTempC();

        return temperature;

    }

    public Double getHumidity() {

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
