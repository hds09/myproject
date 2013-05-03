package edu.nju.MyJourney.model;

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


@Entity
@Table(name="restaurant")
public class Restaurant {
private long id;
private String name;
private City city;
private String address;
private String phone;
private float price = 0.0f;
private int favor;
private int dislike;
private List<Comment> comments;
private List<Place> places;
@Id
@GeneratedValue

public long getId() {
	return id;
}

public void setId(long id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}
@ManyToOne(cascade=CascadeType.ALL, optional=false)
@JoinColumn(name="restaurantOwner")
public City getCity() {
	return city;
}

public void setCity(City city) {
	this.city = city;
}

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}

public String getPhone() {
	return phone;
}

public void setPhone(String phone) {
	this.phone = phone;
}



@OneToMany(mappedBy="hotel", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
@OrderBy(value="id ASC")
public List<Comment> getComments() {
	return comments;
}

public void setComments(List<Comment> comments) {
	this.comments = comments;
}
public void addComments(Comment f){
	if(! this.comments.contains(f)){
	this.comments.add(f);
	f.setRestaurant(this);
	}
}

public void removeComments(Comment f){
	f.setRestaurant(null);
	this.comments.remove(f);
}
@OneToMany(mappedBy="restaurant", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
@OrderBy(value="id ASC")
public List<Place> getPlaces() {
	return places;
}

public void setPlaces(List<Place> places) {
	this.places = places;
}
public void addPlace(Place f){
	if(! this.places.contains(f)){
	this.places.add(f);
	f.setRestaurant(this);
	}
}

public void removePlace(Place f){
	f.setRestaurant(null);
	this.places.remove(f);
}

public int getFavor() {
	return favor;
}

public void setFavor(int favor) {
	this.favor = favor;
}

public int getDislike() {
	return dislike;
}

public void setDislike(int dislike) {
	this.dislike = dislike;
}

public float getPrice() {
	return price;
}

public void setPrice(float price) {
	this.price = price;
}
}
