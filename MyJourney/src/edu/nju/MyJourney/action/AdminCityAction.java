package edu.nju.MyJourney.action;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

import edu.nju.MyJourney.helpflow.SearchFlow;
import edu.nju.MyJourney.helpflow.SearchPrepareStatement;
import edu.nju.MyJourney.model.Attraction;
import edu.nju.MyJourney.model.City;
import edu.nju.MyJourney.model.Hotel;
import edu.nju.MyJourney.model.Restaurant;
import edu.nju.MyJourney.service.AttractionService;
import edu.nju.MyJourney.service.CityService;
import edu.nju.MyJourney.service.HotelService;
import edu.nju.MyJourney.service.RestaurantService;

public class AdminCityAction extends BaseAction{
	private HotelService hotelService;
	private RestaurantService restaurantService;
	private CityService cityService;
	private AttractionService attractionService;
	private String s_type;
	private String keyword;
	private String range;
	public String execute() throws Exception{
		List<City> cities=this.cityService.getCity();
		List<Hotel> hotels=this.hotelService.getAllHotels();
		List<Attraction> attractions=this.attractionService.getAllAttraction();
		List<Restaurant> restaurants=this.restaurantService.getAllRestaurant();
		ActionContext actionContext = ActionContext.getContext();  
		Map session = actionContext.getSession();
		session.put("cities", cities);
		session.put("hotels", hotels);
		session.put("attractions", attractions);
		session.put("restaurants", restaurants);
		return SUCCESS;
	}
	
	public String search() throws Exception{
		System.out.println("keyword: "+this.keyword);
		System.out.println("s_type: "+this.s_type);
		System.out.println("range: "+this.range);
		SearchPrepareStatement sps=new SearchPrepareStatement();
		ActionContext actionContext = ActionContext.getContext();  
		Map session = actionContext.getSession();
		if(this.s_type.equals("1")){
			sps.KEYWORD=this.keyword;
			List<City> cs=SearchFlow.CitySearch(sps);
			session.put("search_type", this.s_type);
			session.put("search_cities", cs);
		}else if(this.s_type.equals("2")){
			sps.KEYWORD=this.keyword;
			sps.range=this.range;
			List<Hotel> hs=SearchFlow.HotelSearch(sps);
			session.put("search_type", this.s_type);
			session.put("search_hotels", hs);
		}else if(this.s_type.equals("3")){
			sps.KEYWORD=this.keyword;
			sps.range=this.range;
			List<Restaurant> rs=SearchFlow.RestaurantSearch(sps);
			session.put("search_type", this.s_type);
			session.put("search_rests", rs);
		}else if(this.s_type.equals("4")){
			sps.KEYWORD=this.keyword;
			sps.range=this.range;
			List<Attraction> as=SearchFlow.AttractionSearch(sps);
			session.put("search_type", this.s_type);
			session.put("search_attrs", as);
		}
		return SUCCESS;
	}
	
	
	public String deleteCity() throws Exception{
		return SUCCESS;
	}
	
	public String deleteHotel() throws Exception{
		return SUCCESS;
	}
	
	public String deleteRestaurant() throws Exception{
		return SUCCESS;
	}
	public String deleteAttraction() throws Exception{
		return SUCCESS;
	}
//	public HotelService getHotelService() {
//		return hotelService;
//	}
	public void setHotelService(HotelService hotelService) {
		this.hotelService = hotelService;
	}
//	public RestaurantService getRestaurantService() {
//		return restaurantService;
//	}
	public void setRestaurantService(RestaurantService restaurantService) {
		this.restaurantService = restaurantService;
	}
//	public CityService getCityService() {
//		return cityService;
//	}
	public void setCityService(CityService cityService) {
		this.cityService = cityService;
	}
//	public AttractionService getAttractionService() {
//		return attractionService;
//	}
	public void setAttractionService(AttractionService attractionService) {
		this.attractionService = attractionService;
	}

	public String getS_type() {
		return s_type;
	}

	public void setS_type(String s_type) {
		this.s_type = s_type;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getRange() {
		return range;
	}

	public void setRange(String range) {
		this.range = range;
	}
}
