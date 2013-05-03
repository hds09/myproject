package edu.nju.MyJourney.service.impl;

import edu.nju.MyJourney.dao.AttractionDao;
import edu.nju.MyJourney.model.Attraction;
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

}