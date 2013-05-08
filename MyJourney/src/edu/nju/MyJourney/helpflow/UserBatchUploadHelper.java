package edu.nju.MyJourney.helpflow;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;



import edu.nju.MyJourney.dao.AttractionDao;
import edu.nju.MyJourney.dao.CityDao;
import edu.nju.MyJourney.dao.HotelDao;
import edu.nju.MyJourney.dao.RestaurantDao;
import edu.nju.MyJourney.dao.UserDao;
import edu.nju.MyJourney.dao.impl.AttractionDaoImpl;
import edu.nju.MyJourney.dao.impl.CityDaoImpl;
import edu.nju.MyJourney.dao.impl.HotelDaoImpl;
import edu.nju.MyJourney.dao.impl.RestaurantDaoImpl;
import edu.nju.MyJourney.dao.impl.UserDaoImpl;
import edu.nju.MyJourney.model.Attraction;
import edu.nju.MyJourney.model.City;
import edu.nju.MyJourney.model.Hotel;
import edu.nju.MyJourney.model.Journey;
import edu.nju.MyJourney.model.Place;
import edu.nju.MyJourney.model.Restaurant;
import edu.nju.MyJourney.model.Team;
import edu.nju.MyJourney.model.User;

public class UserBatchUploadHelper {
	/*
	 * parse xmlStr to User array
	 */
	public static ArrayList<User> Convert2List(String xmlStr) throws Exception{
		ArrayList<User> list=new ArrayList<User>();
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        InputSource is = new InputSource(new StringReader(xmlStr));
        Document doc=builder.parse(is);
        NodeList nlist=doc.getElementsByTagName("User");
        System.out.println("number of users to be inserted: "+nlist.getLength()+" ...");
        for(int i=0;i<nlist.getLength();i++){
        	User tmpUser=new User();
        	Node tmp=nlist.item(i);
        	System.out.println("processing node "+i+" ...");
        	Node first=tmp.getFirstChild();
        	Node tmpNode=first.getNextSibling();
        	while(tmpNode!=null){
        		if(tmpNode.getNodeType()==Node.ELEMENT_NODE){
        			String nodeName=tmpNode.getNodeName();
        			if(nodeName.equals("account")){
        				tmpUser.setAccount(tmpNode.getTextContent());
        			}else if(nodeName.equals("name")){
        				tmpUser.setName(tmpNode.getTextContent());
        			}else if(nodeName.equals("age")){
        				tmpUser.setAge(Integer.parseInt(tmpNode.getTextContent()));
        			}else if(nodeName.equals("city")){
        				tmpUser.setCity(tmpNode.getTextContent());
        			}else if(nodeName.equals("email")){
        				tmpUser.setEmail(tmpNode.getTextContent());
        			}else if(nodeName.equals("phone")){
        				tmpUser.setPhone(tmpNode.getTextContent());
        			}else if(nodeName.equals("password")){
        				tmpUser.setPwd(tmpNode.getTextContent());
        			}else if(nodeName.equals("sex")){
        				tmpUser.setSex(Integer.parseInt(tmpNode.getTextContent()));
        			}else if(nodeName.equals("image")){
        				tmpUser.setImage(tmpNode.getTextContent());
        			}else{
        				System.out.println("uncaught attr: "+nodeName);
        			}
        		}
        		tmpNode=tmpNode.getNextSibling();
        	}
        	list.add(tmpUser);
        }
		return list;
	}
	
	/**
	 * parse to journey array
	 * @return
	 * @throws Exception
	 */
	public static ArrayList<Journey> Convert2JList(String xmlStr) throws Exception{
		ArrayList<Journey> list=new ArrayList<Journey>();
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        InputSource is = new InputSource(new StringReader(xmlStr));
        Document doc=builder.parse(is);
        NodeList nlist=doc.getElementsByTagName("Journey");
        System.out.println("number of journeys to be inserted: "+nlist.getLength()+" ...");
        for(int i=0;i<nlist.getLength();i++){
        	Journey tmp=new Journey();
        	Node node=nlist.item(i);
        	Node first=node.getFirstChild();
        	Node tmpNode=first.getNextSibling();
        	while(tmpNode!=null){
        		if(tmpNode.getNodeType()==Node.ELEMENT_NODE){
        			String nodeName=tmpNode.getNodeName();
        			if(nodeName.equals("journeyName")){
        				tmp.setJourneyName(tmpNode.getTextContent());
        			}else if(nodeName.equals("state")){
        				tmp.setState(Integer.parseInt(tmpNode.getTextContent()));
        			}else if(nodeName.equals("journeyOwner")){
        				String uid=tmpNode.getTextContent();
        				UserDao userdao=new UserDaoImpl();
        				User user=userdao.getUserById(Integer.parseInt(uid));
        				tmp.setUser(user);
        			}else if(nodeName.equals("places")){
        				Node firstP=tmpNode.getFirstChild();
        				Node tmpPlace=firstP.getNextSibling();
        				List<Place> places=new ArrayList<Place>();
        				while(tmpPlace!=null){
        					if(tmpNode.getNodeType()==Node.ELEMENT_NODE && tmpNode.getNodeName().equals("place")){
        						Place place=new Place();
        						Node placeF=tmpNode.getFirstChild();
        						Node placeN=placeF.getNextSibling();
        						while(placeN!=null){
        							if(placeN.getNodeType()==Node.ELEMENT_NODE){
        								String placeNodeName=placeN.getNodeName();
        								if(placeNodeName.equals("time")){
        									place.setTime(placeN.getTextContent());
        								}else if(placeNodeName.equals("traffic")){
        									place.setTraffic(placeN.getTextContent());
        								}else if(placeNodeName.equals("halfday")){
        									place.setHalfday(Integer.parseInt(placeN.getTextContent()));
        								}else if(placeNodeName.equals("hotel")){
        									Hotel hotel=new Hotel();
        									HotelDao hdao=new HotelDaoImpl();
        									hotel=hdao.getHotelById(placeN.getTextContent());
        									place.setHotel(hotel);
        								}else if(placeNodeName.equals("attraction")){
        									Attraction attr=new Attraction();
        									AttractionDao adao=new AttractionDaoImpl();
        									attr=adao.getAttractionById(placeN.getTextContent());
        									place.setAttraction(attr);
        								}else if(placeNodeName.equals("city")){
        									String cityID=tmpNode.getTextContent();
        			        				CityDao cd=new CityDaoImpl();
        			        				City c=cd.getCityById(cityID);
        			        				place.setCity(c);
        								}else if(placeNodeName.equals("restaurant")){
        									Restaurant rest=new Restaurant();
        									RestaurantDao rdao=new RestaurantDaoImpl();
        									rest=rdao.getRestaurantById(placeN.getTextContent());
        									place.setRestaurant(rest);
        								}else{
        									System.out.println("uncaught attribute "+ placeNodeName);
        								}
        							}
        							placeN=placeN.getNextSibling();
        						}
        						place.setJourney(tmp);
        						places.add(place);
        					}
        					tmpPlace=tmpPlace.getNextSibling();
        				}
        				tmp.setPlaces(places);
        			}else if(nodeName.equals("team")){
        				Team tmpTeam=new Team();
        				tmpTeam.setJourney(tmp);
        				List<User> users=new ArrayList<User>();
        				Node tfirst=tmpNode.getFirstChild();
        				Node teamtmp=tfirst.getNextSibling();
        				while(teamtmp!=null){
        					if(teamtmp.getNodeType()==Node.ELEMENT_NODE){
        						if(teamtmp.getNodeName().equals("teamName")){
        							tmpTeam.setTeamName(teamtmp.getTextContent());
        						}else if(teamtmp.getNodeName().equals("members")){
        							Node ufirst=teamtmp.getFirstChild();
        							Node usertmp=ufirst.getNextSibling();
        							while(usertmp!=null && usertmp.getNodeName().equals("user")){
        								String uid=usertmp.getTextContent();
        								UserDao udao=new UserDaoImpl();
        								User user=udao.getUserById(Integer.parseInt(uid));
        								users.add(user);
        								usertmp=usertmp.getNextSibling();
        							}
        						}
        					}
        					teamtmp=teamtmp.getNextSibling();
        				}
        				tmpTeam.setUsers(users);
        				tmp.setTeam(tmpTeam);
        			}else{
        				System.out.println("uncaught attr ... "+nodeName);
        			}
        		}
        		tmpNode=tmpNode.getNextSibling();
        	}
        	list.add(tmp);
        }
        return list;
	}
	
	public static ArrayList<City> Convert2CityList(String xmlStr) throws Exception{
		ArrayList<City> list=new ArrayList<City>();
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        InputSource is = new InputSource(new StringReader(xmlStr));
        Document doc=builder.parse(is);
        NodeList nlist=doc.getElementsByTagName("city");
        System.out.println("number of cities to be inserted: "+nlist.getLength()+" ...");
        for(int i=0;i<nlist.getLength();i++){
        	City tmp=new City();
        	Node node=nlist.item(i);
        	Node first=node.getFirstChild();
        	Node tmpNode=first.getNextSibling();
        	while(tmpNode!=null){
        		if(tmpNode.getNodeType()==Node.ELEMENT_NODE){
        			String nodeName=tmpNode.getNodeName();
        			if(nodeName.equals("country")){
        				tmp.setCountry(tmpNode.getTextContent());
        			}else if(nodeName.equals("lat")){
        				tmp.setLat(tmpNode.getTextContent());
        			}else if(nodeName.equals("lng")){
        				tmp.setLng(tmpNode.getTextContent());
        			}else if(nodeName.equals("name")){
        				tmp.setName(tmpNode.getTextContent());
        			}else if(nodeName.equals("picture")){
        				tmp.setPicture(tmpNode.getTextContent());
        			}else{
        				System.out.println("uncaught attr ... "+nodeName);
        			}
        		}
        		tmpNode=tmpNode.getNextSibling();
        	}
        	list.add(tmp);
        }
        return list;
	}
	
	
	public static ArrayList<Hotel> Convert2HotelList(String xmlStr) throws Exception{
		ArrayList<Hotel> list=new ArrayList<Hotel>();
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        InputSource is = new InputSource(new StringReader(xmlStr));
        Document doc=builder.parse(is);
        NodeList nlist=doc.getElementsByTagName("hotel");
        System.out.println("number of hotels to be inserted: "+nlist.getLength()+" ...");
        for(int i=0;i<nlist.getLength();i++){
        	Hotel tmp=new Hotel();
        	Node node=nlist.item(i);
        	Node first=node.getFirstChild();
        	Node tmpNode=first.getNextSibling();
        	while(tmpNode!=null){
        		if(tmpNode.getNodeType()==Node.ELEMENT_NODE){
        			String nodeName=tmpNode.getNodeName();
            		System.out.println(nodeName);
        			if(nodeName.equals("address")){
        				tmp.setAddress(tmpNode.getTextContent());
        			}else if(nodeName.equals("dislike")){
        				tmp.setDislike(Integer.parseInt(tmpNode.getTextContent()));
        			}else if(nodeName.equals("favor")){
        				tmp.setFavor(Integer.parseInt(tmpNode.getTextContent()));
        			}else if(nodeName.equals("name")){
        				tmp.setName(tmpNode.getTextContent());
        			}else if(nodeName.equals("phone")){
        				tmp.setPhone(tmpNode.getTextContent());
        			}else if(nodeName.equals("price")){
        				tmp.setPrice(Float.parseFloat(tmpNode.getTextContent()));
        			}else if(nodeName.equals("hotelOwner")){
        				String cityID=tmpNode.getTextContent();
        				CityDao cd=new CityDaoImpl();
        				City c=cd.getCityById(cityID);
        				tmp.setCity(c);
        			}else{
        				System.out.println("uncaught attr ... "+nodeName);
        			}
        		}
        		
        		tmpNode=tmpNode.getNextSibling();
        	}
        	list.add(tmp);
        }
		return list;
	}
	
	public static ArrayList<Attraction> Convert2AList(String xmlStr) throws Exception{
		ArrayList<Attraction> list=new ArrayList<Attraction>();
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        InputSource is = new InputSource(new StringReader(xmlStr));
        Document doc=builder.parse(is);
        NodeList nlist=doc.getElementsByTagName("attraction");
        System.out.println("number of attractions to be inserted: "+nlist.getLength()+" ...");
        for(int i=0;i<nlist.getLength();i++){
        	Attraction tmp=new Attraction();
        	Node node=nlist.item(i);
        	Node first=node.getFirstChild();
        	Node tmpNode=first.getNextSibling();
        	while(tmpNode!=null){
        		if(tmpNode.getNodeType()==Node.ELEMENT_NODE){
        			String nodeName=tmpNode.getNodeName();
            		System.out.println(nodeName);
        			if(nodeName.equals("address")){
        				tmp.setAddress(tmpNode.getTextContent());
        			}else if(nodeName.equals("dislike")){
        				tmp.setDislike(Integer.parseInt(tmpNode.getTextContent()));
        			}else if(nodeName.equals("favor")){
        				tmp.setFavor(Integer.parseInt(tmpNode.getTextContent()));
        			}else if(nodeName.equals("name")){
        				tmp.setName(tmpNode.getTextContent());
        			}else if(nodeName.equals("price")){
        				tmp.setPrice(Float.parseFloat(tmpNode.getTextContent()));
        			}else if(nodeName.equals("attractionOwner")){
        				String cityID=tmpNode.getTextContent();
        				CityDao cd=new CityDaoImpl();
        				City c=cd.getCityById(cityID);
        				tmp.setCity(c);
        			}else{
        				System.out.println("uncaught attr ... "+nodeName);
        			}
        		}
        		
        		tmpNode=tmpNode.getNextSibling();
        	}
        	list.add(tmp);
        }
		return list;
	}
	
	public static ArrayList<Restaurant> Convert2RList(String xmlStr) throws Exception{
		ArrayList<Restaurant> list=new ArrayList<Restaurant>();
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        InputSource is = new InputSource(new StringReader(xmlStr));
        Document doc=builder.parse(is);
        NodeList nlist=doc.getElementsByTagName("restaurant");
        System.out.println("number of restaurants to be inserted: "+nlist.getLength()+" ...");
        for(int i=0;i<nlist.getLength();i++){
        	Restaurant tmp=new Restaurant();
        	Node node=nlist.item(i);
        	Node first=node.getFirstChild();
        	Node tmpNode=first.getNextSibling();
        	while(tmpNode!=null){
        		if(tmpNode.getNodeType()==Node.ELEMENT_NODE){
        			String nodeName=tmpNode.getNodeName();
            		System.out.println(nodeName);
        			if(nodeName.equals("address")){
        				tmp.setAddress(tmpNode.getTextContent());
        			}else if(nodeName.equals("dislike")){
        				tmp.setDislike(Integer.parseInt(tmpNode.getTextContent()));
        			}else if(nodeName.equals("favor")){
        				tmp.setFavor(Integer.parseInt(tmpNode.getTextContent()));
        			}else if(nodeName.equals("name")){
        				tmp.setName(tmpNode.getTextContent());
        			}else if(nodeName.equals("phone")){
        				tmp.setPhone(tmpNode.getTextContent());
        			}else if(nodeName.equals("price")){
        				tmp.setPrice(Float.parseFloat(tmpNode.getTextContent()));
        			}else if(nodeName.equals("restaurantOwner")){
        				String cityID=tmpNode.getTextContent();
        				CityDao cd=new CityDaoImpl();
        				City c=cd.getCityById(cityID);
        				tmp.setCity(c);
        			}else{
        				System.out.println("uncaught attr ... "+nodeName);
        			}
        		}
        		
        		tmpNode=tmpNode.getNextSibling();
        	}
        	list.add(tmp);
        }
		return list;
	}
	
	
}
