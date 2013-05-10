package edu.nju.MyJourney.service;

import edu.nju.MyJourney.model.City;
import edu.nju.MyJourney.model.Restaurant;

public interface RestaurantService {
public void insertRestaurant(Restaurant restaurant);
public void updateRestaurant(Restaurant restaurant);
public Restaurant getBestRestaurant(City city);
}
