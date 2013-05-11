package edu.nju.MyJourney.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

import edu.nju.MyJourney.model.User;
import edu.nju.MyJourney.service.UserService;

public class LoginAction extends BaseAction{
	private UserService userService;
	private boolean islogined;

	private String account;
	private String password;
	private User user;
	@Override
	public String execute() throws Exception {
		String result = SUCCESS;
		System.out.println(account+" and "+password);
		if(!userService.haveuser(account, password)){
		result="failure";
		}else{
		ActionContext actionContext = ActionContext.getContext();
		Map session = actionContext.getSession();	
		this.islogined=true;
			session.put("islogined",this.islogined);
			session.put("account",this.account);
			Long uuid=this.userService.getUserByAccount(this.account).getUid();
			session.put("Auuid",uuid);
		}
		return result;
	}
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
		System.out.println("login set userservice");
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public boolean isIslogined() {
		return islogined;
	}
	public void setIslogined(boolean islogined) {
		this.islogined = islogined;
	}
}
