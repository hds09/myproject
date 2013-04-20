package edu.nju.MyJourney.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

import edu.nju.MyJourney.model.User;
import edu.nju.MyJourney.service.UserService;

public class RegisterAction extends BaseAction{
	private boolean islogined;
	private String account;
	private User user;
	private UserService userService;
	private String name;
	
	//private JourneyService journeyService;
	public String execute() throws Exception {
		String result = "failure";
		if(userService.insertUser(user)){
			this.islogined=true;
			this.account=user.getAccount();
			this.name=user.getName();
			System.out.println(account);
			 ActionContext actionContext = ActionContext.getContext();  
			  Map session = actionContext.getSession();		  
			 session.put("islogined",this.islogined);
			 session.put("account",this.account);
			result="success";
			}else{
				this.islogined=false;
			}
		return result;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public boolean isIslogined() {
		return islogined;
	}
	public void setIslogined(boolean islogined) {
		this.islogined = islogined;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
}
