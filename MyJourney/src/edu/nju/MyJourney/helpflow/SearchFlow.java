package edu.nju.MyJourney.helpflow;

import java.util.ArrayList;
import java.util.List;

import edu.nju.MyJourney.dao.UserDao;
import edu.nju.MyJourney.dao.impl.UserDaoImpl;
import edu.nju.MyJourney.model.User;

public class SearchFlow {
	public static ArrayList<User> userSearch(SearchPrepareStatement sps){
		ArrayList<User> result=new ArrayList<User>();
		String searchType=sps.type;
		String keyWord="";
		String field="";
		int sexOption=0;
		int ageOption=0;
		int sortOption=0;
		if(searchType.equals("UserSearch")){
			UserDao dao=new UserDaoImpl();
			List<User> allUsers=dao.getAllUsers();
			System.out.println("fetch all users ...");
			System.out.println("total size: "+allUsers.size());
			keyWord=sps.KEYWORD;
			field=sps.FIELD;
			sexOption=sps.SEXOPTION;
			ageOption=sps.AGEOPTION;
			sortOption=sps.SORTOPTION;
			for(User user:allUsers){
				boolean matched=false;
				//filter 1
				if(field.equals("account")){
					String tgt=user.getAccount();
					if(tgt!=null&&tgt.contains(keyWord)){
						matched=true;
					}
				}else if(field.equals("city")){
					String tgt=user.getCity();
					if(tgt!=null&&tgt.contains(keyWord)){
						matched=true;
					}
				}else if(field.equals("email")){
					String tgt=user.getEmail();
					if(tgt!=null&&tgt.contains(keyWord)){
						matched=true;
					}
				}else if(field.equals("name")){
					String tgt=user.getName();
					if(tgt!=null&&tgt.contains(keyWord)){
						matched=true;
					}
				}else if(field.equals("all")){
					if(user.getName()!=null&&user.getName().contains(keyWord)){
						matched=true;
					}else if(user.getEmail()!=null&&user.getEmail().contains(keyWord)){
						matched=true;
					}else if(user.getAccount()!=null&&user.getAccount().contains(keyWord)){
						matched=true;
					}else if(user.getCity()!=null&&user.getCity().contains(keyWord)){
						matched=true;
					}
				}else{
					System.out.println("field not supported ...");
				}
				//filter 2
				if(sexOption==1){
					if(user.getSex()==0){
						matched=false;
					}
				}else if(sexOption==2){
					if(user.getSex()==1){
						matched=false;
					}
				}
				//filter 3
				if(ageOption==1){
					if(user.getAge()>20){
						matched=false;
					}
				}else if(ageOption==2){
					if(20>=user.getAge()||user.getAge()>40){
						matched=false;
					}
				}else if(ageOption==3){
					if(40>=user.getAge()||user.getAge()>60){
						matched=false;
					}
				}else if(ageOption==4){
					if(60>=user.getAge()){
						matched=false;
					}
				}
				
				//
				if(matched){
					result.add(user);
				}
			}
//			if(sortOption!=0){
//				result=sortByAge(result);
//			}
		}else{
			System.out.println("search type: "+searchType+" is not supported");
		}
		return result;
	}
	
	private static ArrayList<User> sortByAge(ArrayList<User> users){
		ArrayList<User> result=new ArrayList<User>();
		if(users.size()==0||users.size()==1)
			return users;
		for(User user:users){
			int age=user.getAge();
			
		}
		return result;
	}
}
