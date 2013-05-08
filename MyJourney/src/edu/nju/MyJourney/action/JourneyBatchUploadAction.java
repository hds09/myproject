package edu.nju.MyJourney.action;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

import edu.nju.MyJourney.helpflow.UserBatchUploadHelper;
import edu.nju.MyJourney.model.Journey;
import edu.nju.MyJourney.model.User;
import edu.nju.MyJourney.service.JourneyService;
import edu.nju.MyJourney.service.UserService;

public class JourneyBatchUploadAction extends BaseAction{
	private File journeyXml;
	private String journeyXmlFileName ;  
	private String journeyXmlContentType ; 
	private JourneyService journeyService;
	 
	public String execute() throws Exception{
			BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(journeyXml),"UTF-8"));
			System.out.println("filename: "+journeyXmlFileName);
			System.out.println("filetype: "+journeyXmlContentType);
			String xmlStr="";
			String line=br.readLine();
			while(line!=null){
				xmlStr=xmlStr+line;
				System.out.println(line);
				line=br.readLine();
			}
			br.close();
			ArrayList<Journey> journeys=UserBatchUploadHelper.Convert2JList(xmlStr);
			for(Journey journey:journeys){
				journeyService.insertJourney(journey);
			}
			return SUCCESS;
	 }
	
	public File getJourneyXml() {
		return journeyXml;
	}
	public void setJourneyXml(File journeyXml) {
		this.journeyXml = journeyXml;
	}
	public String getJourneyXmlFileName() {
		return journeyXmlFileName;
	}
	public void setJourneyXmlFileName(String journeyXmlFileName) {
		this.journeyXmlFileName = journeyXmlFileName;
	}
	public String getJourneyXmlContentType() {
		return journeyXmlContentType;
	}
	public void setJourneyXmlContentType(String journeyXmlContentType) {
		this.journeyXmlContentType = journeyXmlContentType;
	}
	public JourneyService getJourneyService() {
		return journeyService;
	}
	public void setJourneyService(JourneyService journeyService) {
		this.journeyService = journeyService;
	}
}
