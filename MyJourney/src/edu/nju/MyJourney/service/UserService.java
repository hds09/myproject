package edu.nju.MyJourney.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.nju.MyJourney.dao.UserDao;
import edu.nju.MyJourney.model.User;

public interface UserService {
	
	public UserDao getUserDao();
	public User Login(String account,String password);
}
