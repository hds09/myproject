package edu.nju.MyJourney.service.impl;

import edu.nju.MyJourney.dao.UserDao;
import edu.nju.MyJourney.model.User;
import edu.nju.MyJourney.service.RenrenService;

public class RenrenServiceImpl implements RenrenService {
	private UserDao userDao;
	@Override
	public User renrenLogin(String uid) {
		return userDao.renrenLogin(uid);
	}
	public UserDao getUserDao() {
		return userDao;
	}
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

}
