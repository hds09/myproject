//package edu.nju.MyJourney.action;
//
//import java.sql.Date;
//import java.util.Calendar;
//
//
//import edu.nju.MyJourney.exceptions.PasswordNotMatchException;
//import edu.nju.MyJourney.exceptions.UsernameExistException;
//import edu.nju.MyJourney.model.User;
//import edu.nju.MyJourney.service.UserService;
//
//
//
//
//public class UserAction extends BaseAction {
//
//	private UserService userService; // 注入业务方法 
//	private User user; 
//	
//  
//    public String execute() throws Exception
//    {
//    	String message="";
//		int year=0;
//		int month=0;
//		int day=0;
//		try
//		{
//			year=Integer.valueOf(this.request().getParameter("year")).intValue();
//			month=Integer.valueOf(this.request().getParameter("month")).intValue()-1;
//			day=Integer.valueOf(this.request().getParameter("day")).intValue();
//		}
//		catch(Exception e)
//		{
//			message+="Birthday must be a Integer!<br>";
//			userService.sentErrorMessage(message, this.request(),this.response());
//			return INPUT;
//		}
//		if(this.request().getParameter("passwordOne").equals(this.request().getParameter("passwordTwo"))){
//			user.setPassword(this.request().getParameter("passwordOne"));
//		}
//		else{
//			message+="Password not match!<br>";
//			userService.sentErrorMessage(message, this.request(),this.response());
//			return INPUT;
//		}
//			
//	//	User user=new User();
//		user.setIdByDate();
//		user.setAccount(500000);
//	//	user.setBankid(this.request().getParameter("bankid"));
//	//	user.setEmail(this.request().getParameter("email"));
//	//	user.setName(this.request().getParameter("name"));
//	//	System.out.println(req.getParameter("name"));
//	//	user.setPasswordOne(this.request().getParameter("passwordOne"));
//	//	user.setPasswordTwo(this.request().getParameter("passwordTwo"));
//	//	user.setPhone(this.request().getParameter("phone"));
//	//	user.setUserid(this.request().getParameter("userid"));
//		Calendar calendar=Calendar.getInstance();
//		calendar.set(Calendar.YEAR,year);
//		calendar.set(Calendar.MONTH,month);
//		calendar.set(Calendar.DAY_OF_MONTH,day);
//		Date date=new Date(calendar.getTimeInMillis());
//		user.setBirthday(date);
//		/*try {
//			message=userService.validateRegister(user,message);
//			System.out.println(message);
//		} catch (UsernameExistException e1) {
//		// TODO Auto-generated catch block
//			userService.sentErrorMessage("UsernameExistException", this.request(), this.response());
//		}
//		if(message!="")
//		{
//			userService.sentErrorMessage(message, this.request(), this.response());
//			return INPUT;
//		}*/
//		if((message=userService.registerUser(user))!= null){
//			userService.sentErrorMessage(message, this.request(),this.response());
//			return INPUT;
//		}
//		else{
//			this.request().getSession().setAttribute("userid",user.getUserid());
//			this.request().getSession().setAttribute("name",user.getName());
//			return SUCCESS;
//		}
//		
//    }
//
//	public void setUserService(UserService userService) {
//		this.userService = userService;
//		System.out.println("setUserService");
//	}
//
//	public UserService getUserService() {
//		return userService;
//	}
//
//	public void setUser(User user) {
//		this.user = user;
//		System.out.println(user.getUserid()+"user");
//	}
//
//	public User getUser() {
//		return user;
//	}
//  
//   
//
//}
