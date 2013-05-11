package edu.nju.MyJourney.action.ajax;

import edu.nju.MyJourney.action.BaseAction;
import edu.nju.MyJourney.model.User;
import edu.nju.MyJourney.service.UserService;

public class AddAttentionAction extends BaseAction {
	private UserService userService;
	private String AttentionAccount;
	@Override
	public String execute() throws Exception {
		String result = SUCCESS;
		if(session().getAttribute("account") ==null){
			return "notlogin";
		}
		User attention = userService.getUserByAccount(AttentionAccount);
		String account = (String) session().getAttribute("account");
		User user = userService.getUserByAccount(account);
		if(user.getUid() != attention.getUid()){
			user.addAtterntion(attention);
			userService.updateUser(user);
		}
		return result;
	}
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public String getAttentionAccount() {
		return AttentionAccount;
	}
	public void setAttentionAccount(String attentionAccount) {
		AttentionAccount = attentionAccount;
	}
	
}
