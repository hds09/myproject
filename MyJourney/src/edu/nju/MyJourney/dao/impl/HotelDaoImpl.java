package edu.nju.MyJourney.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import edu.nju.MyJourney.dao.HotelDao;
import edu.nju.MyJourney.model.Hotel;

public class HotelDaoImpl implements HotelDao {
	Configuration config = new Configuration().configure();
	@SuppressWarnings("deprecation")
	SessionFactory sessionFactory = config.buildSessionFactory();
	@Override
	public void insertHotel(Hotel hotel) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Hotel getHotelByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateHotel(Hotel hotel) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Hotel> getAllHotel() {
		// TODO Auto-generated method stub
		return null;
	}

}
