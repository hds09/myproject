package edu.nju.MyJourney.service.impl;

import java.util.List;

import edu.nju.MyJourney.dao.CommentDao;
import edu.nju.MyJourney.model.Comment;
import edu.nju.MyJourney.model.Hotel;
import edu.nju.MyJourney.model.Restaurant;
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
	@Override
	public List<Comment> getHotelComments(Hotel hotel) {
		// TODO Auto-generated method stub
		return this.commentDao.getHotelComments(hotel);
	}
	@Override
	public List<Comment> getRestaurantComments(Restaurant restaurant) {
		// TODO Auto-generated method stub
		return this.commentDao.getRestaurantComments(restaurant);
	}

}
