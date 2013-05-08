package edu.nju.MyJourney.action;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import edu.nju.MyJourney.helpflow.UserBatchUploadHelper;
import edu.nju.MyJourney.model.City;
import edu.nju.MyJourney.model.Restaurant;
import edu.nju.MyJourney.service.CityService;
import edu.nju.MyJourney.service.RestaurantService;

public class RestaurantBatchUploadAction extends BaseAction{
	private File restXml;
	private String restXmlFileName ;  
	private String restXmlContentType ; 
	private RestaurantService restaurantService;
 
   

	public String execute() throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(restXml),"UTF-8"));
		System.out.println("filename: "+restXmlFileName);
		System.out.println("filetype: "+restXmlContentType);
		String xmlStr="";
		String line=br.readLine();
		while(line!=null){
			xmlStr=xmlStr+line;
			System.out.println(line);
			line=br.readLine();
		}
		br.close();
		ArrayList<Restaurant> restaurants=UserBatchUploadHelper.Convert2RList(xmlStr);
		for(Restaurant restaurant:restaurants){
			restaurantService.insertRestaurant(restaurant);
		}
		return SUCCESS;
    }
	
	 public File getRestXml() {
			return restXml;
		}

		public void setRestXml(File restXml) {
			this.restXml = restXml;
		}

		public String getRestXmlFileName() {
			return restXmlFileName;
		}

		public void setRestXmlFileName(String restXmlFileName) {
			this.restXmlFileName = restXmlFileName;
		}

		public String getRestXmlContentType() {
			return restXmlContentType;
		}

		public void setRestXmlContentType(String restXmlContentType) {
			this.restXmlContentType = restXmlContentType;
		}

		public RestaurantService getRestaurantService() {
			return restaurantService;
		}

		public void setRestaurantService(RestaurantService restaurantService) {
			this.restaurantService = restaurantService;
		}
}
