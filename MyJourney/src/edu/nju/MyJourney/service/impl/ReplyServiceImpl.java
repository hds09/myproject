package edu.nju.MyJourney.service.impl;

import edu.nju.MyJourney.dao.ReplayDao;
import edu.nju.MyJourney.dao.impl.ReplyDaoImpl;
import edu.nju.MyJourney.model.Reply;
import edu.nju.MyJourney.service.ReplyService;

public class ReplyServiceImpl implements ReplyService{
	ReplayDao replyDao ;
	@Override
	public boolean insertReply(Reply reply) {
		return replyDao.insertReply(reply);
	}
	public ReplayDao getReplyDao() {
		return replyDao;
	}
	public void setReplyDao(ReplayDao replyDao) {
		this.replyDao = replyDao;
	}

}
