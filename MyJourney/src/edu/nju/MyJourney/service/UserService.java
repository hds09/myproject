package edu.nju.MyJourney.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.nju.MyJourney.dao.UserDao;
import edu.nju.MyJourney.model.User;

public interface UserService {
	
	public UserDao getUserDao();
	public User Login(String account,String password);
	public boolean insertUser(User user);
	public User getUserByAccount(String account);
	public void updateUser(User user);
	public boolean haveuser(String account,String pwd);
	public boolean adminSignin(String email,String pwd);
	public List<User> getAllUsers();
	public User getUserById(String id);
	public void deleteUserById(String id);
}
