package edu.nju.MyJourney.action;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import com.opensymphony.xwork2.ActionContext;
import com.renren.api.client.RenrenApiClient;
import com.renren.api.client.utils.HttpURLUtils;

import edu.nju.MyJourney.connectRenRen.RenrenConfig;
import edu.nju.MyJourney.model.User;
import edu.nju.MyJourney.service.UserService;

public class RenrenAction extends BaseAction{
	private UserService userService;
	private String client_id;
	private String redirect_url;
	private String code;
	private String name;
	private String headurl;
	private String renrenId;
	private boolean islogined;
	private String account;
	private static final String ip="218.94.159.98";
	@Override
	public String execute() throws Exception {
		client_id = RenrenConfig.apiID;
		redirect_url = URLEncoder.encode("http://169.254.133.57:8080/MyJourney/pic/renren", "UTF-8");
//		redirect_url = URLEncoder.encode("http://www.baidu.com", "UTF-8");
		System.out.println(code);
		if(code != null && code.length()>0){
			String rrOAuthTokenEndpoint = "https://graph.renren.com/oauth/token";
			Map<String, String> parameters = new HashMap<String, String>();
			parameters.put("client_id", RenrenConfig.apiID);
			parameters.put("client_secret", RenrenConfig.apiSecretKey);
			parameters.put("redirect_uri", "http://169.254.133.57:8080/MyJourney/pic/renren");
	                              //这个redirect_uri要和之前传给authorization endpoint的值一样
			parameters.put("grant_type", "authorization_code");
			parameters.put("code", code);
			String tokenResult = HttpURLUtils.doPost(rrOAuthTokenEndpoint, parameters);
			JSONObject tokenJson = (JSONObject) JSONValue.parse(tokenResult);
			if (tokenJson != null) {
				String accessToken = (String) tokenJson.get("access_token");
				Long expiresIn = (Long) tokenJson.get("expires_in");//距离过期时的时间段（秒数）
				long currentTime = System.currentTimeMillis() / 1000;
				long expiresTime = currentTime + expiresIn;//即将过期的时间点（秒数）
				request().getSession().setAttribute("expiresTime", expiresTime);
				//调用人人网API获得用户信息
				RenrenApiClient apiClient = new RenrenApiClient(accessToken, true);
				int rrUid = apiClient.getUserService().getLoggedInUser();
				JSONArray userInfo = apiClient.getUserService().getInfo(String.valueOf(rrUid), "name,headurl");
				if (userInfo != null && userInfo.size() > 0) {
					JSONObject currentUser = (JSONObject) userInfo.get(0);
					if (currentUser != null) {
						name = (String) currentUser.get("name");
						headurl = (String) currentUser.get("headurl");
						renrenId = (String) currentUser.get("uid");
						System.out.println(name+"       "+headurl+"       "+currentUser.toJSONString());
						String tmpAccount = (String) session().getAttribute("account");
						if(tmpAccount != null){
							User loginUser = userService.getUserByAccount(tmpAccount);
							loginUser.setRenrenId(renrenId);
							userService.updateUser(loginUser);
							return "login";
						}else{
							User registerUser = new User();
							registerUser.setAccount(name);
							registerUser.setPwd(name);
							registerUser.setImage(headurl);
							registerUser.setRenrenId(renrenId);
							return "success";
						}
					}
				}
			}
		}
		return "failure";
	}

	public String getClient_id() {
		return client_id;
	}
	public void setClient_id(String client_id) {
		this.client_id = client_id;
	}
	public String getRedirect_url() {
		return redirect_url;
	}
	public void setRedirect_url(String redirect_url) {
		this.redirect_url = redirect_url;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHeadurl() {
		return headurl;
	}
	public void setHeadurl(String headurl) {
		this.headurl = headurl;
	}
	
	
	
}
