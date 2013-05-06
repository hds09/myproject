package edu.nju.MyJourney.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

public class LogoutAction extends BaseAction{
public String execute() throws Exception {
		
//		user = userService.Login(account, password);
		String result = SUCCESS;
		
			 ActionContext actionContext = ActionContext.getContext();  
			  Map session = actionContext.getSession();	
			 session.put("islogined",false);
			 session.put("account",null);
			 
		return result;
	}
}
