package edu.nju.MyJourney.dao.impl;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import edu.nju.MyJourney.dao.RestaurantDao;
import edu.nju.MyJourney.model.Hotel;
import edu.nju.MyJourney.model.Restaurant;
import edu.nju.MyJourney.model.User;

public class RestaurantDaoImpl implements RestaurantDao {
	Configuration config = new Configuration().configure();
	@SuppressWarnings("deprecation")
	SessionFactory sessionFactory = config.buildSessionFactory();
	@Override
	public void insertRestaurant(Restaurant hotel) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Hotel getRestaurantByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateRestaurant(Restaurant hotel) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Hotel> getAllRestaurant() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Restaurant getBestRestaurant() {
		Session session=sessionFactory.openSession();
		Restaurant restaurant=null;
		try {	
			Transaction tx=session.beginTransaction();	
			String hql = "from Restaurant r";
			Query query = session.createQuery(hql);	
	
			List list = query.list();
           if(list.size()!=0){	
        	   System.out.println("/////////////////////////////in//////////////////////");
        	   restaurant=(Restaurant) list.get(0);
        	   Hibernate.initialize(restaurant.getPlaces());
           }
	       tx.commit(); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		session.close();
		return restaurant;

	}

}
