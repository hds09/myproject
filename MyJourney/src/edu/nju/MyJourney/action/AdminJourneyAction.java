package edu.nju.MyJourney.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

import edu.nju.MyJourney.helpflow.SearchFlow;
import edu.nju.MyJourney.helpflow.SearchPrepareStatement;
import edu.nju.MyJourney.model.Attraction;
import edu.nju.MyJourney.model.City;
import edu.nju.MyJourney.model.Hotel;
import edu.nju.MyJourney.model.Journey;
import edu.nju.MyJourney.model.Restaurant;
import edu.nju.MyJourney.model.User;
import edu.nju.MyJourney.service.AttractionService;
import edu.nju.MyJourney.service.CityService;
import edu.nju.MyJourney.service.HotelService;
import edu.nju.MyJourney.service.JourneyService;
import edu.nju.MyJourney.service.RestaurantService;
import edu.nju.MyJourney.service.UserService;

public class AdminJourneyAction extends BaseAction{
	private String vid="0";
	private String hid;
	private String rid;
	private String cid;
	private String aid;
	private String j_keyword;
	private String j_type;
	private JourneyService journeyService;
	private HotelService hotelService;
	private RestaurantService restaurantService;
	private CityService cityService;
	private AttractionService attractionService;
	private UserService userService;
	private String ids;
	private String jid;
	private String jowner;
	private String jtype;
	private String jname;
	private String kick_uid;
	private String kick_tid;
	public String execute() throws Exception {
		String res=SUCCESS;
		ActionContext actionContext = ActionContext.getContext();  
		Map session = actionContext.getSession();
		if((Boolean) session.get("privilege_granted")!=true){
			System.out.println("session_expired!");
			return "false";
		}else{
			List<Journey> journeys=journeyService.getAllJourneys();
			session.put("journeys", journeys);
			System.out.println(journeys.size());
			return res;
		}		
	}
	
	public String searchJourney() throws Exception{
		System.out.println("keyword: "+j_keyword);
		System.out.println("type: "+j_type);
		SearchPrepareStatement sps=new SearchPrepareStatement();
		//set keyword
		sps.type="JourneySearch";
		sps.KEYWORD=j_keyword;
		//set type
		sps.j_type=j_type;
//		//
		ArrayList<Journey> searchResult=SearchFlow.JourneySearch(sps);
		System.out.println("searchResult size: "+searchResult.size());
		String res=SUCCESS;
		ActionContext actionContext = ActionContext.getContext();  
		Map session = actionContext.getSession();
		session.put("j_searchResult", searchResult);
		return res;
	}

	public String viewJourney() throws Exception {
		String res=SUCCESS;
		System.out.println("vid value: "+this.vid);
		Journey j=journeyService.getJourneyById(Integer.parseInt(vid));
		ActionContext actionContext = ActionContext.getContext();  
		Map session = actionContext.getSession();
		session.put("view_j", j);
		return res;
	}
	
	public String viewHotel() throws Exception{
		System.out.println("hid value: "+this.hid);
		Hotel h=hotelService.getHotelById(this.hid);
		List<City> cities=cityService.getCity();
		ActionContext actionContext = ActionContext.getContext();  
		Map session = actionContext.getSession();
		session.put("view_h", h);
		session.put("cities", cities);
		return SUCCESS;
	}
	
	public String viewRestaurant() throws Exception{
		System.out.println("rid value: "+this.rid);
		Restaurant r=restaurantService.getRestaurantById(this.rid);
		List<City> cities=cityService.getCity();
		ActionContext actionContext = ActionContext.getContext();  
		Map session = actionContext.getSession();
		session.put("view_r", r);
		session.put("cities", cities);
		return SUCCESS;
	}
	
	public String viewCity() throws Exception{
		System.out.println("cid value: "+this.cid);
		City c=cityService.getCityById(this.cid);
		ActionContext actionContext = ActionContext.getContext();  
		Map session = actionContext.getSession();
		session.put("view_c", c);
		return SUCCESS;
	}
	public String viewAttraction() throws Exception{
		System.out.println("aid value: "+this.aid);
		Attraction a=attractionService.getAttractionById(this.aid);
		List<City> cities=cityService.getCity();
		ActionContext actionContext = ActionContext.getContext();  
		Map session = actionContext.getSession();
		session.put("view_a", a);
		session.put("cities", cities);
		return SUCCESS;
	}
	
	
	public String editJourney() throws Exception{
		System.out.println(this.jid);
		System.out.println(this.jname);
		System.out.println(this.jowner);
		System.out.println(this.jtype);
		Journey j=this.journeyService.getJourneyById(Integer.parseInt(this.jid));
		User u=this.userService.getUserByAccount(this.jowner);
		j.setUser(u);
		j.setState(Integer.parseInt(this.jtype));
		j.setJourneyName(this.jname);
		this.journeyService.updateJourney(j);
		return SUCCESS;
	}
	
//	public UserService getUserService() {
//		return userService;
//	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String deleteJourney() throws Exception{
		System.out.println("ids: "+ids);
		ids=ids.substring(0, ids.length()-1);
		System.out.println("ids: "+ids);
		if(!ids.contains("+")){
			journeyService.deleteJourneyById(ids);
		}else{
			String[] idList=ids.split("\\+");
			System.out.println(idList.length);
			for(int i=0;i<idList.length;i++){
				journeyService.deleteJourneyById(idList[i]);
			}
		}
		System.out.println("done!");
		return SUCCESS;
	}
	
	public String deleteUserFromTeam() throws Exception{
		System.out.println("jid: "+jid);
		System.out.println(this.kick_tid);
		System.out.println(this.kick_uid);
		Journey j=this.journeyService.getJourneyById(Integer.parseInt(jid));
		User u=this.userService.getUserById(this.kick_uid);
		List<User> users=j.getTeam().getUsers();
		System.out.println(users.size()+"fdfd");
		for(int i=0;i<users.size();i++){
			if(users.get(i).getUid()==Integer.parseInt(this.kick_uid)){
				users.remove(i);
			}
		}
		j.getTeam().setUsers(users);
		System.out.println(j.getTeam().getUsers().size()+"fdfd");
		this.journeyService.updateJourney(j);
		return SUCCESS;
	}

	
	public String deletePlace() throws Exception{
		return SUCCESS;
	}

	
//	public JourneyService getJourneyService() {
//		return journeyService;
//	}

	public void setJourneyService(JourneyService journeyService) {
		this.journeyService = journeyService;
	}
	
//	public String getVid() {
//		return vid;
//	}

	public void setVid(String vid) {
		this.vid = vid;
	}

//	public String getHid() {
//		return hid;
//	}

	public void setHid(String hid) {
		this.hid = hid;
	}

//	public String getRid() {
//		return rid;
//	}

	public void setRid(String rid) {
		this.rid = rid;
	}

//	public String getCid() {
//		return cid;
//	}

	public void setCid(String cid) {
		this.cid = cid;
	}

//	public String getAid() {
//		return aid;
//	}

	public void setAid(String aid) {
		this.aid = aid;
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

//	public String getJ_keyword() {
//		return j_keyword;
//	}

	public void setJ_keyword(String j_keyword) {
		this.j_keyword = j_keyword;
	}

//	public String getJ_type() {
//		return j_type;
//	}

	public void setJ_type(String j_type) {
		this.j_type = j_type;
	}

//	public String getIds() {
//		return ids;
//	}

	public void setIds(String ids) {
		this.ids = ids;
	}

//	public String getJid() {
//		return jid;
//	}

	public void setJid(String jid) {
		this.jid = jid;
	}

//	public String getJowner() {
//		return jowner;
//	}

	public void setJowner(String jowner) {
		this.jowner = jowner;
	}

//	public String getJtype() {
//		return jtype;
//	}

	public void setJtype(String jtype) {
		this.jtype = jtype;
	}

//	public String getJname() {
//		return jname;
//	}

	public void setJname(String jname) {
		this.jname = jname;
	}

	public String getKick_uid() {
		return kick_uid;
	}

	public void setKick_uid(String kick_uid) {
		this.kick_uid = kick_uid;
	}

	public String getKick_tid() {
		return kick_tid;
	}

	public void setKick_tid(String kick_tid) {
		this.kick_tid = kick_tid;
	}
}
