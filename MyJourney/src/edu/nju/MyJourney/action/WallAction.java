package edu.nju.MyJourney.action;
import java.util.List;

import edu.nju.MyJourney.helperModel.WallPicture;
import edu.nju.MyJourney.service.WallService;

public class WallAction extends PageAction {
	private static final int pageSize = 16;
	private WallService wallService;
	private List<WallPicture> picList;
	@Override
	public String execute() throws Exception {
		String result = SUCCESS;
		pageMax = wallService.getWallPicturesPageMax(pageSize);
		super.execute();
		if(page<0){
			page = 0;
		}
		picList = wallService.getWallPictures(page,pageSize);
		System.out.println(picList.size());
		return result;
	}
	public WallService getWallService() {
		return wallService;
	}
	public void setWallService(WallService wallService) {
		this.wallService = wallService;
	}
	public List<WallPicture> getPicList() {
		return picList;
	}
	public void setPicList(List<WallPicture> picList) {
		this.picList = picList;
	}




	
}
