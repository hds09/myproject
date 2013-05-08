package edu.nju.MyJourney.service;

import java.util.List;

import edu.nju.MyJourney.helperModel.Daren;



public interface DarenService {
	public List<Daren> getDarens(int page,int pageSize);
	public int getDarensPageMax(int pageSize);
}
