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

import edu.nju.MyJourney.DTO.Place;

@Entity
@Table(name="journey")
public class Journey {
private long id;
private User user;
private String journeyName;
private boolean state;
private List<Place> places;
@Id
@GeneratedValue
public long getId() {
	return id;
}

public void setId(long id) {
	this.id = id;
}
@ManyToOne(cascade=CascadeType.ALL, optional=false)
@JoinColumn(name="journeyOwner")
public User getUser() {
	return user;
}

public void setUser(User user) {
	this.user = user;
}

public boolean isState() {
	return state;
}

public void setState(boolean state) {
	this.state = state;
}
@ElementCollection 
public List<Place> getPlaces() {
	return places;
}

public void setPlaces(List<Place> places) {
	this.places = places;
}

public String getJourneyName() {
	return journeyName;
}

public void setJourneyName(String journeyName) {
	this.journeyName = journeyName;
}


}
