package edu.nju.MyJourney.action;
import java.util.List;

import edu.nju.MyJourney.helperModel.WallPicture;
import edu.nju.MyJourney.service.PicwallService;

public class PicwallAction extends PageAction {
	private static final int pageSize = 16;
	private PicwallService picwallService;
	private List<WallPicture> picList;
	@Override
	public String execute() throws Exception {
		String result = SUCCESS;
		pageMax = picwallService.getWallPicturesPageMax(pageSize);
		super.execute();
		if(page<0){
			page = 0;
		}
		picList = picwallService.getWallPictures(page,pageSize);
		System.out.println(picList.size());
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

	



	
}
