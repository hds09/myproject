package edu.nju.MyJourney.listener;

import java.util.ArrayList;
import java.util.List;


import edu.nju.MyJourney.helperModel.Daren;

public class DarenStorage {
	private static List<Daren> darenList;
	private static DarenStorage instance;
	private DarenStorage(){
		if(darenList == null){
			darenList = new ArrayList<Daren>();
		}
	}
	public static DarenStorage getInstance(){
		if(instance == null){
			synchronized (DarenStorage.class) {
				if(instance == null){
					instance = new DarenStorage();
				}
			}
		}
		return instance;
	}
	public static List<Daren> getDarenList() {
		return darenList;
	}
	public static void setDarenList(List<Daren> darenList) {
		DarenStorage.darenList = darenList;
	}
	
}
