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
//		CityDao cityDao = new CityDaoImpl();
//		PlaceDao placeDao = new PlaceDaoImpl();
//		UserDao userDao = new UserDaoImpl();
//		userDao.deleteUserById("8");
//		userDao.deleteUserById("9");
//		userDao.deleteUserById("10");
//		userDao.deleteUserById("11");
//		JourneyDao journeyDao = new JourneyDaoImpl();
//		Picture picture = new Picture();
//		Place place = new Place();
//		User user = new User();
//		Journey journey = new Journey();
//		
//		City beijing=new City();
//		CityDao citydao=new CityDaoImpl();
//		beijing.setCountry("中国");
//		beijing.setLat("116.404");
//		beijing.setLng("39.915");
//		beijing.setName("北京");
//		beijing.setPicture("BeiJing");
//		
//		City chengdu =new City();
//		chengdu.setCountry("中国");
//		chengdu.setLat("104.06");
//		chengdu.setLng("30.67");
//		chengdu.setName("成都");
//		chengdu.setPicture("ChengDu");
//		
//		City hangzhou =new City();
//		hangzhou.setCountry("中国");
//		hangzhou.setLat("120.19");
//		hangzhou.setLng("30.26");
//		hangzhou.setName("杭州");
//		hangzhou.setPicture("HangZhou");
//		
//		City lijiang=new City();
//		lijiang.setCountry("中国");
//		lijiang.setLat("100.25");
//		lijiang.setLng("26.86");
//		lijiang.setName("丽江");
//		lijiang.setPicture("LiJiang");
//		
//		City shanghai=new City();
//		shanghai.setCountry("中国");
//		shanghai.setLat("121.29");
//		shanghai.setLng("31.14");
//		shanghai.setName("上海");
//		shanghai.setPicture("ShangHai");
//		
//		City xiamen=new City();
//		xiamen.setCountry("中国");
//		xiamen.setLat("118.1");
//		xiamen.setLng("24.46");
//		xiamen.setName("厦门");
//		xiamen.setPicture("XiaMen");
//		
//		City xianggang=new City();
//		xianggang.setCountry("中国");
//		xianggang.setLat("114.1");
//		xianggang.setLng("22.2");
//		xianggang.setName("香港");
//		xianggang.setPicture("XiangGang");
//		
//		City taibei=new City();
//		taibei.setCountry("中国");
//		taibei.setLat("121.30");
//		taibei.setLng("25.03");
//		taibei.setName("台北");
//		taibei.setPicture("TaiBei");
//		
//		City sanya=new City();
//		sanya.setCountry("中国");
//		sanya.setLat("109.31");
//		sanya.setLng("18.14");
//		sanya.setName("三亚");
//		sanya.setPicture("SanYa");
//		citydao.insertCity(sanya);
//		citydao.insertCity(taibei);
//		citydao.insertCity(xianggang);
//		citydao.insertCity(xiamen);
//		citydao.insertCity(shanghai);
//		citydao.insertCity(lijiang);
//		citydao.insertCity(chengdu);
//		citydao.insertCity(beijing);
//		citydao.insertCity(hangzhou);
//		
//		
//		City citys[] = {sanya,taibei,xianggang,xiamen,shanghai,lijiang,chengdu,hangzhou};
//		List<City> citys = new ArrayList<City>();
//		for(int i=1;i<10;i++){
//			City c = cityDao.getCityById(String.valueOf(i));
//			citys.add(c);
//			System.out.println(c.getCid()+"  "+c.getName());
//		}
//		//添加图片
//		List<String> imagePaths=new ArrayList<String>();
//		for(int i=1;i<74;i++){
//			imagePaths.add("/MyJourney/upload/pic/"+i+".jpg");
//			System.out.println("第"+i+"个  ："+imagePaths.get(i-1));
//		}
//		
//		
//		//用户
//		user.setAccount("fdp");
//		user.setAge(24);
//		user.setCity("南京");
//		user.setEmail("fdp@software.com");
//		user.setImage("/MyJourney/upload/user/1.png");
//		user.setName("大鹏");
//		user.setPhone("123456789");
//		user.setPwd("fdp");
//		user.setSex(User.MAN);
//		userDao.insertUser(user);
//		//添加旅行
//		Journey journeys[] = new Journey[16];
//		String journeyName[] = {"三亚游","台北游","香港游","厦门游","上海游","丽江游","成都游","杭州游"
//				,"北京游","南京游","长江游","苏州游","扬州游","周庄游","武汉游","重庆游",};
//		for(int i=0;i<16;i++){
//			journey.setJourneyName(journeyName[i]);
//			journey.setState(new Random().nextInt(2));
//			journey.setUser(user);
//			List<Place> places = new ArrayList<Place>();
//			for(int k=0;k<9;k++){
//				place.setCity(citys.get(new Random().nextInt(8)+1));
//				place.setHalfday(i%2);
//				place.setTime(String.valueOf(System.currentTimeMillis()));
//				place.setTraffic("公交97路");
//				List<Picture> pictureList = new ArrayList<Picture>();
//				for(int l=1;l<74;l++){
//					Picture p = new Picture();
//					p.setImagepath(imagePaths.get(l-1));
//					p.setPlace(place);
//					pictureList.add(p);
//				}
//				int startIndex = new Random().nextInt(73)+1;
//				int endIndex = new Random().nextInt(73)+1;
//				if(startIndex>endIndex){
//					int tmp = startIndex;
//					startIndex = endIndex;
//					endIndex = tmp;
//				}
//				System.out.println("#Picture startIndex:  "+startIndex+"  "+"endIndex:  "+endIndex+"  size:  "+pictureList.size());
//				List<Picture> pics = pictureList.subList(startIndex, endIndex);
//				for(Picture p:pics){
//					if(p.getPlace()==null){
//						p.setPlace(place);
//					}
//				}
//				place.setImages(pics);
//				placeDao.insertPlace(place);
//				places.add(place);
//				place = new Place();
//				
//			}
//			int startIndex = new Random().nextInt(8)+1;
//			int endIndex = new Random().nextInt(8)+1;
//			if(startIndex>endIndex){
//				int tmp = startIndex;
//				startIndex = endIndex;
//				endIndex = tmp;
//			}
//			System.out.println("$Place  startIndex:  "+startIndex+""+"endIndex:  "+endIndex);
//			List<Place> plas=places.subList(startIndex, endIndex);
//			
//			journeyDao.insertJoueney(journey);
//			for(Place p:places){
//				p.setJourney(journey);
//				placeDao.updatePlace(p);
//			}
//			journey = new Journey();
//		}
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
