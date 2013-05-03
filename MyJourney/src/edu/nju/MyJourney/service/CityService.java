package edu.nju.MyJourney.service;

import java.util.List;

import edu.nju.MyJourney.model.City;
import edu.nju.MyJourney.model.Place;

public interface CityService {
public City getCityByPoint(String point);
public City getCityByName(String name);
public void updateCity(City city);
public List<City> getCity();
}
