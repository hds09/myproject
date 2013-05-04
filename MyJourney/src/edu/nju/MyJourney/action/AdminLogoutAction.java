package edu.nju.MyJourney.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

public class AdminLogoutAction extends BaseAction{
	@Override
	public String execute() throws Exception {
		System.out.println("admin sign out...");
		String result = SUCCESS;
		ActionContext actionContext = ActionContext.getContext();  
		Map session = actionContext.getSession();	
		String adminEmail=(String) session.get("email");
		System.out.println("admin email "+adminEmail);
		boolean priv=(Boolean) session.get("privilege_granted");
		if(priv==true){
			priv=false;
		}
		return result;
	}
}
