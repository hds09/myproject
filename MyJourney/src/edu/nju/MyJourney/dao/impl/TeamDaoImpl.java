package edu.nju.MyJourney.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.jdbc.Work;

import edu.nju.MyJourney.dao.TeamDao;
import edu.nju.MyJourney.model.Team;
import edu.nju.MyJourney.model.User;

public class TeamDaoImpl implements TeamDao {
	Configuration config = new Configuration().configure();
	@SuppressWarnings("deprecation")
	SessionFactory sessionFactory = config.buildSessionFactory();
	public void insertTeam(Team team){
		 Session session=sessionFactory.openSession();
			try {	
				Transaction tx=session.beginTransaction();	
				session.save(team);
		       tx.commit();
			} catch (Exception e) {
				e.printStackTrace();
			}
		
			session.close();
	}
public void deleteTeam(Team team){
	 Session session=sessionFactory.openSession();
		try {	
			Transaction tx=session.beginTransaction();	
			List<User> users=team.getUsers();
		
			session.delete(team);
	       tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}

		session.close();
}
@Override
public void kickUserFromTeam(String uid, String tid) {
	// TODO Auto-generated method stub
	Session session=sessionFactory.openSession();
	final String update="delete from users_team where uid="+uid+" and tid="+tid+"";
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
public void updateTeam(Team team) {
	// TODO Auto-generated method stub
	 Session session=sessionFactory.openSession();
		try {	
			Transaction tx=session.beginTransaction();	
			session.merge(team);
	       tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		session.close();
}
@Override
public void joinTeam(String uid, String tid) {
	// TODO Auto-generated method stub
	Session session=sessionFactory.openSession();
	final String update="insert into users_team values("+uid+","+tid+")";
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
}
