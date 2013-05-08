package edu.nju.MyJourney.action;

import java.util.List;

import edu.nju.MyJourney.model.Journey;
import edu.nju.MyJourney.model.Picture;
import edu.nju.MyJourney.model.Place;
import edu.nju.MyJourney.service.HomeService;

public class UserJourneyAction extends PageAction {
	private HomeService homeService;
	private List<Journey> journeyList;
	private List<Place> placeList;
	private List<Picture> pictureList;
	private int journeyIndex;
	private int placeIndex;
	private long placeId;
	@Override
	public String execute() throws Exception {
		String result = SUCCESS;
		if(session().getAttribute("account") ==null){
			//session().setAttribute("account", "a");
			return "failure";
		}
		String account = (String) session().getAttribute("account");
		journeyList = homeService.getUserJourney(account, 0, Integer.MAX_VALUE);
		if(journeyIndex < 0 && journeyIndex>=journeyList.size()){
			journeyIndex = 0;
		}
		if(journeyList.size()>0){
			if(placeId != 0){
				for(Journey j:journeyList){
					for(Place p:j.getPlaces()){
						if(p.getId() == placeId){
							journeyIndex = journeyList.indexOf(j);
							placeIndex = j.getPlaces().indexOf(p);
							break;
						}
					}
				}
			}
			placeList = journeyList.get(journeyIndex).getPlaces();
			pageMax = journeyList.size();
			if(placeIndex<0 && placeIndex>=placeList.size()){
				placeIndex = 0;
			}
			if(placeList !=null && placeList.size()>0){
				pictureList = placeList.get(placeIndex).getImages();
			}
		}
		super.execute();
		return result;
	}
	public HomeService getHomeService() {
		return homeService;
	}
	public void setHomeService(HomeService homeService) {
		this.homeService = homeService;
	}
	public List<Journey> getJourneyList() {
		return journeyList;
	}
	public void setJourneyList(List<Journey> journeyList) {
		this.journeyList = journeyList;
	}
	public List<Place> getPlaceList() {
		return placeList;
	}
	public void setPlaceList(List<Place> placeList) {
		this.placeList = placeList;
	}
	public int getJourneyIndex() {
		return journeyIndex;
	}
	public void setJourneyIndex(int journeyIndex) {
		this.journeyIndex = journeyIndex;
	}
	public List<Picture> getPictureList() {
		return pictureList;
	}
	public void setPictureList(List<Picture> pictureList) {
		this.pictureList = pictureList;
	}
	public int getPlaceIndex() {
		return placeIndex;
	}
	public void setPlaceIndex(int placeIndex) {
		this.placeIndex = placeIndex;
	}
	public long getPlaceId() {
		return placeId;
	}
	public void setPlaceId(long placeId) {
		this.placeId = placeId;
	}
	
}
