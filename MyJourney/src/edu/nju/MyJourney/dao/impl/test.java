package edu.nju.MyJourney.dao.impl;

import java.util.ArrayList;
import java.util.List;

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
    
	//City beijing=new City();
	//beijing.setCountry("中国");
	//beijing.setLat("116.404");
	//beijing.setLng("39.915");
	//beijing.setName("北京");
	//beijing.addHotel(buding);
	Place place=new Place();
	PlaceDaoImpl dao=new PlaceDaoImpl();
	

	dao.insertPlace(place);
	Place place2=dao.getPlaceById(1);
	System.out.println(place2.getImages().get(0));
	*/
	UserDaoImpl dao=new UserDaoImpl();
	User user=new User();
	user.setAccount("hds");
	dao.insertUser(user);
	Team team=new Team();
	team.setTeamName("东方红");
	TeamDaoImpl dao2=new TeamDaoImpl();
	dao2.insertTeam(team);
	user.addTeam(team);
	dao.upodate(user);
	dao.deleteUser(user);
}
}
