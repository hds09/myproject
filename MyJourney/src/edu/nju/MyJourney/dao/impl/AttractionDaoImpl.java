package edu.nju.MyJourney.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import edu.nju.MyJourney.dao.AttractionDao;
import edu.nju.MyJourney.model.Attraction;
import edu.nju.MyJourney.model.City;
import edu.nju.MyJourney.model.Hotel;

public class AttractionDaoImpl implements AttractionDao {
	Configuration config = new Configuration().configure();
	@SuppressWarnings("deprecation")
	SessionFactory sessionFactory = config.buildSessionFactory();
	@Override
	public void insertAttraction(Attraction attraction) {
		// TODO Auto-generated method stub
		  Session session=sessionFactory.openSession();
			try {	
				Transaction tx=session.beginTransaction();	
				session.save(attraction);
		       tx.commit();
			} catch (Exception e) {
				e.printStackTrace();
			}
			session.close();
	}

	@Override
	public Attraction getAttractionByName(String name) {
		Session session=sessionFactory.openSession();
		Attraction attraction=null;
		try {	
			Transaction tx=session.beginTransaction();	
			String hql = "from Attraction a where a.name='"+name+"'";
			Query query = session.createQuery(hql);	
			List list = query.list();
			if(list.size()!=0){
				attraction=(Attraction) list.get(0);
			}
	       tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		session.close();
		return attraction;

	}

	@Override
	public void updateAttraction(Attraction attraction) {
		// TODO Auto-generated method stub
		  Session session=sessionFactory.openSession();
			try {	
				Transaction tx=session.beginTransaction();	
				session.update(attraction);
		       tx.commit();
			} catch (Exception e) {
				e.printStackTrace();
			}
			session.close();
	}

	@Override
	public List<Attraction> getAllAttraction() {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		List<Attraction> attractionlist=null;
		try {	
			Transaction tx=session.beginTransaction();	
			String hql = "from Attraction a  ";
			Query query = session.createQuery(hql);	
			attractionlist = query.list();
	       tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		session.close();
		return attractionlist;
	}

}
