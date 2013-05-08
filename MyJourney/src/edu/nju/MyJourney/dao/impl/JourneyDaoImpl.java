package edu.nju.MyJourney.dao.impl;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import edu.nju.MyJourney.dao.JourneyDao;
import edu.nju.MyJourney.dao.UserDao;
import edu.nju.MyJourney.model.Journey;
import edu.nju.MyJourney.model.User;

public class JourneyDaoImpl implements JourneyDao{
	Configuration config = new Configuration().configure();
	@SuppressWarnings("deprecation")
	SessionFactory sessionFactory = config.buildSessionFactory();
	@Override
	public void insertJoueney(Journey journey) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();

		try {
			
			Transaction tx=session.beginTransaction();	
			session.save(journey);
			System.out.println("..................insert journey.................");
           tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}

		session.close();

	}
	@Override
	public Journey getJourneyByUserObj(User user) {
		UserDao userdao=new UserDaoImpl();
		User tmpuser=userdao.getUserByAccount(user.getAccount());
		Session session=sessionFactory.openSession();
		Journey result=null;
		try {	
			Transaction tx=session.beginTransaction();	
			String hql = "from Journey j  where j.user="
					+tmpuser.getUid()+"";
			Query query = session.createQuery(hql);	
	
			List list = query.list();
           if(list.size()!=0){	
        	   result=(Journey) list.get(0);
        	//  Hibernate.initialize(user.getJourney());
           }
	       tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		session.close();
		return result;
	
	}
	@Override
	public List<Journey> getJourneyByPage(int start, int length) {
		Session session=sessionFactory.openSession();
		List<Journey> result=null;
		try {	
			Transaction tx=session.beginTransaction();	
			String hql = "from Journey";
			Query query = session.createQuery(hql);	
			query.setFirstResult(start);
			query.setMaxResults(length);
	
			result = query.list();
          System.out.println(result.size());
	       tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		session.close();
		return result;
	}
	@Override
	public Journey getJourneyById(long id) {
		Session session=sessionFactory.openSession();
		Journey result=null;
		try {	
			Transaction tx=session.beginTransaction();	
			String hql = "from Journey j  where j.id="
					+id;
			Query query = session.createQuery(hql);	
	
			List list = query.list();
           if(list.size()!=0){	
        	   result=(Journey) list.get(0);
        	   Hibernate.initialize(result.getPlaces());
           }
	       tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		session.close();
		return result;
	}
	@Override
	public void updateJourney(Journey journey) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();

		try {
			
			Transaction tx=session.beginTransaction();	
			session.merge(journey);
           tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		session.close();
		
	}
	@Override
	public List<Journey> getAllJourneys() {
		// TODO Auto-generated method stub
		List<Journey> journeys=null;
		Session session=sessionFactory.openSession();
		try {	
			Transaction tx=session.beginTransaction();	
			String hql = "from Journey";
			Query query = session.createQuery(hql);	
			journeys = query.list();
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		session.close();
		return journeys;
	}
	@Override
	public void deleteJourneyById(String id) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		try {	
			Transaction tx=session.beginTransaction();	
			Journey j=new JourneyDaoImpl().getJourneyById(Integer.parseInt(id));
			session.delete(j);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}

		session.close();
	}
	

}
