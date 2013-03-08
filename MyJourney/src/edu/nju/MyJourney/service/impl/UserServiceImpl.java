//package edu.nju.MyJourney.service.impl;
//
//import java.io.IOException;
//
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//
//
//import edu.nju.MyJourney.dao.UserDao;
//import edu.nju.MyJourney.exceptions.PasswordNotMatchException;
//import edu.nju.MyJourney.exceptions.UsernameExistException;
//import edu.nju.MyJourney.model.User;
//import edu.nju.MyJourney.service.UserService;
//
//
//public class UserServiceImpl implements UserService
//{
//	private UserDao userDao;
//	
//	//private static UserServiceImpl userService=new UserServiceImpl();
//	
//	private UserServiceImpl()
//	{
//		
//	}
//	public UserDao getUserDao(){
//		System.out.println("getUserdao");
//		return userDao;
//	}
//	@Override
//	public void setUserDao(UserDao userDao) {
//		this.userDao=userDao;
//		System.out.println("setUserdao");
//		
//	}
//	/*public static UserServiceImpl getInstance()
//	{
//		return userService;
//	}*/
//	
//	public User validateUser(String userid)
//	{
//	//	ApplicationContext context=new FileSystemXmlApplicationContext("D:\\JEE\\2011\\workspace\\onlineStockSSH\\src\\applicationContext.xml");
//		
//		
//		User user=userDao.find("userid",userid);
//		//System.out.println(user.getUserid()+"userid!");
//		//User user=DaoFactory.getUserDao().find("userid",userid);
//		/*if(user==null)
//		{
//			return null;
//		}*/
//		return user;
//	}
//
//	
//	public String validateUpdateUser(User user) 
//	{
//		String message=null;
//				
//		if(user.getBankid().equals("")||user.getEmail().equals("")||user.getName().equals("")||user.getPassword().equals("")||user.getPhone().equals("")||user.getUserid().equals("")||user.getBankid()==null||user.getEmail()==null||user.getName()==null||user.getPassword()==null||user.getPhone()==null||user.getUserid()==null)
//		{
//			message="All the content must be filled!<br>";
//		}
//		return message;
//	}
//	
//	public Integer validateNumber(String number)
//	{
//		Integer num=null;
//		try
//		{
//			num=Integer.valueOf(number);
//		}
//		catch(Exception e)
//		{
//			return null;
//		}
//		
//		if(num.intValue()<=0)
//		{
//			return null;
//		}
//		
//		return num;
//	}
//	
//	public void sentErrorMessage(String message,HttpServletRequest req,HttpServletResponse resp) 
//					throws ServletException,IOException
//	{
//		req.setAttribute("message",message);
////		RequestDispatcher dispater=req.getRequestDispatcher(resp.encodeURL("/error/error.jsp"));
////		dispater.forward(req,resp);
//	}
//	
//
//	public void sentMessage(String message,HttpServletRequest req,HttpServletResponse resp) 
//					throws ServletException,IOException
//	{
//		req.setAttribute("message",message);
////		RequestDispatcher dispater=req.getRequestDispatcher(resp.encodeURL("/message/message.jsp"));
////		dispater.forward(req,resp);
//	}
//	@Override
//	public String registerUser(User user) {
//		String message=null;
//		if(validateUser(user.getUserid())!=null){
//			System.out.println("username exist");
//			message="username exist";
//			return message;
//		}
//		else if(validateUpdateUser(user)!=null){
//			System.out.println("All the content must be filled!");
//			message="All the content must be filled!";
//			return message;
//		}
//		else{
//			userDao.save(user);
//			
//			return message;
//		}
//	}
//	
//
///*	public void forwardPage(String page,HttpServletRequest req,HttpServletResponse resp) 
//					throws ServletException,IOException
//	{
//		RequestDispatcher dispater=req.getRequestDispatcher(resp.encodeURL(page));
//		dispater.forward(req,resp);
//	}*/
//
//
//}
