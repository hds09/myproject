package edu.nju.MyJourney.service;

import edu.nju.MyJourney.model.City;
import edu.nju.MyJourney.model.Place;

public interface CityService {
public City getCityByPoint(String point);
public void updateCity(City city);
}
