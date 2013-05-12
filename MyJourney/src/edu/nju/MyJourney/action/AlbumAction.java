package edu.nju.MyJourney.action;

import java.util.ArrayList;
import java.util.List;

import edu.nju.MyJourney.model.Journey;
import edu.nju.MyJourney.model.Picture;
import edu.nju.MyJourney.model.Place;
import edu.nju.MyJourney.service.AlbumService;

public class AlbumAction extends PageAction {
	private AlbumService albumService;
	private List<Picture> images;
	private Journey journey;
	private Place place;
	private int albumId;
	@Override
	public String execute() throws Exception {
		images = new ArrayList<Picture>();
		String result = SUCCESS;
		if(page < 0 ){
			page = 0;
		}
		if(session().getAttribute("account") ==null){
			return "notlogin";
		}
		journey = albumService.getAlbum(albumId);
		if(journey != null && journey.getPlaces().size()>page){
			images = journey.getPlaces().get(page).getImages();
			place = journey.getPlaces().get(page);
			pageMax = journey.getPlaces().size();
		}
		super.execute();
		return result;
	}
	public AlbumService getAlbumService() {
		return albumService;
	}
	public void setAlbumService(AlbumService albumService) {
		this.albumService = albumService;
	}
	public int getAlbumId() {
		return albumId;
	}
	public void setAlbumId(int albumId) {
		this.albumId = albumId;
	}
	public List<Picture> getImages() {
		return images;
	}
	public void setImages(List<Picture> images) {
		this.images = images;
	}
	public Journey getJourney() {
		return journey;
	}
	public void setJourney(Journey journey) {
		this.journey = journey;
	}
	public Place getPlace() {
		return place;
	}
	public void setPlace(Place place) {
		this.place = place;
	}
	
}
