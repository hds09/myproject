package edu.nju.MyJourney.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import bsh.This;

import com.opensymphony.xwork2.ActionContext;

import edu.nju.MyJourney.model.Attraction;
import edu.nju.MyJourney.model.City;
import edu.nju.MyJourney.model.Hotel;
import edu.nju.MyJourney.model.Journey;
import edu.nju.MyJourney.model.Place;
import edu.nju.MyJourney.model.Restaurant;
import edu.nju.MyJourney.service.AttractionService;
import edu.nju.MyJourney.service.HotelService;
import edu.nju.MyJourney.service.JourneyService;
import edu.nju.MyJourney.service.PlaceService;
import edu.nju.MyJourney.service.RestaurantService;

public class EditRouteAction extends BaseAction{
	private long RouteId;
    private Journey journey;
    private List<Place> morningPlaces;
    private List<Place> afternoonPlaces;
    
	private JourneyService journeyService;
	private RestaurantService restaurantService;
    private HotelService hotelService;
    private AttractionService attractionService;
    private PlaceService placeService;
	private List<City> cities;
	private List<String>  dateList;
	private String startDate;
	private Place morningStartPlace;
	private Place afternoonStartPlace;
	private int preDay;
	private int otherDay;
	private int selectnum;
	private int length;
	private String morningTraffic;
	private String afternoonTraffic;
	
	private Hotel morningHotel;
	private Restaurant morningRestaurant;
	private Attraction morningAttraction;
	private Hotel afternoonHotel;
	private Restaurant afternoonRestaurant;
	private Attraction afternoonAttraction;
	private Hotel tmpMorningHotel;
	private Restaurant tmpMorningRestaurant;
	private Attraction tmpMorningAttraction;
	private Hotel tmpAfternoonHotel;
	private Restaurant tmpAfternoonRestaurant;
	private Attraction tmpAfternoonAttraction;
    
	public String execute() throws Exception {
		String result = SUCCESS;
		this.preDay=this.selectnum-1;
		this.otherDay=this.selectnum+1;
		dateList=new ArrayList<String>();
		cities=new ArrayList<City>();
		morningPlaces=
				journeyService.getMorningPlaceByUserId(RouteId);
		this.length=this.morningPlaces.size();
	    afternoonPlaces=
	    		journeyService.getAfternoonPlaceByUserId(RouteId);
	    journey=journeyService.getJourneyById(RouteId);
	    System.out.println(morningPlaces.get(0).getTime());
	    for(int i=0;i<morningPlaces.size();i++){
	    	dateList.add(morningPlaces.get(i).getTime());
	    	if(!cities.contains(morningPlaces.get(i).getCity())){
	    		cities.add(morningPlaces.get(i).getCity());
	    	}
	    	if(!cities.contains(afternoonPlaces.get(i).getCity())){
	    		cities.add(afternoonPlaces.get(i).getCity());
	    	}
	    }
	    startDate=dateList.get(selectnum-1);
	    this.morningStartPlace=this.morningPlaces.get(selectnum-1);
	    this.afternoonStartPlace=
	    this.afternoonPlaces.get(selectnum-1);
	    this.tmpAfternoonAttraction=
	            this.attractionService.getBestAttraction(
	            		this.afternoonStartPlace.getCity());
	    this.tmpAfternoonHotel=
	    		this.hotelService.getBestHotel(
	    				this.afternoonStartPlace.getCity());
	    this.tmpAfternoonRestaurant=
	    		this.restaurantService.getBestRestaurant(
	    				this.afternoonStartPlace.getCity());
	    this.tmpMorningAttraction=
	    		this.attractionService.getBestAttraction(
	    				this.morningStartPlace.getCity());
	    this.tmpMorningHotel=
	    		this.hotelService.getBestHotel(
	    				this.morningStartPlace.getCity());
	    this.tmpMorningRestaurant=
	    		this.restaurantService.getBestRestaurant(
	    				this.morningStartPlace.getCity());
		return result;
	}
	//edit morning
	public String editMorningRestaurant()  throws Exception{
		String result=SUCCESS;
		this.morningRestaurant.setCity(this.morningStartPlace.getCity());
		this.restaurantService.insertRestaurant(morningRestaurant);
		this.morningStartPlace.setRestaurant(morningRestaurant);
        this.placeService.updatePlace(morningStartPlace);
		return result;
	}
	public String editMorningHotel()  throws Exception{
		String result=SUCCESS;
		this.morningHotel.setCity(this.morningStartPlace.getCity());
		this.hotelService.insertHotel(morningHotel);
		this.morningStartPlace.setHotel(morningHotel);
        this.placeService.updatePlace(morningStartPlace);
		return result;
	}
	public String editMorningAttraction()  throws Exception{
		String result=SUCCESS;
		this.morningAttraction.setCity(this.morningStartPlace.getCity());
		this.attractionService.insertAttraction(morningAttraction);
		this.morningStartPlace.setAttraction(this.morningAttraction);
        this.placeService.updatePlace(morningStartPlace);
		return result;
	}
	public String editMorningTraffic()  throws Exception{
		String result=SUCCESS;
		this.morningStartPlace.setTraffic(morningTraffic);
		this.placeService.updatePlace(morningStartPlace);
		
		return result;
	}
	//edit afternoon
	public String editAfternoonRestaurant()  throws Exception{
		String result=SUCCESS;
		this.afternoonRestaurant.setCity(this.afternoonStartPlace.getCity());
		this.restaurantService.insertRestaurant(afternoonRestaurant);
		this.afternoonStartPlace.setRestaurant(afternoonRestaurant);
        this.placeService.updatePlace(afternoonStartPlace);
		return result;
	}
	public String editAfternoonHotel()  throws Exception{
		String result=SUCCESS;
		this.afternoonHotel.setCity(this.afternoonStartPlace.getCity());
		this.hotelService.insertHotel(afternoonHotel);
		this.afternoonStartPlace.setHotel(afternoonHotel);
        this.placeService.updatePlace(afternoonStartPlace);
		return result;
	}
	public String editAfternoonAttraction()  throws Exception{
		String result=SUCCESS;
		this.afternoonAttraction.setCity(this.afternoonStartPlace.getCity());
		this.attractionService.insertAttraction(afternoonAttraction);
		this.afternoonStartPlace.setAttraction(afternoonAttraction);
        this.placeService.updatePlace(afternoonStartPlace);
		return result;
	}
	public String editAfternoonTraffic()  throws Exception{
		String result=SUCCESS;
		this.afternoonStartPlace.setTraffic(afternoonTraffic);
        this.placeService.updatePlace(afternoonStartPlace);
		return result;
	}
	public String recommendMorningRestaurant() throws Exception{
		String result=SUCCESS;
		this.morningStartPlace.setRestaurant(tmpMorningRestaurant);
		this.tmpMorningRestaurant.getPlaces().add(morningStartPlace);
		//this.tmpAfternoonRestaurant.addPlace(morningStartPlace);
		this.placeService.updatePlace(morningStartPlace);
		return result;
	}
	public String recommendMorningHotel()  throws Exception{
		String result=SUCCESS;
		this.morningStartPlace.setHotel(this.tmpMorningHotel);
		this.tmpAfternoonHotel.getPlaces().add(morningStartPlace);
		//this.tmpMorningHotel.addPlace(morningStartPlace);
        this.placeService.updatePlace(morningStartPlace);
		return result;
	}
	public String recommendMorningAttraction()  throws Exception{
		String result=SUCCESS;
		
		this.morningStartPlace.setAttraction(this.tmpMorningAttraction);
		this.tmpMorningAttraction.getPlaces().add(morningStartPlace);
		//this.tmpMorningAttraction.addPlace(morningStartPlace);
        this.placeService.updatePlace(morningStartPlace);
		return result;
	}

	//edit afternoon
	public String recommendAfternoonRestaurant()  throws Exception{
		String result=SUCCESS;

		this.afternoonStartPlace.setRestaurant(this.tmpAfternoonRestaurant);
		this.tmpAfternoonRestaurant.getPlaces().add(afternoonStartPlace);
		//this.tmpAfternoonRestaurant.addPlace(afternoonStartPlace);
        this.placeService.updatePlace(afternoonStartPlace);
		return result;
	}
	public String recommendAfternoonHotel()  throws Exception{
		String result=SUCCESS;

		this.afternoonStartPlace.setHotel(this.tmpAfternoonHotel);
		//this.tmpAfternoonHotel.addPlace(afternoonStartPlace);
		this.tmpAfternoonHotel.getPlaces().add(afternoonStartPlace);
        this.placeService.updatePlace(afternoonStartPlace);
		return result;
	}
	public String recommendAfternoonAttraction()  throws Exception{
		String result=SUCCESS;

		this.afternoonStartPlace.setAttraction(this.tmpAfternoonAttraction);
		//this.tmpAfternoonAttraction.addPlace(afternoonStartPlace);
		this.tmpAfternoonAttraction.getPlaces().add(afternoonStartPlace); 
        this.placeService.updatePlace(afternoonStartPlace);
		return result;
	}
	public String test() throws Exception{
		String result=SUCCESS;
		System.out.println(this.length);
		return result;
	}
	public long getRouteId() {
		return RouteId;
	}

	public void setRouteId(long routeId) {
		RouteId = routeId;
	}
	public JourneyService getJourneyService() {
		return journeyService;
	}
	public void setJourneyService(JourneyService journeyService) {
		this.journeyService = journeyService;
	}
	public Journey getJourney() {
		return journey;
	}
	public void setJourney(Journey journey) {
		this.journey = journey;
	}
	public List<Place> getMorningPlaces() {
		return morningPlaces;
	}
	public void setMorningPlaces(List<Place> morningPlaces) {
		this.morningPlaces = morningPlaces;
	}
	public List<Place> getAfternoonPlaces() {
		return afternoonPlaces;
	}
	public void setAfternoonPlaces(List<Place> afternoonPlaces) {
		this.afternoonPlaces = afternoonPlaces;
	}
	public List<String> getDateList() {
		return dateList;
	}
	public void setDateList(List<String> dateList) {
		this.dateList = dateList;
	}
	public List<City> getCities() {
		return cities;
	}
	public void setCities(List<City> cities) {
		this.cities = cities;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public Place getMorningStartPlace() {
		return morningStartPlace;
	}
	public void setMorningStartPlace(Place morningStartPlace) {
		this.morningStartPlace = morningStartPlace;
	}
	public Place getAfternoonStartPlace() {
		return afternoonStartPlace;
	}
	public void setAfternoonStartPlace(Place afternoonStartPlace) {
		this.afternoonStartPlace = afternoonStartPlace;
	}
	public Hotel getMorningHotel() {
		return morningHotel;
	}
	public void setMorningHotel(Hotel morningHotel) {
		this.morningHotel = morningHotel;
	}
	public Restaurant getMorningRestaurant() {
		return morningRestaurant;
	}
	public void setMorningRestaurant(Restaurant morningRestaurant) {
		this.morningRestaurant = morningRestaurant;
	}
	public Attraction getMorningAttraction() {
		return morningAttraction;
	}
	public void setMorningAttraction(Attraction morningAttraction) {
		this.morningAttraction = morningAttraction;
	}
	public String getMorningTraffic() {
		return morningTraffic;
	}
	public void setMorningTraffic(String morningTraffic) {
		this.morningTraffic = morningTraffic;
	}
	public String getAfternoonTraffic() {
		return afternoonTraffic;
	}
	public void setAfternoonTraffic(String afternoonTraffic) {
		this.afternoonTraffic = afternoonTraffic;
	}
	public Hotel getAfternoonHotel() {
		return afternoonHotel;
	}
	public void setAfternoonHotel(Hotel afternoonHotel) {
		this.afternoonHotel = afternoonHotel;
	}
	public Restaurant getAfternoonRestaurant() {
		return afternoonRestaurant;
	}
	public void setAfternoonRestaurant(Restaurant afternoonRestaurant) {
		this.afternoonRestaurant = afternoonRestaurant;
	}
	public Attraction getAfternoonAttraction() {
		return afternoonAttraction;
	}
	public void setAfternoonAttraction(Attraction afternoonAttraction) {
		this.afternoonAttraction = afternoonAttraction;
	}
	public int getSelectnum() {
		return selectnum;
	}
	public void setSelectnum(int selectnum) {
		this.selectnum = selectnum;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public int getPreDay() {
		return preDay;
	}
	public void setPreDay(int preDay) {
		this.preDay = preDay;
	}
	public int getOtherDay() {
		return otherDay;
	}
	public void setOtherDay(int otherDay) {
		this.otherDay = otherDay;
	}
	public RestaurantService getRestaurantService() {
		return restaurantService;
	}
	public void setRestaurantService(RestaurantService restaurantService) {
		this.restaurantService = restaurantService;
	}
	public HotelService getHotelService() {
		return hotelService;
	}
	public void setHotelService(HotelService hotelService) {
		this.hotelService = hotelService;
	}
	public AttractionService getAttractionService() {
		return attractionService;
	}
	public void setAttractionService(AttractionService attractionService) {
		this.attractionService = attractionService;
	}
	public PlaceService getPlaceService() {
		return placeService;
	}
	public void setPlaceService(PlaceService placeService) {
		this.placeService = placeService;
	}

	public Restaurant getTmpMorningRestaurant() {
		return tmpMorningRestaurant;
	}
	public void setTmpMorningRestaurant(Restaurant tmpMorningRestaurant) {
		this.tmpMorningRestaurant = tmpMorningRestaurant;
	}
	public Hotel getTmpMorningHotel() {
		return tmpMorningHotel;
	}
	public void setTmpMorningHotel(Hotel tmpMorningHotel) {
		this.tmpMorningHotel = tmpMorningHotel;
	}
	public Attraction getTmpMorningAttraction() {
		return tmpMorningAttraction;
	}
	public void setTmpMorningAttraction(Attraction tmpMorningAttraction) {
		this.tmpMorningAttraction = tmpMorningAttraction;
	}
	public Hotel getTmpAfternoonHotel() {
		return tmpAfternoonHotel;
	}
	public void setTmpAfternoonHotel(Hotel tmpAfternoonHotel) {
		this.tmpAfternoonHotel = tmpAfternoonHotel;
	}
	public Restaurant getTmpAfternoonRestaurant() {
		return tmpAfternoonRestaurant;
	}
	public void setTmpAfternoonRestaurant(Restaurant tmpAfternoonRestaurant) {
		this.tmpAfternoonRestaurant = tmpAfternoonRestaurant;
	}
	public Attraction getTmpAfternoonAttraction() {
		return tmpAfternoonAttraction;
	}
	public void setTmpAfternoonAttraction(Attraction tmpAfternoonAttraction) {
		this.tmpAfternoonAttraction = tmpAfternoonAttraction;
	}
	

}
