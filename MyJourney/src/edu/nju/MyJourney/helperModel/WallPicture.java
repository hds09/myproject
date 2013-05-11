package edu.nju.MyJourney.helperModel;

import java.util.List;

import edu.nju.MyJourney.model.Journey;
import edu.nju.MyJourney.model.Picture;

public class WallPicture {
	private long journeyId;
	private String userName;
	private String userAccount;
	private String journeyName;
	private int state;
//	private String placeName;
	private Picture image;//封面图片
	
	public WallPicture convertFromJourney(Journey j){
		this.journeyId = j.getId();
		if(j.getUser()!=null){
			this.userName = j.getUser().getName();
			this.userAccount = j.getUser().getAccount();
		}
		this.journeyName = j.getJourneyName();
		this.state = j.getState();
		try{
			if(j.getPlaces()!=null && j.getPlaces().size()>0 
					&& j.getPlaces().get(0).getImages()!=null
					&&j.getPlaces().get(0).getImages().size()>0){
				this.image = j.getPlaces().get(0).getImages().get(0);
			}
		}catch(Exception e){
			System.out.println();
		}
		return this;
	}
	public long getJourneyId() {
		return journeyId;
	}
	public void setJourneyId(long journeyId) {
		this.journeyId = journeyId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getJourneyName() {
		return journeyName;
	}
	public void setJourneyName(String journeyName) {
		this.journeyName = journeyName;
	}
	
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public Picture getImage() {
		return image;
	}
	public String getUserAccount() {
		return userAccount;
	}
	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}
	public void setImage(Picture image) {
		this.image = image;
	}
	
}
