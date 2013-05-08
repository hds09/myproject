/**
 * 
 */
package edu.nju.MyJourney.action;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.util.ServletContextAware;
/**
 * @author softwware
 * 上传图片action
 */
public class PictureUploadAction extends BaseAction implements ServletContextAware{
	protected List<File> picList;
	protected List<String> picListFileName;
	protected ServletContext context;
	private static final int BUFFER_SIZE = 16 * 1024 ;
	@Override
	public void setServletContext(ServletContext arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String execute() throws Exception {
		String result = SUCCESS;
		for(File pic : picList){
			try{
				String imageFileName = System.currentTimeMillis() + getExtention(picListFileName.get(picList.indexOf(pic)));
				picListFileName.set(picList.indexOf(pic), savePicture(pic,imageFileName));
				addActionMessage("成功");
			}catch(Exception e){
				e.printStackTrace();
				addActionMessage("失败");
				result = "failure";
			}
		}
		return result;
	}
	/**
	 * 上传图片相关的方法
	 */
	private String savePicture(File src,String fileName) throws Exception{
		context = application();
		File file=new File(context.getRealPath("/")+"upload/"+fileName);
	    FileUtils.copyFile(src, file);    
	    System.out.println("正在存储文件"+fileName+"到"+file.getAbsolutePath());
	    return "upload/"+fileName;
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
	public List<File> getPicList() {
		return picList;
	}
	public void setPicList(List<File> picList) {
		this.picList = picList;
	}
	public List<String> getPicListFileName() {
		return picListFileName;
	}
	public void setPicListFileName(List<String> picListFileName) {
		this.picListFileName = picListFileName;
	}
	public ServletContext getContext() {
		return context;
	}
	public void setContext(ServletContext context) {
		this.context = context;
	}
    private static String getExtention(String fileName) {
        int pos = fileName.lastIndexOf( "." );
        return fileName.substring(pos);
    }
}
