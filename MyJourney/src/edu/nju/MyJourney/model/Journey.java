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
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;


@Entity
@Table(name="journey")
public class Journey {
private long id;
private User user;
private String journeyName;
private Team team;
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
@OneToMany(mappedBy="journey", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
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
	f.setJourney(this);
	}
}

public void removeRestaurant(Attraction f){
	f.setCity(null);
	this.places.remove(f);
}
public String getJourneyName() {
	return journeyName;
}

public void setJourneyName(String journeyName) {
	this.journeyName = journeyName;
}
@OneToOne(mappedBy = "journey")
public Team getTeam() {
	return team;
}

public void setTeam(Team team) {
	this.team = team;
}


}
