package edu.nju.MyJourney.action.ajax;

import edu.nju.MyJourney.action.BaseAction;
import edu.nju.MyJourney.model.Reply;
import edu.nju.MyJourney.model.User;
import edu.nju.MyJourney.service.HomeService;
import edu.nju.MyJourney.service.ReplyService;
import edu.nju.MyJourney.service.UserService;

public class ReplyAction extends BaseAction {
	private UserService userService;
	private ReplyService replyService;
	private String toAccount;
	private String context;
//	private 
	@Override
	public String execute() throws Exception {
		String loginAccount;
		if(session().getAttribute("account") !=null){
			loginAccount = (String) session().getAttribute("account");
			User user = userService.getUserByAccount(loginAccount);
			User toUser = userService.getUserByAccount(toAccount);
			Reply reply = new Reply();
			reply.setAccount_from(loginAccount);
			reply.setAccount_to(toAccount);
			reply.setContext(context);
			reply.setUser(toUser);
			replyService.insertReply(reply);
		}
		return SUCCESS;
	}
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public ReplyService getReplyService() {
		return replyService;
	}
	public void setReplyService(ReplyService replyService) {
		this.replyService = replyService;
	}
	public String getToAccount() {
		return toAccount;
	}
	public void setToAccount(String toAccount) {
		this.toAccount = toAccount;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	
}
