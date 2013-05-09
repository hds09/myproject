package edu.nju.MyJourney.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import edu.nju.MyJourney.dao.HotelDao;
import edu.nju.MyJourney.model.City;
import edu.nju.MyJourney.model.Hotel;
import edu.nju.MyJourney.model.Place;

public class HotelDaoImpl implements HotelDao {
	Configuration config = new Configuration().configure();
	@SuppressWarnings("deprecation")
	SessionFactory sessionFactory = config.buildSessionFactory();
	@Override
	public void insertHotel(Hotel hotel) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		try {	
			Transaction tx=session.beginTransaction();	
			session.save(hotel);
	       tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		session.close();
	}

	@Override
	public Hotel getHotelByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateHotel(Hotel hotel) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Hotel> getAllHotel() {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		List<Hotel> hotellist=null;
		try {	
			Transaction tx=session.beginTransaction();	
			String hql = "from Hotel h  ";
			Query query = session.createQuery(hql);	
			hotellist = query.list();
	       tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		session.close();
		return hotellist;
	}

	@Override
	public Hotel getHotelById(String id) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Hotel hotel=null;
		try {
			Transaction tx=session.beginTransaction();	
			String hql = "from Hotel a  where a.id="+ id;
			Query query = session.createQuery(hql);	
			List list = query.list();
           if(list.size()!=0){
        	   hotel=(Hotel) list.get(0);
           }
           tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		session.close();
		return hotel;
	}

}
