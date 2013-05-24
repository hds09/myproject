package edu.nju.MyJourney.service.impl;

import edu.nju.MyJourney.dao.TeamDao;
import edu.nju.MyJourney.model.Team;
import edu.nju.MyJourney.service.TeamService;

public class TeamServiceImpl implements TeamService {
    private TeamDao teamDao;
	@Override
	public void insertTeam(Team team) {
		// TODO Auto-generated method stub
        teamDao.insertTeam(team);
	}

	@Override
	public void updateTeam(Team team) {
		// TODO Auto-generated method stub
         teamDao.updateTeam(team);
	}

	public TeamDao getTeamDao() {
		return teamDao;
	}

	public void setTeamDao(TeamDao teamDao) {
		this.teamDao = teamDao;
	}

	@Override
	public void joinTeam(String uid, String tid) {
		// TODO Auto-generated method stub
		this.teamDao.joinTeam(uid, tid);
	}

	@Override
	public void kickUserFromTeam(String uid, String tid) {
		// TODO Auto-generated method stub
		this.teamDao.kickUserFromTeam(uid, tid);
	}

}
