package edu.nju.MyJourney.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="reply")
public class Reply {
private long id;
private String account_from;
private String account_to;
private String context;
private User user;
@Id
@GeneratedValue
public long getId() {
	return id;
}

public void setId(long id) {
	this.id = id;
}

public String getAccount_from() {
	return account_from;
}

public void setAccount_from(String account_from) {
	this.account_from = account_from;
}

public String getContext() {
	return context;
}

public void setContext(String context) {
	this.context = context;
}

public String getAccount_to() {
	return account_to;
}

public void setAccount_to(String account_to) {
	this.account_to = account_to;
}
@ManyToOne(cascade=CascadeType.ALL, optional=false)
@JoinColumn(name="replayOwner")
public User getUser() {
	return user;
}

public void setUser(User user) {
	this.user = user;
}
}
