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

public class SmhiClient {
    RestTemplate restTemplate = new RestTemplate();
    String baserUrl = "https://opendata-download-metfcst.smhi.se/api/category/pmp3g/version/2/geotype/point/lon/18.0300/lat/59.3110/data.json";

    public static void main(String[] args) {
        SmhiClient smhiClient = new SmhiClient();
        smhiClient.getTemperature();
        //smhiClient.getParameterData();

    }

    public void getTemperature() {
        ResponseEntity<ForecastSmhi> responseAllData = restTemplate.exchange(baserUrl, HttpMethod.GET, null, ForecastSmhi.class);
        ForecastSmhi forecastSmhi = responseAllData.getBody();
        String s = forecastSmhi.getTimeSeries().get(23).getValidTime();
        System.out.println(s);
        List<Parameter> parameters = forecastSmhi.getTimeSeries().get(23).getParameters();
        parameters.stream()
                .filter(p -> p.getName().equals("t"))
                .map((p) -> p.getValues())
                .forEach(System.out::println);
    }

}
