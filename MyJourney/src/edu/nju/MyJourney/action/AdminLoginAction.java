package edu.nju.MyJourney.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

import edu.nju.MyJourney.model.Administrator;
import edu.nju.MyJourney.service.UserService;

public class AdminLoginAction extends BaseAction {
	private UserService userService;
	private boolean privilege_granted=false;

	private String email;
	private String password;
	private Administrator admin;
	@Override
	public String execute() throws Exception {
		System.out.println("admin sign in with "+email+" "+password);
		String result = SUCCESS;
		if(!userService.adminSignin(email, password)){
			result="failure";
		}else{
			 ActionContext actionContext = ActionContext.getContext();  
			  Map session = actionContext.getSession();	
			  this.privilege_granted=true;
			 session.put("privilege_granted",this.privilege_granted);
			 session.put("email",this.email);
		}
		return result;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Administrator getAdmin() {
		return admin;
	}
	public void setAdmin(Administrator admin) {
		this.admin = admin;
	}
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}
