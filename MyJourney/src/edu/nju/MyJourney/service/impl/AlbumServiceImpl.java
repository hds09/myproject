package edu.nju.MyJourney.service.impl;

import java.util.List;

import edu.nju.MyJourney.dao.JourneyDao;
import edu.nju.MyJourney.model.Journey;
import edu.nju.MyJourney.service.AlbumService;

public class AlbumServiceImpl implements AlbumService{
	private JourneyDao journeyDao;
	@Override
	public Journey getAlbum(long albumId) {
		return journeyDao.getJourneyById(albumId);
	}
	public JourneyDao getJourneyDao() {
		return journeyDao;
	}
	public void setJourneyDao(JourneyDao journeyDao) {
		this.journeyDao = journeyDao;
	}
	@Override
	public boolean deletePicture(long pictureId) {
		journeyDao.deletePicture(pictureId);
		return false;
	}
	

}
