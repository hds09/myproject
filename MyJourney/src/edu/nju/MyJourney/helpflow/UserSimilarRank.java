package edu.nju.MyJourney.helpflow;

import edu.nju.MyJourney.model.User;

public class UserSimilarRank implements Comparable<UserSimilarRank>{
	private User user;
	private double rank;
	
	@Override
	public int compareTo(UserSimilarRank o) {
		// TODO Auto-generated method stub
		if(this.rank>o.getRank()){
			return 1;
		}else if(this.rank<o.getRank()){
			return -1;
		}else
			return 0;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public double getRank() {
		return rank;
	}
	public void setRank(double rank) {
		this.rank = rank;
	}
}
