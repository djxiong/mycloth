package com.hros.vaadin;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import com.hros.bas.domain.MenuInfo;
import com.hros.vaadin.user.UserTab;
import com.vaadin.ui.Component;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.TabSheet.SelectedTabChangeEvent;
import com.vaadin.ui.TabSheet.Tab;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public class RightMainClosableTabSheet extends VerticalLayout implements
		TabSheet.SelectedTabChangeListener, TabSheet.CloseHandler {

	private TabSheet tabSheet;
	private Map<Component,Tab> tabMap = new HashMap<Component,Tab>();
	private Map<String,Component> componentMap = new HashMap<String,Component>();
	public RightMainClosableTabSheet() {
		// Tab 1 content
		

		tabSheet = new TabSheet();
		tabSheet.setHeight("600");
		tabSheet.setWidth("800");
		tabSheet.setSizeFull();
		
		tabSheet.addListener(this);
		tabSheet.setCloseHandler(this);

		addComponent(tabSheet);
	}

	public void selectedTabChange(SelectedTabChangeEvent event) {
		TabSheet tabsheet = event.getTabSheet();
		Tab tab = tabsheet.getTab(tabsheet.getSelectedTab());
		if (tab != null) {
			//getWindow().showNotification("Selected tab: " + tab.getCaption());
		}
	}

	public void onTabClose(TabSheet tabsheet, Component tabContent) {
		getWindow().showNotification(
				"Closed tab: " + tabsheet.getTab(tabContent).getCaption());
		
		tabsheet.removeComponent(tabContent);
		tabMap.remove(tabContent);
	}
	
	public void addUserTab(UserTab userTab){
		final Tab feedback = tabSheet.addTab(userTab, "Feedback");
		feedback.setClosable(true);
	}
	
	public void addCustomTab(MenuInfo menuInfo){
		String caption = menuInfo.getMenuName();
		
		//检查是否有已存在的component,如果有,用已存在的.
		Component component = componentMap.get(caption);
		if(component != null){
			Tab existedTab =  tabMap.get(component);
			if(existedTab != null){
				tabSheet.setSelectedTab(existedTab);
				return ;
			}
			else{
				final Tab tab = tabSheet.addTab(component, caption);
				tabSheet.setSelectedTab(tab);
				tab.setClosable(true);
				tabMap.put(component, tab);
				return;
			}
		}
		//没有已存在的component,新创建一个
		try {
			if (menuInfo.getServiceName() != null && menuInfo.getServiceName() != "") {
				Constructor c = Class.forName(menuInfo.getWinClass()).getDeclaredConstructor(String.class);
				c.setAccessible(true);
				component = (Component) c.newInstance(menuInfo.getServiceName());
			} else {
				component = (Component)Class.forName(menuInfo.getWinClass()).newInstance();
			}
			componentMap.put(menuInfo.getMenuName(),component);
			final Tab tab = tabSheet.addTab(component, caption);
			tabSheet.setSelectedTab(tab);
			tab.setClosable(true);
			tabMap.put(component, tab);
			
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
