package edu.nju.MyJourney.service.impl;

import edu.nju.MyJourney.dao.CityDao;
import edu.nju.MyJourney.dao.PlaceDao;
import edu.nju.MyJourney.model.City;
import edu.nju.MyJourney.model.Place;
import edu.nju.MyJourney.service.CityService;

public class CityServiceImpl implements CityService {
private CityDao cityDao;
	@Override
	public City getCityByPoint(String point) {
		// TODO Auto-generated method stub
		return cityDao.getCityByPoint(point);
	}
	public CityDao getCityDao() {
		return cityDao;
	}
	public void setCityDao(CityDao cityDao) {
		this.cityDao = cityDao;
	}
	@Override
	public void updateCity(City city) {
		// TODO Auto-generated method stub
		cityDao.updateCity(city);
	}

}
