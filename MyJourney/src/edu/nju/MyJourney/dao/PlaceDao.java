package edu.nju.MyJourney.dao;

import java.util.List;

import edu.nju.MyJourney.model.Place;

public interface PlaceDao {
  public void insertPlace(Place place);
  public void updatePlace(Place place);
  public Place getPlaceById(long id);
  public void updatePlaceFdp(Place place);
  public List<Place> getAllPlace();
}
