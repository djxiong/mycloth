package com.hros.vaadin;

import com.vaadin.Application;
import com.vaadin.ui.*;


@SuppressWarnings("serial")
public class HrosApplication extends Application {
	
	private AppSession appSession;
	
	@Override
	public void init() {
		Window mainWindow = new Window("Hros Application");
		setMainWindow(mainWindow);
		
		//MainWindow appWindow = new MainWindow();
		MyLoginForm appWindow = new MyLoginForm();
		appWindow.setSizeFull();
	    mainWindow.getContent().setSizeFull();
		mainWindow.addComponent(appWindow);
		this.setTheme("contacts");
	}
	
	public void initSession() {
		appSession = new AppSession();
		setUser(appSession);
	}
}
