package edu.nju.MyJourney.service.impl;

import java.util.ArrayList;
import java.util.List;

import edu.nju.MyJourney.dao.JourneyDao;
import edu.nju.MyJourney.dao.UserDao;
import edu.nju.MyJourney.helperModel.Daren;
import edu.nju.MyJourney.model.Journey;
import edu.nju.MyJourney.model.Picture;
import edu.nju.MyJourney.model.Reply;
import edu.nju.MyJourney.model.User;
import edu.nju.MyJourney.service.HomeService;

public class HomeServiceImpl implements HomeService {
	private UserDao userDao;
	private JourneyDao journeyDao;
	@Override
	public Daren DarenInfo(long id) {
		return new Daren().convertFromUser(userDao.userInfo(id));
	}
	@Override
	public List<Picture> getUserPicture(int page, int pageSize) {
		return userDao.getUserPicture(page, pageSize);
	}
	@Override
	public List<Journey> getUserJourney(String account, int page, int pageSize) {
		User user = userDao.getUserByAccount(account);
		if(user != null){
			return journeyDao.getUserJourney(user, page, pageSize);
		}else{
			return new ArrayList<Journey>();
		}
	}
	
	@Override
	public List<Daren> getAttention(long uid) {
		List<Daren> result = new ArrayList<Daren>();
		User user = userDao.userInfo(uid);
		if(user == null){
			System.out.println("用户为空");
		}else{
			for(User u:user.getAttention()){
				result.add(new Daren().convertFromUser(u));
			}
		}
		return result;
	}
	@Override
	public List<Daren> getConcerned(long uid) {
		List<Daren> result = new ArrayList<Daren>();
		User user = userDao.userInfo(uid);
		if(user == null){
			System.out.println("用户为空");
		}else{
			for(User u:user.getConcerned()){
				result.add(new Daren().convertFromUser(u));
			}
		}
		return result;
	}
	@Override
	public List<Reply> getMessage(long uid) {
		List<Reply> result = new ArrayList<Reply>();
		User user = userDao.userInfo(uid);
		if(user == null){
			System.out.println("用户为空");
		}
		else{
			result = user.getMeassage();
		}
		return result;
	}

	public UserDao getUserDao() {
		return userDao;
	}
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	public JourneyDao getJourneyDao() {
		return journeyDao;
	}
	public void setJourneyDao(JourneyDao journeyDao) {
		this.journeyDao = journeyDao;
	}
	@Override
	public int getUserJourneyPageMax(long uid,int pageSize) {
		User user = userDao.getUserById(uid);
		if(user != null){
			return journeyDao.getUserJourneyPageMax(user, pageSize);
		}else{
			System.out.println("用户不存在");
			return 0;
		}
	}
	@Override
	public User getUserByAccount(String account) {
		return userDao.getUserByAccount(account);
	}
	@Override
	public boolean hasAttention(String account, String attentionAccount) {
		User user = userDao.getUserByAccount(account);
		for(User att: user.getAttention()){
			if(att.getAccount().equals(attentionAccount)){
				return true;
			}
		}
		return false;
	}
}
