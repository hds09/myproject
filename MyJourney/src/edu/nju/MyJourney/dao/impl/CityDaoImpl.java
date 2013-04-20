package edu.nju.MyJourney.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import edu.nju.MyJourney.dao.CityDao;
import edu.nju.MyJourney.model.City;
import edu.nju.MyJourney.model.Place;

public class CityDaoImpl implements CityDao {
	Configuration config = new Configuration().configure();
	@SuppressWarnings("deprecation")
	SessionFactory sessionFactory = config.buildSessionFactory();
	@Override
	public void insertCity(City city) {
		// TODO Auto-generated method stub
   Session session=sessionFactory.openSession();
	try {	
		Transaction tx=session.beginTransaction();	
		session.save(city);
       tx.commit();
	} catch (Exception e) {
		e.printStackTrace();
	}
	session.close();
	}

	@Override
	public List<City> getAllCity() {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		List<City> citylist=null;
		try {	
			Transaction tx=session.beginTransaction();	
			String hql = "from City c  ";
			Query query = session.createQuery(hql);	
			 citylist = query.list();
	       tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		session.close();
		return citylist;
	}

	@Override
	public City getCityByName(String name) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		City city=null;
		try {	
			Transaction tx=session.beginTransaction();	
			String hql = "from City c where c.name='"+name+"'";
			Query query = session.createQuery(hql);	
			 List list = query.list();
			 if(list.size()!=0){
				 city=(City)list.get(0);
			 }
	       tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		session.close();
		return city;
	}

	@Override
	public void updateCity(City city) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public City getCityByPoint(String point) {
		// TODO Auto-generated method stub
		String tmp[]=point.split(",");
		Session session=sessionFactory.openSession();
		City city=null;
		try {	
			Transaction tx=session.beginTransaction();	
			String hql = "from City c where c.lat='"+tmp[0]+"' and c.lng='"+tmp[1]+"'";
			Query query = session.createQuery(hql);	
			 List list = query.list();
			 if(list.size()!=0){
				 city=(City)list.get(0);
			 }
	       tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		session.close();
		return city;
	}

}
