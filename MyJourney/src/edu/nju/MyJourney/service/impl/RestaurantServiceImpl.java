package edu.nju.MyJourney.service.impl;

import edu.nju.MyJourney.dao.RestaurantDao;
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

}
