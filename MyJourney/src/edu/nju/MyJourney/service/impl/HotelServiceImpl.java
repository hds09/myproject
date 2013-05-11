package edu.nju.MyJourney.service.impl;

import java.util.List;

import edu.nju.MyJourney.dao.HotelDao;
import edu.nju.MyJourney.model.City;
import edu.nju.MyJourney.model.Hotel;
import edu.nju.MyJourney.service.HotelService;

public class HotelServiceImpl implements HotelService {
    private HotelDao hotelDao;
	@Override
	public void insertHotel(Hotel hotel) {
		// TODO Auto-generated method stub
       hotelDao.insertHotel(hotel);
	}
	public HotelDao getHotelDao() {
		return hotelDao;
	}
	public void setHotelDao(HotelDao hotelDao) {
		this.hotelDao = hotelDao;
	}
	@Override
	public void updateHotel(Hotel hotel) {
		// TODO Auto-generated method stub
		this.hotelDao.updateHotel(hotel);
	}
	@Override
	public Hotel getHotelById(String id) {
		// TODO Auto-generated method stub
		return hotelDao.getHotelById(id);
	}
	@Override
	public List<Hotel> getAllHotels() {
		// TODO Auto-generated method stub
		return this.hotelDao.getAllHotel();
	}
	public Hotel getBestHotel(City city) {
		// TODO Auto-generated method stub
		return null;
	}

}
