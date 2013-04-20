package edu.nju.MyJourney.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

import edu.nju.MyJourney.service.UserService;

public class IndexAction extends BaseAction{
	private boolean islogined;
	private String account;
	private UserService userService;
	public String execute() throws Exception {
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
