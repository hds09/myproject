package edu.nju.MyJourney.model;

import java.util.List;

import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.CollectionType;
import org.hibernate.annotations.Index;
import org.hibernate.annotations.Type;
import org.hibernate.search.annotations.ContainedIn;
import org.hibernate.search.annotations.IndexedEmbedded;

import edu.nju.MyJourney.DTO.Comment;

@Entity
@Table(name="attraction" )
public class Attraction {
private long id;
private String name;
private City city;
private String address;
private float price = 0.0f;
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
@ElementCollection 
public List<Comment> getComments() {
	return comments;
}

public void setComments(List<Comment> comments) {
	this.comments = comments;
}

public boolean isDislike() {
	return dislike;
}

public void setDislike(boolean dislike) {
	this.dislike = dislike;
}

public boolean isFavor() {
	return favor;
}

public void setFavor(boolean favor) {
	this.favor = favor;
}

public float getPrice() {
	return price;
}

public void setPrice(float price) {
	this.price = price;
}

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}

@ManyToOne(cascade=CascadeType.ALL, optional=false)
@JoinColumn(name="attractionOwner")
public City getCity() {
	return city;
}

public void setCity(City city) {
	this.city = city;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

}
