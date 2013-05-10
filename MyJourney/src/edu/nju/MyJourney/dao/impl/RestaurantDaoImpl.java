package edu.nju.MyJourney.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import edu.nju.MyJourney.dao.RestaurantDao;
import edu.nju.MyJourney.model.City;
import edu.nju.MyJourney.model.Hotel;
import edu.nju.MyJourney.model.Restaurant;

public class RestaurantDaoImpl implements RestaurantDao {
	Configuration config = new Configuration().configure();
	@SuppressWarnings("deprecation")
	SessionFactory sessionFactory = config.buildSessionFactory();
	@Override
	public void insertRestaurant(Restaurant hotel) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();

		try {
			
			Transaction tx=session.beginTransaction();	
			session.save(hotel);
			System.out.println("..................insert rest.................");
           tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}

		session.close();
	}

	@Override
	public Hotel getRestaurantByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateRestaurant(Restaurant hotel) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		try {	
			Transaction tx=session.beginTransaction();	
			session.merge(hotel);
			System.out.println("...................update hotel.........................");
	       tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		session.close();
	}

	@Override
	public List<Restaurant> getAllRestaurant() {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		List<Restaurant> restlist=null;
		try {	
			Transaction tx=session.beginTransaction();	
			String hql = "from Restaurant r  ";
			Query query = session.createQuery(hql);	
			restlist = query.list();
	       tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		session.close();
		return restlist;
	}

	@Override
	public Restaurant getRestaurantById(String id) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Restaurant rest=null;
		try {
			Transaction tx=session.beginTransaction();	
			String hql = "from Restaurant a  where a.id="+ id;
			Query query = session.createQuery(hql);	
			List list = query.list();
           if(list.size()!=0){
        	   rest=(Restaurant) list.get(0);
           }
           tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		session.close();
		return rest;
	}

}
