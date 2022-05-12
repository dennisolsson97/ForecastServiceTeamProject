package se.iths.group.forecastserviceteamproject.restclients;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import se.iths.group.forecastserviceteamproject.met.ForecastMet;

@Component
public class MetClient {

    String baseurl = "https://api.met.no/weatherapi/locationforecast/2.0/compact?lat=59.3110&lon=18.0300";
    RestTemplate restTemplate = new RestTemplateBuilder()
            .defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
            .defaultHeader(HttpHeaders.USER_AGENT, "notJava!")
            .build();
    ForecastMet forecastMet = restTemplate.getForObject(baseurl, ForecastMet.class);


    public String getTime(){
        String time = forecastMet.getProperties().getTimeseries().get(24).getTime();

        return time;
    }

    public Double getTemperature(){
        Double temperature = forecastMet.getProperties()
                .getTimeseries()
                .get(24)
                .getData()
                .getInstant()
                .getDetails()
                .getAirTemperature();

        return temperature;
    }

    public Double getHumidity(){
        Double humidity = forecastMet.getProperties()
                .getTimeseries()
                .get(24)
                .getData()
                .getInstant()
                .getDetails()
                .getRelativeHumidity();

        return humidity;
    }
}
