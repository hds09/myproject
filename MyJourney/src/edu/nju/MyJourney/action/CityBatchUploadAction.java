package edu.nju.MyJourney.action;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

import edu.nju.MyJourney.helpflow.UserBatchUploadHelper;
import edu.nju.MyJourney.model.City;
import edu.nju.MyJourney.model.User;
import edu.nju.MyJourney.service.CityService;
import edu.nju.MyJourney.service.UserService;

public class CityBatchUploadAction extends BaseAction{
	private File cityXml;
	private String cityXmlFileName ;  
	private String cityXmlContentType ; 
	private CityService cityService;
 
    public String execute() throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(cityXml),"UTF-8"));
		System.out.println("filename: "+cityXmlFileName);
		System.out.println("filetype: "+cityXmlContentType);
		String xmlStr="";
		String line=br.readLine();
		while(line!=null){
			xmlStr=xmlStr+line;
			System.out.println(line);
			line=br.readLine();
		}
		br.close();
		ArrayList<City> cities=UserBatchUploadHelper.Convert2CityList(xmlStr);
		for(City city:cities){
			cityService.insertCity(city);
		}
		return SUCCESS;
    }

	
	
	public File getCityXml() {
		return cityXml;
	}

	public void setCityXml(File cityXml) {
		this.cityXml = cityXml;
	}

	public String getCityXmlFileName() {
		return cityXmlFileName;
	}

	public void setCityXmlFileName(String cityXmlFileName) {
		this.cityXmlFileName = cityXmlFileName;
	}

	public String getCityXmlContentType() {
		return cityXmlContentType;
	}

	public void setCityXmlContentType(String cityXmlContentType) {
		this.cityXmlContentType = cityXmlContentType;
	}



	public CityService getCityService() {
		return cityService;
	}



	public void setCityService(CityService cityService) {
		this.cityService = cityService;
	}
}
