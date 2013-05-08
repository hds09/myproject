package edu.nju.MyJourney.service.impl;

import java.util.List;

import edu.nju.MyJourney.dao.DarenDao;
import edu.nju.MyJourney.helperModel.Daren;
import edu.nju.MyJourney.service.DarenService;

public class DarenServiceImpl implements DarenService {
	private DarenDao darenDao;
	@Override
	public List<Daren> getDarens(int page,int pageSize) {
		return darenDao.getDarens(page, pageSize);
	}
	public DarenDao getDarenDao() {
		return darenDao;
	}
	public void setDarenDao(DarenDao darenDao) {
		this.darenDao = darenDao;
	}
	@Override
	public int getDarensPageMax(int pageSize) {
		return darenDao.getDarensPageMax(pageSize);
	}

}
