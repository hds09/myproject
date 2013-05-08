package edu.nju.MyJourney.action;




import edu.nju.MyJourney.model.User;
import edu.nju.MyJourney.service.UserService;
import edu.nju.MyJourney.service.impl.UserServiceImpl;

public class AdminEditUserAction extends BaseAction{
	private UserService userService;
	private String account;
	private String city;
	private String email;
	private String image;
	private String name;
	private String phone;
	private String password;
	private String sex;
	private String result;
	private String id;
	private String age;
	
	private String u_account;
	private String u_city;
	private String u_email;
	private String u_image;
	private String u_name;
	private String u_phone;
	private String u_pwd;
	private String u_sex;
	private String u_age;
	private String u_id;
	@Override
	public String execute() throws Exception {
		System.out.println("in ajax action...");
		System.out.println("email "+email);
		System.out.println("account "+account);
		System.out.println("city "+city);
		System.out.println("image "+image);
		System.out.println("name "+name);
		System.out.println("phone "+phone);
		System.out.println("password "+password);
		System.out.println("sex "+sex);
		this.response().setContentType("application/json;charset=UTF-8");
		User user=new User();
		user.setAccount(this.account);
		user.setAge(Integer.parseInt(this.age));
		user.setCity(this.city);
		user.setEmail(this.email);
		user.setImage(this.image);
		user.setName(this.name);
		user.setPhone(this.phone);
		user.setPwd(this.password);
		user.setSex(Integer.parseInt(this.sex));
		user.setUid(Integer.parseInt(this.id));
		System.out.println(user.getEmail());
		userService.updateUser(user);
		this.result="success";
		return SUCCESS;
		
	}
	
	public String adminEditUser2() throws Exception {
		System.out.println("in ajax action 2...");
		System.out.println("email "+u_email);
		System.out.println("account "+u_account);
		System.out.println("city "+u_city);
		System.out.println("image "+u_image);
		System.out.println("name "+u_name);
		System.out.println("phone "+u_phone);
		System.out.println("password "+u_pwd);
		System.out.println("sex "+u_sex);
		this.response().setContentType("application/json;charset=UTF-8");
		User user=new User();
		user.setAccount(this.u_account);
		user.setAge(Integer.parseInt(this.u_age));
		user.setCity(this.u_city);
		user.setEmail(this.u_email);
		user.setImage(this.u_image);
		user.setName(this.u_name);
		user.setPhone(this.u_phone);
		user.setPwd(this.u_pwd);
		user.setSex(Integer.parseInt(this.u_sex));
		user.setUid(Integer.parseInt(this.u_id));
		System.out.println(user.getEmail());
		userService.updateUser(user);
		this.result="success";
		return SUCCESS;
	}
	public String getResult() {
		return result;
	}
//	public String getId() {
//		return id;
//	}
	//	public String getEmail() {
//		return this.email;
//	}
	public void setEmail(String email) {
		this.email = email;
	}
//	public String getAccount() {
//		return account;
//	}
	public void setAccount(String account) {
		this.account = account;
	}
//	public String getCity() {
//		return city;
//	}
	public void setCity(String city) {
		this.city = city;
	}
//	public String getImage() {
//		return image;
//	}
	public void setImage(String image) {
		this.image = image;
	}
//	public String getName() {
//		return name;
//	}
	public void setName(String name) {
		this.name = name;
	}
//	public String getPhone() {
//		return phone;
//	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
//	public String getPassword() {
//		return password;
//	}
	public void setPassword(String password) {
		this.password = password;
	}
//	public String getSex() {
//		return sex;
//	}
	public void setSex(String sex) {
		this.sex = sex;
	}
//	public String getResult() {
//		return result;
//	}
	public void setResult(String result) {
		this.result = result;
	}
//	public String getId() {
//		return id;
//	}
	public void setId(String id) {
		this.id = id;
	}
//	public String getAge() {
//		return age;
//	}
	public void setAge(String age) {
		this.age = age;
	}
//	public UserService getUserService() {
//		return userService;
//	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public String getU_account() {
		return u_account;
	}
	public void setU_account(String u_account) {
		this.u_account = u_account;
	}
	public String getU_city() {
		return u_city;
	}
	public void setU_city(String u_city) {
		this.u_city = u_city;
	}
	public String getU_email() {
		return u_email;
	}
	public void setU_email(String u_email) {
		this.u_email = u_email;
	}
	public String getU_image() {
		return u_image;
	}
	public void setU_image(String u_image) {
		this.u_image = u_image;
	}
	public String getU_name() {
		return u_name;
	}
	public void setU_name(String u_name) {
		this.u_name = u_name;
	}
	public String getU_phone() {
		return u_phone;
	}
	public void setU_phone(String u_phone) {
		this.u_phone = u_phone;
	}
	public String getU_pwd() {
		return u_pwd;
	}
	public void setU_pwd(String u_pwd) {
		this.u_pwd = u_pwd;
	}
	public String getU_sex() {
		return u_sex;
	}
	public void setU_sex(String u_sex) {
		this.u_sex = u_sex;
	}
	public String getU_age() {
		return u_age;
	}
	public void setU_age(String u_age) {
		this.u_age = u_age;
	}

	public String getU_id() {
		return u_id;
	}

	public void setU_id(String u_id) {
		this.u_id = u_id;
	}

}
