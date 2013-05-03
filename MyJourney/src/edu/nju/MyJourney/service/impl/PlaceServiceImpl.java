package edu.nju.MyJourney.service.impl;

import edu.nju.MyJourney.dao.PlaceDao;
import edu.nju.MyJourney.model.Place;
import edu.nju.MyJourney.service.PlaceService;

public class PlaceServiceImpl implements PlaceService {
    private PlaceDao placeDao;
	@Override
	public void updatePlace(Place place) {
		// TODO Auto-generated method stub
      this.placeDao.updatePlace(place);
	}
	public PlaceDao getPlaceDao() {
		return placeDao;
	}
	public void setPlaceDao(PlaceDao placeDao) {
		this.placeDao = placeDao;
	}
	@Override
	public void insertPlace(Place place) {
		// TODO Auto-generated method stub
		placeDao.insertPlace(place);
	}

}
