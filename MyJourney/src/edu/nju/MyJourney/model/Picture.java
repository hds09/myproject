package edu.nju.MyJourney.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="picture")
public class Picture {
private long id;
private String imagepath;
private String context;
private String soundpath;
private Place place;
@Id
@GeneratedValue
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getImagepath() {
	return imagepath;
}
public void setImagepath(String imagepath) {
	this.imagepath = imagepath;
}

public String getContext() {
	return context;
}
public void setContext(String context) {
	this.context = context;
}
public String getSoundpath() {
	return soundpath;
}
public void setSoundpath(String soundpath) {
	this.soundpath = soundpath;
}
@ManyToOne(cascade=CascadeType.ALL, optional=false)
@JoinColumn(name="image_place")
public Place getPlace() {
	return place;
}
public void setPlace(Place place) {
	this.place = place;
}
}
