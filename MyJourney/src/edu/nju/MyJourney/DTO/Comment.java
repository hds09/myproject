package edu.nju.MyJourney.DTO;

import java.io.Serializable;

import javax.persistence.Embeddable;

public class Comment implements Serializable {
private String account;
private String context;
public String getAccount() {
	return account;
}
public void setAccount(String account) {
	this.account = account;
}
public String getContext() {
	return context;
}
public void setContext(String context) {
	this.context = context;
}
}
