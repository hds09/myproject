package edu.nju.MyJourney.action;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;

import edu.nju.MyJourney.helpflow.UserBatchUploadHelper;
import edu.nju.MyJourney.model.User;
import edu.nju.MyJourney.service.UserService;

public class UserBatchUploadAction extends BaseAction{
	private File userXml;
	private String userXmlFileName ;  
	private String userXmlContentType ; 
	private UserService userService;
 
    public String execute() throws Exception{
		BufferedReader br=new BufferedReader(new FileReader(userXml));
		System.out.println("filename: "+userXmlFileName);
		System.out.println("filetype: "+userXmlContentType);
		String xmlStr="";
		String line=br.readLine();
		while(line!=null){
			xmlStr=xmlStr+line;
			System.out.println(line);
			line=br.readLine();
		}
		br.close();
		ArrayList<User> users=UserBatchUploadHelper.Convert2List(xmlStr);
		for(User user:users){
			userService.insertUser(user);
		}
		return SUCCESS;
    }

	public String getUserXmlFileName() {
		return userXmlFileName;
	}


	public void setUserXmlFileName(String userXmlFileName) {
		this.userXmlFileName = userXmlFileName;
	}


	public String getUserXmlContentType() {
		return userXmlContentType;
	}


	public void setUserXmlContentType(String userXmlContentType) {
		this.userXmlContentType = userXmlContentType;
	}


	public File getUserXml() {
		return userXml;
	}


	public void setUserXml(File userXml) {
		this.userXml = userXml;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}
