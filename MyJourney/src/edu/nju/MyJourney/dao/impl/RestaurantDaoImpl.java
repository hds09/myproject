package edu.nju.MyJourney.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import edu.nju.MyJourney.dao.RestaurantDao;
import edu.nju.MyJourney.model.Hotel;
import edu.nju.MyJourney.model.Restaurant;

public class RestaurantDaoImpl implements RestaurantDao {
	Configuration config = new Configuration().configure();
	@SuppressWarnings("deprecation")
	SessionFactory sessionFactory = config.buildSessionFactory();
	@Override
	public void insertRestaurant(Restaurant hotel) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Hotel getRestaurantByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateRestaurant(Restaurant hotel) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Hotel> getAllRestaurant() {
		// TODO Auto-generated method stub
		return null;
	}

}
