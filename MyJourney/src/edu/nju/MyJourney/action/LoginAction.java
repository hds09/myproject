package edu.nju.MyJourney.action;

import edu.nju.MyJourney.model.User;
import edu.nju.MyJourney.service.UserService;

public class LoginAction extends BaseAction{
	private UserService userService;
	private String account;
	private String password;
	private User user;
	@Override
	public String execute() throws Exception {
		System.out.println("I am in");
//		user = userService.Login(account, password);
		String result = INPUT;
		if(user == null){
			result = "failure";
			addActionMessage("登陆失败");
		}else{
			addActionMessage("登陆成功");
			result = SUCCESS;
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
   
}
