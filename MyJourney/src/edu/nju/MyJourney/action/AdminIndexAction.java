package edu.nju.MyJourney.action;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

import edu.nju.MyJourney.model.Comment;
import edu.nju.MyJourney.model.User;
import edu.nju.MyJourney.service.CommentService;
import edu.nju.MyJourney.service.UserService;

public class AdminIndexAction extends BaseAction{
	private UserService userService;
	private CommentService commentService;
	private String uid;
	public String execute() throws Exception {
		String res=SUCCESS;
		ActionContext actionContext = ActionContext.getContext();  
		Map session = actionContext.getSession();
		if((Boolean) session.get("privilege_granted")!=true){
			System.out.println("session_expired!");
			return "false";
		}else{
			List<User> users=userService.getAllUsers();
			session.put("users", users);
			System.out.println(users.size());
			return res;
		}	
	}
	
	public String viewUser() throws Exception {
		ActionContext actionContext = ActionContext.getContext();  
		Map session = actionContext.getSession();
		User user=userService.getUserById(this.uid);
		List<Comment> comments=commentService.getCommentsByUserId(this.uid);
		session.put("view_user", user);
		session.put("user_comments", comments);
		System.out.println("get user id: "+user.getUid());
		String res=SUCCESS;
		return res;
	}
	
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

//	public CommentService getCommentService() {
//		return commentService;
//	}

	public void setCommentService(CommentService commentService) {
		this.commentService = commentService;
	}
}
