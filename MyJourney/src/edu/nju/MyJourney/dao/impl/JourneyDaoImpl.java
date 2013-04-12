package edu.nju.MyJourney.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import edu.nju.MyJourney.dao.JourneyDao;
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
           tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		session.close();

	}
	

}
