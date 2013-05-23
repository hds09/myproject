package edu.nju.MyJourney.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name="comment")
public class Comment {
private long id;
private User user;
private String context;
private Attraction attraction;
private Hotel hotel;
private Restaurant restaurant;

@Id
@GeneratedValue
public long getId() {
	return id;
}

public void setId(long id) {
	this.id = id;
}


public String getContext() {
	return context;
}
public void setContext(String context) {
	this.context = context;
}

@LazyCollection(LazyCollectionOption.FALSE)
@ManyToOne(cascade=CascadeType.ALL, optional=true)
@JoinColumn(name="comments_user")

public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}

@LazyCollection(LazyCollectionOption.FALSE)
@ManyToOne(cascade=CascadeType.ALL, optional=true)
@JoinColumn(name="comments_attraction")
public Attraction getAttraction() {
	return attraction;
}

public void setAttraction(Attraction attraction) {
	this.attraction = attraction;
}

@LazyCollection(LazyCollectionOption.FALSE)
@ManyToOne(cascade=CascadeType.ALL, optional=true)
@JoinColumn(name="comments_hotel")
public Hotel getHotel() {
	return hotel;
}
public void setHotel(Hotel hotel) {
	this.hotel = hotel;
}
@LazyCollection(LazyCollectionOption.FALSE)
@ManyToOne(cascade=CascadeType.ALL, optional=true)
@JoinColumn(name="comments_restaurant")
public Restaurant getRestaurant() {
	return restaurant;
}
public void setRestaurant(Restaurant restaurant) {
	this.restaurant = restaurant;
}
}
