package edu.nju.MyJourney.service.impl;

import java.util.List;

import edu.nju.MyJourney.dao.AttractionDao;
import edu.nju.MyJourney.model.Attraction;
import edu.nju.MyJourney.model.City;
import edu.nju.MyJourney.service.AttractionService;

public class AttractionServiceImpl implements AttractionService {
     private AttractionDao attractionDao;
	@Override
	public void insertAttraction(Attraction attraction) {
		attractionDao.insertAttraction(attraction);

	}
	public AttractionDao getAttractionDao() {
		return attractionDao;
	}
	public void setAttractionDao(AttractionDao attractionDao) {
		this.attractionDao = attractionDao;
	}
	@Override
	public void updateAttraction(Attraction attraction) {
		// TODO Auto-generated method stub
		this.attractionDao.updateAttraction(attraction);
	}
	@Override

	public Attraction getAttractionById(String id) {
		// TODO Auto-generated method stub
		return attractionDao.getAttractionById(id);
	}
	@Override
	public List<Attraction> getAllAttraction() {
		// TODO Auto-generated method stub
		return this.attractionDao.getAllAttraction();
	}
	public Attraction getBestAttraction(City city) {
		// TODO Auto-generated method stub
		return null;
	}

}
