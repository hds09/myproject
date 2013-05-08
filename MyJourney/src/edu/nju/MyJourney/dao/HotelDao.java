package edu.nju.MyJourney.dao;

import java.util.List;

import edu.nju.MyJourney.model.Hotel;

public interface HotelDao {
public void insertHotel(Hotel hotel);
public Hotel getHotelByName(String name);
public void updateHotel(Hotel hotel);
public List<Hotel> getAllHotel();
public Hotel getHotelById(String id);
}
