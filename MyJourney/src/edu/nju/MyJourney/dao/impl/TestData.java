package edu.nju.MyJourney.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import edu.nju.MyJourney.dao.CityDao;
import edu.nju.MyJourney.dao.JourneyDao;
import edu.nju.MyJourney.dao.PlaceDao;
import edu.nju.MyJourney.dao.UserDao;
import edu.nju.MyJourney.model.City;
import edu.nju.MyJourney.model.Journey;
import edu.nju.MyJourney.model.Picture;
import edu.nju.MyJourney.model.Place;
import edu.nju.MyJourney.model.User;

/**
 * 测试数据
 * @author softwware
 *
 */
public class TestData {
	public static void main(String[] args) {
		PlaceDao placeDao = new PlaceDaoImpl();
		UserDao userDao = new UserDaoImpl();
		JourneyDao journeyDao = new JourneyDaoImpl();
		Picture picture = new Picture();
		Place place = new Place();
		User user = new User();
		Journey journey = new Journey();
		
		City beijing=new City();
		CityDao citydao=new CityDaoImpl();
		beijing.setCountry("中国");
		beijing.setLat("116.404");
		beijing.setLng("39.915");
		beijing.setName("北京");
		beijing.setPicture("BeiJing");
		
		City chengdu =new City();
		chengdu.setCountry("中国");
		chengdu.setLat("104.06");
		chengdu.setLng("30.67");
		chengdu.setName("成都");
		chengdu.setPicture("ChengDu");
		
		City hangzhou =new City();
		hangzhou.setCountry("中国");
		hangzhou.setLat("120.19");
		hangzhou.setLng("30.26");
		hangzhou.setName("杭州");
		hangzhou.setPicture("HangZhou");
		
		City lijiang=new City();
		lijiang.setCountry("中国");
		lijiang.setLat("100.25");
		lijiang.setLng("26.86");
		lijiang.setName("丽江");
		lijiang.setPicture("LiJiang");
		
		City shanghai=new City();
		shanghai.setCountry("中国");
		shanghai.setLat("121.29");
		shanghai.setLng("31.14");
		shanghai.setName("上海");
		shanghai.setPicture("ShangHai");
		
		City xiamen=new City();
		xiamen.setCountry("中国");
		xiamen.setLat("118.1");
		xiamen.setLng("24.46");
		xiamen.setName("厦门");
		xiamen.setPicture("XiaMen");
		
		City xianggang=new City();
		xianggang.setCountry("中国");
		xianggang.setLat("114.1");
		xianggang.setLng("22.2");
		xianggang.setName("香港");
		xianggang.setPicture("XiangGang");
		
		City taibei=new City();
		taibei.setCountry("中国");
		taibei.setLat("121.30");
		taibei.setLng("25.03");
		taibei.setName("台北");
		taibei.setPicture("TaiBei");
		
		City sanya=new City();
		sanya.setCountry("中国");
		sanya.setLat("109.31");
		sanya.setLng("18.14");
		sanya.setName("三亚");
		sanya.setPicture("SanYa");
		citydao.insertCity(sanya);
		citydao.insertCity(taibei);
		citydao.insertCity(xianggang);
		citydao.insertCity(xiamen);
		citydao.insertCity(shanghai);
		citydao.insertCity(lijiang);
		citydao.insertCity(chengdu);
		citydao.insertCity(beijing);
		citydao.insertCity(hangzhou);
		
		
		City citys[] = {sanya,taibei,xianggang,xiamen,shanghai,lijiang,chengdu,hangzhou};
		//添加图片
		String imagepaths[] = {"/MyJourney/upload/pic/1.jpg","/MyJourney/upload/pic/2.jpg"
								,"/MyJourney/upload/pic/3.jpg","/MyJourney/upload/pic/4.jpg"
								,"/MyJourney/upload/pic/5.jpg","/MyJourney/upload/pic/6.jpg"
								,"/MyJourney/upload/pic/7.jpg","/MyJourney/upload/pic/8.jpg",};
		
		
		//用户
		user.setAccount("fdp");
		user.setAge(24);
		user.setCity("南京");
		user.setEmail("fdp@software.com");
		user.setImage("/MyJourney/upload/user/1.png");
		user.setName("大鹏");
		user.setPhone("123456789");
		user.setPwd("fdp");
		user.setSex(User.MAN);
		userDao.insertUser(user);
		//添加旅行
		Journey journeys[] = new Journey[8];
		String journeyName[] = {"三亚游","台北游","香港游","厦门游","上海游","丽江游","成都游","杭州游"};
		for(int i=0;i<8;i++){
			journey.setJourneyName(journeyName[i]);
			journey.setState(new Random().nextInt(2));
			journey.setUser(user);
			List<Place> places = new ArrayList<Place>();
			for(int k=0;k<8;k++){
				place.setCity(citys[i]);
				place.setHalfday(i%2);
				place.setTime(String.valueOf(System.currentTimeMillis()));
				place.setTraffic("公交97路");
				List<Picture> pictureList = new ArrayList<Picture>();
				for(int j=0;j<8;j++){
					picture = new Picture();
					picture.setImagepath(imagepaths[i]);
					pictureList.add(picture);
				}
				List<Picture> pics = pictureList.subList(0, new Random().nextInt(7)+1);
				for(Picture p:pics){
					if(p.getPlace()==null){
						p.setPlace(place);
					}
				}
				place.setImages(pics);
				placeDao.insertPlace(place);
				places.add(place);
				place = new Place();
				
			}
			List<Place> plas=places.subList(0, new Random().nextInt(7)+1);
			
			journeyDao.insertJoueney(journey);
			for(Place p:places){
				p.setJourney(journey);
				placeDao.updatePlace(p);
			}
			journey = new Journey();
		}
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
