package edu.nju.MyJourney.action;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

import edu.nju.MyJourney.helpflow.DataAnalysisFlow;
import edu.nju.MyJourney.model.Attraction;
import edu.nju.MyJourney.model.Hotel;
import edu.nju.MyJourney.model.Restaurant;
import edu.nju.MyJourney.service.UserService;

public class IndexAction extends BaseAction{
	private boolean islogined;
	private String account;
	private UserService userService;
	public String execute() throws Exception {
		List<Restaurant> hotRests=DataAnalysisFlow.GetHotRestaurants(3);
		List<Hotel> hotHotels=DataAnalysisFlow.GetHotHotels(3);
		List<Attraction> hotAttrs=DataAnalysisFlow.GetHotAttractions(3);
		String result = SUCCESS;
		 ActionContext actionContext = ActionContext.getContext();  
		  Map session = actionContext.getSession();
		  String tmp=(String)session.get("account");
		    if(tmp==null){
		    	this.islogined=false;
		    }else{
		    	this.islogined=true;
		    	
		    }
		    session.put("islogined",this.islogined);
		    session.put("ind_hotH",hotHotels);
		    session.put("ind_hotR",hotRests);
		    session.put("ind_hotA",hotAttrs);
		// session.put("islogined",this.islogined);
		 //session.put("account", this.account);
		return result;
	}
	public boolean isIslogined() {
		return islogined;
	}
	public void setIslogined(boolean islogined) {
		this.islogined = islogined;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}
