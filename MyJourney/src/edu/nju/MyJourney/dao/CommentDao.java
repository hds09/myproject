package edu.nju.MyJourney.dao;

import java.util.List;

import edu.nju.MyJourney.model.Comment;

public interface CommentDao {
	public List<Comment> getCommentsByUserId(String id);
}
