package edu.nju.MyJourney.service.impl;

import java.util.List;

import edu.nju.MyJourney.dao.CommentDao;
import edu.nju.MyJourney.model.Comment;
import edu.nju.MyJourney.service.CommentService;

public class CommentServiceImpl implements CommentService{
	private CommentDao commentDao;
	@Override
	public List<Comment> getCommentsByUserId(String id) {
		// TODO Auto-generated method stub
		return commentDao.getCommentsByUserId(id);
	}
	public CommentDao getCommentDao() {
		return commentDao;
	}
	public void setCommentDao(CommentDao commentDao) {
		this.commentDao = commentDao;
	}
	@Override
	public void insertComment(Comment comment) {
		// TODO Auto-generated method stub
		this.commentDao.insertComment(comment);
	}

}
