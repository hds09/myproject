package edu.nju.MyJourney.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import edu.nju.MyJourney.dao.JourneyDao;
import edu.nju.MyJourney.dao.UserDao;
import edu.nju.MyJourney.helperModel.WallPicture;
import edu.nju.MyJourney.model.Journey;
import edu.nju.MyJourney.model.Picture;
import edu.nju.MyJourney.model.Place;
import edu.nju.MyJourney.model.User;

public class JourneyDaoImpl implements JourneyDao{
	Configuration config = new Configuration().configure();
	@SuppressWarnings("deprecation")
	SessionFactory sessionFactory = config.buildSessionFactory();
	@Override
	public void insertJoueney(Journey journey) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();

		try {
			
			Transaction tx=session.beginTransaction();	
			session.save(journey);
			System.out.println("..................insert journey.................");
           tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}

		session.close();

	}
	@Override
	public Journey getJourneyByUserObj(User user) {
		UserDao userdao=new UserDaoImpl();
		User tmpuser=userdao.getUserByAccount(user.getAccount());
		Session session=sessionFactory.openSession();
		Journey result=null;
		try {	
			Transaction tx=session.beginTransaction();	
			String hql = "from Journey j  where j.user="
					+tmpuser.getUid()+"";
			Query query = session.createQuery(hql);	
	
			List list = query.list();
           if(list.size()!=0){	
        	   result=(Journey) list.get(0);
        	//  Hibernate.initialize(user.getJourney());
           }
	       tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		session.close();
		return result;
	
	}
	@Override
	public List<Journey> getJourneyByPage(int start, int length) {
		Session session=sessionFactory.openSession();
		List<Journey> result=null;
		try {	
			Transaction tx=session.beginTransaction();	
			String hql = "from Journey";
			Query query = session.createQuery(hql);	
			query.setFirstResult(start);
			query.setMaxResults(length);
	
			result = query.list();
          System.out.println(result.size());
	       tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		session.close();
		return result;
	}
	@Override
	public Journey getJourneyById(long id) {
		Session session=sessionFactory.openSession();
		Journey result=null;
		try {	
			Transaction tx=session.beginTransaction();	
			String hql = "from Journey j  where j.id="
					+id;
			Query query = session.createQuery(hql);	
	
			List list = query.list();
           if(list.size()!=0){	
        	   result=(Journey) list.get(0);
        	   Hibernate.initialize(result.getPlaces());
        	   for(Place p:result.getPlaces()){
        		   Hibernate.initialize(p.getImages());
        	   }
           }
	       tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		session.close();
		return result;
	}
	@Override
	public void updateJourney(Journey journey) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();

		try {
			
			Transaction tx=session.beginTransaction();	
			session.merge(journey);
           tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		session.close();
		
	}
	@Override
	public List<Journey> getAllJourneys() {
		// TODO Auto-generated method stub
		List<Journey> journeys=null;
		Session session=sessionFactory.openSession();
		try {	
			Transaction tx=session.beginTransaction();	
			String hql = "from Journey";
			Query query = session.createQuery(hql);	
			journeys = query.list();
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		session.close();
		return journeys;
	}
	@Override
	public void deleteJourneyById(String id) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		try {	
			Transaction tx=session.beginTransaction();	
			Journey j=new JourneyDaoImpl().getJourneyById(Integer.parseInt(id));
			session.delete(j);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}

		session.close();
	}
	
	public List<WallPicture> getWallPictures(int page, int pageSize) {
		Session session=sessionFactory.openSession();
		List<WallPicture> result = new ArrayList<WallPicture>();
		try{
			Transaction tx = session.beginTransaction();
//			String hql = "from Place p";
//			Query query = session.createQuery(hql);
//			query.setFirstResult(page*pageSize);
//			query.setMaxResults(pageSize);
//			List<Place> placeList = query.list();
//			for(Place p:placeList){
//				Hibernate.initialize(p.getJourney());
//				Hibernate.initialize(p.getImages());
//				Hibernate.initialize(p.getJourney().getUser());
//				if(p.getImages()!=null && p.getImages().size()>0){
//					WallPicture wp = new WallPicture();
//					wp.setImage(p.getImages().get(0));
//					wp.setJourneyId(p.getJourney().getId());
//					wp.setJourneyName(p.getJourney().getJourneyName());
//					wp.setState(p.getJourney().getState());
//					wp.setUserAccount(p.getJourney().getUser().getAccount());
//					wp.setUserName(p.getJourney().getUser().getName());
//					result.add(wp);
//				}
//			}
			String hql = "from Journey order by id desc";
			Query query = session.createQuery(hql);
			query.setFirstResult(page*pageSize);
			query.setMaxResults(pageSize);
			List<Journey> journeyList = query.list();
			System.out.println("旅行列表数目："+journeyList.size());
			for(Journey j:journeyList){
				Hibernate.initialize(j.getUser());
				Hibernate.initialize(j.getUser().getAttention());
				Hibernate.initialize(j.getUser().getConcerned());
				Hibernate.initialize(j.getUser().getComments());
				Hibernate.initialize(j.getUser().getMeassage());
				Hibernate.initialize(j.getPlaces());
				for(Place p: j.getPlaces()){
					Hibernate.initialize(p.getImages());
				}

				if(j.getPlaces()!=null && j.getPlaces().size()>0 
						&& j.getPlaces().get(0).getImages()!=null
						&&j.getPlaces().get(0).getImages().size()>0){
					result.add(new WallPicture().convertFromJourney(j));
				}
			}
			if(result.size()<pageSize){
				result.addAll((getWallPictures(page+1, pageSize)).subList(0, pageSize-result.size()));
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
	public List<Journey> getUserJourney(User user, int page, int pageSize) {
		Session session = sessionFactory.openSession();
		List<Journey> result = new ArrayList<Journey>();
		try{
			Transaction tx = session.beginTransaction();
//			String hql = "from Journey j  where j.user="+user.getUid()+"";
			String hql = "from Journey j where j.user="+user.getUid()+" order by j.id desc";
			Query query = session.createQuery(hql);
			query.setFirstResult(page*pageSize);
			query.setMaxResults(pageSize);
			result = (List<Journey>) query.list();
			for(Journey j:result){
				Hibernate.initialize(j.getPlaces());
				for(Place p:j.getPlaces()){
					Hibernate.initialize(p.getCity());
					Hibernate.initialize(p.getImages());
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
	public int getUserJourneyPageMax(User user,int pageSize) {
		Session session = sessionFactory.openSession();
		int result = 0;
		try{
			Transaction tx = session.beginTransaction();
			String hql = "from Journey j order by id desc where j.user="+user.getUid();
			Query query = session.createQuery(hql);
			int total = query.list().size();
			if(total%pageSize == 0){
				result = total/pageSize;
			}else{
				result = total/pageSize;
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
	public int getWallPicturesPageMax(int pageSize) {
		Session session=sessionFactory.openSession();
		int result = 0;
		try{
			Transaction tx = session.beginTransaction();
			String hql = "from Journey order by id desc";
			Query query = session.createQuery(hql);
			int total = query.list().size();
			if(total%pageSize == 0){
				result = total/pageSize;
			}else{
				result = total/pageSize;
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
	public boolean deletePicture(long pictureId) {
		Session session=sessionFactory.openSession();
		try {	
			Transaction tx=session.beginTransaction();	
			String hql = "from Picture p where p.id="+pictureId;
			Query query = session.createQuery(hql);
			List<Picture> pictureList = query.list();
			if(pictureList.size()>0){
				for(Picture p:pictureList){
					if(p.getId() == pictureId){
						session.delete(p);
					}
				}
			}
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		session.close();
		return true;
	}
	

}
