package edu.nju.MyJourney.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import edu.nju.MyJourney.dao.ReplayDao;
import edu.nju.MyJourney.model.Place;
import edu.nju.MyJourney.model.Reply;

public class ReplyDaoImpl implements ReplayDao {

	Configuration config = new Configuration().configure();
	@SuppressWarnings("deprecation")
	SessionFactory sessionFactory = config.buildSessionFactory();
	@Override
	public boolean insertReply(Reply reply) {
		Session session=sessionFactory.openSession();
		try {	
			Transaction tx=session.beginTransaction();	
			session.save(reply);
            tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		session.close();
		return true;
	}

}
