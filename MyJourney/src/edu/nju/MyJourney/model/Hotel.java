package edu.nju.MyJourney.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import edu.nju.MyJourney.DTO.Comment;

@Entity
@Table(name="hotel")
public class Hotel {
private long id;
private String name;
private City city;
private String address;
private String phone;
private boolean favor;
private boolean dislike;
private List<Comment> comments;
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
@ElementCollection 
public List<Comment> getComments() {
	return comments;
}

public void setComments(List<Comment> comments) {
	this.comments = comments;
}

}
