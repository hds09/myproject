package edu.nju.MyJourney.service;

import java.util.List;

import edu.nju.MyJourney.model.Hotel;

public interface HotelService {
public void insertHotel(Hotel hotel);
public void updateHotel(Hotel hotel);
public Hotel getHotelById(String id);
public List<Hotel> getAllHotels();
}
