package edu.nju.MyJourney.service.impl;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.nju.MyJourney.dao.UserDao;
import edu.nju.MyJourney.model.User;
import edu.nju.MyJourney.service.UserService;






public class UserServiceImpl implements UserService
{
	private UserDao userDao;
	
	//private static UserServiceImpl userService=new UserServiceImpl();
	


	@Override
	public User Login(String account, String password) {
		// TODO Auto-generated method stub
		return userDao.login(account, password);
	}

	@Override
	public UserDao getUserDao() {
		// TODO Auto-generated method stub
		return userDao;
	}
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	

}
