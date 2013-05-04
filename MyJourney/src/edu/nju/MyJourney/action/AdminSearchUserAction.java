package edu.nju.MyJourney.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

import edu.nju.MyJourney.helpflow.SearchFlow;
import edu.nju.MyJourney.helpflow.SearchPrepareStatement;
import edu.nju.MyJourney.model.User;

public class AdminSearchUserAction extends BaseAction {
	private String field;
	private String keyword;
	private String sortOption;
	private String ageOption;
	private String sexOption;
	public String execute() throws Exception {
		System.out.println("keyword: "+keyword);
		System.out.println("field: "+field);
		System.out.println("sortOption: "+sortOption);
		System.out.println("ageOption: "+ageOption);
		System.out.println("sexOption: "+sexOption);
		SearchPrepareStatement sps=new SearchPrepareStatement();
		//set keyword
		sps.type="UserSearch";
		sps.KEYWORD=keyword;
		//set field
		sps.FIELD=field;
		//set ageOption
		if(ageOption.equals("age_all")){
			sps.AGEOPTION=0;
		}else if(ageOption.equals("age1")){
			sps.AGEOPTION=1;
		}else if(ageOption.equals("age2")){
			sps.AGEOPTION=2;
		}else if(ageOption.equals("age3")){
			sps.AGEOPTION=3;
		}else if(ageOption.equals("age4")){
			sps.AGEOPTION=4;
		}
		//set sexOption
		if(sexOption.equals("sex_all")){
			sps.SEXOPTION=0;
		}else if(sexOption.equals("male")){
			sps.SEXOPTION=1;
		}else if(sexOption.equals("female")){
			sps.SEXOPTION=2;
		}
		//set sort option
		if(sortOption.equals("default")){
			sps.SORTOPTION=0;
		}else if(sortOption.equals("agesort1")){
			sps.SORTOPTION=1;
		}else if(sortOption.equals("agesort2")){
			sps.SORTOPTION=2;
		}
		//
		ArrayList<User> searchResult=SearchFlow.userSearch(sps);
		System.out.println("searchResult size: "+searchResult.size());
		String res=SUCCESS;
		ActionContext actionContext = ActionContext.getContext();  
		Map session = actionContext.getSession();
		session.put("searchResult", searchResult);
		return res;
	}
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
	public String getSortOption() {
		return sortOption;
	}
	public void setSortOption(String sortOption) {
		this.sortOption = sortOption;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getAgeOption() {
		return ageOption;
	}
	public void setAgeOption(String ageOption) {
		this.ageOption = ageOption;
	}
	public String getSexOption() {
		return sexOption;
	}
	public void setSexOption(String sexOption) {
		this.sexOption = sexOption;
	}
}
