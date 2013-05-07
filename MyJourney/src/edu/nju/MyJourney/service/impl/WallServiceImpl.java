package edu.nju.MyJourney.service.impl;

import java.util.List;

import edu.nju.MyJourney.dao.JourneyDao;
import edu.nju.MyJourney.helperModel.WallPicture;
import edu.nju.MyJourney.service.WallService;

public class WallServiceImpl implements WallService {
	private JourneyDao journeyDao;
	@Override
	public List<WallPicture> getWallPictures(int page,int pageSize) {
		return journeyDao.getWallPictures(page, pageSize);
	}
	
	@Override
	public int getWallPicturesPageMax(int pageSize) {
		return journeyDao.getWallPicturesPageMax(pageSize);
	}

	public JourneyDao getJourneyDao() {
		return journeyDao;
	}

	public void setJourneyDao(JourneyDao journeyDao) {
		this.journeyDao = journeyDao;
	}
	

}
