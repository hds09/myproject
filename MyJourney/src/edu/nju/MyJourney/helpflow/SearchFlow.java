package edu.nju.MyJourney.helpflow;

import java.util.ArrayList;
import java.util.List;

import edu.nju.MyJourney.dao.AttractionDao;
import edu.nju.MyJourney.dao.CityDao;
import edu.nju.MyJourney.dao.HotelDao;
import edu.nju.MyJourney.dao.JourneyDao;
import edu.nju.MyJourney.dao.RestaurantDao;
import edu.nju.MyJourney.dao.UserDao;
import edu.nju.MyJourney.dao.impl.AttractionDaoImpl;
import edu.nju.MyJourney.dao.impl.CityDaoImpl;
import edu.nju.MyJourney.dao.impl.HotelDaoImpl;
import edu.nju.MyJourney.dao.impl.JourneyDaoImpl;
import edu.nju.MyJourney.dao.impl.RestaurantDaoImpl;
import edu.nju.MyJourney.dao.impl.UserDaoImpl;
import edu.nju.MyJourney.model.Attraction;
import edu.nju.MyJourney.model.City;
import edu.nju.MyJourney.model.Hotel;
import edu.nju.MyJourney.model.Journey;
import edu.nju.MyJourney.model.Restaurant;
import edu.nju.MyJourney.model.User;

public class SearchFlow {
	public static ArrayList<User> userSearch(SearchPrepareStatement sps){
		ArrayList<User> result=new ArrayList<User>();
		String searchType=sps.type;
		String keyWord="";
		String field="";
		int sexOption=0;
		int ageOption=0;
		int sortOption=0;
		if(searchType.equals("UserSearch")){
			UserDao dao=new UserDaoImpl();
			List<User> allUsers=dao.getAllUsers();
			System.out.println("fetch all users ...");
			System.out.println("total size: "+allUsers.size());
			keyWord=sps.KEYWORD;
			field=sps.FIELD;
			sexOption=sps.SEXOPTION;
			ageOption=sps.AGEOPTION;
			sortOption=sps.SORTOPTION;
			for(User user:allUsers){
				boolean matched=false;
				//filter 1
				if(field.equals("account")){
					String tgt=user.getAccount();
					if(tgt!=null&&tgt.contains(keyWord)){
						matched=true;
					}
				}else if(field.equals("city")){
					String tgt=user.getCity();
					if(tgt!=null&&tgt.contains(keyWord)){
						matched=true;
					}
				}else if(field.equals("email")){
					String tgt=user.getEmail();
					if(tgt!=null&&tgt.contains(keyWord)){
						matched=true;
					}
				}else if(field.equals("name")){
					String tgt=user.getName();
					if(tgt!=null&&tgt.contains(keyWord)){
						matched=true;
					}
				}else if(field.equals("all")){
					if(user.getName()!=null&&user.getName().contains(keyWord)){
						matched=true;
					}else if(user.getEmail()!=null&&user.getEmail().contains(keyWord)){
						matched=true;
					}else if(user.getAccount()!=null&&user.getAccount().contains(keyWord)){
						matched=true;
					}else if(user.getCity()!=null&&user.getCity().contains(keyWord)){
						matched=true;
					}
				}else{
					System.out.println("field not supported ...");
				}
				//filter 2
				if(sexOption==1){
					if(user.getSex()==0){
						matched=false;
					}
				}else if(sexOption==2){
					if(user.getSex()==1){
						matched=false;
					}
				}
				//filter 3
				if(ageOption==1){
					if(user.getAge()>20){
						matched=false;
					}
				}else if(ageOption==2){
					if(20>=user.getAge()||user.getAge()>40){
						matched=false;
					}
				}else if(ageOption==3){
					if(40>=user.getAge()||user.getAge()>60){
						matched=false;
					}
				}else if(ageOption==4){
					if(60>=user.getAge()){
						matched=false;
					}
				}
				
				//
				if(matched){
					result.add(user);
				}
			}
//			if(sortOption!=0){
//				result=sortByAge(result);
//			}
		}else{
			System.out.println("search type: "+searchType+" is not supported");
		}
		return result;
	}
	
	
	
	public static ArrayList<Journey> JourneySearch(SearchPrepareStatement sps){
		ArrayList<Journey> result=new ArrayList<Journey>();
		String searchType=sps.type;
		String keyWord=sps.KEYWORD;
		String j_type=sps.j_type;
		if(searchType.equals("JourneySearch")){
			JourneyDao jdao=new JourneyDaoImpl();
			List<Journey> all=jdao.getAllJourneys();
			for(int i=0;i<all.size();i++){
				boolean ismatched=false;
				if(all.get(i).getJourneyName().contains(keyWord)){
					ismatched=true;
				}
				if(j_type.equals("p")){
					if(all.get(i).getState()==1){
						ismatched=false;
					}
				}else if(j_type.equals("t")){
					if(all.get(i).getState()==0){
						ismatched=false;
					}
				}else{
					
				}
				if(ismatched){
					result.add(all.get(i));
				}
			}
		}
		return result;
	}
	
	public static ArrayList<City> CitySearch(SearchPrepareStatement sps){
		ArrayList<City> cities=new ArrayList<City>();
		CityDao cdao=new CityDaoImpl();
		List<City> all=cdao.getAllCity();
		for(int i=0;i<all.size();i++){
			boolean ismatched=false;
			if(all.get(i).getName().contains(sps.KEYWORD)||all.get(i).getCountry().contains(sps.KEYWORD)){
				ismatched=true;
			}
			if(ismatched){
				cities.add(all.get(i));
			}
		}
		return cities;
	}
	
	public static ArrayList<Hotel> HotelSearch(SearchPrepareStatement sps){
		ArrayList<Hotel> hotels=new ArrayList<Hotel>();
		HotelDao cdao=new HotelDaoImpl();
		List<Hotel> all=cdao.getAllHotel();
		for(int i=0;i<all.size();i++){
			boolean ismatched=false;
			if(all.get(i).getName().contains(sps.KEYWORD)||all.get(i).getAddress().contains(sps.KEYWORD)){
				ismatched=true;
			}
			String range=sps.range;
			if(range.equals("1")){
				if(all.get(i).getPrice()>100){
					ismatched=false;
				}
			}else if(range.equals("2")){
				if(all.get(i).getPrice()>=200 || 100>=all.get(i).getPrice()){
					ismatched=false;
				}
			}else if(range.equals("3")){
				if(all.get(i).getPrice()<200){
					ismatched=false;
				}
			}
			if(ismatched){
				hotels.add(all.get(i));
			}
		}
		return hotels;
	}
	
	public static ArrayList<Restaurant> RestaurantSearch(SearchPrepareStatement sps){
		ArrayList<Restaurant> rests=new ArrayList<Restaurant>();
		RestaurantDao cdao=new RestaurantDaoImpl();
		List<Restaurant> all=cdao.getAllRestaurant();
		for(int i=0;i<all.size();i++){
			boolean ismatched=false;
			if(all.get(i).getName().contains(sps.KEYWORD)||all.get(i).getAddress().contains(sps.KEYWORD)){
				ismatched=true;
			}
			String range=sps.range;
			if(range.equals("1")){
				if(all.get(i).getPrice()>100){
					ismatched=false;
				}
			}else if(range.equals("2")){
				if(all.get(i).getPrice()>=200 || 100>=all.get(i).getPrice()){
					ismatched=false;
				}
			}else if(range.equals("3")){
				if(all.get(i).getPrice()<200){
					ismatched=false;
				}
			}
			if(ismatched){
				rests.add(all.get(i));
			}
		}
		return rests;
	}
	
	public static ArrayList<Attraction> AttractionSearch(SearchPrepareStatement sps){
		ArrayList<Attraction> attrs=new ArrayList<Attraction>();
		AttractionDao cdao=new AttractionDaoImpl();
		List<Attraction> all=cdao.getAllAttraction();
		for(int i=0;i<all.size();i++){
			boolean ismatched=false;
			if(all.get(i).getName().contains(sps.KEYWORD)||all.get(i).getAddress().contains(sps.KEYWORD)){
				ismatched=true;
			}
			String range=sps.range;
			if(range.equals("1")){
				if(all.get(i).getPrice()>100){
					ismatched=false;
				}
			}else if(range.equals("2")){
				if(all.get(i).getPrice()>=200 || 100>=all.get(i).getPrice()){
					ismatched=false;
				}
			}else if(range.equals("3")){
				if(all.get(i).getPrice()<200){
					ismatched=false;
				}
			}
			if(ismatched){
				attrs.add(all.get(i));
			}
		}
		return attrs;
	}
	
	
	private static ArrayList<User> sortByAge(ArrayList<User> users){
		ArrayList<User> result=new ArrayList<User>();
		if(users.size()==0||users.size()==1)
			return users;
		for(User user:users){
			int age=user.getAge();
			
		}
		return result;
	}
}
