package edu.nju.MyJourney.service.impl;

import java.util.List;

import edu.nju.MyJourney.dao.RestaurantDao;
import edu.nju.MyJourney.model.City;
import edu.nju.MyJourney.model.Restaurant;
import edu.nju.MyJourney.service.RestaurantService;

public class RestaurantServiceImpl implements RestaurantService {
    private RestaurantDao restaurantDao;
	@Override
	public void insertRestaurant(Restaurant restaurant) {
		// TODO Auto-generated method stub
      restaurantDao.insertRestaurant(restaurant);
	}
	public RestaurantDao getRestaurantDao() {
		return restaurantDao;
	}
	public void setRestaurantDao(RestaurantDao restaurantDao) {
		this.restaurantDao = restaurantDao;
	}
	@Override
	public void updateRestaurant(Restaurant restaurant) {
		// TODO Auto-generated method stub
		this.restaurantDao.updateRestaurant(restaurant);
	}
	@Override
	public Restaurant getRestaurantById(String id) {
		// TODO Auto-generated method stub
		return restaurantDao.getRestaurantById(id);
	}
	@Override
	public List<Restaurant> getAllRestaurant() {
		// TODO Auto-generated method stub
		return this.restaurantDao.getAllRestaurant();
	}
	public Restaurant getBestRestaurant(City city) {
		// TODO Auto-generated method stub
		
		return this.restaurantDao.getBestRestaurant();
	}

}
