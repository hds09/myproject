package edu.nju.MyJourney.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.jdbc.Work;
import org.springframework.orm.hibernate4.SessionFactoryUtils;

import edu.nju.MyJourney.dao.CommentDao;
import edu.nju.MyJourney.model.City;
import edu.nju.MyJourney.model.Comment;
import edu.nju.MyJourney.model.Hotel;
import edu.nju.MyJourney.model.Restaurant;

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
	public void insertComment(Comment comment) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		final String update="insert into comment(context,comments_attraction,comments_hotel,comments_restaurant,comments_user) values ('"+comment.getContext()+"',"+comment.getAttraction().getId()+","+comment.getHotel().getId()+","+comment.getRestaurant().getId()+","+comment.getUser().getUid()+")";
		System.out.println(update);
		Work work=new Work(){
			@Override
			public void execute(Connection connection) throws SQLException {
				   PreparedStatement stmt=connection
				   .prepareStatement(update);
				   stmt.executeUpdate();
			}
	   };
	   session.doWork(work);
	   session.close();
	}
	@Override
	public List<Comment> getHotelComments(Hotel hotel) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Comment> getRestaurantComments(Restaurant restaurant) {
		// TODO Auto-generated method stub
		return null;
	}

}
