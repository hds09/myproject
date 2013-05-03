package edu.nju.MyJourney.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name="place")
public class Place{
private long id;
private String time;
private Hotel hotel;
private Restaurant restaurant;
private Attraction attraction;
private City city;
private List<Picture> images;
private Journey journey;
private String traffic;
private int halfday;

@ManyToOne( optional=true)
@Cascade(value={org.hibernate.annotations.CascadeType.SAVE_UPDATE}) 
@JoinColumn(name="place_hotel")
public Hotel getHotel() {
	return hotel;
}

public void setHotel(Hotel hotel) {
	this.hotel = hotel;
}
@ManyToOne( optional=true)
@Cascade(value={org.hibernate.annotations.CascadeType.SAVE_UPDATE}) 
@JoinColumn(name="place_restaurant")
public Restaurant getRestaurant() {
	return restaurant;
}

public void setRestaurant(Restaurant restaurant) {
	this.restaurant = restaurant;
}
@ManyToOne(optional=true)
@Cascade(value={org.hibernate.annotations.CascadeType.SAVE_UPDATE}) 
@JoinColumn(name="place_Attraction")
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

public int getHalfday() {
	return halfday;
}

public void setHalfday(int halfday) {
	this.halfday = halfday;
}

@ManyToOne( optional=true)
@Cascade(value={org.hibernate.annotations.CascadeType.SAVE_UPDATE}) 
@JoinColumn(name="place_city")
public City getCity() {
	return city;
}

public void setCity(City city) {
	this.city = city;
}
@Id
@GeneratedValue
public long getId() {
	return id;
}

public void setId(long id) {
	this.id = id;
}
@ManyToOne( optional=true)
@JoinColumn(name="place_journey")
public Journey getJourney() {
	return journey;
}

public void setJourney(Journey journey) {
	this.journey = journey;
}
@OneToMany(mappedBy="place",  fetch=FetchType.LAZY)
@Cascade(value={org.hibernate.annotations.CascadeType.SAVE_UPDATE}) 
@OrderBy(value="id ASC")
public List<Picture> getImages() {
	return images;
}

public void setImages(List<Picture> images) {
	this.images = images;
}
public void addImages(Picture f){
	if(! this.images.contains(f)){
	this.images.add(f);
	f.setPlace(this);
	}
}

public void removeImages(Picture f){
	f.setPlace(null);
	this.images.remove(f);
}

public String getTime() {
	return time;
}

public void setTime(String time) {
	this.time = time;
}
}
