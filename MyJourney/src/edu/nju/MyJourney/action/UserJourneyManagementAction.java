package edu.nju.MyJourney.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;



import com.opensymphony.xwork2.ActionContext;

import edu.nju.MyJourney.helpflow.DataAnalysisFlow;
import edu.nju.MyJourney.helpflow.SearchFlow;
import edu.nju.MyJourney.helpflow.SearchPrepareStatement;
import edu.nju.MyJourney.model.Attraction;
import edu.nju.MyJourney.model.Comment;
import edu.nju.MyJourney.model.Hotel;
import edu.nju.MyJourney.model.Journey;
import edu.nju.MyJourney.model.Restaurant;
import edu.nju.MyJourney.model.Team;
import edu.nju.MyJourney.model.User;
import edu.nju.MyJourney.service.*;
import edu.nju.MyJourney.helperModel.*;
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
	private String commText;
	private String voteType;
	private String voteFoD;
	private String keyword;

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

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
		List<SimilarJourney> sims=new ArrayList<SimilarJourney>();
		for(int i=0;i<journeys.size();i++){
			SimilarJourney tmp=new SimilarJourney();
			List<Journey> tmpsims=DataAnalysisFlow.GetSimilarJourneys(Long.toString(journeys.get(i).getId()));
			tmp.setSims(tmpsims);
			tmp.setTheJ(journeys.get(i));
			sims.add(tmp);
		}
		session.put("similarJs",sims);
		List<Journey> userInterested=DataAnalysisFlow.GetUserInterestedJourneys(Long.toString(user.getUid()));
		session.put("user_int", userInterested);
		List<User> sUsers=DataAnalysisFlow.FindSimilarUsers(Long.toString(user.getUid()));
		session.put("InUser", sUsers);
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
	public String viewRestaurant() throws Exception {
		Restaurant r=restaurantService.getRestaurantById(this.rid);
		ActionContext actionContext = ActionContext.getContext();  
		Map session = actionContext.getSession();
		session.put("targetr",r );
		session.put("viewer",this.uid );
		return SUCCESS;
	}
	public String viewAttraction() throws Exception {
		Attraction a=attractionService.getAttractionById(this.aid);
		ActionContext actionContext = ActionContext.getContext();  
		Map session = actionContext.getSession();
		session.put("targeta",a );
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
		System.out.println(this.commText);
		User u=userService.getUserById(this.uid);
		Hotel h=hotelService.getHotelById(this.hid);
		Attraction a=attractionService.getAttractionById(this.aid);
		Restaurant r=restaurantService.getRestaurantById(this.rid);
		c.setUser(u);
		c.setHotel(h);
		c.setAttraction(a);
		c.setRestaurant(r);
		c.setContext(this.commText);
		u.addComments(c);
		userService.updateUser(u);
//		this.commentService.insertComment(c);
		return SUCCESS;
	}
	
	public String allhotels() throws Exception{
		List<Hotel> hotels=this.hotelService.getAllHotels();
		ActionContext actionContext = ActionContext.getContext();  
		List<Hotel> hots=DataAnalysisFlow.GetHotHotels(2);
		Map session = actionContext.getSession();
		session.put("allHotels", hotels);
		session.put("hotHotels", hots);
		return SUCCESS;
	}
	
	public String allrests() throws Exception{
		List<Restaurant> rests=this.restaurantService.getAllRestaurant();
		ActionContext actionContext = ActionContext.getContext(); 
		List<Restaurant> hots=DataAnalysisFlow.GetHotRestaurants(2);
		Map session = actionContext.getSession();
		session.put("allRests", rests);
		session.put("hotRests", hots);
		return SUCCESS;
	}
	
	public String userHotelSearch() throws Exception{
		ActionContext actionContext = ActionContext.getContext(); 
		Map session = actionContext.getSession();
		SearchPrepareStatement sps=new SearchPrepareStatement();
		sps.KEYWORD=this.keyword;
		List<Hotel> res=SearchFlow.HotelSearch(sps);
		session.put("s_result", res);
		return SUCCESS;
	}
	
	public String userRestSearch() throws Exception{
		ActionContext actionContext = ActionContext.getContext(); 
		Map session = actionContext.getSession();
		SearchPrepareStatement sps=new SearchPrepareStatement();
		sps.KEYWORD=this.keyword;
		List<Restaurant> res=SearchFlow.RestaurantSearch(sps);
		session.put("s_result", res);
		return SUCCESS;
	}
	public String userVote() throws Exception{
		ActionContext actionContext = ActionContext.getContext();  
		Map session = actionContext.getSession();
		if(this.voteType.equals("hotel")){
			Hotel hotel=this.hotelService.getHotelById(this.hid);
			String tmp="ratedhotel"+hid;
			if(this.voteFoD.equals("0")){
				int newVote=hotel.getDislike()+1;
				hotel.setDislike(newVote);
				System.out.println(tmp);
				session.put(tmp,"1" );
			}else{
				int newVote=hotel.getFavor()+1;
				hotel.setFavor(newVote);
				System.out.println(tmp);
				session.put(tmp,"1" );
			}
			this.hotelService.updateHotel(hotel);
		}else if(this.voteType.equals("restaurant")){
			Restaurant r=this.restaurantService.getRestaurantById(this.rid);
			String tmp="ratedrest"+rid;
			if(this.voteFoD.equals("0")){
				int newVote=r.getDislike()+1;
				r.setDislike(newVote);
				System.out.println(tmp);
				session.put(tmp,"1" );
			}else{
				int newVote=r.getFavor()+1;
				r.setFavor(newVote);
				System.out.println(tmp);
				session.put(tmp,"1" );
			}
			this.restaurantService.updateRestaurant(r);
		}else if(this.voteType.equals("attraction")){
			Attraction a=this.attractionService.getAttractionById(this.aid);
			String tmp="ratedattr"+aid;
			if(this.voteFoD.equals("0")){
				int newVote=a.getDislike()+1;
				a.setDislike(newVote);
				System.out.println(tmp);
				session.put(tmp,"1" );
			}else{
				int newVote=a.getFavor()+1;
				a.setFavor(newVote);
				System.out.println(tmp);
				session.put(tmp,"1" );
			}
			this.attractionService.updateAttraction(a);
		}
		return SUCCESS;
	}
	
	public String joinTeam() throws Exception{
		System.out.print("in user join team");
		System.out.println("uid: "+uid);
		System.out.println("jid: "+jid);
		User u=this.userService.getUserById(uid);
		Journey j=this.journeyService.getJourneyById(Long.parseLong(jid));
		j.getTeam().getUsers().add(u);
		this.journeyService.updateJourney(j);
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

	public String getCommText() {
		return commText;
	}

	public void setCommText(String commText) {
		this.commText = commText;
	}

	public String getVoteType() {
		return voteType;
	}

	public void setVoteType(String voteType) {
		this.voteType = voteType;
	}

	public String getVoteFoD() {
		return voteFoD;
	}

	public void setVoteFoD(String voteFoD) {
		this.voteFoD = voteFoD;
	}

}
