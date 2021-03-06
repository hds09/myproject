package edu.nju.MyJourney.action;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

//import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;



public class BaseAction extends ActionSupport{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    public HttpServletRequest request(){
        return ServletActionContext.getRequest();
    }
    public HttpSession session(){
        return ServletActionContext.getRequest().getSession();
    }
    public ServletContext application(){
        return ServletActionContext.getServletContext();
    }
    public HttpServletResponse response(){
        return ServletActionContext.getResponse();
    }
    public String path(){
    	return request().getContextPath(); 
    }
    //返回http://localhost:8080/MyJourney/。。。
    public String basePath(){
    	return request().getScheme()+"://"+request().getServerName()+":"+request().getServerPort()+path()+"/"; 
    }
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
