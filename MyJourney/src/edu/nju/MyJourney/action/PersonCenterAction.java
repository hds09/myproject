package edu.nju.MyJourney.action;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

import edu.nju.MyJourney.model.Journey;
import edu.nju.MyJourney.model.User;
import edu.nju.MyJourney.service.UserService;

public class PersonCenterAction extends BaseAction{
	private boolean islogined;
	private String account;
	private User user;
	private int selectnum;
	private String newpwd;
	private String oldpwd;
	private String email;
    private List<Journey> journeylist;
	private String city;
	private String phone;
	private int sex;
	private int age;
	private UserService userService;
	
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
		    	this.account=(String)session.get("account");
		    }
		    session.put("islogined",this.islogined);
		    this.selectnum=1;
		// session.put("islogined",this.islogined);
		 //session.put("account", this.account);
		return result;
	}
    public String select2() throws Exception{
    	String result = SUCCESS;
    	 ActionContext actionContext = ActionContext.getContext();  
		  Map session = actionContext.getSession();
		  String tmp=(String)session.get("account");
		  user=userService.getUserByAccount(tmp);
		  this.selectnum=2;
    	return result;
    }
    public String select3() throws Exception{
    	String result = SUCCESS;
    	
    	this.selectnum=3;
    	return result;
    }
    public String select4() throws Exception{
    	String result = SUCCESS;
    	ActionContext actionContext = ActionContext.getContext();  
		Map session = actionContext.getSession();
		String tmp=(String)session.get("account");
		journeylist=userService.getUserByAccount(tmp).getJourney();
    	this.selectnum=4;
    	return result;
    }
    public String changePwd() throws Exception{
    	String result=SUCCESS;
    	 ActionContext actionContext = ActionContext.getContext();  
		  Map session = actionContext.getSession();
		  String tmp=(String)session.get("account");
		  System.out.println(tmp+":"+oldpwd);
		  boolean flag=userService.haveuser(tmp, oldpwd);
		  if(flag){
			  User user=userService.getUserByAccount(tmp);
			  user.setPwd(newpwd);
			  userService.updateUser(user);
		  }else{
			  result="failure";
		  }
    	this.selectnum=1;
    	return result;
    }
    public String changeCity() throws Exception{
    	String result=SUCCESS;
    	 ActionContext actionContext = ActionContext.getContext();  
		 Map session = actionContext.getSession();
		 String tmp=(String)session.get("account");
		  User user=userService.getUserByAccount(tmp);
		  user.setCity(this.getCity());
		  userService.updateUser(user);
    	  this.selectnum=2;
    	  return result;
    }
    public String changeAge() throws Exception{
    	String result=SUCCESS;
   	     ActionContext actionContext = ActionContext.getContext();  
		 Map session = actionContext.getSession();
		 String tmp=(String)session.get("account");
		  User user=userService.getUserByAccount(tmp);
		  user.setAge(this.getAge());
		  userService.updateUser(user);
   	      this.selectnum=2;
   	     return result;
    }
    public String changeSex() throws Exception{
    	String result=SUCCESS;
   	     ActionContext actionContext = ActionContext.getContext();  
		 Map session = actionContext.getSession();
		 String tmp=(String)session.get("account");
		  User user=userService.getUserByAccount(tmp);
		 user.setSex(this.getSex());
		  userService.updateUser(user);
   	      this.selectnum=2;
   	      return result;
    }
    public String changePhone() throws Exception{
    	String result=SUCCESS;
   	     ActionContext actionContext = ActionContext.getContext();  
		 Map session = actionContext.getSession();
		 String tmp=(String)session.get("account");
		  User user=userService.getUserByAccount(tmp);
		  user.setPhone(this.getPhone());
		  userService.updateUser(user);
   	      this.selectnum=2;
   	      return result;
    }
    public String changeEmail() throws Exception{
    	String result=SUCCESS;
   	     ActionContext actionContext = ActionContext.getContext();  
		 Map session = actionContext.getSession();
		 String tmp=(String)session.get("account");
		  User user=userService.getUserByAccount(tmp);
		  user.setEmail(this.getEmail());
		  userService.updateUser(user);
   	      this.selectnum=2;
   	      return result;
    }
	public int getSelectnum() {
		return selectnum;
	}

	public void setSelectnum(int selectnum) {
		this.selectnum = selectnum;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public String getNewpwd() {
		return newpwd;
	}
	public void setNewpwd(String newpwd) {
		this.newpwd = newpwd;
	}
	public String getOldpwd() {
		return oldpwd;
	}
	public void setOldpwd(String oldpwd) {
		this.oldpwd = oldpwd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public List<Journey> getJourneylist() {
		return journeylist;
	}
	public void setJourneylist(List<Journey> journeylist) {
		this.journeylist = journeylist;
	}
}
