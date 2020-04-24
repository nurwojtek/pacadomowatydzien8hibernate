package pl.com.nur.pacadomowatydzien8hibernate.exercise1.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.Schedules;
import org.springframework.stereotype.Component;
import pl.com.nur.pacadomowatydzien8hibernate.exercise1.model.CityDB;
import pl.com.nur.pacadomowatydzien8hibernate.exercise1.repository.CityDbRepo;
import pl.com.nur.pacadomowatydzien8hibernate.exercise1.service.WeatherCity;

import java.util.List;

@Component
public class Start {
    CityDbRepo cityDbRepo;
    WeatherCity weatherCity;

    @Autowired
    public Start(CityDbRepo cityDbRepo, WeatherCity weatherCity) {
        this.cityDbRepo = cityDbRepo;
        this.weatherCity = weatherCity;
    }

    @Schedules({
            @Scheduled(fixedDelay = 60*60*1000)
    })
    public void startWeather() throws InterruptedException {
        List<CityDB> cityList = cityDbRepo.findAll();
        for (int i = 0; i < cityList.size() ; i++) {
            weatherCity.getWeather(cityList.get(i).getWoeid());
        }

    }


//    @EventListener(ApplicationReadyEvent.class)
//    public void init() {
//        CityDB warsaw = new CityDB("Warsaw","523920" );
//        CityDB london = new CityDB("London", "44418" );
//
//        cityDbRepo.save(warsaw);
//        cityDbRepo.save(london);
//        System.out.println("dodaje miasta do listy");
//        cityDbRepo.findAll().forEach(System.out::println);
//    }
}
