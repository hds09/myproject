package edu.nju.MyJourney.model;

import java.util.List;

import javax.persistence.CascadeType;
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
	private List<Replay> meassage;
	
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
	@OneToMany(mappedBy="user", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@OrderBy(value="id ASC")
	public List<Journey> getJourney() {
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
		return team;
	}
	public void setTeam(List<Team> team) {
		this.team = team;
	}
	@OneToMany(mappedBy="user", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@OrderBy(value="id ASC")
	public List<Replay> getMeassage() {
		return meassage;
	}
	public void setMeassage(List<Replay> meassage) {
		this.meassage = meassage;
	}
	@ElementCollection
	public List<User> getAttention() {
		return attention;
	}
	public void setAttention(List<User> attention) {
		this.attention = attention;
	}
	@ElementCollection
	public List<User> getConcerned() {
		return concerned;
	}
	public void setConcerned(List<User> concerned) {
		this.concerned = concerned;
	}
	
}
