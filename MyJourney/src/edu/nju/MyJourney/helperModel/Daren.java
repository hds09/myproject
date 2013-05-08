package edu.nju.MyJourney.helperModel;

import java.util.List;

import edu.nju.MyJourney.model.User;


public class Daren {
	public static final int MAN = 1;
	public static final int WOMAN =0;
	private long uid;
	private String email;
	private String name;
	private int age;
	private int sex;
	private String city;
	private String phone;
	private int attentionNum;
	private String account;
	private String image;
	private int concernedNum;
	private int journeyNum;
	private int teamNum;
	private int meassageNum;
	private int imageNum;
	private int hasAttention;//0已经关注，1未关注，2本人
	private List<WallPicture> pictureList;
	public Daren convertFromUser(User user){
		this.uid = user.getUid();
		this.email = user.getEmail();
		this.name = user.getName();
		this.age = user.getAge();
		this.sex = user.getSex();
		this.city = user.getCity();
		this.phone = user.getPhone();
		this.account = user.getAccount();
		this.image = user.getImage();
		if(user.getAttention()!=null)
			this.attentionNum = user.getAttention().size();
		if(user.getConcerned()!=null)
			this.concernedNum = user.getConcerned().size();
		if(user.getJourney()!=null && user.getTeam()!=null)
			this.journeyNum = user.getJourney().size()+user.getTeam().size();
		if(user.getTeam()!=null)
			this.teamNum = user.getTeam().size();
		if(user.getMeassage()!=null)
			this.meassageNum = user.getMeassage().size();
		this.hasAttention = 1;
		return this;
	}
	public long getUid() {
		return uid;
	}
	public void setUid(long uid) {
		this.uid = uid;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getSex() {
		return sex;
	}
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
	public int getAttentionNum() {
		return attentionNum;
	}
	public void setAttentionNum(int attentionNum) {
		this.attentionNum = attentionNum;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getConcernedNum() {
		return concernedNum;
	}
	public void setConcernedNum(int concernedNum) {
		this.concernedNum = concernedNum;
	}
	public int getJourneyNum() {
		return journeyNum;
	}
	public void setJourneyNum(int journeyNum) {
		this.journeyNum = journeyNum;
	}
	public int getTeamNum() {
		return teamNum;
	}
	public void setTeamNum(int teamNum) {
		this.teamNum = teamNum;
	}
	public int getMeassageNum() {
		return meassageNum;
	}
	public void setMeassageNum(int meassageNum) {
		this.meassageNum = meassageNum;
	}
	public int getImageNum() {
		return imageNum;
	}
	public void setImageNum(int imageNum) {
		this.imageNum = imageNum;
	}
	public List<WallPicture> getPictureList() {
		return pictureList;
	}
	public void setPictureList(List<WallPicture> pictureList) {
		this.pictureList = pictureList;
	}
	public int getHasAttention() {
		return hasAttention;
	}
	public void setHasAttention(int hasAttention) {
		this.hasAttention = hasAttention;
	}

	
}
