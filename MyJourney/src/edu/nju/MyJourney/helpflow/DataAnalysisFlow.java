package edu.nju.MyJourney.helpflow;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import edu.nju.MyJourney.dao.AttractionDao;
import edu.nju.MyJourney.dao.HotelDao;
import edu.nju.MyJourney.dao.JourneyDao;
import edu.nju.MyJourney.dao.RestaurantDao;
import edu.nju.MyJourney.dao.UserDao;
import edu.nju.MyJourney.dao.impl.AttractionDaoImpl;
import edu.nju.MyJourney.dao.impl.HotelDaoImpl;
import edu.nju.MyJourney.dao.impl.JourneyDaoImpl;
import edu.nju.MyJourney.dao.impl.RestaurantDaoImpl;
import edu.nju.MyJourney.dao.impl.UserDaoImpl;
import edu.nju.MyJourney.model.Attraction;
import edu.nju.MyJourney.model.City;
import edu.nju.MyJourney.model.Hotel;
import edu.nju.MyJourney.model.Journey;
import edu.nju.MyJourney.model.Place;
import edu.nju.MyJourney.model.Restaurant;
import edu.nju.MyJourney.model.User;
import edu.nju.MyJourney.service.JourneyService;
import edu.nju.MyJourney.service.impl.JourneyServiceImpl;

public class DataAnalysisFlow {
	public static ArrayList<Hotel> GetHotHotels(int size){
		HotelDao hdao=new HotelDaoImpl();
		List<Hotel> hotels=hdao.getAllHotel();
		ArrayList<Hotel> hots=new ArrayList<Hotel>();
		ArrayList<HotelRankCoef> hRanks=new ArrayList<HotelRankCoef>();
		//if not enough hotels in db
		//return all
		if(size>=hotels.size()){
			hots.addAll(hotels);
			return hots;
		}else{
			//enough hotels
			//rank all the hotels based on Rank coefficient
			hRanks=new ArrayList<HotelRankCoef>();
			
			for(int i=0;i<hotels.size();i++){
				HotelRankCoef tmp=new HotelRankCoef();
				tmp.setHotel(hotels.get(i));
				double coeff=1*tmp.getHotel().getFavor()-0.5*tmp.getHotel().getDislike();
				tmp.setCoff(coeff);
				hRanks.add(tmp);
			}
			Collections.sort(hRanks);
			for(HotelRankCoef hrc:hRanks){
				System.out.println(hrc.getHotel().getName());
				System.out.println(hrc.getCoff());
			}
		}
		System.out.println("why not printing");
		//trim to intended list size
		System.out.println("last index: "+hRanks.get(hRanks.size()-1).getCoff());
		List<HotelRankCoef> fin= hRanks.subList(hRanks.size()-size, hRanks.size());
		System.out.println("fin size: "+fin.size());
		for(int i=0;i<fin.size();i++){
			hots.add(fin.get(i).getHotel());
			System.out.println("rate: "+fin.get(i).getCoff());
		}
		System.out.print("size: "+size);
		System.out.println("hot hotels size: "+hots.size());
		//revert to normal descending order
		ArrayList<Hotel> tmpList=new ArrayList<Hotel>();
		int sizein=hots.size();
		for(int i=0;i<hots.size();i++){
			tmpList.add(hots.get(sizein-i-1));
		}
		hots=tmpList;
		return hots;
	}
	
	
	
	
	public static ArrayList<Restaurant> GetHotRestaurants(int size){
		RestaurantDao rdao=new RestaurantDaoImpl();
		List<Restaurant> rests=rdao.getAllRestaurant();
		ArrayList<Restaurant> hots=new ArrayList<Restaurant>();
		ArrayList<RestRankCoef> rRanks=new ArrayList<RestRankCoef>();
		//if not enough rests in db
		//return all
		if(size>=rests.size()){
			hots.addAll(rests);
			return hots;
		}else{
			//enough rests
			//rank all the rests based on Rank coefficient
			rRanks=new ArrayList<RestRankCoef>();
			for(int i=0;i<rests.size();i++){
				RestRankCoef tmp=new RestRankCoef();
				tmp.setRest(rests.get(i));
				double coeff=1*tmp.getRest().getFavor()-0.5*tmp.getRest().getDislike();
				tmp.setCoff(coeff);
				rRanks.add(tmp);
			}
			Collections.sort(rRanks);
			for(RestRankCoef hrc:rRanks){
				System.out.println(hrc.getRest().getName());
				System.out.println(hrc.getCoff());
			}
		}
		//trim to intended list size
		List<RestRankCoef> fins= rRanks.subList(rRanks.size()-size, rRanks.size());
		for(int i=0;i<fins.size();i++){
			hots.add(fins.get(i).getRest());
		}
		System.out.println("hot rest size: "+hots.size());
		ArrayList<Restaurant> tmpList=new ArrayList<Restaurant>();
		int sizein=hots.size();
		for(int i=0;i<hots.size();i++){
			tmpList.add(hots.get(sizein-i-1));
		}
		hots=tmpList;
		return hots;
	}
	
	
	
	public static ArrayList<Attraction> GetHotAttractions(int size){
		AttractionDao rdao=new AttractionDaoImpl();
		List<Attraction> attrs=rdao.getAllAttraction();
		ArrayList<Attraction> hots=new ArrayList<Attraction>();
		ArrayList<AttrRankCoef> aRanks=new ArrayList<AttrRankCoef>();
		//if not enough attrs in db
		//return all
		if(size>=attrs.size()){
			hots.addAll(attrs);
			return hots;
		}else{
			//enough attrs
			//rank all the attrs based on Rank coefficient
			aRanks=new ArrayList<AttrRankCoef>();
			for(int i=0;i<attrs.size();i++){
				AttrRankCoef tmp=new AttrRankCoef();
				tmp.setAttr(attrs.get(i));
				double coeff=1*tmp.getAttr().getFavor()-0.5*tmp.getAttr().getDislike();
				tmp.setCoef(coeff);
				aRanks.add(tmp);
			}
			Collections.sort(aRanks);
			for(AttrRankCoef hrc:aRanks){
				System.out.println(hrc.getAttr().getName());
				System.out.println(hrc.getCoef());
			}
		}
		//trim to intended list size
		List<AttrRankCoef> fins= aRanks.subList(aRanks.size()-size, aRanks.size());
		for(int i=0;i<fins.size();i++){
			hots.add(fins.get(i).getAttr());
		}
		System.out.println("hot attr size: "+hots.size());
		ArrayList<Attraction> tmpList=new ArrayList<Attraction>();
		int sizein=hots.size();
		for(int i=0;i<hots.size();i++){
			tmpList.add(hots.get(sizein-i-1));
		}
		hots=tmpList;
		return hots;
	}
	
	
	
	
	public static ArrayList<Journey> GetSimilarJourneys(String jid){
		JourneyDao jdao=new JourneyDaoImpl();
		List<Journey> tjourneys=jdao.getAllJourneys();
		List<Journey> journeys=new ArrayList<Journey>();
		ArrayList<Journey> sims=new ArrayList<Journey>();
		Journey theJ=jdao.getJourneyById(Integer.parseInt(jid));
		List<Place> places=theJ.getPlaces();
		Long uid=theJ.getUser().getUid();
		//
		for(int i=0;i<tjourneys.size();i++){
			if(tjourneys.get(i).getState()==0){
				if(tjourneys.get(i).getUser().getUid()!=uid){
					journeys.add(tjourneys.get(i));
				}
			}else{
				if(tjourneys.get(i).getTeam()!=null){
					List<User> mm=tjourneys.get(i).getTeam().getUsers();
					boolean inTheTeam=false;
					for(int j=0;j<mm.size();j++){
						if(mm.get(j).getUid()==uid){
							inTheTeam=true;
							break;
						}
					}
					if(!inTheTeam){
						journeys.add(tjourneys.get(i));
					}
				}
			}
		}
		
		journeys.remove(theJ);
		//
		ArrayList<JourneySimilarRank> js=new ArrayList<JourneySimilarRank>();
		for(int i=0;i<journeys.size();i++){
			Journey tmpJ=journeys.get(i);
			List<Place> tmpJp=tmpJ.getPlaces();
			int rvalue=GetPlaceSimilarity(places,tmpJp);
			JourneySimilarRank tmp=new JourneySimilarRank();
			tmp.setJourney(tmpJ);
			tmp.setRank(rvalue);
			js.add(tmp);
		}
		Collections.sort(js);
		for(JourneySimilarRank hrc:js){
			System.out.println(hrc.getJourney().getJourneyName());
			System.out.println(hrc.getRank());
		}
		//trim to 2
		if(js.size()>2){
			sims.add(js.get(js.size()-1).getJourney());
			sims.add(js.get(js.size()-2).getJourney());
		}else{
			for(int i=0;i<js.size();i++){
				sims.add(js.get(i).getJourney());
			}
		}
		
		return sims;
	}
	
	public static ArrayList<Journey> GetUserInterestedJourneys(String uid){
		System.out.println("uid: "+uid);
		JourneyDao jdao=new JourneyDaoImpl();
		List<Journey> all=jdao.getAllJourneys();
		ArrayList<JourneySimilarRank> js=new ArrayList<JourneySimilarRank>();
		ArrayList<Journey> interests=new ArrayList<Journey>();
		
		//get rid of userjourney from all
		Long userid=Long.parseLong(uid);
		List<Journey> userrelated=new ArrayList<Journey>();
		for(int i=0;i<js.size();i++){
			if(all.get(i).getUser().getUid()==userid){
				userrelated.add(all.get(i));
			}else if(all.get(i).getState()==1){
				List<User> tmp=all.get(i).getTeam().getUsers();
				for(int j=0;j<tmp.size();j++){
					if(tmp.get(j).getUid()==userid){
						userrelated.add(all.get(j));
						break;
					}
				}
			}
		}
		
		//
		for(int i=0;i<userrelated.size();i++){
			if(WithinJourneyList(userrelated.get(i),all)){
				all.remove(userrelated.get(i));
			}
		}
		for(int i=0;i<all.size();i++){
			int NoC=GetUserJourneyCities(userrelated,all.get(i));
			JourneySimilarRank tmp=new JourneySimilarRank();
			tmp.setJourney(all.get(i));
			tmp.setRank(NoC);
			js.add(tmp);
		}
		Collections.sort(js);
		if(js.size()>3){
			interests.add(js.get(js.size()-1).getJourney());
			interests.add(js.get(js.size()-2).getJourney());
			interests.add(js.get(js.size()-3).getJourney());
		}else{
			for(int i=0;i<js.size();i++){
				interests.add(js.get(i).getJourney());
			}
		}
		return interests;
	}
	public static ArrayList<User> FindSimilarUsers(String uid){
		UserDao udao=new UserDaoImpl();
		List<User> tusers=udao.getAllUsers();
		List<User> users=new ArrayList<User>();
		System.out.println("before deleting this User: "+tusers.size());
		User thisUser=udao.getUserById(Long.parseLong(uid));
		for(int i=0;i<tusers.size();i++){
			if(tusers.get(i).getUid()!=Long.parseLong(uid)){
				users.add(tusers.get(i));
			}
		}
		System.out.println("after deleting this User: "+users.size());
		ArrayList<User> res=new ArrayList<User>();
		for(int i=0;i<users.size();i++){
			if(users.get(i).getCity()!=null&&users.get(i).getCity().equals(thisUser.getCity())){
				res.add(users.get(i));
			}
		}
		if(res.size()<3){
			while(res.size()<3){
				int j=0;
				res.add(users.get(j));
				j++;
			}
		}else{
			ArrayList<User> tmp=new ArrayList<User>();
			for(int i=0;i<3;i++){
				tmp.add(res.get(i));
			}
			return tmp;
		}
		return res;
	}
	
	
	
	private static int GetPlaceSimilarity(List<Place> the,List<Place> ano){
		int rank=0;
		for(int i=0;i<the.size();i++){
			long tmpId=the.get(i).getId();
			for(int j=0;j<ano.size();j++){
				if(ano.get(j).getId()==tmpId){
					rank++;
					break;
				}
			}
		}
		return rank;
	}
	
	private static int GetUserJourneyCities(List<Journey> userJ,Journey tJ){
		int same=0;
		List<Place> ps=tJ.getPlaces();
		ArrayList<String> cities=new ArrayList<String>();
		ArrayList<String> ucities=new ArrayList<String>();
		for(int i=0;i<ps.size();i++){
			String cName=ps.get(i).getCity().getName();
			if(!cities.contains(cName)){
				cities.add(cName);
			}
		}
		for(int i=0;i<userJ.size();i++){
			List<Place> up=userJ.get(i).getPlaces();
			for(int j=0;j<up.size();j++){
				String ucName=up.get(i).getCity().getName();
				if(!ucities.contains(ucName)){
					ucities.add(ucName);
				}
			}
		}
		for(int i=0;i<cities.size();i++){
			if(ucities.contains(cities.get(i))){
				same++;
			}
		}
		return same;
	}
	
	private static boolean WithinJourneyList(Journey j,List<Journey> all){
		for(int i=0;i<all.size();i++){
			if(j.getId()==all.get(i).getId()){
				return true;
			}
		}
		return false;
	}
	
	
	public Restaurant getBestRestaurant(City city){
		RestaurantDao rdao=new RestaurantDaoImpl();
		List<Restaurant> rests=rdao.getAllRestaurant();
		List<Restaurant> cityrs=new ArrayList<Restaurant>();
		ArrayList<RestRankCoef> rRanks=new ArrayList<RestRankCoef>();
		//filter the restaurants
		for(int i=0;i<rests.size();i++){
			if(rests.get(i).getCity().getCid()==city.getCid()){
				cityrs.add(rests.get(i));
			}
		}
		System.out.println("cityrs size: "+cityrs.size());
		if(1==cityrs.size()){
			return cityrs.get(0);
		}else if(cityrs!=null && cityrs.size()>1){
			
			//rank all the rests based on Rank coefficient
			for(int i=0;i<cityrs.size();i++){
				RestRankCoef tmp=new RestRankCoef();
				tmp.setRest(cityrs.get(i));
				double coeff=1*tmp.getRest().getFavor()-0.5*tmp.getRest().getDislike();
				tmp.setCoff(coeff);
				rRanks.add(tmp);
			}
			Collections.sort(rRanks);
			for(RestRankCoef hrc:rRanks){
				System.out.println(hrc.getRest().getName());
				System.out.println(hrc.getCoff());
			}
			return rRanks.get(rRanks.size()-1).getRest();
		}else{
			return null;
		}
		
	}
	
	public Hotel getBestHotel(City city){
		HotelDao hdao=new HotelDaoImpl();
		List<Hotel> hotels=hdao.getAllHotel();
		List<Hotel> cityrs=new ArrayList<Hotel>();
		ArrayList<HotelRankCoef> hRanks=new ArrayList<HotelRankCoef>();
		//filter the restaurants
		for(int i=0;i<hotels.size();i++){
			if(hotels.get(i).getCity().getCid()==city.getCid()){
				cityrs.add(hotels.get(i));
			}
		}
		System.out.println("cityrs size: "+cityrs.size());
		if(1==cityrs.size()){
			return cityrs.get(0);
		}else if(cityrs!=null && cityrs.size()>1){
			
			//rank all the rests based on Rank coefficient
			for(int i=0;i<cityrs.size();i++){
				HotelRankCoef tmp=new HotelRankCoef();
				tmp.setHotel(cityrs.get(i));
				double coeff=1*tmp.getHotel().getFavor()-0.5*tmp.getHotel().getDislike();
				tmp.setCoff(coeff);
				hRanks.add(tmp);
			}
			Collections.sort(hRanks);
			for(HotelRankCoef hrc:hRanks){
				System.out.println(hrc.getHotel().getName());
				System.out.println(hrc.getCoff());
			}
			return hRanks.get(hRanks.size()-1).getHotel();
		}else{
			return null;
		}
		
	}
	public Attraction getBestAttraction(City city){
		AttractionDao adao=new AttractionDaoImpl();
		List<Attraction> attrs=adao.getAllAttraction();
		List<Attraction> cityrs=new ArrayList<Attraction>();
		ArrayList<AttrRankCoef> rRanks=new ArrayList<AttrRankCoef>();
		//filter the restaurants
		for(int i=0;i<attrs.size();i++){
			if(attrs.get(i).getCity().getCid()==city.getCid()){
				cityrs.add(attrs.get(i));
			}
		}
		System.out.println("cityrs size: "+cityrs.size());
		if(1==cityrs.size()){
			return cityrs.get(0);
		}else if(cityrs!=null && cityrs.size()>1){
			
			//rank all the rests based on Rank coefficient
			for(int i=0;i<cityrs.size();i++){
				AttrRankCoef tmp=new AttrRankCoef();
				tmp.setAttr(cityrs.get(i));
				double coeff=1*tmp.getAttr().getFavor()-0.5*tmp.getAttr().getDislike();
				tmp.setCoef(coeff);
				rRanks.add(tmp);
			}
			Collections.sort(rRanks);
			for(AttrRankCoef hrc:rRanks){
				System.out.println(hrc.getAttr().getName());
				System.out.println(hrc.getCoef());
			}
			return rRanks.get(rRanks.size()-1).getAttr();
		}else{
			return null;
		}
	}
}
