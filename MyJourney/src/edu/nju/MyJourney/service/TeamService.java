package edu.nju.MyJourney.service;

import edu.nju.MyJourney.model.Team;

public interface TeamService {
public void insertTeam(Team team);
public void updateTeam(Team team);
public void joinTeam(String uid,String tid);
public void kickUserFromTeam(String uid,String tid);
}
