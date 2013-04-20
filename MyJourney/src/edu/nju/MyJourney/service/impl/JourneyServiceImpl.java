package edu.nju.MyJourney.service.impl;

import edu.nju.MyJourney.dao.JourneyDao;
import edu.nju.MyJourney.model.Journey;
import edu.nju.MyJourney.service.JourneyService;

public class JourneyServiceImpl implements JourneyService{
    private JourneyDao journeyDao;
	@Override
	public void insertJourney(Journey journey) {
		// TODO Auto-generated method stub
		journeyDao.insertJoueney(journey);
	}
	public JourneyDao getJourneyDao() {
		return journeyDao;
	}
	public void setJourneyDao(JourneyDao journeyDao) {
		this.journeyDao = journeyDao;
	}

}
