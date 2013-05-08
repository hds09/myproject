package edu.nju.MyJourney.service.impl;

import java.util.List;

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
	@Override
	public List<City> getCity() {
		// TODO Auto-generated method stub
		return cityDao.getAllCity();
	}
	@Override
	public City getCityByName(String name) {
		// TODO Auto-generated method stub
		return cityDao.getCityByName(name);
	}
	@Override
	public void insertCity(City city) {
		// TODO Auto-generated method stub
		cityDao.insertCity(city);
	}
	@Override
	public City getCityById(String id) {
		// TODO Auto-generated method stub
		return cityDao.getCityById(id);
	}

}
