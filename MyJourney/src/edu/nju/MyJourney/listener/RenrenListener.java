package edu.nju.MyJourney.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.renren.api.client.RenrenApiConfig;

import edu.nju.MyJourney.connectRenRen.RenrenConfig;

public class RenrenListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		RenrenApiConfig.renrenApiKey = RenrenConfig.apiKey;
		RenrenApiConfig.renrenApiSecret = RenrenConfig.apiSecretKey;
	}

}
