package edu.nju.MyJourney.dao;

import java.util.List;

import edu.nju.MyJourney.model.Hotel;
import edu.nju.MyJourney.model.Restaurant;

public interface RestaurantDao {
		public void insertRestaurant(Restaurant hotel);
		public Hotel getRestaurantByName(String name);
		public void updateRestaurant(Restaurant hotel);
		public List<Hotel> getAllRestaurant();
}
