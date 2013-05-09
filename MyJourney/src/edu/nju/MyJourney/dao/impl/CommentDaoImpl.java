package edu.nju.MyJourney.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import edu.nju.MyJourney.dao.CommentDao;
import edu.nju.MyJourney.model.City;
import edu.nju.MyJourney.model.Comment;

public class CommentDaoImpl implements CommentDao{
	Configuration config = new Configuration().configure();
	@SuppressWarnings("deprecation")
	SessionFactory sessionFactory = config.buildSessionFactory();
	@Override
	public List<Comment> getCommentsByUserId(String id) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		List<Comment> comments=null;
		try {	
			Transaction tx=session.beginTransaction();	
			String hql = "from Comment c where c.user.id='"+id+"'";
			Query query = session.createQuery(hql);	
			 List list = query.list();
			 comments=(List<Comment>)list;
	       tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		session.close();
		return comments;
	}
	@Override
	public void insertComment(Comment c) {
		// TODO Auto-generated method stub
		 Session session=sessionFactory.openSession();
			try {	
				Transaction tx=session.beginTransaction();
				session.saveOrUpdate(c);
				session.save(c);
		       tx.commit();
			} catch (Exception e) {
				e.printStackTrace();
			}
			session.close();
	}

}
