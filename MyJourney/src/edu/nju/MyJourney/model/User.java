package edu.nju.MyJourney.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;







@Entity
@Table(name="user")
public class User {
	public static final int MAN = 1;
	public static final int WOMAN =0;
	private long uid;
	private String email;
	private String pwd;
	private String name;
	private int age;
	private int sex;
	private String city;
	private String phone;
	private List<User> attention;
	private String account;
	private String image;//头像
	private List<User> concerned;
	private List<Journey> journey;
	private List<Team> team;
	private List<Reply> message;
	private List<Comment> comments;
	
	public String getAccount() { 
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Id
	@GeneratedValue	
	public long getUid() {
		return uid;
	}
	
	public void setUid(long id) {
		this.uid = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
	/**
	 * @return the sex
	 */
	public int getSex() {
		return sex;
	}
	/**
	 * @param sex the sex to set
	 */
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	@OneToMany(mappedBy="user",  fetch=FetchType.LAZY)
	@Cascade(value={org.hibernate.annotations.CascadeType.SAVE_UPDATE}) 
	@OrderBy(value="id ASC")
	public List<Journey> getJourney() {
		if(this.journey==null){
			journey=new ArrayList<Journey>();
		}
		return journey;
	}
	public void setJourney(List<Journey> journey) {
		this.journey = journey;
	}
	@ManyToMany(fetch = FetchType.LAZY)   
	@Cascade(value={org.hibernate.annotations.CascadeType.SAVE_UPDATE}) 
	@JoinTable(name="users_Team", joinColumns={@JoinColumn(name="uid")},  
	 inverseJoinColumns={@JoinColumn(name="tid")})   
	public List<Team> getTeam() {
		if(team==null)
			return new ArrayList<Team>();
		return team;
	}
	public void setTeam(List<Team> team) {
		this.team = team;
	}
	public void addTeam(Team p){
		if(!this.getTeam().contains(p)){
			this.getTeam().add(p);
			p.getUsers().add(this);
		}
	}
	public void removeTeam(Team p){
		p.getUsers().remove(this);
		this.team.remove(p);
	}
	@OneToMany(mappedBy="user",  fetch=FetchType.LAZY)
	@Cascade(value={org.hibernate.annotations.CascadeType.SAVE_UPDATE}) 
	@OrderBy(value="id ASC")
	public List<Reply> getMeassage() {
		if(this.message==null){
			this.message=new ArrayList<Reply>();
		}
		return message;
	}
	public void setMeassage(List<Reply> meassage) {
		this.message = meassage;
	}
	@ManyToMany(fetch = FetchType.LAZY)   
	@Cascade(value={org.hibernate.annotations.CascadeType.SAVE_UPDATE}) 
	@JoinTable(name="attention_concerned", joinColumns={@JoinColumn(name="attention_uid")},  
	 inverseJoinColumns={@JoinColumn(name="concern_uid")})  
	public List<User> getAttention() {
		return attention;
	}
	public void setAttention(List<User> attention) {
		this.attention = attention;
	}
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE },  
			fetch = FetchType.LAZY, mappedBy="attention")  
	public List<User> getConcerned() {
		return concerned;
	}
	public void setConcerned(List<User> concerned) {
		this.concerned = concerned;
	}
	public void addAtterntion(User p){
		if(!this.attention.contains(p)){
			this.attention.add(p);
			p.concerned.add(this);
		}
	}
	public void removeAtterntion(User p){
		p.concerned.remove(this);
		this.attention.remove(p);
		
	}
	
	public void addJourney(Journey f){
		if(!this.getJourney().contains(f)){
		this.getJourney().add(f);
		f.setUser(this);
		}
	}

	public void removeJourney(Journey f){
		f.setUser(null);
		this.getJourney().remove(f);
	}
	public void addMessage(Reply f){
		if(! this.message.contains(f)){
		this.message.add(f);
		f.setUser(this);
		}
	}

	public void removeMessage(Reply f){
		f.setUser(null);
		this.message.remove(f);
	}
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy="user", cascade=CascadeType.ALL)
	@OrderBy(value="id ASC")
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	public void addComments(Comment f){
		if(! this.comments.contains(f)){
		this.comments.add(f);
		f.setUser(this);
		}
	}

	public void removeComments(Comment f){
		f.setUser(null);
		this.comments.remove(f);
	}
}
