package edu.nju.MyJourney.service;

import java.util.List;

import edu.nju.MyJourney.model.Comment;

public interface CommentService {
	public List<Comment> getCommentsByUserId(String id);
	public void insertComment(Comment comment);
}
