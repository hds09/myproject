package edu.nju.MyJourney.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import edu.nju.MyJourney.dao.DarenDao;
import edu.nju.MyJourney.helperModel.Daren;
import edu.nju.MyJourney.model.User;

public class DarenDaoImpl implements DarenDao {
	Configuration config = new Configuration().configure();
	@SuppressWarnings("deprecation")
	SessionFactory sessionFactory = config.buildSessionFactory();
//	SessionFactory sessionFactory;

	/* 
	 * @see edu.nju.MyJourney.dao.DarenDao#getDarens(int)
	 */
	@Override
	public List<Daren> getDarens(int page,int pageSize) {
		
		Session session=sessionFactory.openSession();
		List<Daren> result = new ArrayList<Daren>();
		try{
			Transaction tx=session.beginTransaction();
			String hql = "from User u";
			Query query = session.createQuery(hql);
			query.setFirstResult(page*pageSize);
			query.setMaxResults(pageSize);
			List<User> userList = query.list();
			System.out.println("用户列表有"+userList.size());
			if(userList.size() != 0){
				for(User u: userList){
					result.add(new Daren().convertFromUser(u));
				}
			}
	        tx.commit();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return result;
	}

	@Override
	public int getDarensPageMax(int pageSize) {
		Session session = sessionFactory.openSession();
		int result = 0;
		try{
			Transaction tx=session.beginTransaction();
			String hql = "from User u";
			Query query = session.createQuery(hql);
			int total = query.list().size();
			if(total%pageSize == 0){
				result = total/pageSize;
			}else{
				result = total/pageSize+1;
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return result;
	}


	
}
