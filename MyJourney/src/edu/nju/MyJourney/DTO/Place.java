package edu.nju.MyJourney.DTO;

import java.io.Serializable;
import java.sql.Date;

import edu.nju.MyJourney.model.Attraction;
import edu.nju.MyJourney.model.Hotel;
import edu.nju.MyJourney.model.Restaurant;

public class Place implements Serializable {
private Date time;
private Hotel hotel;
private Restaurant restaurant;
private Attraction attraction;
private String traffic;
public Date getTime() {
	return time;
}

public void setTime(Date time) {
	this.time = time;
}

public Hotel getHotel() {
	return hotel;
}

public void setHotel(Hotel hotel) {
	this.hotel = hotel;
}

public Restaurant getRestaurant() {
	return restaurant;
}

public void setRestaurant(Restaurant restaurant) {
	this.restaurant = restaurant;
}

public Attraction getAttraction() {
	return attraction;
}

public void setAttraction(Attraction attraction) {
	this.attraction = attraction;
}

public String getTraffic() {
	return traffic;
}

public void setTraffic(String traffic) {
	this.traffic = traffic;
}
}
