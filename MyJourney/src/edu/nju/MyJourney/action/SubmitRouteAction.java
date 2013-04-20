package edu.nju.MyJourney.action;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

import edu.nju.MyJourney.model.City;
import edu.nju.MyJourney.model.Journey;
import edu.nju.MyJourney.model.Place;
import edu.nju.MyJourney.model.User;
import edu.nju.MyJourney.service.CityService;
import edu.nju.MyJourney.service.JourneyService;
import edu.nju.MyJourney.service.UserService;

public class SubmitRouteAction extends BaseAction{
	private List<String> morninglist;
	private List<String> afternoonlist;
	private UserService userService;
	private final int MORNING=1;
	private final int AFTERNOON=0;
	private String startDate;
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	private CityService cityService;
	private JourneyService journeyService;
	public CityService getCityService() {
		return cityService;
	}
	public void setCityService(CityService cityService) {
		this.cityService = cityService;
	}
	public String execute() throws Exception {
		String result=SUCCESS;
		System.out.println(startDate);
		List<Place> places=new ArrayList<Place>();
		Journey journey=new Journey();
		 ActionContext actionContext = ActionContext.getContext();  
		  Map session = actionContext.getSession();	
		String account=(String)session.get("account");
		int length=morninglist.size();
		
	    for(int i=0;i<length;i++){
		Place place=new Place();
		City city=cityService.getCityByPoint(morninglist.get(i));
		
		place.setTime(startDate);
		place.setHalfday(MORNING);	
		city.addPlace(place);
		cityService.updateCity(city);
		journey.addPlace(place);
		}
	    for(int i=0;i<length;i++){
			Place place=new Place();
			City city=cityService.getCityByPoint(afternoonlist.get(i));
			
			place.setTime(startDate);
			place.setHalfday(AFTERNOON);
			city.addPlace(place);
			cityService.updateCity(city);
			journey.addPlace(place);
			
			}
	   
	    User user=userService.getUserByAccount(account);
	    if(user!=null){
	    	journeyService.insertJourney(journey);
	    	
	       user.addJourney(journey);
	    
	      userService.updateUser(user);
		System.out.println(startDate);

	    }else{
	    	System.out.println("error");
	    }
		
		return result;
	}
	public List<String> getMorninglist() {
		return morninglist;
	}
	public void setMorninglist(List<String> morninglist) {
		this.morninglist = morninglist;
	}
	public List<String> getAfternoonlist() {
		return afternoonlist;
	}
	public void setAfternoonlist(List<String> afternoonlist) {
		this.afternoonlist = afternoonlist;
	}

	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public JourneyService getJourneyService() {
		return journeyService;
	}
	public void setJourneyService(JourneyService journeyService) {
		this.journeyService = journeyService;
	}
	
}
