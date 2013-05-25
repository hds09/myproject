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
	public AlbumService getAlbumService() {
		return albumService;
	}
	public void setAlbumService(AlbumService albumService) {
		this.albumService = albumService;
	}
	public long getPictureId() {
		return pictureId;
	}
	public void setPictureId(long pictureId) {
		this.pictureId = pictureId;
	}
	
}
