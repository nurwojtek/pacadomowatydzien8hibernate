package pl.com.nur.pacadomowatydzien8hibernate.exercise1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.com.nur.pacadomowatydzien8hibernate.exercise1.model.CityDB;

@Repository
public interface CityDbRepo extends JpaRepository<CityDB, Long> {

    CityDB findByWoeid(String woe);
}
