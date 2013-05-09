package edu.nju.MyJourney.action;

import java.util.List;
import java.util.Map;



import com.opensymphony.xwork2.ActionContext;

import edu.nju.MyJourney.model.Attraction;
import edu.nju.MyJourney.model.Comment;
import edu.nju.MyJourney.model.Hotel;
import edu.nju.MyJourney.model.Journey;
import edu.nju.MyJourney.model.Restaurant;
import edu.nju.MyJourney.model.User;
import edu.nju.MyJourney.service.*;

public class UserJourneyManagementAction extends BaseAction{
	private UserService userService;
	private JourneyService journeyService;
	private HotelService hotelService;
	private RestaurantService restaurantService;
	private CityService cityService;
	private AttractionService attractionService;
	private CommentService commentService;
	private String uid;
	private String jid;
	private String hid;
	private String aid;
	private String rid;
	private String u_uid;
	public String execute() throws Exception{
		ActionContext actionContext = ActionContext.getContext();  
		Map session = actionContext.getSession();
		System.out.println("logged in account: "+session.get("account"));
		if(session.get("account")==null){
			return "failure";
		}
		User user=this.userService.getUserByAccount((String)session.get("account"));
		List<Journey> journeys=journeyService.getUserRelatedJourney(Long.toString(user.getUid()));
		System.out.println("get user related journeys ... size: "+journeys.size());
		session.put("user_journeys",journeys);
		List<Journey> allj=journeyService.getAllJourneys();
		session.put("all_journeys",allj);
		return SUCCESS;
	}
	
	public String viewTeam() throws Exception {
		Journey j=journeyService.getJourneyById(Integer.parseInt(this.jid));
		List<Comment> comments=commentService.getCommentsByUserId(this.uid);
		ActionContext actionContext = ActionContext.getContext();  
		Map session = actionContext.getSession();
		session.put("targetJ",j );
		session.put("viewer",this.uid );
		session.put("comments",comments );
		return SUCCESS;
	}
	
	public String viewHotel() throws Exception {
		Hotel h=hotelService.getHotelById(this.hid);
		ActionContext actionContext = ActionContext.getContext();  
		Map session = actionContext.getSession();
		session.put("targeth",h );
		session.put("viewer",this.uid );
		return SUCCESS;
	}
	
	public String comment() throws Exception{
		Comment c=new Comment();
		ActionContext actionContext = ActionContext.getContext();  
		Map session = actionContext.getSession();
		this.uid=(String) session.get("viewer");
		System.out.println("uid: "+uid);
		System.out.println("jid: "+jid);
		System.out.println("hid: "+hid);
		System.out.println("aid: "+aid);
		User u=userService.getUserById(this.uid);
		Hotel h=hotelService.getHotelById(this.hid);
		Attraction a=attractionService.getAttractionById(this.aid);
		Restaurant r=restaurantService.getRestaurantById(this.rid);
		c.setUser(u);
		c.setHotel(h);
		c.setAttraction(a);
		c.setRestaurant(r);
		this.commentService.insertComment(c);
		return SUCCESS;
	}
//	public UserService getUserService() {
//		return userService;
//	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
//	public JourneyService getJourneyService() {
//		return journeyService;
//	}
	public void setJourneyService(JourneyService journeyService) {
		this.journeyService = journeyService;
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

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getJid() {
		return jid;
	}

	public void setJid(String jid) {
		this.jid = jid;
	}

	public String getHid() {
		return hid;
	}

	public void setHid(String hid) {
		this.hid = hid;
	}

//	public CommentService getCommentService() {
//		return commentService;
//	}

	public void setCommentService(CommentService commentService) {
		this.commentService = commentService;
	}

	public String getAid() {
		return aid;
	}

	public void setAid(String aid) {
		this.aid = aid;
	}

	public String getRid() {
		return rid;
	}

	public void setRid(String rid) {
		this.rid = rid;
	}

	public String getU_uid() {
		return u_uid;
	}

	public void setU_uid(String u_uid) {
		this.u_uid = u_uid;
	}

}
