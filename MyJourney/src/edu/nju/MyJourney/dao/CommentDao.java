package edu.nju.MyJourney.dao;

import java.util.List;

import edu.nju.MyJourney.model.Comment;
import edu.nju.MyJourney.model.Hotel;
import edu.nju.MyJourney.model.Restaurant;

public interface CommentDao {
	public List<Comment> getCommentsByUserId(String id);
	public void insertComment(Comment comment);
	public List<Comment> getHotelComments(Hotel hotel);
	public List<Comment> getRestaurantComments(Restaurant restaurant);
}
