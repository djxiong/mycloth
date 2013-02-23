package com.hros.vaadin.user;

import com.hros.bas.domain.MenuInfo;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Form;

public class MenuTab extends CustomComponent{
	private MenuInfo menu;
	
	public MenuTab(){
		menu = new MenuInfo();
		BeanItem<MenuInfo> menuItem = new BeanItem<MenuInfo>(menu);
		Form menuForm = new Form();
		menuForm.setItemDataSource(menuForm);
		this.addComponent(menuForm);
	}
}
