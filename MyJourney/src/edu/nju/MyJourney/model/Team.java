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
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;


@Entity
@Table(name="team")
public class Team {
private long tid;
private String TeamName;
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

@LazyCollection(LazyCollectionOption.FALSE)
@ManyToMany(mappedBy="team")  
@Cascade(value={org.hibernate.annotations.CascadeType.SAVE_UPDATE})
public List<User> getUsers() {
	if(this.users==null){
		return new ArrayList<User>();
	}
	return users;
}

public void setUsers(List<User> users) {

	this.users = users;
}

public void removeUsers(User u){
	if(!this.users.contains(u)){
		this.users.add(u);
	}
}

@LazyCollection(LazyCollectionOption.FALSE)
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

public String getTeamName() {
	return TeamName;
}

public void setTeamName(String teamName) {
	TeamName = teamName;
}




}
