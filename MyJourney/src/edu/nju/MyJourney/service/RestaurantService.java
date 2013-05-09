package edu.nju.MyJourney.service;

import java.util.List;

import edu.nju.MyJourney.model.Restaurant;

public interface RestaurantService {
public void insertRestaurant(Restaurant restaurant);
public void updateRestaurant(Restaurant restaurant);
public Restaurant getRestaurantById(String id);
public List<Restaurant> getAllRestaurant();
}
