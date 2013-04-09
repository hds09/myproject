package edu.nju.MyJourney.dao.impl;

//import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

//import org.springframework.orm.hibernate3.support.HibernateDaoSupport;


import edu.nju.MyJourney.dao.UserDao;
import edu.nju.MyJourney.model.*;



public class UserDaoImpl implements UserDao
{
	Configuration config = new Configuration().configure();
	@SuppressWarnings("deprecation")
	SessionFactory sessionFactory = config.buildSessionFactory();
	
	
	
	@Override
	public User login(String account, String password) {
		Session session=sessionFactory.openSession();
		User user=null;
		try {
			
			Transaction tx=session.beginTransaction();	
			String hql = "from User a  where a.account="
					+ "'"+account+"' and "+"a.password="+"'"+password+"'";
			Query query = session.createQuery(hql);	
			List list = query.list();
           if(list.size()!=0){
        	
        	   user=(User) list.get(0);
           }
           tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		session.close();
		System.out.println(account+"登录"+user.getAccount());
		return user;
	}
	

}
