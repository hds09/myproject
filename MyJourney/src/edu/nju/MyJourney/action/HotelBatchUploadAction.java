package edu.nju.MyJourney.action;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import edu.nju.MyJourney.helpflow.UserBatchUploadHelper;
import edu.nju.MyJourney.model.City;
import edu.nju.MyJourney.model.Hotel;
import edu.nju.MyJourney.service.CityService;
import edu.nju.MyJourney.service.HotelService;

public class HotelBatchUploadAction extends BaseAction {
	private File hotelXml;
	private String hotelXmlFileName ;  
	private String hotelXmlContentType ; 
	private HotelService hotelService;
 
    public String execute() throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(hotelXml),"UTF-8"));
		System.out.println("filename: "+hotelXmlFileName);
		System.out.println("filetype: "+hotelXmlContentType);
		String xmlStr="";
		String line=br.readLine();
		while(line!=null){
			xmlStr=xmlStr+line;
			System.out.println(line);
			line=br.readLine();
		}
		br.close();
		ArrayList<Hotel> hotels=UserBatchUploadHelper.Convert2HotelList(xmlStr);
		for(Hotel hotel:hotels){
			hotelService.insertHotel(hotel);
		}
		return SUCCESS;
    }

	public HotelService getHotelService() {
		return hotelService;
	}

	public void setHotelService(HotelService hotelService) {
		this.hotelService = hotelService;
	}
	
	public File getHotelXml() {
		return hotelXml;
	}

	public void setHotelXml(File hotelXml) {
		this.hotelXml = hotelXml;
	}

	public String getHotelXmlFileName() {
		return hotelXmlFileName;
	}

	public void setHotelXmlFileName(String hotelXmlFileName) {
		this.hotelXmlFileName = hotelXmlFileName;
	}

	public String getHotelXmlContentType() {
		return hotelXmlContentType;
	}

	public void setHotelXmlContentType(String hotelXmlContentType) {
		this.hotelXmlContentType = hotelXmlContentType;
	}
}
