package edu.nju.MyJourney.action;
import java.util.List;

import edu.nju.MyJourney.helperModel.Daren;
import edu.nju.MyJourney.model.Journey;
import edu.nju.MyJourney.service.HomeService;
/**
 * 个人主页action，显示一个人的信息
 * @author softwware
 *
 */
public class HomeAction extends PageAction{
	public static final int pageSize = 10;
	private HomeService homeService;
	private long darenId;
	private Daren daren;
	private List<Journey> journeyList;
	@Override
	public String execute() throws Exception {
		String result = SUCCESS;
		daren = homeService.DarenInfo(darenId);
		if(session().getAttribute("account") !=null){
			String loginAccount = (String) session().getAttribute("account");
			if(loginAccount.equals(daren.getAccount())){
				daren.setHasAttention(2);//本人
			}else if(homeService.hasAttention(loginAccount, daren.getAccount())){
				daren.setHasAttention(0);//已经关注
			}else{
				daren.setHasAttention(1);
			}
		}
		if(page < 0 ){
			page = 0;
		}
		journeyList = homeService.getUserJourney(daren.getAccount(), page, pageSize);
		pageMax = homeService.getUserJourneyPageMax(darenId,pageSize);
		super.execute();
		return result;
	}
	public HomeService getHomeService() {
		return homeService;
	}
	public void setHomeService(HomeService homeService) {
		this.homeService = homeService;
	}
	public long getDarenId() {
		return darenId;
	}
	public void setDarenId(long darenId) {
		this.darenId = darenId;
	}
	public Daren getDaren() {
		return daren;
	}
	public void setDaren(Daren daren) {
		this.daren = daren;
	}
	public List<Journey> getJourneyList() {
		return journeyList;
	}
	public void setJourneyList(List<Journey> journeyList) {
		this.journeyList = journeyList;
	}
	
}	
