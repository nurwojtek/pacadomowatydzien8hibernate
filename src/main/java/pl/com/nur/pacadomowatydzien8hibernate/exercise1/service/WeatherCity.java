package pl.com.nur.pacadomowatydzien8hibernate.exercise1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.com.nur.pacadomowatydzien8hibernate.exercise1.model.CityDB;
import pl.com.nur.pacadomowatydzien8hibernate.exercise1.model.WeatherHistory;
import pl.com.nur.pacadomowatydzien8hibernate.exercise1.model.weatherpojo.ConsolidatedWeather;
import pl.com.nur.pacadomowatydzien8hibernate.exercise1.model.weatherpojo.Weather;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.com.nur.pacadomowatydzien8hibernate.exercise1.repository.CityDbRepo;
import pl.com.nur.pacadomowatydzien8hibernate.exercise1.repository.WeatherDbRepo;

@Service
public class WeatherCity {

    Weather weather;
    ConsolidatedWeather consolidatedWeather;
    WeatherDbRepo weatherDbRepo;
    CityDbRepo cityDbRepo;

    @Autowired
    public WeatherCity(WeatherDbRepo weatherDbRepo, CityDbRepo cityDbRepo) {
        this.weatherDbRepo = weatherDbRepo;
        this.cityDbRepo = cityDbRepo;
        weather = new Weather();
        consolidatedWeather = new ConsolidatedWeather();
    }

    public void getWeather(String city) {
        Weather weathernew = new Weather();
        HttpEntity httpEntity = new HttpEntity(weathernew);
        RestTemplate restTemplate = new RestTemplate();

        String urlCity= "https://www.metaweather.com/api/location/" + city;
        System.out.println(urlCity);
        ResponseEntity<Weather> weatherResponseEntity = restTemplate.exchange(
                String.format(urlCity),
                HttpMethod.GET,
                httpEntity,
                Weather.class);
        this.weather = weatherResponseEntity.getBody();

        weatherDbRepo.save(new WeatherHistory(weather, cityDbRepo.findByWoeid(city).getId()));
    }
}
