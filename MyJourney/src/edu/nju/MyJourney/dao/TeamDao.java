package edu.nju.MyJourney.dao;

import edu.nju.MyJourney.model.Team;

public interface TeamDao {
	public void deleteTeam(Team team);
	public void insertTeam(Team team);
	public void kickUserFromTeam(String uid,String tid);
	public void updateTeam(Team team);
	public void joinTeam(String uid,String tid);
}
