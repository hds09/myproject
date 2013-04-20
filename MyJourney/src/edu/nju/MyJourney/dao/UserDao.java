package edu.nju.MyJourney.dao;

import edu.nju.MyJourney.model.Journey;
import edu.nju.MyJourney.model.Team;
import edu.nju.MyJourney.model.User;

public interface UserDao {

	public User login(String account,String password);
	public void update(User user);
	public boolean insertUser(User user);
	public void removeTeam(User user,Team team);
	public void removeJourney(User user,Journey journey);
	public void deleteUser(User user);
	public void deleteUserByAccount(String account);
	public boolean haveuser(String account,String pwd);
	public User getUserByAccount(String account);
	public User getUserById(long id);
//	public void save(User user);
//	
//	
//	/*
//	 * ��ݲ��������������ϵ�ֵ����user����,����ҵ��򷵻��������,���򷵻�null
//	 * column ����
//	 * value ��ֵ
//	 */
//	public User find(String column,String value);
//	
//	
//	/*
//	 * ���id����user���һ����¼
//	 */
//	public void updateByUserid(User user);
}
