package edu.nju.MyJourney.service.impl;

import java.io.IOException;
import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.nju.MyJourney.dao.AdministratorDao;
import edu.nju.MyJourney.dao.UserDao;
import edu.nju.MyJourney.model.User;
import edu.nju.MyJourney.service.UserService;






public class UserServiceImpl implements UserService
{
	private UserDao userDao;
	private AdministratorDao administratorDao;
	
	//private static UserServiceImpl userService=new UserServiceImpl();
	


	@Override
	public User Login(String account, String password) {
		// TODO Auto-generated method stub
		return userDao.login(account, password);
	}


	@Override
	public boolean insertUser(User user) {
		
		// TODO Auto-generated method stub
		return userDao.insertUser(user);
	}

	@Override
	public User getUserByAccount(String account) {
		// TODO Auto-generated method stub
		
		return userDao.getUserByAccount(account);
	}

	@Override
	public UserDao getUserDao() {
		// TODO Auto-generated method stub
		return userDao;
	}
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}


	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		userDao.update(user);
	}


	@Override
	public boolean haveuser(String account, String pwd) {
		// TODO Auto-generated method stub
		return userDao.haveuser(account, pwd);
	}
	
	@Override
	public boolean adminSignin(String email, String pwd) {
		// TODO Auto-generated method stub
		return administratorDao.login(email, pwd);
	}


	public AdministratorDao getAdministratorDao() {
		return administratorDao;
	}


	public void setAdministratorDao(AdministratorDao administratorDao) {
		this.administratorDao = administratorDao;
	}


	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userDao.getAllUsers();
	}

}
