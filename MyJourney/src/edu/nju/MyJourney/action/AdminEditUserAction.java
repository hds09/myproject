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

}
