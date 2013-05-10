package edu.nju.MyJourney.service;

import edu.nju.MyJourney.model.City;
import edu.nju.MyJourney.model.Hotel;

public interface HotelService {
public void insertHotel(Hotel hotel);
public void updateHotel(Hotel hotel);
public Hotel getBestHotel(City city);
}
