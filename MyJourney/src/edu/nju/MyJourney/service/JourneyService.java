package edu.nju.MyJourney.service;

import java.util.List;

import edu.nju.MyJourney.model.Journey;
import edu.nju.MyJourney.model.Place;

public interface JourneyService {
public void insertJourney(Journey journey);
public Journey getJourneyById(long id);
public List<Place> getMorningPlaceByUserId(long id);
public List<Place> getAfternoonPlaceByUserId(long id);
public void updateJourney(Journey journey);
public List<Journey> getAllJourneys();
public void deleteJourneyById(String id);
}
