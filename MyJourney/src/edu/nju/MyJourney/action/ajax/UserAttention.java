package edu.nju.MyJourney.action.ajax;

import java.util.List;

import edu.nju.MyJourney.action.BaseAction;
import edu.nju.MyJourney.helperModel.Daren;
import edu.nju.MyJourney.service.HomeService;

public class UserAttention extends BaseAction{
	private HomeService homeService;
	private long uid;
	private List<Daren> attentionList;
	@Override
	public String execute() throws Exception {
		String result = SUCCESS;
		attentionList = homeService.getAttention(uid);
		System.out.println("用户"+uid+"关注的人数："+attentionList.size());
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
	public List<Daren> getAttentionList() {
		return attentionList;
	}
	public void setAttentionList(List<Daren> attentionList) {
		this.attentionList = attentionList;
	}
	
}
