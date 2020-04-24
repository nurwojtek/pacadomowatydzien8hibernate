package pl.com.nur.pacadomowatydzien8hibernate.exercise1.model;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "cities")
public class CityDB {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String woeid;

//    @OneToMany(mappedBy = "city")
//    private Set<WeatherHistory> weatherHistorySet;
    @OneToMany
    @JoinColumn(name = "cityId")
    private List<WeatherHistory> weatherHistoryList;

    public CityDB() {
    }

    public CityDB(String name, String woeid) {
        this.name = name;
        this.woeid = woeid;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWoeid() {
        return woeid;
    }

    public void setWoeid(String woeid) {
        this.woeid = woeid;
    }

    public List<WeatherHistory> getWeatherHistoryList() {
        return weatherHistoryList;
    }

    public void setWeatherHistoryList(List<WeatherHistory> weatherHistoryList) {
        this.weatherHistoryList = weatherHistoryList;
    }

    @Override
    public String toString() {
        return "CityDB{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", woeid='" + woeid + '\'' +
                ", weatherHistoryList=" + weatherHistoryList +
                '}';
    }
}
