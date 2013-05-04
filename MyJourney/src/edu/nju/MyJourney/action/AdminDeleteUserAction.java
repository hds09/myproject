package edu.nju.MyJourney.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

import edu.nju.MyJourney.service.UserService;

public class AdminDeleteUserAction extends BaseAction{
	private String ids;
	private UserService userService;
	public String execute() throws Exception {
		if(!ids.contains("+")){
			System.out.println(ids);
			
		}else{
			String[] idList=ids.split("+");
			System.out.println(idList.length);
			
		}
		return SUCCESS;
	}
	public String getIds() {
		return ids;
	}
	public void setIds(String ids) {
		this.ids = ids;
	}
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}
