package edu.nju.MyJourney.action.ajax;

import edu.nju.MyJourney.action.BaseAction;
import edu.nju.MyJourney.service.HomeService;

public class MessageLeaveAction extends BaseAction {
	private HomeService homeService;
	private String toAccount;
//	private 
	@Override
	public String execute() throws Exception {
		String loginAccount;
		if(session().getAttribute("account") !=null){
			loginAccount = (String) session().getAttribute("account");
		}
		
		return SUCCESS;
	}
	
}
