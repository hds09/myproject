package edu.nju.MyJourney.listener;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import edu.nju.MyJourney.helperModel.Daren;
import edu.nju.MyJourney.helperModel.WallPicture;
import edu.nju.MyJourney.service.DarenService;
import edu.nju.MyJourney.service.WallService;
/**
 * 达人监听器，负责自动后台生成达人数据
 * listener类型有ServletContextListener，ServletContextAttributeListener，
 * HttpSessionListener,HttpSessionAttributeListener
 * web.xml中配置如下
 * < listener >
         < listener-class >
            com.hc.znpb.servlet.ContextListener
         </ listener-class >
     </ listener >
 * @author softwware
 *
 */
public class DarenListener  implements ServletContextListener,ServletContextAttributeListener{
	private DarenService darenService;
	private List<Daren> darenList;
	private WallService wallService;
	private List<WallPicture> picList;
	private DarenStorage darenStorage;
	private PicWallStorage picwallStorage;
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				darenStorage = darenStorage.getInstance();
				if(darenStorage.getDarenList().size() == 0 ){
					darenStorage.setDarenList(darenService.getDarens(0, 100));
				}
				picwallStorage = PicWallStorage.getInstance();
				if(picwallStorage.getPictureList().size() == 0){
					picwallStorage.setPictureList(wallService.getWallPictures(0, 100));
				}
			}
		};
		Timer timer = new Timer("daren",true);
		timer.schedule(task, 0, 30*60*1000);
	}
//从此以下是attributelistener的方法
	@Override
	public void attributeAdded(ServletContextAttributeEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attributeRemoved(ServletContextAttributeEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attributeReplaced(ServletContextAttributeEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
