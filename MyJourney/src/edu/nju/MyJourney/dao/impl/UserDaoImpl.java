package edu.nju.MyJourney.dao.impl;

//import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
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
	public boolean haveuser(String account,String pwd) {
		System.out.println(account+" and "+pwd);
		Session session = sessionFactory.openSession();
		// TODO Auto-generated method stub
		boolean result=false;
		try {
			
			Transaction tx=session.beginTransaction();	
             
			String hql = "from User a  where a.account="
					+ "'"+account+"' and "+"a.pwd="+"'"+pwd+"'";
			Query query = session.createQuery(hql);
			
			List list = query.list();
           if(list.size()==0){
        	   result=false;
           }else{
        	   result=true;
           }
           tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		session.close();
		
		System.out.println(result);
		return result;
	}
	public void update(User user){
		 Session session=sessionFactory.openSession();
			try {	
				Transaction tx=session.beginTransaction();	
				session.merge(user);
				System.out.println("...................update user.........................");
		       tx.commit();
			} catch (Exception e) {
				e.printStackTrace();
			}
			session.close();
	}
	public boolean insertUser(User user){
		boolean result=false;
		 Session session=sessionFactory.openSession();
			try {	
				Transaction tx=session.beginTransaction();	
				session.save(user);
				result=true;
		       tx.commit();
			} catch (Exception e) {
				e.printStackTrace();
			}
			session.close();
			return result;
	}
	public void removeTeam(User user,Team team){
		 Session session=sessionFactory.openSession();
			try {	
				Transaction tx=session.beginTransaction();	
				user.removeTeam(team);
				session.update(user);
		       tx.commit();
			} catch (Exception e) {
				e.printStackTrace();
			}
			session.close();
	}
	public void removeJourney(User user,Journey journey){
		 Session session=sessionFactory.openSession();
			try {	
				Transaction tx=session.beginTransaction();	
				user.removeJourney(journey);
				session.update(user);
		       tx.commit();
			} catch (Exception e) {
				e.printStackTrace();
			}
			session.close();
	}
    public void deleteUser(User user){
	 Session session=sessionFactory.openSession();
		try {	
			Transaction tx=session.beginTransaction();	
			session.delete(user);
	       tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		session.close();
}
	@Override
	public void deleteUserByAccount(String account) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		User user=null;
		try {	
			Transaction tx=session.beginTransaction();	
			String hql = "from User a  where a.account="
					+ "'"+account+"'";
			Query query = session.createQuery(hql);	
			List list = query.list();
           if(list.size()!=0){	
        	   user=(User) list.get(0);
           }
			session.delete(user);
	       tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		session.close();
	}
	@Override
	public User getUserByAccount(String account) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		User user=null;
		try {	
			Transaction tx=session.beginTransaction();	
			String hql = "from User a  where a.account="
					+ "'"+account+"'";
			Query query = session.createQuery(hql);	
	
			List list = query.list();
           if(list.size()!=0){	
        	   user=(User) list.get(0);
        	  Hibernate.initialize(user.getJourney());
        	  Hibernate.initialize(user.getAttention());
        	  Hibernate.initialize(user.getConcerned());
           }
	       tx.commit(); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		session.close();
		return user;
	}
	
	@Override
	public User getUserById(long id) {
		Session session=sessionFactory.openSession();
		User user=null;
		try {	
			Transaction tx=session.beginTransaction();	
			String hql = "from User a  where a.id="
					+ "'"+id+"'";
			Query query = session.createQuery(hql);	
	
			List list = query.list();
           if(list.size()!=0){	
        	   user=(User) list.get(0);
        	  Hibernate.initialize(user.getJourney());
           }
	       tx.commit(); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		session.close();
		return user;
	}

	
	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		List<User> users=null;
		Session session=sessionFactory.openSession();
		try {	
			Transaction tx=session.beginTransaction();	
			String hql = "from User";
			Query query = session.createQuery(hql);	
			users = query.list();
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		session.close();
		return users;
	}
	@Override
	public void deleteUserById(String id) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		User user=null;
		try {	
			Transaction tx=session.beginTransaction();	
			String hql = "from User a  where a.id="
					+ "'"+id+"'";
			Query query = session.createQuery(hql);	
			List list = query.list();
           if(list.size()!=0){	
        	   user=(User) list.get(0);
           }
			session.delete(user);
	       tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		session.close();
	}

	//fdp
    @Override
    public User userInfo(long id) {
    	Session session=sessionFactory.openSession();
		User user=null;
		try {

			Transaction tx=session.beginTransaction();	
			String hql = "from User a  where a.id="	+ "'"+id+"'";
			Query query = session.createQuery(hql);	
			List list = query.list();
           if(list.size()!=0){
        	   user=(User) list.get(0);
        	   Hibernate.initialize(user.getAttention());
        	   Hibernate.initialize(user.getComments());
        	   Hibernate.initialize(user.getConcerned());
        	   Hibernate.initialize(user.getJourney());
        	   Hibernate.initialize(user.getMeassage());
        	   Hibernate.initialize(user.getTeam());
        	   
           }
           tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		return user;
    }
    @Override
    public List<Picture> getUserPicture(int page, int pageSize) {
    	Session session=sessionFactory.openSession();
		List<Picture> result = null;
		try{
			Transaction tx=session.beginTransaction();
			//TO DO
	        tx.commit();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return result;
    }

}
