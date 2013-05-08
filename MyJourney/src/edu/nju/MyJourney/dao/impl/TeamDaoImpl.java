package edu.nju.MyJourney.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

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
	
}
}
