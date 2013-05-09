package edu.nju.MyJourney.service;

import java.util.List;

import edu.nju.MyJourney.model.Attraction;

public interface AttractionService {
public void insertAttraction(Attraction attraction);
public void updateAttraction(Attraction attraction);
public Attraction getAttractionById(String id);
public List<Attraction> getAllAttraction();
}
