package edu.nju.MyJourney.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import edu.nju.MyJourney.dao.PlaceDao;
import edu.nju.MyJourney.model.Place;
import edu.nju.MyJourney.model.User;

public class PlaceDaoImpl implements PlaceDao {
	Configuration config = new Configuration().configure();
	@SuppressWarnings("deprecation")
	SessionFactory sessionFactory = config.buildSessionFactory();
	@Override
	public void insertPlace(Place place) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		try {	
			Transaction tx=session.beginTransaction();	
			session.save(place);
           tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		session.close();
	}

	@Override
	public Place getPlaceById(long id) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Place place=null;
	try {
			Transaction tx=session.beginTransaction();	
			String hql = "from Place a  where a.id="+ id;
			Query query = session.createQuery(hql);	
			List list = query.list();
           if(list.size()!=0){
        	   place=(Place) list.get(0);
           }
           tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		session.close();
		//System.out.println(account+"登录"+user.getAccount());
		return place;
	}

	@Override
	public void updatePlace(Place place) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		try {	
			Transaction tx=session.beginTransaction();	
			session.merge(place);
           tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		session.close();
	}



}
