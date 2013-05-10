package edu.nju.MyJourney.service;

import edu.nju.MyJourney.model.Attraction;
import edu.nju.MyJourney.model.City;

public interface AttractionService {
public void insertAttraction(Attraction attraction);
public void updateAttraction(Attraction attraction);
public Attraction getBestAttraction(City city);
}
