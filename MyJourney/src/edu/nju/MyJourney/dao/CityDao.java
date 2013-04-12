package edu.nju.MyJourney.dao;

import java.util.List;

import edu.nju.MyJourney.model.City;

public interface CityDao {
public void insertCity(City city);
public void updateCity(City city);
public List<City> getAllCity();
public City getCityByName(String name);
}
