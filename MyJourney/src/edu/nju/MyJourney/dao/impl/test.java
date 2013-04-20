package edu.nju.MyJourney.dao.impl;

import java.util.ArrayList;
import java.util.List;

import edu.nju.MyJourney.dao.CityDao;
import edu.nju.MyJourney.dao.JourneyDao;
import edu.nju.MyJourney.dao.UserDao;
import edu.nju.MyJourney.model.City;
import edu.nju.MyJourney.model.Hotel;
import edu.nju.MyJourney.model.Journey;
import edu.nju.MyJourney.model.Place;
import edu.nju.MyJourney.model.Team;
import edu.nju.MyJourney.model.User;

public class test {
public static void main(String args[]){
	//Journey journey=new Journey();
	//Place beijing=new Place();
	
/*	Hotel buding=new Hotel();
	buding.setName("布丁");
	buding.setPhone("123456789");
	buding.setAddress("xxx路xxx号");
    

	Place place=new Place();
	PlaceDaoImpl dao=new PlaceDaoImpl();
	

	dao.insertPlace(place);
	Place place2=dao.getPlaceById(1);
	System.out.println(place2.getImages().get(0));
	*/
	/*UserDaoImpl dao=new UserDaoImpl();
	User user=new User();
	user.setAccount("hds");
	dao.insertUser(user);
	Team team=new Team();
	team.setTeamName("东方红");
	TeamDaoImpl dao2=new TeamDaoImpl();
	dao2.insertTeam(team);
	user.addTeam(team);
	dao.update(user);*///如果两个表都有记录  怎么加关联
	UserDao userdao=new UserDaoImpl();
	JourneyDao journeydao=new JourneyDaoImpl();
	Journey journey=new Journey();
	journey.setJourneyName("探险者");
	journeydao.insertJoueney(journey);
	User user=userdao.getUserByAccount("hds");
	//User user=userdao.getUserById(1);
	System.out.println(user.getAccount());
	//user.setAccount("hds");
	//userdao.insertUser(user);
	user.addJourney(journey);
	userdao.update(user);
	//int length=team.getUsers().size();
	/*for(int i=0;i<length;i++){
	dao.removeTeam(team.getUsers().get(i), team);
	}*/
	//dao2.deleteTeam(team);
	//dao.deleteUserByAccount("hds");
	
	/*City beijing=new City();
	CityDao citydao=new CityDaoImpl();
	beijing.setCountry("中国");
	beijing.setLat("116.404");
	beijing.setLng("39.915");
	beijing.setName("北京");
	
	City chengdu =new City();
	chengdu.setCountry("中国");
	chengdu.setLat("104.06");
	chengdu.setLng("30.67");
	chengdu.setName("成都");
	
	City hangzhou =new City();
	hangzhou.setCountry("中国");
	hangzhou.setLat("120.19");
	hangzhou.setLng("30.26");
	hangzhou.setName("杭州");
	
	City lijiang=new City();
	lijiang.setCountry("中国");
	lijiang.setLat("100.25");
	lijiang.setLng("26.86");
	lijiang.setName("丽江");
	
	City shanghai=new City();
	shanghai.setCountry("中国");
	shanghai.setLat("121.29");
	shanghai.setLng("31.14");
	shanghai.setName("上海");
	
	City xiamen=new City();
	xiamen.setCountry("中国");
	xiamen.setLat("118.1");
	xiamen.setLng("24.46");
	xiamen.setName("厦门");
	
	City xianggang=new City();
	xianggang.setCountry("中国");
	xianggang.setLat("114.1");
	xianggang.setLng("22.2");
	xianggang.setName("香港");
	
	City taibei=new City();
	taibei.setCountry("中国");
	taibei.setLat("121.30");
	taibei.setLng("25.03");
	taibei.setName("台北");
	
	City sanya=new City();
	sanya.setCountry("中国");
	sanya.setLat("109.31");
	sanya.setLng("18.14");
	sanya.setName("三亚");
	citydao.insertCity(sanya);
	citydao.insertCity(taibei);
	citydao.insertCity(xianggang);
	citydao.insertCity(xiamen);
	citydao.insertCity(shanghai);
	citydao.insertCity(lijiang);
	citydao.insertCity(chengdu);
	citydao.insertCity(beijing);
	citydao.insertCity(hangzhou);*/
	
	/*User user=new User();

	user.setAccount("hds09");
	user.setAge(23);
	user.setCity("南京");*/
	
}
}
