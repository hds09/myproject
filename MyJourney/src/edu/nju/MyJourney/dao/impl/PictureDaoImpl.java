package edu.nju.MyJourney.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import edu.nju.MyJourney.model.Picture;
import edu.nju.MyJourney.model.Place;

public class PictureDaoImpl {
	Configuration config = new Configuration().configure();
	@SuppressWarnings("deprecation")
	SessionFactory sessionFactory = config.buildSessionFactory();
	public void insert(Picture picture){
		Session session=sessionFactory.openSession();
		try {
			Transaction tx=session.beginTransaction();	
			session.save(picture);
            tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		session.close();
	}
	public List<Picture> getAllPicture(){
		List<Picture> pictureList=null;
		Session session=sessionFactory.openSession();
		try {	
			Transaction tx=session.beginTransaction();	
			String hql = "from Picture";
			Query query = session.createQuery(hql);	
			pictureList = query.list();
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		session.close();
		return pictureList;
	}
}
