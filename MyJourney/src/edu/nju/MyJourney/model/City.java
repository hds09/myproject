package edu.nju.MyJourney.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name="city")
public class City {
private int cid;
private String lng;
private String lat;
private String name;
private String country;
private String picture;
private List<Attraction> attractions;
private List<Hotel> hotels;
private List<Restaurant> restaurants;
private List<Place> places;
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
@LazyCollection(LazyCollectionOption.FALSE)
@OneToMany(mappedBy="city")
@Cascade(value={org.hibernate.annotations.CascadeType.SAVE_UPDATE}) 
@OrderBy(value="id ASC")
public List<Attraction> getAttractions() {
	return attractions;
}

public void setAttractions(List<Attraction> attractions) {
	this.attractions = attractions;
}
public void addAttraction(Attraction f){
	if(! this.attractions.contains(f)){
	this.attractions.add(f);
	f.setCity(this);
	}
}

public void removeAttraction(Attraction f){
	f.setCity(null);
	this.attractions.remove(f);
}

@LazyCollection(LazyCollectionOption.FALSE)
@OneToMany(mappedBy="city")
@Cascade(value={org.hibernate.annotations.CascadeType.SAVE_UPDATE}) 
@OrderBy(value="id ASC")
public List<Hotel> getHotels() {
	return hotels;
}

public void setHotels(List<Hotel> hotels) {
	this.hotels = hotels;
}
public void addHotel(Hotel f){
	if(! this.attractions.contains(f)){
	this.hotels.add(f);
	f.setCity(this);
	}
}

public void removeHotel(Hotel f){
	f.setCity(null);
	this.hotels.remove(f);
}

@LazyCollection(LazyCollectionOption.FALSE)
@OneToMany(mappedBy="city")
@Cascade(value={org.hibernate.annotations.CascadeType.SAVE_UPDATE}) 
@OrderBy(value="id ASC")
public List<Restaurant> getRestaurants() {
	return restaurants;
}

public void setRestaurants(List<Restaurant> restaurants) {
	this.restaurants = restaurants;
}
public void addRestaurants(Restaurant f){
	if(! this.restaurants.contains(f)){
	this.restaurants.add(f);
	f.setCity(this);
	}
}

public void removeRestaurant(Attraction f){
	f.setCity(null);
	this.restaurants.remove(f);
}
public String getLng() {
	return lng;
}

public void setLng(String lng) {
	this.lng = lng;
}

public String getLat() {
	return lat;
}

public void setLat(String lat) {
	this.lat = lat;
}

@LazyCollection(LazyCollectionOption.FALSE)
@OneToMany(mappedBy="city")
@Cascade(value={org.hibernate.annotations.CascadeType.SAVE_UPDATE}) 
@OrderBy(value="id ASC")
public List<Place> getPlaces() {
	if(this.places==null){
		this.places=new ArrayList<Place>();
	}
	return places;
}

public void setPlaces(List<Place> places) {
	this.places = places;
}
public void addPlace(Place f){
	if(! this.getPlaces().contains(f)){
	this.getPlaces().add(f);
	f.setCity(this);
	}
}

public void removePlace(Place f){
	f.setCity(null);
	this.getPlaces().remove(f);
}

public String getPicture() {
	return picture;
}

public void setPicture(String picture) {
	this.picture = picture;
}
}
