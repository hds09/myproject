/**
 * 
 */
package edu.nju.MyJourney.action;

import java.util.List;
import java.util.ArrayList;

import com.opensymphony.xwork2.ActionContext;

import edu.nju.MyJourney.helperModel.Daren;
import edu.nju.MyJourney.helperModel.WallPicture;
import edu.nju.MyJourney.model.Journey;
import edu.nju.MyJourney.service.DarenService;
import edu.nju.MyJourney.service.HomeService;
/**
 * @author softwware
 * 达人action
 * 获取达人列表
 */
public class DarenAction extends PageAction{
	private static final int pageSize = 20;
	private DarenService darenService;
	private HomeService homeService;
	private List<Daren> darenList;
	@Override
	public String execute() throws Exception {
		String result = SUCCESS;
		System.out.println(darenService+" "+ homeService);
		if(page < 0 ){
			page = 0;
		}
		darenList = darenService.getDarens(page,pageSize);
		List<WallPicture> picList;
		List<Journey> journeyList;
		if(darenList != null){
			for(Daren d:darenList){
				picList = new ArrayList<WallPicture>();
				journeyList = new ArrayList<Journey>();
				journeyList = homeService.getUserJourney(d.getAccount(), 0, 4);
				for(Journey j:journeyList){
					picList.add(new WallPicture().convertFromJourney(j));
				}
				d.setPictureList(picList);
				//判断是否已经关注
				if(session().getAttribute("account") !=null){
					String loginAccount = (String) session().getAttribute("account");
					if(loginAccount.equals(d.getAccount())){
						d.setHasAttention(2);//本人
					}else if(homeService.hasAttention(loginAccount, d.getAccount())){
						d.setHasAttention(0);//已经关注
					}else{
						d.setHasAttention(1);
					}
				}
//				System.out.println(d.getAccount());
//				System.out.println(d.getHasAttention());
			}
			pageMax = darenService.getDarensPageMax(pageSize);
		}
		super.execute();
		return result;
	}


	public List<Daren> getDarenList() {
		return darenList;
	}


	public void setDarenList(List<Daren> darenList) {
		this.darenList = darenList;
	}

	public DarenService getDarenService() {
		return darenService;
	}


	public void setDarenService(DarenService darenService) {
		this.darenService = darenService;
	}


	public HomeService getHomeService() {
		return homeService;
	}


	public void setHomeService(HomeService homeService) {
		this.homeService = homeService;
	}

	
	
}
