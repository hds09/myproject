package edu.nju.MyJourney.action;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import edu.nju.MyJourney.model.City;
import edu.nju.MyJourney.model.Place;
import edu.nju.MyJourney.service.CityService;

public class MakeRouteAction extends BaseAction{
    private CityService cityService;
    private List<City> citylist;
	public String execute() throws Exception {
		String result = SUCCESS;
		citylist=cityService.getCity();
		return result;
	}
	public CityService getCityService() {
		return cityService;
	}
	public void setCityService(CityService cityService) {
		this.cityService = cityService;
	}
	public List<City> getCitylist() {
		return citylist;
	}
	public void setCitylist(List<City> citylist) {
		this.citylist = citylist;
	}

}
