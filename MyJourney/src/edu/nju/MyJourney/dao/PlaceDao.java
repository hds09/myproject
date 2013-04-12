package edu.nju.MyJourney.dao;

import edu.nju.MyJourney.model.Place;

public interface PlaceDao {
  public void insertPlace(Place place);
  public void updatePlace(Place place);
  public Place getPlaceById(long id);
}
