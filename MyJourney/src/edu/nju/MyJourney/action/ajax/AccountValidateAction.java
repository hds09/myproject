package edu.nju.MyJourney.action.ajax;

import edu.nju.MyJourney.action.BaseAction;
import edu.nju.MyJourney.service.UserService;

/**
 * @author softwware
 * 用于ajax的帐号验证
 */
public class AccountValidateAction extends BaseAction{
	private UserService userService;
	private String account;
	private String result;
	@Override
	public String execute() throws Exception {
		System.out.println("test ajax "+account);
		result = "hello" + account;
		System.out.println(userService);
		return SUCCESS;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
}
