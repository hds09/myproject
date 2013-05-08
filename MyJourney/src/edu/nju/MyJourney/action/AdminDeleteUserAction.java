package edu.nju.MyJourney.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

import edu.nju.MyJourney.service.UserService;

public class AdminDeleteUserAction extends BaseAction{
	private String ids;
	private UserService userService;
	public String execute() throws Exception {
		System.out.println("ids: "+ids);
		ids=ids.substring(0, ids.length()-1);
		System.out.println("ids: "+ids);
		if(!ids.contains("+")){
			userService.deleteUserById(ids);
		}else{
			String[] idList=ids.split("\\+");
			System.out.println(idList.length);
			for(int i=0;i<idList.length;i++){
				userService.deleteUserById(idList[i]);
			}
		}
		System.out.println("done!");
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
