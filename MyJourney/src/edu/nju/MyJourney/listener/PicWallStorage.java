package edu.nju.MyJourney.listener;
import java.util.ArrayList;
import java.util.List;

import edu.nju.MyJourney.helperModel.WallPicture;

public class PicWallStorage {
	private static List<WallPicture> pictureList;
	private static PicWallStorage instance;
	private PicWallStorage(){
		if(pictureList == null){
			pictureList = new ArrayList<WallPicture>();
		}
	}
	public static PicWallStorage getInstance(){
		if(instance == null){
			synchronized (PicWallStorage.class) {
				if(instance == null){
					instance = new PicWallStorage();
				}
			}
		}
		return instance;
	}
	public static List<WallPicture> getPictureList() {
		return pictureList;
	}
	public static void setPictureList(List<WallPicture> pictureList) {
		PicWallStorage.pictureList = pictureList;
	}
}
