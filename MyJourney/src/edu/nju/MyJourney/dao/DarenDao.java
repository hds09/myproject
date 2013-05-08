package edu.nju.MyJourney.dao;

import java.util.List;

import edu.nju.MyJourney.helperModel.Daren;


public interface DarenDao {
	public List<Daren> getDarens(int page,int pageSize);
	public int getDarensPageMax(int pageSize);
}
