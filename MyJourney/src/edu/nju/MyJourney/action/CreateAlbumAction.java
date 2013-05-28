package edu.nju.MyJourney.action;

import java.io.File;

import edu.nju.MyJourney.dao.PlaceDao;
import edu.nju.MyJourney.model.Picture;
import edu.nju.MyJourney.model.Place;
import edu.nju.MyJourney.model.User;

public class CreateAlbumAction extends PictureUploadAction {
	private PlaceDao placeDao;
	private long placeId;
	private int journeyIndex;
	private Place place;
	@Override
	public String execute() throws Exception {
		String result = SUCCESS;
		System.out.print("journeyIndex"+journeyIndex);
		System.out.println("call create album");
		if(session().getAttribute("account") ==null){
			return "notlogin";
		}
		result = super.execute();
		System.out.println(result);
		if(result == "success"){
			place = placeDao.getPlaceById(placeId);
			Picture p = new Picture();
			for(String f:picListFileName){
				p.setImagepath(f);
				place.addImages(p);
				p = new Picture();
			}
			placeDao.updatePlaceFdp(place);
		}
		return result;
	}
	public PlaceDao getPlaceDao() {
		return placeDao;
	}
	public void setPlaceDao(PlaceDao placeDao) {
		this.placeDao = placeDao;
	}
	public long getPlaceId() {
		return placeId;
	}
	public void setPlaceId(long placeId) {
		this.placeId = placeId;
	}
	public Place getPlace() {
		return place;
	}
	public void setPlace(Place place) {
		this.place = place;
	}
	public int getJourneyIndex() {
		return journeyIndex;
	}
	public void setJourneyIndex(int journeyIndex) {
		this.journeyIndex = journeyIndex;
	}
	
}
