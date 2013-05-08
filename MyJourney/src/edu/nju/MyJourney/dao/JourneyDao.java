package edu.nju.MyJourney.dao;

import java.util.List;

import edu.nju.MyJourney.model.Journey;
import edu.nju.MyJourney.model.User;

public interface JourneyDao {
  public void insertJoueney(Journey journey);
  public Journey getJourneyById(long id);
  public Journey getJourneyByUserObj(User user);
  public List<Journey> getJourneyByPage(int start,int length);
  public void updateJourney(Journey journey);
  public List<Journey> getAllJourneys();
  public void deleteJourneyById(String id);
}
