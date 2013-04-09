package edu.nju.MyJourney.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import edu.nju.MyJourney.DTO.Place;

@Entity
@Table(name="team")
public class Team {
private long tid;
private String teamJourneyName;
private List<Place> places;
//private List<Long> journeyid;
private List<User> users;
@Id
@GeneratedValue
public long getTid() {
	return tid;
}

public void setTid(long id) {
	this.tid = id;
}


@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE },  
fetch = FetchType.LAZY, mappedBy="team")     
public List<User> getUsers() {
	return users;
}

public void setUsers(List<User> users) {
	this.users = users;
}
@ElementCollection
public List<Place> getPlaces() {
	return places;
}

public void setPlaces(List<Place> places) {
	this.places = places;
}

public String getTeamJourneyName() {
	return teamJourneyName;
}

public void setTeamJourneyName(String teamJourneyName) {
	this.teamJourneyName = teamJourneyName;
}





}
