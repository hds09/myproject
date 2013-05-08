package edu.nju.MyJourney.action.ajax;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.util.ServletContextAware;

import edu.nju.MyJourney.action.BaseAction;
import edu.nju.MyJourney.model.User;
import edu.nju.MyJourney.service.HomeService;
import edu.nju.MyJourney.service.UserService;

public class CreateHeadPhotoAction extends BaseAction implements ServletContextAware {
	private UserService userService;
	private String account;
	private long darenId;
	private File photo;
	private String photoFileName;
	private ServletContext context;
	private static final int BUFFER_SIZE = 16 * 1024 ;
	@Override
	public void setServletContext(ServletContext arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String execute() throws Exception {
		String result = SUCCESS;
		if(account == null){
			account = "a";
		}
		try{
			String imageFileName = System.currentTimeMillis() + getExtention(photoFileName);
			photoFileName = savePicture(photo,imageFileName);
			User user = userService.getUserByAccount(account);
			if(user != null){
				darenId = user.getUid();
				user.setImage(basePath()+"upload/user/"+photoFileName);
				userService.updateUser(user);
				addActionMessage("成功");
			}else{
				result = "failure";
				addActionMessage("用户不存在");
			}
		}catch(Exception e){
			e.printStackTrace();
			addActionMessage("失败");
			result = "failure";
		}
		return result;
	}
	/**
	 * 上传图片相关的方法
	 */
	private String savePicture(File src,String fileName) throws Exception{
		context = application();
		File file=new File(context.getRealPath("/")+"upload/user/"+fileName);
	    FileUtils.copyFile(src, file);    
	    System.out.println("正在存储文件"+fileName+"到"+file.getAbsolutePath());
	    return "upload/user/"+fileName;
	}
	private static void copy(File src, File dst) {
        try {
           InputStream in = null ;
           OutputStream out = null ;
            try {                
               in = new BufferedInputStream( new FileInputStream(src), BUFFER_SIZE);
               out = new BufferedOutputStream( new FileOutputStream(dst), BUFFER_SIZE);
                byte [] buffer = new byte [BUFFER_SIZE];
                while (in.read(buffer) > 0 ) {
                   out.write(buffer);
               } 
           } finally {
                if ( null != in) {
                   in.close();
               } 
                if ( null != out) {
                   out.close();
               } 
           } 
       } catch (Exception e) {
           e.printStackTrace();
       } 
   }
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public File getPhoto() {
		return photo;
	}
	public void setPhoto(File photo) {
		this.photo = photo;
	}
	public String getPhotoFileName() {
		return photoFileName;
	}
	public void setPhotoFileName(String photoFileName) {
		this.photoFileName = photoFileName;
	}
	public ServletContext getContext() {
		return context;
	}
	public void setContext(ServletContext context) {
		this.context = context;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public long getDarenId() {
		return darenId;
	}
	public void setDarenId(long darenId) {
		this.darenId = darenId;
	}
	private static String getExtention(String fileName) {
        int pos = fileName.lastIndexOf( "." );
        return fileName.substring(pos);
    }
	
}
