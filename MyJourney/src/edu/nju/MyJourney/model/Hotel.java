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
@Table(name="hotel")
public class Hotel {
private long id;
private String name;
private City city;
private String address;
private String phone;
private float price = 0.0f;
private boolean favor;
private boolean dislike;
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
@JoinColumn(name="hotelOwner")
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


public boolean isFavor() {
	return favor;
}

public void setFavor(boolean favor) {
	this.favor = favor;
}

public boolean isDislike() {
	return dislike;
}

public void setDislike(boolean dislike) {
	this.dislike = dislike;
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
	f.setHotel(this);
	}
}

public void removeComments(Comment f){
	f.setHotel(null);
	this.comments.remove(f);
}
@OneToMany(mappedBy="hotel", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
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
	f.setHotel(this);
	}
}

public void removePlace(Place f){
	f.setHotel(null);
	this.places.remove(f);
}

public float getPrice() {
	return price;
}

public void setPrice(float price) {
	this.price = price;
}
}
