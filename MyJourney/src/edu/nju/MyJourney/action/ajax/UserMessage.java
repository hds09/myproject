package edu.nju.MyJourney.action.ajax;

import java.util.ArrayList;
import java.util.List;

import edu.nju.MyJourney.action.BaseAction;
import edu.nju.MyJourney.model.Reply;
import edu.nju.MyJourney.service.HomeService;

public class UserMessage extends BaseAction {
	private HomeService homeService;
	private long uid;
	private List<Reply> messageList;
	@Override
	public String execute() throws Exception {
		String result = SUCCESS;
		messageList = homeService.getMessage(uid);
//		messageList = new ArrayList<Reply>();
//		Reply re = new Reply();
//		re.setAccount_from("1");
//		re.setAccount_to("fdp");
//		re.setContext("test");
//		re.setId(1);
//		messageList.add(re);
		return result;
	}
	public HomeService getHomeService() {
		return homeService;
	}
	public void setHomeService(HomeService homeService) {
		this.homeService = homeService;
	}
	public long getUid() {
		return uid;
	}
	public void setUid(long uid) {
		this.uid = uid;
	}
	public List<Reply> getMessageList() {
		return messageList;
	}
	public void setMessageList(List<Reply> messageList) {
		this.messageList = messageList;
	}
	
}
