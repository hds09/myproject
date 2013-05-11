package edu.nju.MyJourney.service.impl;

import java.util.ArrayList;
import java.util.List;

import edu.nju.MyJourney.dao.JourneyDao;
import edu.nju.MyJourney.model.Journey;
import edu.nju.MyJourney.model.Place;
import edu.nju.MyJourney.model.User;
import edu.nju.MyJourney.service.JourneyService;

public class JourneyServiceImpl implements JourneyService{
    private JourneyDao journeyDao;
    private final int MORNING=1;
	private final int AFTERNOON=0;
	@Override
	public void insertJourney(Journey journey) {
		// TODO Auto-generated method stub
		journeyDao.insertJoueney(journey);
	}
	
	@Override
	public Journey getJourneyById(long id) {
		// TODO Auto-generated method stub
		return this.journeyDao.getJourneyById(id);
	}
	@Override
	public List<Place> getMorningPlaceByUserId(long id) {
		// TODO Auto-generated method stub
		Journey journey=this.journeyDao.getJourneyById(id);
		List<Place> morningList=new ArrayList<Place>();
		int length=journey.getPlaces().size();
		for(int i=0;i<length;i++){
			if(journey.getPlaces().get(i).getHalfday()==MORNING){
				morningList.add(journey.getPlaces().get(i));
			}
		}
		return morningList;
	}
	@Override
	public List<Place> getAfternoonPlaceByUserId(long id) {
		Journey journey=this.journeyDao.getJourneyById(id);
		List<Place> afternoonList=new ArrayList<Place>();
		int length=journey.getPlaces().size();
		for(int i=0;i<length;i++){
			if(journey.getPlaces().get(i).getHalfday()==AFTERNOON){
				afternoonList.add(journey.getPlaces().get(i));
			}
		}
		return afternoonList;
	}
	@Override
	public void updateJourney(Journey journey) {
		// TODO Auto-generated method stub
		this.journeyDao.updateJourney(journey);
	}
	@Override
	public List<Journey> getAllJourneys() {
		// TODO Auto-generated method stub
		return this.journeyDao.getAllJourneys();
	}
	@Override
	public void deleteJourneyById(String id) {
		// TODO Auto-generated method stub
		this.journeyDao.deleteJourneyById(id);
	}
	@Override
	public List<Journey> getUserRelatedJourney(String uid) {
		// TODO Auto-generated method stub
		Long userid=Long.parseLong(uid);
		List<Journey> js=this.journeyDao.getAllJourneys();
		List<Journey> result=new ArrayList<Journey>();
		for(int i=0;i<js.size();i++){
			if(js.get(i).getUser().getUid()==userid){
				result.add(js.get(i));
			}else if(js.get(i).getState()==1){
				List<User> tmp=js.get(i).getTeam().getUsers();
				for(int j=0;j<tmp.size();j++){
					if(tmp.get(j).getUid()==userid){
						result.add(js.get(j));
						break;
					}
				}
			}
		}
		return result;
	}

	public JourneyDao getJourneyDao() {
		return journeyDao;
	}
	public void setJourneyDao(JourneyDao journeyDao) {
		this.journeyDao = journeyDao;
	}

}
