package edu.nju.MyJourney.service.impl;

import edu.nju.MyJourney.dao.HotelDao;
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

}
