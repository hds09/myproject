package edu.nju.MyJourney.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import edu.nju.MyJourney.dao.AdministratorDao;
import edu.nju.MyJourney.model.Administrator;
import edu.nju.MyJourney.model.User;

public class AdministratorDaoImpl implements AdministratorDao{
	Configuration config = new Configuration().configure();
	@SuppressWarnings("deprecation")
	SessionFactory sessionFactory = config.buildSessionFactory();
	
	@Override
	public boolean login(String uemail, String password) {
		Session session=sessionFactory.openSession();
		Administrator admin=null;
		try {
			Transaction tx=session.beginTransaction();	
			String hql = "from Administrator a  where a.email="
					+ "'"+uemail+"'";
			Query query = session.createQuery(hql);	
			List list = query.list();
           if(list.size()!=0){
        	   admin=(Administrator) list.get(0);
           }else{
        	   return false;
           }
           tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		session.close();
		if(admin.getPassword().equals(password)){
			return true;
		}else{
			return false;
		}
		
	}

}
