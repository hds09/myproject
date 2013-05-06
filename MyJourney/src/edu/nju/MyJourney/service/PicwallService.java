package edu.nju.MyJourney.service;

import java.util.List;

import edu.nju.MyJourney.helperModel.WallPicture;



public interface PicwallService {
	public List<WallPicture> getWallPictures(int page,int pageSize);
	public int getWallPicturesPageMax(int pageSize);
}
