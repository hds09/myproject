package edu.nju.MyJourney.action;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

import edu.nju.MyJourney.model.User;
import edu.nju.MyJourney.service.UserService;

public class AdminIndexAction extends BaseAction{
	private UserService userService;
	public String execute() throws Exception {
		String res=SUCCESS;
		ActionContext actionContext = ActionContext.getContext();  
		Map session = actionContext.getSession();
		if((Boolean) session.get("privilege_granted")!=true){
			System.out.println("session_expired!");
			return "false";
		}else{
			List<User> users=userService.getAllUsers();
			session.put("users", users);
			System.out.println(users.size());
			return res;
		}	
	}
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}
