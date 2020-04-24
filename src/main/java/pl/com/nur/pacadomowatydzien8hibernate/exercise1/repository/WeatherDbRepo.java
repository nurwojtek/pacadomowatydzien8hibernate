package pl.com.nur.pacadomowatydzien8hibernate.exercise1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.com.nur.pacadomowatydzien8hibernate.exercise1.model.WeatherHistory;

@Repository
public interface WeatherDbRepo extends JpaRepository<WeatherHistory, Long> {

}
