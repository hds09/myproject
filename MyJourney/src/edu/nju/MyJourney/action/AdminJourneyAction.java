package edu.nju.MyJourney.action;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

import edu.nju.MyJourney.model.User;

public class AdminJourneyAction extends BaseAction{
	public String execute() throws Exception {
		System.out.println("in journey ...");
		String res=SUCCESS;
		ActionContext actionContext = ActionContext.getContext();  
		Map session = actionContext.getSession();
		return res;	
	}
}
