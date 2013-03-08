package edu.nju.MyJourney.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

@Entity
@Table(name="city")
public class City {
private int cid;
private String name;
private String country;
private List<Attraction> attractions;
private List<Hotel> hotels;
private List<Restaurant> restaurants;
@Id
@GeneratedValue
public int getCid() {
	return cid;
}

public void setCid(int cid) {
	this.cid = cid;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getCountry() {
	return country;
}

public void setCountry(String country) {
	this.country = country;
}

@OneToMany(mappedBy="city", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
@OrderBy(value="id ASC")
public List<Attraction> getAttractions() {
	return attractions;
}

public void setAttractions(List<Attraction> attractions) {
	this.attractions = attractions;
}
@OneToMany(mappedBy="city", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
@OrderBy(value="id ASC")
public List<Hotel> getHotels() {
	return hotels;
}

public void setHotels(List<Hotel> hotels) {
	this.hotels = hotels;
}
@OneToMany(mappedBy="city", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
@OrderBy(value="id ASC")
public List<Restaurant> getRestaurants() {
	return restaurants;
}

public void setRestaurants(List<Restaurant> restaurants) {
	this.restaurants = restaurants;
}

}
