package se.iths.group.forecastserviceteamproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import se.iths.group.forecastserviceteamproject.service.ForecastService;
import se.iths.group.forecastserviceteamproject.service.WeatherAttributes;

@Controller
public class BestWeatherController {

    @Autowired
    ForecastService forecastService;

    @GetMapping("")
    public String getBestWeather(Model model){
        WeatherAttributes weatherAttributes = forecastService.getBestWeather();
        model.addAttribute("bestWeather", weatherAttributes);

        return "index";
    }
}
