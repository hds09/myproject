package edu.nju.MyJourney.dao;

import edu.nju.MyJourney.model.User;

public interface UserDao {

	public User login(String account,String password);
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
