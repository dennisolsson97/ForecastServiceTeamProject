package se.iths.group.forecastserviceteamproject.restclients;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import se.iths.group.forecastserviceteamproject.smhi.ForecastSmhi;
import se.iths.group.forecastserviceteamproject.smhi.Parameter;
import se.iths.group.forecastserviceteamproject.smhi.TimeSeries;

import java.lang.reflect.Type;
import java.util.List;
import java.util.stream.Collectors;

public class SmhiClient {

    RestTemplate restTemplate = new RestTemplate();
    String baserUrl = "https://opendata-download-metfcst.smhi.se/api/category/pmp3g/version/2/geotype/point/lon/18.0300/lat/59.3110/data.json";
    ResponseEntity<ForecastSmhi> responseAllData = restTemplate.exchange(baserUrl, HttpMethod.GET, null, ForecastSmhi.class);

    ForecastSmhi forecastSmhi = responseAllData.getBody();

    public String getTime() {

        return forecastSmhi.getTimeSeries().get(23).getValidTime();
    }

    public Double getTemperature() {

        List<Parameter> parameters = forecastSmhi.getTimeSeries().get(23).getParameters();
        Double temperature = 0.0;

        for (Parameter p: parameters) {
            if (p.getName().equals("t"))
             temperature = p.getValues().get(0);
        }

        return temperature;

    }

    public Double getHumidity() {

        List<Parameter> parameters = forecastSmhi.getTimeSeries().get(23).getParameters();
        Double humidity = 0.0;

        for (Parameter p: parameters) {
            if (p.getName().equals("r"))
                humidity = p.getValues().get(0);
        }
        return humidity;
    }
}
