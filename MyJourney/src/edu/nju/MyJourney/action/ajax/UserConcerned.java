package edu.nju.MyJourney.action.ajax;

import java.util.List;

import edu.nju.MyJourney.action.BaseAction;
import edu.nju.MyJourney.helperModel.Daren;
import edu.nju.MyJourney.service.HomeService;

public class UserConcerned extends BaseAction{
	private HomeService homeService;
	private long uid;
	private List<Daren> concernedList;
	@Override
	public String execute() throws Exception {
		String result = SUCCESS;
		concernedList = homeService.getConcerned(uid);
		System.out.println("用户"+uid+"关注的人数："+concernedList.size());
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
	public List<Daren> getConcernedList() {
		return concernedList;
	}
	public void setConcernedList(List<Daren> concernedList) {
		this.concernedList = concernedList;
	}
}
