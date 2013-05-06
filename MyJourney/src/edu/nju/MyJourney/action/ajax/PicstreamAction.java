package edu.nju.MyJourney.action.ajax;

import java.util.List;

import edu.nju.MyJourney.action.BaseAction;
import edu.nju.MyJourney.helperModel.WallPicture;
import edu.nju.MyJourney.service.PicwallService;
/**
 * 图片墙
 * @author softwware
 *
 */
public class PicstreamAction extends BaseAction {
	private static final int pageSize = 20;
	private PicwallService picwallService;
	private List<WallPicture> picList;
	private int page;
	@Override
	public String execute() throws Exception {
		String result = SUCCESS;
		if(page<0){
			page = 0;
		}
		picList = picwallService.getWallPictures(page,pageSize);
		System.out.println("ajax图片流图片数目："+picList.size());
		return result;
	}

	public List<WallPicture> getPicList() {
		return picList;
	}

	public void setPicList(List<WallPicture> picList) {
		this.picList = picList;
	}



	public PicwallService getPicwallService() {
		return picwallService;
	}

	public void setPicwallService(PicwallService picwallService) {
		this.picwallService = picwallService;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}
	
}
