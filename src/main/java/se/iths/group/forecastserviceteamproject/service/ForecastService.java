package se.iths.group.forecastserviceteamproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import se.iths.group.forecastserviceteamproject.restclients.MetClient;
import se.iths.group.forecastserviceteamproject.restclients.SmhiClient;

public class ForecastService {
    @Autowired
    SmhiClient smhiClient;

    @Autowired
    MetClient metClient;

//    public String getBestWeather(){
//      String timeSmhi = smhiClient.getTime();
//    }
}
