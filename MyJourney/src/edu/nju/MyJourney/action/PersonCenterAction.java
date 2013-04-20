package edu.nju.MyJourney.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

public class PersonCenterAction extends BaseAction{
	private boolean islogined;
	private int selectnum;
	
	public String execute() throws Exception {
		String result = SUCCESS;
		 ActionContext actionContext = ActionContext.getContext();  
		  Map session = actionContext.getSession();
		  String tmp=(String)session.get("account");
		    if(tmp==null){
		    	this.islogined=false;
		    	result="failure";
		    }else{
		    	this.islogined=true;
		    	
		    }
		    session.put("islogined",this.islogined);
		    this.selectnum=1;
		// session.put("islogined",this.islogined);
		 //session.put("account", this.account);
		return result;
	}

	public int getSelectnum() {
		return selectnum;
	}

	public void setSelectnum(int selectnum) {
		this.selectnum = selectnum;
	}
}
