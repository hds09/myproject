package edu.nju.MyJourney.action;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

import edu.nju.MyJourney.model.City;
import edu.nju.MyJourney.model.Journey;
import edu.nju.MyJourney.model.Place;
import edu.nju.MyJourney.model.Team;
import edu.nju.MyJourney.model.User;
import edu.nju.MyJourney.service.CityService;
import edu.nju.MyJourney.service.JourneyService;
import edu.nju.MyJourney.service.PlaceService;
import edu.nju.MyJourney.service.TeamService;
import edu.nju.MyJourney.service.UserService;

public class SubmitRouteAction extends BaseAction{
	private List<String> morninglist;
	private List<String> afternoonlist;
	private UserService userService;
	private String routeName;
	private final int MORNING=1;
	private final int AFTERNOON=0;
	private String startDate;
    private PlaceService placeService;
	private CityService cityService;
	private JourneyService journeyService;
	private TeamService teamService;
	private int state;

	public String execute() throws Exception {
		String result=SUCCESS;
		List<Place> places=new ArrayList<Place>();
		Journey journey=new Journey();
		ActionContext actionContext = ActionContext.getContext();  
	    Map session = actionContext.getSession();	
		String account=(String)session.get("account");
		int length=morninglist.size();
		journey.setJourneyName(routeName);
		journey.setState(state);
		journeyService.insertJourney(journey);		
		for(int i=0;i<length;i++){
			Place place2=new Place();
			String startDateTmp=startDate;
			City city=cityService.getCityByName(afternoonlist.get(i));
			if(i!=0){
				startDateTmp=this.addDay(startDateTmp);
				startDateTmp=changeString(startDateTmp);
				}
				place2.setTime(startDateTmp);
				place2.setHalfday(AFTERNOON);
				placeService.insertPlace(place2);
				city.addPlace(place2);
				cityService.updateCity(city);			
				journey.addPlace(place2);
				placeService.updatePlace(place2);
			}
	    for(int i=0;i<length;i++){
	    	String startDateTmp=startDate;
		    Place place=new Place();
		    City city=cityService.getCityByName(morninglist.get(i));
		    if(i!=0){
			    startDateTmp=this.addDay(startDateTmp);
			    startDateTmp=changeString(startDateTmp);
			    }
		    place.setTime(startDateTmp);
		    place.setHalfday(MORNING);	
		    placeService.insertPlace(place);
		    city.addPlace(place);
		    cityService.updateCity(city);
		    journey.addPlace(place);
		    placeService.updatePlace(place);
		    }
	     Journey tmp=journeyService.getJourneyById(journey.getId());
	     User user=userService.getUserByAccount(account);
	     user.addJourney(tmp);
	     userService.updateUser(user);
	     journeyService.updateJourney(tmp);
	     Team team=new Team();
	     team.setTeamName(this.routeName);
	     teamService.insertTeam(team);
	     team.addJourney(tmp);
	     teamService.updateTeam(team);
	     journeyService.updateJourney(tmp);
		return result;
	}
	public String addDay(String startDateTmp){
		DateFormat fmt =new SimpleDateFormat("yyyy-MM-dd");
	    Date date=null;
		try {
			date = (Date) fmt.parse(startDateTmp);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    String[] tmp=this.addDay(date).toLocaleString().split(" ");
	    startDateTmp=tmp[0];
	    return startDateTmp;
	}
	public String changeString(String date){
		String[] tmp=date.split("-");
	    String result="";
		int year=Integer.parseInt(tmp[0]);
		result=result+year+"-";
		String monthString="";
		String dayString="";
		int month=Integer.parseInt(tmp[1]);
		int day=Integer.parseInt(tmp[2]);
		if(month<10){
			monthString=monthString+"0";
		}
		monthString=monthString+month;
		if(day<10){
			dayString=dayString+"0";
		}
		dayString=dayString+day;
		result=result+monthString+"-"+dayString;
		return result;
	}
	public Date addDay(Date date){
		Date tomo = new   Date((date.getTime()/1000+86400*1)*1000);
		return tomo;
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
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public CityService getCityService() {
		return cityService;
	}
	public void setCityService(CityService cityService) {
		this.cityService = cityService;
	}
	public String getRouteName() {
		return routeName;
	}
	public void setRouteName(String routeName) {
		this.routeName = routeName;
	}
	public PlaceService getPlaceService() {
		return placeService;
	}
	public void setPlaceService(PlaceService placeService) {
		this.placeService = placeService;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public TeamService getTeamService() {
		return teamService;
	}
	public void setTeamService(TeamService teamService) {
		this.teamService = teamService;
	}
}
