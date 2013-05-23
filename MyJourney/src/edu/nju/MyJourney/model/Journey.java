package edu.nju.MyJourney.model;

import java.util.ArrayList;
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

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;


@Entity
@Table(name="journey")
public class Journey {
private static final int UNSTART=1;
private static final int UNDERWAY=1;
private static final int ENDED=1;
private long id;
private User user;
private String journeyName;
private Team team;
private int state;


private List<Place> places;

@Id
@GeneratedValue
public long getId() {
	return id;
}

public void setId(long id) {
	this.id = id;
}
@ManyToOne( optional=true)

@LazyCollection(LazyCollectionOption.FALSE)
@JoinColumn(name="journeyOwner")
public User getUser() {
	return user;
}

public void setUser(User user) {
	this.user = user;
}

@LazyCollection(LazyCollectionOption.FALSE)
@OneToMany(mappedBy="journey")
@OrderBy(value="id ASC")
public List<Place> getPlaces() {
	if(places==null){
		places=new ArrayList<Place>();
	}
	return places;
}

public void setPlaces(List<Place> places) {
	this.places = places;
}

public void addPlace(Place f){
	if(! this.getPlaces().contains(f)){
	this.getPlaces().add(f);
	f.setJourney(this);
	}
}

public void removePlace(Place f){
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
public int getState() {
	return state;
}

public void setState(int state) {
	this.state = state;
}

}
