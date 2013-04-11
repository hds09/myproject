package edu.nju.MyJourney.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;


@Entity
@Table(name="team")
public class Team {
private long tid;

private Journey journey;
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

@OneToOne(cascade = CascadeType.ALL)
@JoinColumn(name = "Jid")
public Journey getJourney() {
	return journey;
}

public void setJourney(Journey journey) {
	this.journey = journey;
}

public void addJourney(Journey f){
	this.journey = f;
	journey.setTeam(this);
}
public void removeJourney(Journey f){
	f.setTeam(null);
	this.setJourney(null);
}




}
