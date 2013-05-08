package edu.nju.MyJourney.action;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import edu.nju.MyJourney.helpflow.UserBatchUploadHelper;
import edu.nju.MyJourney.model.Attraction;
import edu.nju.MyJourney.model.Hotel;
import edu.nju.MyJourney.service.AttractionService;
import edu.nju.MyJourney.service.HotelService;

public class AttractionBatchUploadAction extends BaseAction{
	private File attractionXml;
	private String attractionXmlFileName ;  
	private String attractionXmlContentType ; 
	private AttractionService attractionService;
 
    public String execute() throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(attractionXml),"UTF-8"));
		System.out.println("filename: "+attractionXmlFileName);
		System.out.println("filetype: "+attractionXmlContentType);
		String xmlStr="";
		String line=br.readLine();
		while(line!=null){
			xmlStr=xmlStr+line;
			System.out.println(line);
			line=br.readLine();
		}
		br.close();
		ArrayList<Attraction> attractions=UserBatchUploadHelper.Convert2AList(xmlStr);
		for(Attraction attraction:attractions){
			attractionService.insertAttraction(attraction);
		}
		return SUCCESS;
    }

	public AttractionService getAttractionService() {
		return attractionService;
	}

	public void setAttractionService(AttractionService attractionService) {
		this.attractionService = attractionService;
	}
	
	public File getAttractionXml() {
		return attractionXml;
	}

	public void setAttractionXml(File attractionXml) {
		this.attractionXml = attractionXml;
	}

	public String getAttractionXmlFileName() {
		return attractionXmlFileName;
	}

	public void setAttractionXmlFileName(String attractionXmlFileName) {
		this.attractionXmlFileName = attractionXmlFileName;
	}

	public String getAttractionXmlContentType() {
		return attractionXmlContentType;
	}

	public void setAttractionXmlContentType(String attractionXmlContentType) {
		this.attractionXmlContentType = attractionXmlContentType;
	}

}
