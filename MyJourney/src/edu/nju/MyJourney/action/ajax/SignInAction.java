package edu.nju.MyJourney.action.ajax;


import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

import edu.nju.MyJourney.action.BaseAction;
import edu.nju.MyJourney.model.User;
import edu.nju.MyJourney.service.UserService;

public class SignInAction extends BaseAction{
	private UserService userService;
	private String account;
	private String password;
	private String result;
	@Override
	public String execute() throws Exception {
		System.out.println(account+" and "+password);
		System.out.println(this);
		System.out.println(this.userService);
		if(!this.userService.haveuser(account, password)){
			result = "failure";
		}else{
			 ActionContext actionContext = ActionContext.getContext();  
			 Map session = actionContext.getSession();	
			 session.put("islogined",true);
			 session.put("account",this.account);
			 result = "success";
		}
		return SUCCESS;
	}
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
		System.out.println(userService);
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
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
}
