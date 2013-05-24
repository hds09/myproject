package edu.nju.MyJourney.action.ajax;

import edu.nju.MyJourney.action.BaseAction;
import edu.nju.MyJourney.service.AlbumService;

public class DeletePictureAction extends BaseAction{
	private AlbumService albumService;
	private long pictureId;
	@Override
	public String execute() throws Exception {
		albumService.deletePicture(pictureId);
		return SUCCESS;
	}
	
}
