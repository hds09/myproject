package edu.nju.MyJourney.service;

import java.util.List;

import edu.nju.MyJourney.helperModel.Daren;
import edu.nju.MyJourney.model.Journey;
import edu.nju.MyJourney.model.Picture;
import edu.nju.MyJourney.model.Reply;
import edu.nju.MyJourney.model.User;
public interface HomeService {
	public User getUserByAccount(String account);
	public boolean hasAttention(String account,String attentionAccount);
	public Daren DarenInfo(long id);
	public List<Picture> getUserPicture(int page,int pageSize);
	public List<Journey> getUserJourney(String account,int page,int pageSize);
	public int getUserJourneyPageMax(long uid,int pageSize);
	public List<Daren> getAttention(long uid);
	public List<Daren> getConcerned(long uid);
	public List<Reply> getMessage(long uid);
	public boolean messageLeave(User fromUser,User toUser);
}
